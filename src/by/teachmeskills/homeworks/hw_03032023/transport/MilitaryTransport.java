package by.teachmeskills.homeworks.hw_03032023.transport;

public class MilitaryTransport extends AirTransport {
    private boolean ejectionSystem;
    private int rocketsOnBoard;

    public MilitaryTransport(int power, int maxSpeed, int weight, String brand, int wingspan, int minimumRunwayLength, boolean ejectionSystem, int rocketsOnBoard) {
        super(power, maxSpeed, weight, brand, wingspan, minimumRunwayLength);
        this.ejectionSystem = ejectionSystem;
        this.rocketsOnBoard = rocketsOnBoard;
    }

    public boolean isEjectionSystem() {
        return ejectionSystem;
    }

    public void setEjectionSystem(boolean ejectionSystem) {
        this.ejectionSystem = ejectionSystem;
    }

    public int getRocketsOnBoard() {
        return rocketsOnBoard;
    }

    public void setRocketsOnBoard(int rocketsOnBoard) {
        this.rocketsOnBoard = rocketsOnBoard;
    }

    public void shot(int r) {
        if (r > 0 && r <= rocketsOnBoard && r != 0) {
            System.out.println("Ракета пошла");
        } else {
            System.out.println("Боеприпасы отсутствуют");
        }
    }

    public void checkEjectionSystem() {
        if (ejectionSystem) {
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