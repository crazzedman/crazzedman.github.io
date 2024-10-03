# -*- coding: utf-8 -*-
"""
Created on Mon Mar 27 13:15:59 2023

@author: 24AaronL
"""
import pygame


pygame.init()
class Perceptron:
    def __init__(self, inputcount, inputs, weights):
        self.inputcount = inputcount
        self.inputs = inputs
        self.weights = weights
        self.currentgate = ""
        self.result = True
        
    def setinputvalues(self, newinputs, newweights,inputcount):
        line = input("Input: ")        
        self.inputs.append(line)
        line = input("Weight of Input: ")
        self.weights.append(line)
        line = input("Input 2: ")        
        self.inputs.append(line)
        line = input("Weight of Input 2: ")
        self.weights.append(line)
        self.inputcount = inputcount

        
    def andgate(self,threshold):
        self.currentgate = "and"
        self.threshold = threshold
        counter = 0
        values = []
        for a in self.inputs:
            value = int(self.weights[counter])*int(a)
            values.append(value)
            counter+=1
            
        previousvalue = values[0]
        output = 1
        self.result = True
        total = 0
        for value in values:
            if previousvalue != value:
                output = 0
                self.result = False
            
            previousvalue = value
            total+=value
        
        average = total/self.inputcount
        print(average)
        if average < int(threshold):
            output = 0
            self.result = False
        
        del values[:]
        
        return output
        
        
    def orgate(self,threshold):
        self.currentgate = "or"
        self.threshold = threshold
        counter = 0
        values = []
        
        for a in self.inputs:
            value = int(self.weights[counter])*int(a)
            values.append(value)
            counter+=1
            
        print(values)
        greatestvalue = values[0]
        output = 1
        self.result = True
        for value in values:
            if greatestvalue < value:
                greatestvalue = value
        
        print(greatestvalue)
        if greatestvalue < int(threshold):
            output = 0
            self.result = False
        else :
            output = greatestvalue
        
        del values[:]
        return output
        
    def display(self,display):
        pygame.draw.line(display,(255,255,255), (100,500),(100,100))
        pygame.draw.line(display,(255,255,255), (200,500),(200,100))
        pygame.draw.line(display,(255,255,255), (300,500),(300,100))
        pygame.draw.line(display,(255,255,255), (400,500),(400,100))
        pygame.draw.line(display,(255,255,255),(100,500),(500,500))
        pygame.draw.line(display,(255,255,255),(100,400),(500,400))
        pygame.draw.line(display,(255,255,255),(100,300),(500,300))
        pygame.draw.line(display,(255,255,255),(100,200),(500,200))
        if self.currentgate == "or" :
            x1=(100+int(self.threshold)*50,500)
            x2=(100,500-int(self.threshold)*50)
        elif self.currentgate == "and":
            x1 = (100+int(self.threshold)*150,500)
            x2=(100,500-int(self.threshold)*150)
            
        pygame.draw.line(display,(0,0,255),x1,x2)
    
        if not self.result :
            pygame.draw.circle(display,(255,0,0),(100+int(self.inputs[0])*100*int(self.weights[0]),500-int(self.inputs[1])*int(self.weights[1])*100),10)
        elif self.result :
            pygame.draw.circle(display,(0,255,0),(100+int(self.inputs[0])*100*int(self.weights[0]),500-int(self.inputs[1])*int(self.weights[1])*100),10)
        
        del self.inputs[:]
        del self.weights[:]
            
            
        
        
def runner():     
    pygame.init()
    display = pygame.display.set_mode((600, 600))
    inputs = []
    weights = []
    inputcount = 0
    perceptor = Perceptron(inputcount,inputs,weights)
    run = True 
    while(run):
        pygame.time.delay(50)
        #controls environment through user input/helps it run smoothly
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                run = False                
        display.fill((0,0,0))
        perceptor.setinputvalues(inputs,weights,2)
        threshold = input("Threshold Value: ")
        line = input("And Gate or Or Gate: ")
        if line == 'And Gate':
            print("Output : " + str(perceptor.andgate(threshold)))
        if line == 'Or Gate':
            print('Output : ' + str(perceptor.orgate(threshold)))
            
        perceptor.display(display)
        pygame.display.update()  
        if "y" == input("Do you want to end the gates(y/n): "):
            run = False
    
    pygame.quit()
    
runner()