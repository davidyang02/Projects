import random

randNum = random.randint(1, 101)

while True:
    user_input = int(input("Guess the number: "))

    if user_input > randNum:
        print("This number is too high! Try Again")

    elif user_input < randNum:
        print("This number is too low! Try Again")

    else:
        print("You found the right number! ")
        break