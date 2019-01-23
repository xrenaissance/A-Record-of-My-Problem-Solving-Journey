class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.min = None
        self.freq_dict = {}

    def push(self, x):
        """
        :type x: int
        :rtype: void
        """
        print(self.min)
        if not self.min and self.min != 0:
            self.min = x
        elif x < self.min:
            self.min = x
        if x not in self.freq_dict:
            self.freq_dict[x] = 1
        else:
            self.freq_dict[x] += 1
        self.stack.append(x)

    def pop(self):
        """
        :rtype: void
        """
        e = self.stack.pop()
        self.freq_dict[e] -= 1
        # Need to check and adjust the minimum value after pop
        # It will be O(N), unless there's already a data structure that keeps track of the sorted order of all stack elements
        # I can use a frequency hash table to determine if it needs to update or not
            
        if self.freq_dict[e] == 0:
            if len(self.stack) == 0:
                self.min = None
            else:
                self.min = self.stack[0]
                for i in self.stack:
                    if i < self.min:
                        self.min = i

    def top(self):
        """
        :rtype: int
        """
        return self.stack[-1]
        

    def getMin(self):
        """
        :rtype: int
        """
        return self.min


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
