# -*- coding: utf-8 -*-
"""
Created on Tue Apr 30 21:29:36 2019

@author: hfyjc
"""

def longestpalindrome(s):
    start,end=0,0
    
            
    def helper(s,i,j):
        if s[i]!=s[j]:
            return(i,i)
        while(0<=i and j<len(s) and s[i]==s[j]):
            i-=1
            j+=1
        return(i+1,j-1)
    for i in range(len(s)-1):
        l,r=helper(s,i,i)
        if r-l>end-start:
            start,end=l,r
        l,r=helper(s,i,i+1)
        if r-l>end-start:
            start,end=l,r
    return(s[start:end+1])
    
print(longestpalindrome("abcdfe"))
print(longestpalindrome("babad"))
print(longestpalindrome("cbbdd"))
            