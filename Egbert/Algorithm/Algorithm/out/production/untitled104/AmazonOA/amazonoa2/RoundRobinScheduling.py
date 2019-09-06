# -*- coding: utf-8 -*-
"""
Created on Wed May  1 14:45:28 2019

@author: hfyjc
"""

def RoundRobinScheduling(req,exe,t):
    data=[]
    for i in range(len(req)):
        data.append([req[i],exe[i],exe[i]])
    i=0
    waittime=0
    time=data[0][0]
    while data:
        
        curr=data.pop(0)
        curr[2]-=t
        if curr[2]<=0:
            time+=t+curr[2]
            
            waittime+=time-curr[0]-curr[1]
            print(waittime)
            if data and time<data[0][0]:
                time=data[0][0]
        else:
            time+=t
            if data and time<data[i][0]:
                data.insert(0,curr)
            else:
                data.append(curr)
    print(waittime)
    return waittime/len(req)

print(RoundRobinScheduling([3,4,5,6],[3,4,5,3],2))
print(RoundRobinScheduling([0,1,4],[5,2,3],3))
            
        
        