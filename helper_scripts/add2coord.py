#!/usr/bin/python
import urllib
import json
import sqlite3

conn= sqlite3.connect('shuttle.db')
c = conn.cursor()
c.execute('''create table locations
              (name TEXT, address TEXT,lat READ,lng READ)''')

endpoint = 'http://maps.googleapis.com/maps/api/geocode/json?sensor=false&address='
f = open('./addrlst.txt')
for addr in f:
    tup = addr.split(';')
    name = tup[0]
    addr = tup[1]
    quote_plus = urllib.quote_plus(addr)
    res = urllib.urlopen(endpoint+quote_plus)
    data = json.loads(res.read())
    if len(data['results']) > 0:
        lat =  data['results'][0]['geometry']['location']['lat']
        lng = data['results'][0]['geometry']['location']['lng']
        lst = [name,addr,lat,lng]
        c.execute('INSERT into locations (name,address,lat,lng) VALUES (?,?,?,?)',lst)
        #print 'aMap.put("%s", new Coordinate(%s,%s));' % (name,lat,lng)

conn.commit()
c.close()





