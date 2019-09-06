package ParkingLot;

public class ParkingLot {
    private final Level[] levels;
    private int numOfCompactLeft;
    private int numOfLargeLeft;
    public ParkingLot(int numLevels, int numOfSpotsPerLevel) {
        levels = new Level[numLevels];
        for (int i = 0; i < numLevels; i++) {
            Level level = new Level(numOfSpotsPerLevel);
            levels[i] = level;
            this.numOfCompactLeft += level.getNumOfCompact();
            this.numOfLargeLeft += level.getNumOfLarge();
        }
        System.out.println("total num of Cpt: " + numOfCompactLeft);
        System.out.println("total num of large: " + numOfLargeLeft);
    }
    public boolean hasSpot(Vehicle v) {
        for (Level l : levels) {
            if (l.hasSpot(v)) {
                return true;
            }
        }
        return false;
    }
    public boolean park(Vehicle v) {
        for (Level l : levels) {
            if (v.getSize().getSize() == 1 && l.getNumOfCompact() > 0) {
                l.park(v);
                this.numOfCompactLeft--;
                System.out.println(" after parking num of cpt: " + this.numOfCompactLeft);
                System.out.println(" after parking num of larg: " + this.numOfLargeLeft);
                System.out.println();
                return true;
            } else if (v.getSize().getSize() == 1 && this.numOfCompactLeft > 0) {
                continue;
            } else if (v.getSize().getSize() == 1 && l.park(v)) {
                this.numOfLargeLeft--;
                System.out.println(" after parking num of cpt: " + this.numOfCompactLeft);
                System.out.println(" after parking num of larg: " + this.numOfLargeLeft);
                System.out.println();
                return true;
            } else if (l.park(v)) {
               this.numOfLargeLeft--;
                System.out.println(" after parking num of cpt: " + this.numOfCompactLeft);
                System.out.println(" after parking num of larg: " + this.numOfLargeLeft);
                System.out.println();
               return true;
            }
        }
        return false;
    }
    public boolean leave(Vehicle v) {
        for (Level l : levels) {
            if (l.leave(v)) {
                this.numOfCompactLeft = 0;
                this.numOfLargeLeft = 0;
                for (Level level : levels) {
                    this.numOfLargeLeft += level.getNumOfLarge();
                    this.numOfCompactLeft += level.getNumOfCompact();
                }
                System.out.println(" after leaving num of cpt: " + this.numOfCompactLeft);
                System.out.println(" after leaving num of larg: " + this.numOfLargeLeft);
                System.out.println();
                return true;
            }
        }
        return false;
    }
}
