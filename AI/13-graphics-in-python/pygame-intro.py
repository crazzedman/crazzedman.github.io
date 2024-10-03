# -*- coding: utf-8 -*-
"""
Created on Mon Feb 20 13:06:09 2023

@author: 24AaronL
"""

import pygame

pygame.init()
  
display = pygame.display.set_mode((500, 500))
   
x = 200
y = 200

width = 20
height = 20

speed = 10
  
run = True
#infinite loop for continous movement
while run:
    pygame.time.delay(10)
      
    #controls environment through user input/helps it run smoothly
    for event in pygame.event.get():
          
        if event.type == pygame.QUIT:
            run = False
    keys = pygame.key.get_pressed()
      
    if keys[pygame.K_LEFT] and x>0:
        x -= speed 
    if keys[pygame.K_RIGHT] and x<500-width:
          
        x += speed
    if keys[pygame.K_UP] and y>0:
          
        y -= speed
           
    if keys[pygame.K_DOWN] and y<500-height:
        y += speed
         
             #resets the screen 
    display.fill((0, 0, 0))
       # creates rectangle
    pygame.draw.rect(display, (255, 0, 0), (x, y, width, height))
      
    pygame.display.update() 
  
pygame.quit()