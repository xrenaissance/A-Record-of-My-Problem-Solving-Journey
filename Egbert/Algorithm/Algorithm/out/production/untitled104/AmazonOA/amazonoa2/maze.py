# -*- coding: utf-8 -*-
"""
Created on Tue Apr 30 17:39:25 2019

@author: hfyjc
"""

def haspath(maze):
    queue=[(0,4)]
    distance={}
    distance[(0,4)]=0
    direction=[(1,0),(0,1),(-1,0),(0,-1)]
    while queue:
        curr_position=queue.pop(0)
        
            
            
            
            
        for x,y in direction:
            i=curr_position[0]+x
            j=curr_position[1]+y
            
            if i>=0 and i<len(maze) and j>=0 and j<len(maze): 
                d=distance[curr_position]+1
                if (i,j) not in distance.keys():
                    distance[(i,j)]=d
                else:
                    distance[(i,j)]=min(distance[(i,j)],d)
                if maze[i][j]==2:
                    print(distance[(i,j)])
                    
                    return True
                if maze[i][j]==0:
                    queue.append((i,j))
                    maze[curr_position[0]][curr_position[1]]=3
                
            
            
    return False
    

    
maze=[[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,2]]
print(haspath(maze))
    