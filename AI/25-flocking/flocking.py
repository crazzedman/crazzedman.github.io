# -*- coding: utf-8 -*-
"""
Created on Mon Mar  6 13:34:36 2023

@author: 24AaronL
"""

import pygame
import numpy as np
from boid import Boid
def runner():
    width = 1000
    height = 1000
    sep = input("From 1-5 label priority of Separation:")
    coh = input("From 1-5 label priority of Cohesion:")
    ali = input("From 1-5 label priority of Alignment:")
    boids = [Boid(*np.random.rand(2)*1000,width,height,sep,coh,ali) for _ in range(30)]  
    display = pygame.display.set_mode((width, height))

    
    run = True 
    while(run):
        pygame.time.delay(50)
        #controls environment through user input/helps it run smoothly
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                run = False
        display.fill((0, 0, 0))
        for boid in boids:
            boid.display(display)
            boid.apply_conditions(boids)
            boid.move()
            boid.borders()
            
        pygame.display.update()    
    pygame.quit()    
    
runner()
    
