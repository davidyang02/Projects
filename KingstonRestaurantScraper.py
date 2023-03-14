from bs4 import BeautifulSoup
import requests
import re
import pandas as pd


url = ('https://www.tripadvisor.ca/Restaurants-g154992-Kingston_Ontario.html')

user_agent = ({'User-Agent':
            'Mozilla/5.0 (Windows NT 10.0; Win64; x64) \
            AppleWebKit/537.36 (KHTML, like Gecko) \
            Chrome/90.0.4430.212 Safari/537.36',
            'Accept-Language': 'en-US, en;q=0.5'})

def get_page_contents(url):
    page = requests.get(url, headers = user_agent)
    return BeautifulSoup(page.text, 'html.parser')

soup = get_page_contents(url)


page_text = soup.find('div',{'class': "unified pagination js_pageLinks"})

pages = str(page_text.contents).split("-")[1]
pages2 = int(re.sub('\D', '', pages))

Restaurants = []
ratings = []
reviews = []
prices = []
for x in range(4):

    print(x)
    pages3 = pages2*x
    url = f'https://www.tripadvisor.ca/RestaurantSearch-g154992-oa{pages3}-Kingston_Ontario.html#EATERY_LIST_CONTENTS'

    user_agent = ({'User-Agent':
                       'Mozilla/5.0 (Windows NT 10.0; Win64; x64) \
                       AppleWebKit/537.36 (KHTML, like Gecko) \
                       Chrome/90.0.4430.212 Safari/537.36',
                   'Accept-Language': 'en-US, en;q=0.5'})

    page = requests.get(url,  headers = user_agent).text
    soup = BeautifulSoup(page, "html.parser")

    # Find and extract the data elements.

    for name in soup.findAll('div',{'class':'RfBGI'}):
        Restaurants.append(name.text.strip())


    for rating in soup.findAll('svg',{'class':'UctUV d H0'}):
        ratings.append(rating['aria-label'])


    for review in soup.findAll('span',{'class':'IiChw'}):
        reviews.append(review.text.strip())


    for p in soup.findAll('span',{'class':'ABgbd'}):
        pplus = p.find_all(text=re.compile("\$.*"))
        for i in pplus:
            prices.append(i)





# Create the dictionary.
dict = {'Hotel Names':Restaurants,'Ratings':ratings,'Number of Reviews':reviews,'Prices':prices}

print(dict)

    # Create the dataframe.
Kingston = pd.DataFrame.from_dict(dict)
Kingston.head(10)

# Convert dataframe to CSV file.
Kingston.to_csv('kingstonRest.csv', index=False, header=True)






