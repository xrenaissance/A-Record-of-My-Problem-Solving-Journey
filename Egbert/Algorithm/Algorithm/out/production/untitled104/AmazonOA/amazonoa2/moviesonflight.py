# -*- coding: utf-8 -*-
"""
Created on Mon Apr 29 23:05:32 2019

@author: hfyjc
"""

def moviesonflight(movie,flight):
    movies=[]
    pair=[]
    ans=[]
    
    for i,v in enumerate(movie):
        movies.append([v,i])
    
    target=flight-30
    movies.sort(key=lambda x:x[0])
    i,j=0,len(movies)-1
    while(i<j):
        if(movies[i][0]+movies[j][0]<=target):
            pair.append([movies[i][1],movies[j][1],target-movies[i][0]-movies[j][0]])
            i+=1
        else:
            j-=1
            
    pair.sort(key=lambda x:x[2])
    for x in pair:
        if x[2]==pair[0][2]:
            ans.append([movie[x[0]],movie[x[1]]])
    print(ans)
            

moviesonflight([90,85,75,60,120,150,125],250)
