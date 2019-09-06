package ParkingLot;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Level {
    private final List<ParkingSpot> spots;
    private int numOfCompactLeft;
    private int numOfLargeLeft;
    public Level(int numOfSpots) {
        List<ParkingSpot> list = new ArrayList<>(numOfSpots);
        int i = 0;
        for (; i < numOfSpots / 2; i++) {
            list.add(new ParkingSpot(VehicleSize.Compact));
            numOfCompactLeft++;
        }
        for (; i < numOfSpots; i++) {
            list.add(new ParkingSpot(VehicleSize.Large));
            numOfLargeLeft++;
        }
        spots = Collections.unmodifiableList(list);
    }
    public int getNumOfCompact() {
        return this.numOfCompactLeft;
    }
    public int getNumOfLarge(){
        return this.numOfLargeLeft;
    }
    public boolean hasSpot(Vehicle v) {
        for (ParkingSpot s : spots) {
            if (s.fit(v)) {
                return true;
            }
        }
        return false;
    }
    public boolean park(Vehicle v) {
        ParkingSpot availableSpot = findSpot(v);
        if (availableSpot != null) {
            availableSpot.park(v);
            if (availableSpot.getSize() == 1) {
                this.numOfCompactLeft--;
                System.out.println("level---- Num of compt: " + numOfCompactLeft);
            } else {
                this.numOfLargeLeft--;
                System.out.println("level----- Num of Larg: " + numOfLargeLeft);
            }
            return true;
        }
        return false;
    }
    public ParkingSpot findSpot(Vehicle v) {
        if (v.getSize().getSize() == 1) {
            for (ParkingSpot s : spots) {
                if (s.fit(v) && s.getSize() == v.getSize().getSize()) {
                    return s;
                }
            }
            for (ParkingSpot s : spots) {
                if (s.fit(v) && s.getSize() > v.getSize().getSize()) {
                    return s;
                }
            }
        } else {
            for (ParkingSpot s : spots) {
                if (s.fit(v) && s.getSize() == v.getSize().getSize()) {
                   return s;
                }
            }
        }
        return null;
    }
    public boolean leave(Vehicle v) {
        for (ParkingSpot s : spots) {
            if (s.getVehicle() == v) {
                s.leave();
                if (s.getSize() == 1) {
                    this.numOfCompactLeft++;
                } else {
                    this.numOfLargeLeft++;
                }
                return true;
            }
        }
        return false;
    }
}