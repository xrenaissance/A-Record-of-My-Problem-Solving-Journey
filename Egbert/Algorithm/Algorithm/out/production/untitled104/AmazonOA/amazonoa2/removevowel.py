# -*- coding: utf-8 -*-
"""
Created on Tue Apr 30 20:53:36 2019

@author: hfyjc
"""

def removevowel(s):
    vowel=('a','e','i','o','u','A','E','I','O','U')
    news=''
    for x in s:
        if x not in vowel:
            news+=x
    print(news)

def removevowel1(s):
    vowel=('a','e','i','o','u','A','E','I','O','U')
    for x in vowel:
        s=s.replace(x,'',len(s))
    print(s)
removevowel('adfexceve')
removevowel1('adfexceve')        