from flask import render_template, request
from webapp import app
from webapp.backtest_engine import fetch_data, apply_strategy, calculate_profit_with_cash, fetch_benchmark, plot_profit_vs_benchmark, plot_backtest

@app.route('/')
def home():
    return render_template('index.html')

@app.route('/backtest', methods=['POST'])
def backtest():
    stock_symbol = request.form['stock_symbol']
    start_date = request.form['start_date']
    end_date = request.form['end_date']
    benchmark_symbol = request.form['benchmark']  # Get the selected benchmark

    # Fetch stock data and apply the backtesting strategy
    data = fetch_data(stock_symbol, start_date, end_date)
    data = apply_strategy(data)

    # Calculate total profit and portfolio values
    total_profit, trades, final_cash, portfolio_values, portfolio_df = calculate_profit_with_cash(data)

    # Fetch and normalize benchmark data
    benchmark_df = fetch_benchmark(benchmark_symbol, start_date, end_date)

    # Plot the backtest chart (with buy/sell signals)
    backtest_chart = plot_backtest(data)

    # Plot the profit vs benchmark chart
    profit_chart = plot_profit_vs_benchmark(portfolio_df, benchmark_df, benchmark_symbol)

    # Pass everything to the template
    return render_template(
        'backtest.html',
        stock_symbol=stock_symbol,
        backtest_chart=backtest_chart,  # Pass backtest_chart to template
        profit_chart=profit_chart,      # Pass profit_chart to template
        total_profit=total_profit,
        trades=trades,
        final_cash=final_cash,
        portfolio_value=portfolio_df['Portfolio Value'].iloc[-1]
    )






