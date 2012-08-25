import sqlite3,csv
conn= sqlite3.connect('shuttle.db')

c = conn.cursor()
c.execute('''create table shuttle
            (shuttle_ID INTEGER,stop_ID INTEGER, 
            time INTEGER,lat REAL,lng REAL,stop_name TEXT)''')
with open('northIC.csv','rb') as infile:
    dr = csv.DictReader(infile,delimiter=',')
