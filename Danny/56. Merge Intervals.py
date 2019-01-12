# Definition for an interval.
# class Interval:
#     def __init__(self, s=0, e=0):
#         self.start = s
#         self.end = e


class Solution:
    def merge(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: List[Interval]
        """
        """
        Edge Case: 
        - No Array -> Nothing
        - One Array -> One Array
        
        Assumption:
        - Number > 0
        - Arrays are not sorted
        
        1. Sort base on 1st element, then check and merge neighbour intervals
        """
        merged = []

        if len(intervals) in [0, 1]:
            return intervals

        intervals.sort(key=lambda x: x.start)
        for interval in intervals:
            # Check this interval with next interval
            if len(merged) == 0:
                # Add first interval to merged
                merged.append(interval)
            else:
                # Check current interval against merged
                if (interval.start >= merged[-1].start and interval.end <= merged[-1].end) or (interval.start <= merged[-1].end and interval.end >= merged[-1].start):
                    # Merge
                    merged[-1].start = min(merged[-1].start, interval.start)
                    merged[-1].end = max(merged[-1].end, interval.end)

                else:
                    merged.append(interval)
        return merged
