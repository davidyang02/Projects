word = "cookie"
wordList = []
falseWord = []
loss_counter = 0

# Finds the duplicate indexes of item


def list_duplicates_of(seq, item):
    start_at = -1
    locs = []
    while True:
        try:
            loc = seq.index(item, start_at+1)
        except ValueError:
            break
        else:
            locs.append(loc)
            start_at = loc
    return locs

# fills the wordList (Convert the string to a list)


for i in range(len(word)):
    wordList.append(word[i])

# fills the falseWord with a number of "_" based on the word length
for n in range(len(word)):
    falseWord.append("_")

res = [idx for idx, val in enumerate(word) if val in word[:idx]]

n = 0
while n < 1:

    user_input = input("enter a letter: ")

    if user_input in wordList:
        falseWord[wordList.index(user_input)] = user_input
        for u in list_duplicates_of(word, user_input):
            falseWord[u] = user_input

            print(falseWord)
            # Win condition
            if falseWord == wordList:
                print("You win! The word was " + word)
                n = 1

    # When the player puts in the wrong letter, the counter goes down
    else:
        loss_counter += 1
        left = 5 - loss_counter
        print("mistakes left: " + str(left))

        print(falseWord)

        # Loss condition
        if loss_counter == 5:
            print("You lost! The word was " + word)
            break
