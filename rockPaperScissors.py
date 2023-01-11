import random

user_wins = 0
computer_wins = 0
rpsRange = ["rock", "paper", "scissors"]

while user_wins or computer_wins < 3:

    randRps = random.choice(rpsRange)
    playerInput = input("Type rock/paper/scissors: ")
    print("Player chose: " + playerInput)
    print("Computer chose: " + randRps)
    if playerInput == "rock" and randRps == "scissors":
        user_wins += 1
    elif playerInput == "paper" and randRps == "rock":
        user_wins += 1
    elif playerInput == "scissors" and randRps == "paper":
        user_wins += 1
    elif playerInput == randRps:
        pass
    else:
        computer_wins += 1

    print("User Wins: " + str(user_wins))
    print("Computer Wins: " + str(computer_wins))

    if user_wins == 2:
        print("You have won, best out of 3")
        break

    if computer_wins == 2:
        print("You have lost, best out of 3")
        break




