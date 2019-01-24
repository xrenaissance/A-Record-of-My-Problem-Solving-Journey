class Baseball:
    def __init__(self):
        self.st = []
        
    def push(self, val):
        self.st.append(val)
    
    def C(self):
        self.st.pop()
    
    def D(self):
        val = 2 * self.top()
        self.push(val)
    
    def top(self):
        """
        :rtype: int or None
        Returns the last element on stack
        """
        return self.st[-1] if self.st else None
    
    def Plus(self):
        val = self.st[-1] + self.st[-2]
        self.push(val)
    
    def get_sum(self):
        return sum(self.st)
    
class Solution:
    def calPoints(self, ops):
        """
        :type ops: List[str]
        :rtype: int
        """
        baseball = Baseball()
        
        for i in ops:
            if i == "+":
                baseball.Plus()
            elif i == "C":
                baseball.C()
            elif i == "D":
                baseball.D()
            else:
                baseball.push(int(i))
        return baseball.get_sum()
