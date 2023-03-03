package by.teachmeskills.homeworks.hw_03032023.transport;

public class AirTransport extends Transport {
    protected int wingspan;
    protected int minimumRunwayLength;

    public AirTransport(int power, int maxSpeed, int weight, String brand, int wingspan, int minimumRunwayLength) {
        super(power, maxSpeed, weight, brand);
        this.wingspan = wingspan;
        this.minimumRunwayLength = minimumRunwayLength;
    }

    public int getWingspan() {
        return wingspan;
    }

    public  void setWingspan(int wingspan) {
        this.wingspan = wingspan;
    }

    public  int getMinimumRunwayLength() {
        return minimumRunwayLength;
    }

    public  void setMinimumRunwayLength(int minimumRunwayLength) {
        this.minimumRunwayLength = minimumRunwayLength;
    }

    @Override
    public String toString() {
        return super.toString() + "размах крыльев = " + wingspan + " м., минимальная длина взлетно-посадочной полосы = " + minimumRunwayLength + " м., ";
    }
}