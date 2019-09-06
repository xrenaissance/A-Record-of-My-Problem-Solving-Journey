# -*- coding: utf-8 -*-
"""
Created on Thu May  2 00:55:53 2019

@author: hfyjc
"""

def MaxminPath(A):
    ans=[]
    
    def helper(A,minv,i,j):
        
        if i<len(A)-1:
            
            helper(A,min(minv,A[i][j]),i+1,j)
        if j<len(A[0])-1:
            
            
            helper(A,min(minv,A[i][j]),i,j+1)
        
        if i==len(A)-1 and j==len(A[0])-1:
            minv=min(minv,A[i][j])
            
            ans.append(minv)
        
        
    helper(A,10000,0,0)
    return max(ans)
   

print(MaxminPath([[8,4,7],[6,5,9]]))