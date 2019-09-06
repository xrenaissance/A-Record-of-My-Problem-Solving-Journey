package ParkingLot;

public class ParkingSpot {
    private final VehicleSize size;
    private Vehicle currentVehicle;
    public ParkingSpot(VehicleSize size) {
        this.size = size;
    }
    public int getSize() {
        return size.getSize();
    }
    public boolean fit(Vehicle v) {
        return currentVehicle != null;
                //currentVehicle == null && size.getSize() > v.getSize().getSize();
    }

    public Vehicle getVehicle() {
        return this.currentVehicle;
    }

    // record a vehicle is parked by updating the currentVehicle field
    public void park(Vehicle v) {
        this.currentVehicle = v;
    }
    public void leave() {
        this.currentVehicle = null;
    }
}
