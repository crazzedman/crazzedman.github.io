# -*- coding: utf-8 -*-
"""
Created on Thu Mar 16 13:15:51 2023

@author: 24AaronL
help from https://numpy.org/doc/stable/reference/generated/numpy.linalg.norm.html
coding train vid for some help
for numpy and math regarding conditions

"""
import pygame
import numpy as np
import math
from p5 import Vector

class Boid:
    def __init__(self, x, y,width,height,sep,coh,ali):
        self.position = Vector(x,y)
        vec = (np.random.rand(2) - 0.5)*10
        self.velocity = Vector(*vec)
        vec = (np.random.rand(2) - 0.5)/2
        self.acceleration = Vector(*vec) 
        self.perception = 50
        self.width = width
        self.height = height
        self.max_speed = 5
        self.max_force = 0.3
        self.sep=sep
        self.coh=coh
        self.ali=ali
        
        self.color = list(np.random.choice(range(255),size=3))

    def display(self,display):
        angle = math.atan2(self.velocity[1],self.velocity[0])
        self.p1=(self.position.x+10*math.cos(angle),self.position.y+10*math.sin(angle))
        self.p2=(self.position.x+5*math.cos(angle+2*math.pi/3),self.position.y+5*math.sin(angle+2*math.pi/3))
        self.p3=(self.position.x+5*math.cos(angle+4*math.pi/3),self.position.y+5*math.sin(angle+4*math.pi/3))
        
        pygame.draw.polygon(display,self.color,[self.p1,self.p2,self.p3])
    
    def borders(self):
        if self.position.x > self.width:
            self.position.x = 0
        elif self.position.x < 0:
            self.position.x = self.width
        if self.position.y > self.height:
            self.position.y = 0
        elif self.position.y < 0:
            self.position.y = self.height  
            
    def cohesioncondition(self,boids):
        #set vectors of steering and center of mass to 0
        steering = Vector(*np.zeros(2))
        total = 0
        com = Vector(*np.zeros(2))
        #find boids within range to form cohesion
        for boid in boids:
            if np.linalg.norm(boid.position - self.position) < self.perception:
                com += boid.position
                total += 1
        #checks if there are boids within range
        if total > 0:
            com /= total
            #divide the com and set vector of the com to the total number of boids in cohesion
            com = Vector(*com)
            vec_to_com = com - self.position
            if np.linalg.norm(vec_to_com) > 0:
                vec_to_com = (vec_to_com / np.linalg.norm(vec_to_com)) * self.max_speed
            steering = vec_to_com - self.velocity
            
            #ensures no drift and too much force use
            if np.linalg.norm(steering)> self.max_force:
               steering = (steering /np.linalg.norm(steering)) * self.max_force
               
        return steering
    

    def separationcondition(self,boids):
        steering = Vector(*np.zeros(2))
        total = 0
        avg_vector = Vector(*np.zeros(2))
        for boid in boids:
            distance = np.linalg.norm(boid.position - self.position)
            #checks boids within range
            if self.position != boid.position and distance < self.perception:
                diff = self.position - boid.position
                avg_vector += diff
                #adds the distance of all the vectors nearby and their distance from self vector
                total += 1
        if total > 0:
            #calculate the average space that is needed regarding position
            avg_vector /= total
            avg_vector = Vector(*avg_vector)
            if np.linalg.norm(steering) > 0:
                avg_vector = (avg_vector / np.linalg.norm(steering)) * self.max_speed
            steering = avg_vector - self.velocity
            
        #makes sure that there is no drift
            if np.linalg.norm(steering) > self.max_force:
                steering = (steering /np.linalg.norm(steering)) * self.max_force

        return steering
        
     
        
    def alignmentcondition(self,boids):
        steering = Vector(*np.zeros(2))
        total = 0
        avg_vec = Vector(*np.zeros(2))
        for boid in boids:
            if np.linalg.norm(boid.position - self.position) < self.perception:
                avg_vec += boid.velocity
                total += 1
        if total > 0:
            avg_vec /= total
            avg_vec = Vector(*avg_vec)
            avg_vec = (avg_vec /np.linalg.norm(avg_vec)) * self.max_speed
            steering = avg_vec - self.velocity
            #direction and makes an optimal alignment of all boids within range
        return steering

    def apply_conditions(self, boids):
        alignment = self.alignmentcondition(boids)
        separation = self.separationcondition(boids)
        cohesion = self.cohesioncondition(boids)
        self.acceleration += alignment*int(self.ali)
        self.acceleration += cohesion*int(self.coh)
        self.acceleration += separation*int(self.sep)
        
    
    def move(self):
        self.position += self.velocity
        self.velocity += self.acceleration
        if np.linalg.norm(self.velocity) > self.max_speed:
            self.velocity = self.velocity / np.linalg.norm(self.velocity) * self.max_speed
            
        self.acceleration = Vector(*np.zeros(2))
        angle = math.atan2(self.velocity[0],self.velocity[1]) 
        self.p1=(self.position.x+self.velocity[0]*5,self.position.y+self.velocity[1]*5)
        self.p2=(self.position.x+5*math.cos(angle+2*math.pi/3),self.position.y+5*math.sin(angle+2*math.pi/3))
        self.p3=(self.position.x+5*math.cos(angle+4*math.pi/3),self.position.y+5*math.sin(angle+4*math.pi/3))
        

        