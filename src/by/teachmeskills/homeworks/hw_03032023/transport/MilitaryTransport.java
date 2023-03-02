package by.teachmeskills.homeworks.hw_03032023.transport;

public class MilitaryTransport extends AirTransport {
    private boolean ejectionSystem;
    private int rocketsOnBoard;

    public MilitaryTransport(int power, int maxSpeed, int weight, String brand, int wingspan, int minimumRunwayLength, boolean ejectionSystem, int rocketsOnBoard) {
        super(power, maxSpeed, weight, brand, wingspan, minimumRunwayLength);
        this.ejectionSystem = ejectionSystem;
        this.rocketsOnBoard = rocketsOnBoard;
    }

    protected boolean isEjectionSystem() {
        return ejectionSystem;
    }

    protected void setEjectionSystem(boolean ejectionSystem) {
        this.ejectionSystem = ejectionSystem;
    }

    protected int getRocketsOnBoard() {
        return rocketsOnBoard;
    }

    protected void setRocketsOnBoard(int rocketsOnBoard) {
        this.rocketsOnBoard = rocketsOnBoard;
    }

    protected void shot(int r) {
        if (r > 0 && r <= rocketsOnBoard && r != 0) {
            System.out.println("Ракета пошла");
        } else {
            System.out.println("Боеприпасы отсутствуют");
        }
    }

    protected void checkEjectionSystem() {
        if (ejectionSystem == true) {
            System.out.println("Катапультирование прошло успешно");
        } else {
            System.out.println("У Вас нет такой системы");
        }
    }

    @Override
    public String toString() {
        return "Военный самолет - " + super.toString() + " система катапультирования " + ejectionSystem + ", количество ракет на борту = " + rocketsOnBoard + " шт.";
    }
}