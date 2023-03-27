from functools import total_ordering


class Assignment8():

    def __init__(self, name="anonymous"):
        self.name = name
        self.connections = []
        self.connection_type = Assignment8
        self.score = 0

    def add_connection(self, con):
        if type(con) == self.connection_type:
            self.connections.append(con)

    def compute_score(self):
        self.score = len(self.connections)

    def __str__(self):
        return self.name

    def get_score(self):
        return self.score

    def get_name(self):
        return self.name


@total_ordering
class Customer(Assignment8):
    instances_list = []

    def __init__(self, name="a_customer"):
        super().__init__(name)
        self.connection_type = Restaurant
        Customer.instances_list.append(self)

    def compute_score(self):
        ''' the score for a Customer is the average of the scores
          of the Restaurants where the Customer has eaten '''
        self.score = 0
        if len(self.connections) > 0:
            for con in self.connections:
                self.score += con.get_score()
            self.score /= len(self.connections)

    def get_num_cons(self):
        return len(self.connections)

    def __eq__(self, other):
        return self.name == other.name

    def __ne__(self, other):
        return self.name != other.name

    def __lt__(self, other):
        return ((self.score < other.score) or
                ((self.score == other.score) and (self.name > other.name)))

    def return_top(n):
        ''' return the top n Customers '''
        sorted_Customers = sorted(Customer.instances_list)
        sorted_Customers.reverse()
        return sorted_Customers[:n]


# end of Customer class definition


@total_ordering
class Restaurant(Assignment8):
    instances_list = []

    def __init__(self, name="a restaurant"):
        super().__init__(name)
        self.connection_type = Customer
        Restaurant.instances_list.append(self)

    def compute_score(self):
        ''' the score for a Restaurant is the sum of the number
          of Restaurants where the Customers of this Restaurant have eaten '''
        self.score = 0
        for con in self.connections:
            self.score += con.get_num_cons()

    def __eq__(self, other):
        return self.name == other.name

    def __ne__(self, other):
        return self.name != other.name

    def __lt__(self, other):
        return ((self.score < other.score) or
                (self.score == other.score and ((len(self.name) < len(other.name)) or
                                                (len(self.name) == len(other.name) and (self.name > other.name))))
                )

    def return_top(n):
        ''' return the top n Restaurants '''
        sorted_Restaurants = sorted(Restaurant.instances_list)
        sorted_Restaurants.reverse()
        return sorted_Restaurants[:n]


# end of Restaurant class definition


# main


infile = open(
    "C:\\Users\David Yang\Downloads\Mini Python Projects\RestaurantRanking\Customers and Restaurants 2022.csv", "r",
    encoding="UTF-8")
restaurants = infile.readline().split(",")  # read the first line : the restaurant names

# print(restaurants)

cust_list = []
rest_list = []

for r in restaurants[1:]:  # start at 1 because the first element is blank
    rest_list.append(Restaurant(name=r.strip()))  # create all the Restaurant objects

for line in infile:  # read the rest of the lines
    line_list = line.split(",")
    new_customer = Customer(line_list[0].strip())  # the first element on the line is the customer name
    cust_list.append(new_customer)
    for i in range(1, len(line_list)):  # the rest of the line is all 0's and 1's
        c = int(line_list[i].strip())
        if c == 1:  # if c == 1, add both the connections:
            new_customer.add_connection(rest_list[i - 1])  # add the Restaurant to the Customer's connections
            rest_list[i - 1].add_connection(new_customer)  # add the Customer to the Restaurant's connections

# compute the scores of all restaurants

for r in rest_list:
    r.compute_score()

# compute the scores of all customers
for c in cust_list:
    c.compute_score()

print("Top 10 restaurants (descending order)\n")

for r in Restaurant.return_top(10):
    print(r.get_name(), r.get_score())

print()

print("Top 10 customers (descending order)\n")

for c in Customer.return_top(10):
    print(c.get_name(), c.get_score())

print()
