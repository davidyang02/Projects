import random

diceRange = [1, 2, 3, 4, 5, 6]
rollSumList = []
for i in range(2):
    roll = random.choice(diceRange)

    rollSumList.append(roll)
    print(roll)

rollSum = (rollSumList[0] + rollSumList[1])


print("dice roll sum = " + str(rollSum))
