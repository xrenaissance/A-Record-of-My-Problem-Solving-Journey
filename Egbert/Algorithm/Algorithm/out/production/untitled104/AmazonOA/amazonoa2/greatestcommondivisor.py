# -*- coding: utf-8 -*-
"""
Created on Wed May  1 01:29:44 2019

@author: hfyjc
"""

def greatestcommondivisor(A,B):
    
    r=A%B
    
    while r:
        A=B
        B=r
        r=A%B
    return B
print(greatestcommondivisor(18,45))
        