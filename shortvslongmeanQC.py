# region imports
from AlgorithmImports import *
# endregion

class WellDressedMagentaJackal(QCAlgorithm):

    def Initialize(self):
        self.SetStartDate(2020, 1, 1)  # Set Start Date
        self.SetCash(100000)  # Set Strategy Cash
        self.spy = self.AddEquity("SPY", Resolution.Daily).Symbol

        self.SetBenchmark(self.spy)

        self.longSMA = self.SMA(self.spy, 100, Resolution.Daily)
        self.shortSMA = self.SMA(self.spy, 10, Resolution.Daily)

        self.SetWarmUp(100, Resolution.Daily)

    def OnData(self, data: Slice):
        if data.ContainsKey(self.spy) and data [self.spy] is not None:
            price = data[self.spy].Value
            longSMA_value = self.longSMA.Current.Value
            shortSMA_value = self.shortSMA.Current.Value

            if (not self.Portfolio[self.spy].Invested) and (shortSMA_value > longSMA_value):
                self.SetHoldings(self.spy, 1)


            if (self.Portfolio[self.spy].Invested) and (shortSMA_value < longSMA_value):
                self.Liquidate()


