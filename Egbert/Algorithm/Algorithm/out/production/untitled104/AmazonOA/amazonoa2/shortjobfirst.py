# -*- coding: utf-8 -*-
"""
Created on Wed May  1 12:36:53 2019

@author: hfyjc
"""

def sjf(R,E):
    Time=[]
    for i in range(len(R)):
        Time.append([R[i],E[i],R[i]+E[i],R[i]])
    Time.sort(key=lambda X:(X[0],X[-1]))
    
        
    
    wait=0
    
    while Time:
        curr=Time.pop(0)
        print(curr[1])
        wait+=curr[-1]-curr[0]
        
        for x in Time:
            if x[-1]<curr[2]:
                
                x[-1]=curr[2]
                x[2]=x[-1]+x[1]
        Time.sort(key=lambda X:(X[-1],X[2]))
    
    print(wait)
    avg=wait/len(R)
    return avg

print(sjf([8,9,10,12],[4,2,3,1]))        