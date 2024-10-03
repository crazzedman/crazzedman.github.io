# -*- coding: utf-8 -*-
"""
Created on Thu Feb  2 13:46:22 2023

@author: 24AaronL
"""

letterdict = {}

name = "portfolio.csv"
lines=[]
for line in open (name):
  line=line[:-1]
  tokens=line.split(",")
  lines.append(tokens)

languagedict = {}

for x in lines:
    for y in x:
        if y == x[0]:
            letterdict[y]=0
print(languagedict)
name = "text1.txt"
lettercount = 0
for line in open (name, encoding="utf-8"):
  print (line)
  for c in line:
      print (c + " ", end=" ")
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
    if x == lines[0]:
        continue
    closest = 1000
    for y in x:
        if y == x[0]:
            continue
        b = abs(float(y)-letterdict[x[0]])
                
                
                
        
