import random
                              
import time

import sys


 # Radix Sort

def radix_sort(a_list):
   '''returns a new list containing the same elements
      as a_list, in sorted order
      
      Parameter:
      
      a_list is expected to be a list of non-negative integers
   '''
   new_list = a_list[:]
   buckets = [[],[],[],[],[],[],[],[],[],[]]
   #print(buckets)
   done = False
   divisor = 1
   while not done:
      done = True
      for v in new_list:
         if v >= divisor:
            done = False
         digit = (v // divisor) % 10
         buckets[digit].append(v)
      #print(buckets)
      temp_list = []
      for b in buckets:
         temp_list.extend(b)
      
      buckets = [[],[],[],[],[],[],[],[],[],[]]
   
      new_list = temp_list
      divisor *= 10
   
   return new_list
      
# Merge Sort      
      
def merge(list_1, list_2):
   '''returns a new list containing the sorted elements of list_1 and list_2
     
     Parameters:
     
     list_1 and list_2 must be sorted lists of comparable elements
   '''
   # print("Merging",list_1,"and",list_2)
   merged_list = []
   f1, f2 = 0, 0
   l1, l2 = len(list_1) - 1, len(list_2) - 1
   while f1 <= l1  and  f2 <= l2:
      if list_1[f1] <= list_2[f2]:
         merged_list.append(list_1[f1])
         f1 += 1
      else:
         merged_list.append(list_2[f2])
         f2 += 1

   if f1 > l1:
      merged_list.extend(list_2[f2:])
   else:
      merged_list.extend(list_1[f1:])
      
   return merged_list


def merge_sort(a_list):
   '''initiates the recursive merge sort
   
      Parameter:
      
      a_list must be a list of comparable values
   '''
   return merge_sort_rec(a_list, 0, len(a_list)-1)
   
def merge_sort_rec(a_list, first, last):
   '''returns a new list containing the elements from a_list[first] to a_list[last]
     in sorted order
     
     Parameters:
     
     a_list is a list of comparable values
     first and last are integers indicating the start and end of the segment
         of a_list currently being sorted
   '''
   if first > last:
      return []
   elif first == last:
      return [a_list[first]]
   else:
      mid = (first + last) // 2
      left = merge_sort_rec(a_list, first, mid)
      right = merge_sort_rec(a_list, mid+1, last)
      return merge(left, right)
   
       
# main



# Test the algorithms for correctness.  If they give identical
# results on 100 random test cases, we accept this as evidence that 
# both algorithms are implemented correctly.
for i in range(100):
   values_for_r = random.sample(range(100000,999999), 100)
   values_for_m = values_for_r[:]
   radix_sort_result = radix_sort(values_for_r)
   merge_sort_result = merge_sort(values_for_m)
   if radix_sort_result != merge_sort_result:
      print("Error: Different results obtained from the two sorting algorithms.")
      # stop the program
      sys.exit()

print("radix_sort() and merge_sort() returned identical results on 100 tests.")
print("It is reasonable to conclude that both are correctly implemented.")

# Collect time data
trials = 50
times_r_was_faster = 0
times_m_was_faster = 0
times_they_tied = 0
total_time_r = 0
total_time_m = 0
for t in range(trials):
   values = random.sample(range(100000, 999999),10000)
   values_copy = values[:]
   
   start = time.time()
   nv = radix_sort(values)
   end = time.time()
   time_r = end - start

   start = time.time()
   nv = merge_sort(values_copy)
   end = time.time()
   time_m = end - start
   
   total_time_r += time_r
   total_time_m += time_m
   
   if abs(time_r - time_m)/time_r < 0.01:
      # difference is < 1%, so we consider them tied
      # This is an arbitrary definition of being tied
      times_they_tied += 1
   elif time_r < time_m:
      times_r_was_faster += 1
   else:
      times_m_was_faster += 1
      
   print("radix wins : ", times_r_was_faster,"\tmerge wins : ",times_m_was_faster,
            "\tties : ", times_they_tied)

print("Final standings:")
print("Radix sort was faster", times_r_was_faster,"times")
print("Merge sort was faster", times_m_was_faster,"times")
print("They tied",times_they_tied,"times")
print("Average time for radix sort =", total_time_r/trials)
print("Average time for merge sort =",total_time_m/trials)


#  Summary of my results:  Radix sort finishes in approximately 1/3 the time
#  taken by Merge sort in every trial.  Merge sort is never faster, nor do they
#  ever tie.  The average time for Radix sort is 0.0086 seconds, and the average
#  time for Merge sort is 0.024 seconds.   This is convincing evidence that for
#  data sets of this size and nature, the average time for Radix sort is less than the
#  average time for Merge sort.
