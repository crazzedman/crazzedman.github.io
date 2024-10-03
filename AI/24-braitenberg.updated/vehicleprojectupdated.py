# -*- coding: utf-8 -*-
"""
Created on Wed Feb 22 12:37:17 2023

@author: 24AaronL
"""

import pygame
import math

pygame.init()
class vehicle1:
    def __init__(self, x, y, size,speed):
        self.x = x
        self.y = y
        self.size = size
        self.speed = speed
        
    def sense(self,mouselocation):
        xdist = abs((self.x+100)-mouselocation[0])
        ydist = abs(self.y-mouselocation[1])
        self.dist = math.sqrt(pow(xdist,2)+pow(ydist,2))
    def decide(self,mouselocation):
        if mouselocation[0]>=self.x+20 and mouselocation[0]<=self.x-20 and mouselocation[1]>=self.y+20 and mouselocation[1]<=self.y-20 :
            self.speed = 10
        else :
            self.speed=30/self.dist
    def act(self,display,mouselocation,image):
        self.x+=self.speed
        display.blit(image,(self.x,self.y))
        
class vehicle2:
    def __init__(self,module, x, y, size,speed):
        self.x = x
        self.y = y
        self.module = module
        self.size = size
        self.speedx = speed
        self.speedy = 0
        self.speed = speed
        self.direct = 0
        self.speedy = 0
        self.realdirect = 0
    def sense(self,mouselocation):
        sensorxl = self.x+85*math.cos(math.radians(self.direct+28))
        sensoryl = self.y+85*math.sin(math.radians(self.direct+28))
        sensorxr = self.x+85*math.cos(math.radians(self.direct-28))
        sensoryr = self.y+85*math.sin(math.radians(self.direct-28))  
        xdistl = abs(sensorxl-mouselocation[0])
        ydistl = abs(sensoryl-mouselocation[1])
        xdistr = abs(sensorxr-mouselocation[0])
        ydistr = abs(sensoryr-mouselocation[1])
        self.distl = math.sqrt(pow(xdistl,2)+pow(ydistl,2))
        self.distr = math.sqrt(pow(xdistr,2)+pow(ydistr,2))

    def decide(self,mouselocation):
        if mouselocation[0]<=self.x+200 and mouselocation[0]>=self.x-200 and mouselocation[1]<=self.y+200 and mouselocation[1]>=self.y-200 :
                self.speed = 5
                self.speedx=self.speed*math.cos(math.radians(-self.direct))
                self.speedy=self.speed*math.sin(math.radians(-self.direct))
                if self.module == 'a':
                    if self.distl > self.distr:
                        self.realdirect = -5
                    elif self.distl < self.distr:
                        self.realdirect = 5
                elif self.module == 'b':
                    if self.distl > self.distr:
                        self.realdirect = 5
                    elif self.distl < self.distr:
                        self.realdirect = -5
        else:
            self.speed = 2.5
            self.speedx=self.speed*math.cos(math.radians(-self.direct))
            self.speedy=self.speed*math.sin(math.radians(-self.direct))
            self.realdirect = 0
        
          
        
    def act(self,display,mouselocation,image):
        self.x+=self.speedx
        self.y+=self.speedy
        self.direct+=self.realdirect
        rotimage = pygame.transform.rotate(image, self.direct)
        newimage = rotimage.get_rect(center = image.get_rect(center = (self.x, self.y)).center)
        display.blit(rotimage,newimage)

class vehicle3: 
    def __init__(self,module, x, y, size,speed):
        self.x = x
        self.y = y
        self.module = module
        self.size = size
        self.speedx = speed
        self.speedy = 0
        self.speed = speed
        self.direct = 0
        self.speedy = 0
        self.realdirect = 0
    def sense(self,mouselocation):
        sensorxl = self.x+85*math.cos(math.radians(self.direct+28))
        sensoryl = self.y+85*math.sin(math.radians(self.direct+28))
        sensorxr = self.x+85*math.cos(math.radians(self.direct-28))
        sensoryr = self.y+85*math.sin(math.radians(self.direct-28))  
        xdistl = abs(sensorxl-mouselocation[0])
        ydistl = abs(sensoryl-mouselocation[1])
        xdistr = abs(sensorxr-mouselocation[0])
        ydistr = abs(sensoryr-mouselocation[1])
        self.distl = math.sqrt(pow(xdistl,2)+pow(ydistl,2))
        self.distr = math.sqrt(pow(xdistr,2)+pow(ydistr,2))

    def decide(self,mouselocation):
        if mouselocation[0]<=self.x+200 and mouselocation[0]>=self.x-200 and mouselocation[1]<=self.y+200 and mouselocation[1]>=self.y-200 :
                self.speed = 2.5
                self.speedx=self.speed*math.cos(math.radians(-self.direct))
                self.speedy=self.speed*math.sin(math.radians(-self.direct))
                if self.module == 'a':
                    if self.distl > self.distr:
                        self.realdirect = -5
                    elif self.distl < self.distr:
                        self.realdirect = 5
                elif self.module == 'b':
                    if self.distl > self.distr:
                        self.realdirect = 5
                    elif self.distl < self.distr:
                        self.realdirect = -5
        else:
            self.speed = 5
            self.speedx=self.speed*math.cos(math.radians(-self.direct))
            self.speedy=self.speed*math.sin(math.radians(-self.direct))
            self.realdirect =0
        
    def act(self,display,mouselocation,image):
        self.x+=self.speedx
        self.y+=self.speedy
        self.direct+=self.realdirect
        rotimage = pygame.transform.rotate(image, self.direct)
        newimage = rotimage.get_rect(center = image.get_rect(center = (self.x, self.y)).center)
        display.blit(rotimage,newimage)
    
        
class mouse:
    def display(self,display,mouselocation):
        pygame.draw.circle(display, (255,255,255), (mouselocation[0],mouselocation[1]),10)
    
def runner():
    line = input("Vehicle: ")
    if line == '1' : 
        lambo = vehicle1(0,400,20,2) 
        image = pygame.image.load("BRVehicle01.jpg")
    if line == '2a' :
        lambo = vehicle2('a',0,400,20,5)
        image = pygame.image.load("BRVehicle02a.jpg")
    if line == '2b' :
        lambo = vehicle2('b',0,400,20,5)
        image = pygame.image.load("BRVehicle02a.jpg")
    if line == '3a' :
        lambo = vehicle3('a',0,400,20,5)
        image = pygame.image.load("BRVehicle02a.jpg")
    if line == '3b' :
        lambo = vehicle3('b',0,400,20,5)
        image = pygame.image.load("BRVehicle02a.jpg")
    control = mouse()
    display = pygame.display.set_mode((800, 800))
    run = True 
    while(run):
        pygame.time.delay(50)
        #controls environment through user input/helps it run smoothly
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                run = False
        mouselocation = pygame.mouse.get_pos()               
        lambo.sense(mouselocation)
        lambo.decide(mouselocation)
        display.fill((0, 0, 0))
        control.display(display,mouselocation)
        lambo.act(display,mouselocation,image)
        pygame.display.update()    
    pygame.quit()

runner()


