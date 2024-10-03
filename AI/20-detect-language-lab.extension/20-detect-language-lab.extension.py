# -*- coding: utf-8 -*-
"""
Created on Thu Feb  2 13:46:22 2023

@author: 24AaronL
"""



name = "portfolio.csv"
lines=[]
for line in open (name):
  line=line[:-1]
  tokens=line.split(",")
  lines.append(tokens)
languagedict = {}
for x in lines[0]:
    if x != lines[0][0]:
        languagedict[x]=0


letterdict = {}
for x in lines:
    if x == lines[0]:
        continue
    for y in x:
        if y == x[0]:
            letterdict[y]=0

line = input("Text: ")
lettercount = 0
for c in line:
    if c.lower() not in letterdict:
        letterdict[c.lower()]=1
        lettercount = lettercount+1
    else:
        a = letterdict[c.lower()]
        letterdict[c.lower()]=a+1
        lettercount = lettercount+1


print(letterdict)
print(lettercount)
letteraverage = {}
for x in letterdict:
    letteraverage[x] = (letterdict[x]/lettercount)*100
    temp = letteraverage[x]
    letteraverage[x] = round(temp,3)
print(letteraverage)

for x in lines:
    if x  == lines[0]:
        continue
    for y in x:
        if y == x[0]:
            continue
        var = abs(float(y)-letteraverage[x[0]])
        languagedict[lines[0][x.index(y)]]=languagedict[lines[0][x.index(y)]]+var
print(languagedict)

min = 1000
key = "random"
for x in lines[0]:
    if x != lines[0][0]:
        if min > languagedict[x]:
            min = languagedict[x]
            key = x

print('Most likely language: ' + key)
                                    
        
                
                
                
        
