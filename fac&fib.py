def fact (x):

    if x == 0:
        return 1

    else:


        return x * fact(x-1)

print(fact(4))

def fib(x):

    if (x>=3):
        return fib(x-1) + fib(x-2)
    else:
        return 1

print(fib(9))

