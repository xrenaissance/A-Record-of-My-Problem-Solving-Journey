class Solution:
    def judgeCircle(self, moves: str) -> bool:
        # Initiate two variables for directions
        if not moves:
            return True
        direction_dict = {
            "U" : 0,
            "D" : 0,
            "L" : 0,
            "R" : 0
        }
        for d in moves:
            direction_dict[d] += 1
        return direction_dict["U"] == direction_dict["D"] and direction_dict["L"] == direction_dict["R"]
