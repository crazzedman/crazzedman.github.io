# -*- coding: utf-8 -*-
"""
Created on Mon May  1 16:18:55 2023

@author: 24AaronL
"""

import numpy as np 
#np.random.seed(0)
#creating Artificial Neural Network
def sigmoid (x):
    return 1/(1 + np.exp(-x))

def sigmoid_derivative(x):
    return x * (1 - x)
#before
#Input datasets
inputs = np.array([[0,0],[0,1],[1,0],[1,1]])
expected_output = np.array([[0],[1],[1],[0]])

maxiterations = 1000000
lr = 0.1
inputLayerNeurons, hiddenLayerNeurons, outputLayerNeurons = 2,2,1

#Random weights and bias initialization
hidden_weights = np.random.uniform(size=(inputLayerNeurons,hiddenLayerNeurons))
hidden_bias =np.random.uniform(size=(1,hiddenLayerNeurons))
output_weights = np.random.uniform(size=(hiddenLayerNeurons,outputLayerNeurons))
output_bias = np.random.uniform(size=(1,outputLayerNeurons))

print("Initial hidden weights: ",end='')
print(*hidden_weights)
print("Hidden biases: ",end='')
print(*hidden_bias)
print("Initial output weights: ",end='')
print(*output_weights)
print("Output biases: ",end='')
print(*output_bias)


#Training rule
#During
maxerror = -1
iterations = 0

for _ in range(maxiterations):
    #feedforward
    hidden_layer_activation = np.dot(inputs,hidden_weights)
    hidden_layer_activation += hidden_bias
    hidden_layer_output = sigmoid(hidden_layer_activation)
    output_layer_activation = np.dot(hidden_layer_output,output_weights)
    output_layer_activation += output_bias
    predicted_output = sigmoid(output_layer_activation)
    #Backpropagation
    error = expected_output - predicted_output
    stopper = 0;
    for i in range(4):
        if error[i] > maxerror:
            maxerror=error[i]
        if error[i] < 0.01:
            stopper+=1
    if stopper == 4:
        break
    d_predicted_output = error * sigmoid_derivative(predicted_output)
    error_hidden_layer = d_predicted_output.dot(output_weights.T)
    d_hidden_layer = error_hidden_layer * sigmoid_derivative(hidden_layer_output)
    #Updating Weights and Biases
    output_weights += hidden_layer_output.T.dot(d_predicted_output) * lr
    hidden_weights += inputs.T.dot(d_hidden_layer) * lr
    
    iterations+=1

#After
print("Final hidden weights: ",end='')
print(*hidden_weights)

print("Final output weights: ",end='')
print(*output_weights)
print("Maxerror : ", end = '')
print(maxerror)
if iterations == maxiterations:
    print("\nOutput from neural network after maximum amount of iterations: ",end='')
    print(*predicted_output)
elif iterations < maxiterations:
    print("\nOutput from neural network after " + str(iterations) + " iterations : ",end='')
    print(*predicted_output)
    