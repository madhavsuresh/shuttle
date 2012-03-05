#!/usr/bin/python
import urllib
import json

endpoint = 'http://maps.googleapis.com/maps/api/geocode/json?sensor=false&address='
f = open('./addrlst.txt')
for addr in f:
    print addr
    tup = addr.split(';')
    name = tup[0]
    addr = tup[1]
    quote_plus = urllib.quote_plus(addr)
    res = urllib.urlopen(endpoint+quote_plus)
    data = json.loads(res.read())
    if len(data['results']) > 0:
        lat =  data['results'][0]['geometry']['location']['lat']
        lng = data['results'][0]['geometry']['location']['lng']
        print 'aMap.put("%s", new Coordinate(%s,%s));' % (name,lat,lng)






