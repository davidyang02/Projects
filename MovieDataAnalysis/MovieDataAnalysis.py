from matplotlib import pyplot as plt

imdb_file = open("IMDB_movie_metadata.csv","r", encoding="UTF-8")

headers = imdb_file.readline().split(",")
#~ print(headers)               # These lines were used during debugging
#~ print(len(headers))


# Each genre gets its own entry in the genre_dict.  The data associated with each
# genre is a list of the movies that belong to that genre.  Each movie can be in
# several of the lists.
genre_dict = {}

for line in imdb_file:
   #print(line)
   fields = line.split(",")
   #~ if len(fields) != len(headers):        # These lines were used during debugging
      #~ print(len(fields))
      #~ for i in range(len(fields)):
         #~ print(i, fields[i])
   m_dict = {}                                         # Each movie is stored as a dictionary
                                                               # The keys are the headers from the first
                                                               # line of the file.
   for i in range(len(fields)):
      m_dict[headers[i]] = fields[i].strip()
      
   m_dict["genres"] = list(fields[4].split("|"))   # Split the 'genres' string into a list of genres
 
   # Add this movie to the list for every genre it belongs to.
   for g in m_dict["genres"]:
      if g in genre_dict:
         genre_dict[g].append(m_dict)
      else:
         #~ print("New genre : ",g)                          # Report the genres as they are discovered
                                                                             #  - used during debugging
         genre_dict[g] = [m_dict]

# Define the graphs to be plotted   
charts = [ ("Sci-Fi", "budget", "imdb_score"),           # The first three graphs are required
                 ("Western", "title_year", "duration"),
                 ("Family", "budget", "gross"),
                 ("Documentary", "duration", "imdb_score"),  # The last three are free choice
                 ("Mystery", "duration", "imdb_score"),
                 ("Comedy", "duration", "imdb_score")
               ]

# Plot the graphs one by one
for c in charts:
   genre, field_1, field_2 = c
   x_vals = []
   y_vals = []
   for m in genre_dict[genre]:
      if m[field_1] != "" and m[field_2] != "":          
         x_vals.append(float(m[field_1]))
         y_vals.append(float(m[field_2]))
   fig = plt.figure(figsize=(100,8))   
   fig.suptitle(genre + " :  " + field_1 + " vs " + field_2)
   plt.scatter(x_vals, y_vals)
   plt.xlabel(field_1)
   plt.ylabel(field_2)
   plt.show()
