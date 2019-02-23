class Solution(object):
    def findRedundantConnection(self, edges):
        """
        :type edges: List[List[int]]
        :rtype: List[int]
        """
        if not edges:
            return None
            
        # Count degrees and Construct edge mappings
        uniq_dict = {}
        conn_dict = {}
        for edge in edges:
            e1, e2 = edge
            for e in edge:
                if e in uniq_dict:
                    uniq_dict[e] += 1
                else:
                    uniq_dict[e] = 1
            if e1 in conn_dict:
                conn_dict[e1].append(e2)
            else:
                conn_dict[e1] = [e2]
            if e2 in conn_dict:
                conn_dict[e2].append(e1)
            else:
                conn_dict[e2] = [e1]
            
        
        # Reduce degrees by removing single connections
        while 1 in uniq_dict.values():
            for k, v in uniq_dict.items():
                if v == 0:
                    uniq_dict.pop(k)
                elif v == 1:
                    uniq_dict.pop(k)
                    # Find all edges that has connection to k
                    for e in conn_dict[k]:
                        if e in uniq_dict:
                            uniq_dict[e] -= 1
                            
        # Now dictionary leaves with duplicated entries
        for edge in edges[::-1]:
            e1, e2 = edge
            if e1 in uniq_dict and e2 in uniq_dict:
                return edge
        
        
        return []
