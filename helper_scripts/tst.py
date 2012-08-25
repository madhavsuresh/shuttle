#!/usr/bin/python

f = open('./addrlst.txt')
for line in f:
    l = line.split(';')
    print '"%s",' % l[0]
