class Stack:
    def __init__(self):
        self.stack = []
        self.counter = 0
        
    def push(self, e):
        self.counter += 1
        self.stack.append(e)
    
    def pop(self):
        if self.counter > 0:
            self.counter -= 1
            return self.stack.pop()
        else:
            return None
    
    def __len__(self):
        return self.counter
        
class Solution:
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        stack = Stack()
        for i in s:
            if i in ["(", "{", "["]:
                stack.push(i)
            else:
                poped = stack.pop()
                if not poped:
                    # s == ])}
                    return False
                if poped+i not in ["[]", "{}", "()"]:
                    return False
        if len(stack) == 0:
            return True
        else:
            return False
