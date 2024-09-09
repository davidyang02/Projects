import yfinance as yf
import pandas as pd
import plotly.graph_objects as go

def fetch_data(stock_symbol, start_date, end_date):
    # Fetch historical stock data from Yahoo Finance
    data = yf.download(stock_symbol, start=start_date, end=end_date)
    # Calculate 50-day and 200-day moving averages
    data['50_MA'] = data['Close'].rolling(window=50).mean()
    data['200_MA'] = data['Close'].rolling(window=200).mean()
    return data

def apply_strategy(data):
    # Apply a simple moving average crossover strategy
    data['Position'] = (data['50_MA'] > data['200_MA']).astype(int)
    
    # Use .loc to assign values to a subset of the DataFrame
    data.iloc[:50, data.columns.get_loc('Position')] = 0  # Ensure the first 50 rows are set to 0

    # Create buy/sell signals
    data['Buy_Signal'] = (data['Position'].shift(1) == 0) & (data['Position'] == 1)
    data['Sell_Signal'] = (data['Position'].shift(1) == 1) & (data['Position'] == 0)
 
    return data

def calculate_profit_with_cash(data, starting_cash=10000):
    """
    Calculate total profit or loss based on buy and sell signals, updating cash and shares held.
    Also, track the portfolio value over time.
    """
    data = data.copy()  # Ensure we don't modify the original data
    cash = starting_cash
    shares_held = 0
    total_profit = 0  # Initialize total profit
    portfolio_values = []  # Track portfolio value over time
    trades = []  # Store details of each trade (buy price, sell price, profit)

    for index, row in data.iterrows():
        # Check for buy signal
        if row['Buy_Signal']:
            buy_price = row['Close']
            if cash > 0:
                shares_held = cash // buy_price  # Buy as many shares as possible
                cash -= shares_held * buy_price  # Update cash after buying

        # Check for sell signal
        if row['Sell_Signal'] and shares_held > 0:
            sell_price = row['Close']
            trade_profit = shares_held * (sell_price - buy_price)
            trades.append({
                'Buy Price': buy_price,
                'Sell Price': sell_price,
                'Shares': shares_held,
                'Profit': trade_profit
            })
            total_profit += trade_profit  # Add to total profit
            cash += shares_held * sell_price  # Update cash after selling
            shares_held = 0  # Reset shares held

        # Calculate portfolio value (cash + current value of shares)
        portfolio_value = cash + (shares_held * row['Close'])
        portfolio_values.append(portfolio_value)  # Track portfolio value over time

    # Create a DataFrame for portfolio values over time
    portfolio_df = pd.DataFrame({
        'Date': data.index,
        'Portfolio Value': portfolio_values
    })
    
    return total_profit, trades, cash, portfolio_values, portfolio_df


def plot_profit_vs_benchmark(portfolio_df, benchmark_df, benchmark_name):
    """
    Plot the portfolio's cumulative value and compare it against the benchmark with the same starting cash.
    """
    fig = go.Figure()

    # Add the portfolio's value over time
    fig.add_trace(go.Scatter(
        x=portfolio_df['Date'], y=portfolio_df['Portfolio Value'],
        mode='lines', name='Portfolio Value', line=dict(color='blue')
    ))

    # Add the normalized benchmark's value over time
    fig.add_trace(go.Scatter(
        x=benchmark_df.index, y=benchmark_df['Normalized'],
        mode='lines', name=f'{benchmark_name} (Normalized)', line=dict(color='orange')
    ))

    # Update layout
    fig.update_layout(
        title='Portfolio vs Benchmark',
        xaxis_title='Date',
        yaxis_title='Value ($)',
        hovermode='x',
        template='plotly_dark',
        autosize=True,
        height=600,
        margin=dict(l=0, r=0, t=50, b=0)
    )

    return fig.to_html(full_html=False)




def fetch_benchmark(benchmark_symbol, start_date, end_date, starting_cash=10000):
    """
    Fetch benchmark data (e.g., S&P 500) for the same period as the stock.
    Normalize the benchmark so it starts at the same value as the portfolio (starting_cash).
    """
    benchmark_data = yf.download(benchmark_symbol, start=start_date, end=end_date)

    # Normalize the benchmark to start at the same value as the portfolio's starting cash
    benchmark_data['Normalized'] = benchmark_data['Close'] / benchmark_data['Close'].iloc[0] * starting_cash

    return benchmark_data[['Normalized']]



def plot_backtest(data):
    """
    Plots the backtest results including stock prices, buy/sell signals, and moving averages.
    """
    fig = go.Figure()

    # Add stock price (Close price)
    fig.add_trace(go.Scatter(x=data.index, y=data['Close'], mode='lines', name='Price', line=dict(color='black')))

    # Add moving averages (50 MA and 200 MA)
    if '50_MA' in data.columns:
        fig.add_trace(go.Scatter(x=data.index, y=data['50_MA'], mode='lines', name='50-day MA', line=dict(color='blue')))
    if '200_MA' in data.columns:
        fig.add_trace(go.Scatter(x=data.index, y=data['200_MA'], mode='lines', name='200-day MA', line=dict(color='red')))

    # Plot buy signals (green up arrows)
    if 'Buy_Signal' in data.columns:
        fig.add_trace(go.Scatter(
            x=data[data['Buy_Signal']].index, 
            y=data[data['Buy_Signal']]['Close'],
            mode='markers',
            marker=dict(color='green', symbol='triangle-up', size=10),
            name='Buy Signal'
        ))

    # Plot sell signals (red down arrows)
    if 'Sell_Signal' in data.columns:
        fig.add_trace(go.Scatter(
            x=data[data['Sell_Signal']].index, 
            y=data[data['Sell_Signal']]['Close'],
            mode='markers',
            marker=dict(color='red', symbol='triangle-down', size=10),
            name='Sell Signal'
        ))

    # Update layout
    fig.update_layout(
        title='Backtest Results',
        xaxis_title='Date',
        yaxis_title='Price',
        hovermode='x',
        template='plotly_dark',
        height=600
    )

    # Return the HTML div element for the plot
    return fig.to_html(full_html=False)


