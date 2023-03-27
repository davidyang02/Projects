import tkinter as tk
from tkinter.filedialog import askdirectory

import glob   # for the purpose of getting a list of files in a directory

import itertools     # for the purpose of choosing all pairs from a list

def letters_only(word):
   '''parameter:
         word - a string
      returns:
         a string containing only the letters of the parameter
   '''
   result = ''
   for c in word:
      if c.isalpha():
         result += c
   return result
   
   
def build_signature(file, num = 10):
   '''parameters:
         file - a string containing the path to a text file
         num - the size of the signature (default value is 10)
      returns:
         a set containing the num most frequent non-stopwords in the file
   '''
   word_counts = {}
   infile = open(file,'r', encoding="UTF-8")
   for line in infile:
      words = line.split()
      for w in words:
         w = w.lower()
         w = letters_only(w)
         if len(w) > 0 and w not in stop_words:
            if w in word_counts:
               word_counts[w] += 1
            else:
               word_counts[w] = 1
   words_and_frequencies = []
   for w,c in iter(word_counts.items()):
      words_and_frequencies.append ((w,c))
   words_and_frequencies.sort(key = lambda x : x[1], reverse = True)
   return_set = set()
   for i in range(min(num, len(words_and_frequencies))):
      return_set.add(words_and_frequencies[i][0])                 # we just want the words
   infile.close()      
   # technically we don't need to close the file, but it is a good habit.
   return return_set
   
def jaccard(s1, s2):
   '''parameters:
         s1 - a set
         s2 - a set
      returns:
         the Jaccard measure of similarity between the two sets
   '''
   return len(s1.intersection(s2)) / len(s1.union(s2))
   
# main

# load the StopWords
stop_words = set()
stop_words_file = open("StopWords.txt", 'r', encoding="UTF-8")
for line in stop_words_file:
   stop_words.add(letters_only(line.lower()))

# find out where the books are
window = tk.Tk()
window.geometry("1600x1200")
window.title("Book Similarity")
data_dir = askdirectory(initialdir=r"home\David Yang\Downloads\Mini Python Projects\BookRecommendation-Jaccard\Books")
# print statement for debugging purposes
# print(data_dir)
data_dir += '/'

text_files = glob.glob(data_dir+"*.txt", recursive = True)

text_files.sort()

short_names = {}
signatures = {}

for file in text_files:
      # the extraction of the short_name part of the file identifier is optional
      short_name = file.split("/")[-1]
      short_names[file] = short_name
      signatures[file] = build_signature(file, 25)
      #print statements for debugging purposes
      #print(short_names[file],": ",len(signatures[file]),"words in signature")
      #print("\n",file, "\n\t",short_names[file],"\n\t", signatures[file])

  
best_match = {}
for f in text_files:
   best_match[f] = (None,0)

# This loop uses a function from the itertools library to iterate through all the pairs of files
# of methods for making sure all the similarity values are computed.
for f1, f2 in itertools.combinations(text_files,2):
   # print statement for debugging purposes
   #~ print(short_names[f1],"and",short_names[f2],"\n\tsize of intersection = ",len(signatures[f1].intersection(signatures[f2])),
            #~ "\n\tsize of union = ",len(signatures[f1].union(signatures[f2])),
            #~ "\n\tsimilarity score = ", jaccard(signatures[f1],signatures[f2]))
   similarity = jaccard(signatures[f1],signatures[f2])
   # if there are multiple files that tie for "best match" for f1, this makes a list
   # of them.
   if similarity == best_match[f1][1]:
      best_match[f1][0].append(f2)
   elif similarity > best_match[f1][1]:
      best_match[f1] = ([f2],similarity)
   if similarity == best_match[f2][1]:
      best_match[f2][0].append(f1)
   elif similarity > best_match[f2][1]:
      best_match[f2] = ([f1],similarity)

# set up the labels in the header row
print_row = 0
header_1 = tk.Label(window, pady = 10,text = "If You Liked ...", font = (None, 16))
header_1.grid(row = 0, column = 0)
header_space = tk.Label(window, pady = 10, text = "                ")
header_space.grid(row = 0, column = 1)
header_2 = tk.Label(window, text = "I Recommend ...", font = (None, 16))
header_2.grid(row = 0, column = 2)
print_row = 0

# fill the table
for f in text_files:
   print_row += 1
   # print statement for debugging purposes
   #   print("\nBest match(es) for",short_names[f],"\t(",round(best_match[f][1],2),")")
   
   fl = tk.Label(window, width = 30, text = short_names[f], anchor = 'w', borderwidth = 3, padx = 5, font = (None, 14), relief = tk.GROOVE)
   # anchor = 'w'  causes the Label text to be left-aligned in the table.
   fl.grid(row = print_row, column = 0)
   print_column = 1
   for m in best_match[f][0]:
      print_column += 1
      m = tk.Label(window, width = 30, text = short_names[m], anchor = 'w', borderwidth = 3, padx = 5, font = (None, 14), relief = tk.GROOVE)
      m.grid(row = print_row, column = print_column)
    

# display the info
      
window.mainloop()      
