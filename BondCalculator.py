while True:
    m = float(input('Number of payments per period: '))
    t = float(input('Number of years to maturity:'))
    ytm = float(input('Yield to maturity: '))
    fv = float(input('Face Value: '))
    c = float(input("Coupon Rate: "))




    bondPrice = ((fv * c / m * (1 - (1 + ytm / m) ** (-m * t))) / (ytm / m)) + fv * (1 + (ytm / m)) ** (-m * t)
    print('$' + str('%.2f' %bondPrice))












