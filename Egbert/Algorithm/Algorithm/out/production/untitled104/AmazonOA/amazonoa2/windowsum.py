# -*- coding: utf-8 -*-
"""
Created on Wed May  1 00:21:14 2019

@author: hfyjc
"""

def windowsum(l,k):
    ans=[]
    for i in range(len(l)-k+1):
        print(i)
        ans.append(l[i]+l[i+1]+l[i+2])
    
    return(ans)

print(windowsum([0,1,2,3,4,5,6,7,8,9],3))
        