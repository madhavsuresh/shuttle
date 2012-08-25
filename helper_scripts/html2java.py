#!usr/bin/python
#from time import strptime,strftime

import sqlite3
conn= sqlite3.connect('shuttle.db')

c = conn.cursor()
#c.execute('''create table shuttle
            #(shuttle_ID INTEGER,stop_ID INTEGER, 
            #$time INTEGER,lat REAL,lng REAL,stop_name TEXT)''')

f = open('./interSouth.txt','r')
g = open('./intercampus.txt','r')
coord_map = {}
for line in g:
    tup = line.strip().split('@')
    name = tup[0].strip()
    coord =  tup[1].split(',')
    coord_t = (coord[0],coord[1])
    #print coord_t
    coord_map[name] = coord_t


print coord_map['Sherman/Noyes'][0]
#print 'shuttleID,stopID,lat,lng,time,stopName'

#intercampus north
shuttleID = 1
counter = 0
dict_list = {}
for line in f:
    times =  line.split()
    place = times[0]
    times = times[1:]
    time_list = []

    counter = counter + 1
    pm = 0
    for time in times:
        sp =  time.split(':')
        hour = int(sp[0])
        minute = sp[1]
        if hour == 12: 
            pm = 1
        elif pm == 1:
            hour = int(hour) + 12
        time = hour*100+int(minute)
        time_list.append(time)

    for time in time_list:
        #print 'shuttleID,stopID,time,lat,lng,stopName'
        lst = (shuttleID,counter,time,coord_map[place][0],coord_map[place][1],place,)
        print lst
        c.execute('INSERT into shuttle (shuttle_ID,stop_ID,time,lat,lng,stop_name) VALUES (?,?,?,?,?,?)',lst)



  #  coord_map[place] = (counter,coord_map[place])
    #print place, time_list, coord_map[place]
#print coord_map


            
conn.commit()
c.close()
            




f.close()
g.close()
