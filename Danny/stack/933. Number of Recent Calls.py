class RecentCounter:

    def __init__(self):
        self.queue = []
        self.lower = 0

    def ping(self, t):
        """
        :type t: int
        :rtype: int
        """
        self.queue.append(t)
        while self.queue[self.lower] < t-3000:
            self.lower += 1
        return len(self.queue) - self.lower


# Your RecentCounter object will be instantiated and called as such:
# obj = RecentCounter()
# param_1 = obj.ping(t)
