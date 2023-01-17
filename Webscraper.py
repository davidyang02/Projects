from urllib.request import Request, urlopen
from bs4 import BeautifulSoup
import requests

root = "https://www.google.com/"
link = "https://www.google.com/search?q=biden&tbm=nws&source=lnt&tbs=sbd:1&sa=X&ved=0ahUKEwjAvsKDyOXtAhXBhOAKHXWdDgcQpwUIKQ&biw=1604&bih=760&dpr=1.2"

req = Request(link, headers={'User-Agent': 'Mozilla/5.0'})


webpage = urlopen(req).read()

with requests.Session() as c:
    soup = BeautifulSoup(webpage, "html5lib")
    for item in soup.find_all('div', attrs={'class': 'kCrYT'}):
        print(item)

