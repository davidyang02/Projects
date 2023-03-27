import numpy as np
import random
import math

# define the two distance measures

def manhattan(l1, l2):
      ''' computes the Manhattan Distance between two vectors '''
      if len(l1) != len(l2):
         return None
      else:
         d = 0
         for i in range(len(l1)):
            d += abs(l1[i] - l2[i])
         return d


def euclidean(l1, l2):      
      ''' computes the Euclidean diistance '''
      if len(l1) != len(l2):
         return None
      else:
         d = 0
         for i in range(len(l1)):
            d += (l1[i] - l2[i])**2
         return math.sqrt(d)   
         

   



measures = [manhattan, euclidean]     # this makes it easy to apply both measures using a loop


all_animals = np.loadtxt("zoo_2.txt", dtype = int, skiprows= 1, usecols=range(1,16))
#print (all_animals.shape)

animal_names = np.loadtxt("zoo_2.txt", dtype = str, skiprows = 1, usecols = (0))
#print (animal_names)

# create a dictionary pairing animal names with their attributes
zoo = {}
for i in range(len(all_animals)):
   zoo[animal_names[i]] =  all_animals[i]


# parameters of the algorithm

num_clusters = 7
dimensions = all_animals.shape[1]
iterations = 100
epsilon = 0.1

for measure in measures:    # for each distance measure
   
   print("\nUsing", measure.__name__,"distance\n")   # a handy Python trick - every function has a
                                                                                   # __name__ attribute
                                                                                   
   # choose initial centres
   random_initial_centres = random.sample(range(len(all_animals)),7)

   centres = []
   for i in random_initial_centres:
      centres.append(zoo[animal_names[i]])

   # Create a dictionary that associates a cluster number with each animal name
   # Initially these are all None
   chosen_cluster = {}
   for a in zoo:
      chosen_cluster[a] = None
      
   
   # iterate iterations times:
   for i in range(iterations):
      print("Iteration", i+1)
      new_clusters = []
      for x in range(num_clusters):
         new_clusters.append([])
         
      #    assign animals to clusters using current centres
      animal_moved = False
      for a in zoo:
         closest_centre = 0
         closest_distance = 1000000000
         for j in range(num_clusters):
            d = measure(zoo[a], centres[j])
            if d < closest_distance:
               closest_distance = d
               closest_centre = j
         if closest_centre != chosen_cluster[a]:
            animal_moved = True
            chosen_cluster[a] = closest_centre
            print("\t",a,"moved to cluster", closest_centre)
         new_clusters[closest_centre].append(a) 
         
      #    determine if any animal changed cluster
      if not animal_moved:
         print("\tNo animal moved to a different cluster")
         break
   
      #    compute new cluster centres
      new_centres = np.zeros((num_clusters, 15))
      for c in range(num_clusters):
         #print("length of cluster",c,"=",len(new_clusters[c]))
         if len(new_clusters[c]) > 0:
            temp = np.zeros(dimensions)
            for a in new_clusters[c]:
               temp += zoo[a]
            new_centres[c] = temp / len(new_clusters[c])
            #print("new centre", new_centres[c])
            
      #    determine if the cluster centres moved
      centre_moved = False
      for c in range(num_clusters):
         if measure(centres[c], new_centres[c]) > epsilon:
            centre_moved = True
            break
      
      if not centre_moved:
         print("\tNo centre moved more than",epsilon)
         break
         
      old_clusters = new_clusters  # save the current clusters so we can compare them to the
                                                    # next set of clusters
      centres = new_centres
      #print("new centres", centres) 

   # show the final clusters
   print("\n\n")
   for c in new_clusters:
      print("Cluster: ",end="")
      for a in c:
         print(a," ", end="")
      print("\n")
      
      
  
