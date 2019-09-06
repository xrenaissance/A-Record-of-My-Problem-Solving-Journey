# -*- coding: utf-8 -*-
"""
Created on Tue Apr 30 21:06:11 2019

@author: hfyjc
"""

def isValidParentheses(s):
    stack=[]
    for x in s:
        if x=='(':
            stack.append(x)
        if x==')':
            if len(stack)==0:
                return -1
            if stack.pop()!='(':
                return -1
    if len(stack)==0:
        return len(s)//2
    else:
        return -1


print(isValidParentheses('()()()()((()))))(()'))
print(isValidParentheses('()()()()'))
print(isValidParentheses(')((()))'))
                
                
