# -*- coding: utf-8 -*-
"""
Created on Wed May  1 01:53:01 2019

@author: hfyjc
"""

def coutmiss(l,size):
    cache=l[:size]
    count=0
    for i in range(size,len(l)):
        if l[i] in cache:
            cache.remove(l[i])
        else:
            count+=1
            cache.pop(0)
        cache.append(l[i])
    
    return count


print(coutmiss([1,1,1,1,1,1,1,1,2],4))