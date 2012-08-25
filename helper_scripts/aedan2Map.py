f = open('./intercampus.txt')
x = 0
for line in f:
    tup = line.strip().split('@')
    name = tup[0].strip()
    coord =  tup[1].split(',')
    #print 'lol.add(new Coordinate(%s,%s,%s));' % (coord[0],coord[1],x)
    print '%s : %s' % (str(x), name)
    x = x + 1

