package by.teachmeskills.homeworks.hw_03032023.transport;

public class AirTransport extends Transport {
    private int wingspan;
    private int minimumRunwayLength;

    public AirTransport(int power, int maxSpeed, int weight, String brand, int wingspan, int minimumRunwayLength) {
        super(power, maxSpeed, weight, brand);
        this.wingspan = wingspan;
        this.minimumRunwayLength = minimumRunwayLength;
    }

    protected int getWingspan() {
        return wingspan;
    }

    protected  void setWingspan(int wingspan) {
        this.wingspan = wingspan;
    }

    protected  int getMinimumRunwayLength() {
        return minimumRunwayLength;
    }

    protected  void setMinimumRunwayLength(int minimumRunwayLength) {
        this.minimumRunwayLength = minimumRunwayLength;
    }

    @Override
    public String toString() {
        return super.toString() + "размах крыльев = " + wingspan + " м., минимальная длина взлетно-посадочной полосы = " + minimumRunwayLength + " м., ";
    }
}