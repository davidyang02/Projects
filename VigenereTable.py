table = ['ABCDEFGHIJKLMNOPQRSTUVWXYZ']
for i in range(25):
   temp = table[i][1:]+table[i][0]
   table.append(temp)


# Get plaintext and key

plaintext = "It was the best of times, it was the worst of times"
key = "artichoke"


# Convert plaintext and key to all upper case letters

plaintext = plaintext.upper()
key = key.upper()



# Remove all non-letters from plaintext and key

cleantext = ""
for c in plaintext:
   if c in 'ABCDEFGHIJKLMNOPQRSTUVWXYZ':
      cleantext = cleantext + c
      
# another test for upper case letters:   if (c >= 'A') and (c <= 'Z')  
# and another : if (ord(c) >= ord('A')) and (ord(c) <= ord('Z'))
# and many other options!

cleankey = ""
for c in key:
   if c in 'ABCDEFGHIJKLMNOPQRSTUVWXYZ':
      cleankey = cleankey + c

# Encrypt plaintext

key_length = len(cleankey)
encrypted = ""
key_pos = -1
ord_A = ord('A')

for c in cleantext:
   key_pos = (key_pos + 1 ) % key_length     # this advances to the next key letter 
   
   key_letter = cleankey[key_pos]                  # this identifies the letter of the key to use
   
   row = ord(key_letter) - ord_A                     # this can be done with a formula instead of a table
   col =ord(c) - ord_A
   encrypted = encrypted + table[row][col]


# Show result on screen

print(encrypted)
