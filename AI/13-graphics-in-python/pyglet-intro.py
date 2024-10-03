# -*- coding: utf-8 -*-
"""
Created on Tue Feb 21 09:31:20 2023

@author: 24AaronL
"""
#taken from website but slightly edited to make animated object
import pyglet
from pyglet import shapes
from pyglet.window import key


x = 250
y = 250
speed = 10

window = pyglet.window.Window(500,500)
batch = pyglet.graphics.Batch()
rectangle = shapes.Rectangle(x, y, 30, 30, color=(255, 22, 20), batch=batch)

@window.event
def on_key_press(symbol, modifiers):
    if symbol == key.LEFT and x>0:
        rectangle.x -= speed 
    if symbol == key.RIGHT and x<480:
        rectangle.x += speed
    if symbol == key.DOWN and y>0:
        rectangle.y -= speed
    if symbol == key.UP and y<480:
        rectangle.y += speed
@window.event
def on_draw():
    window.clear()
    batch.draw()
    
    
pyglet.app.run()
    