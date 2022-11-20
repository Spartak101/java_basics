public class Elevator {
    private final int minFloor;
    private final int maxFloor;
    public int currentFloor = 1;

    public Elevator(int minFloor, int maxFloor) {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void moveDown() {
        currentFloor = currentFloor - 1;
    }

    public void moveUp() {
        currentFloor = currentFloor + 1;
    }

    public void move(int floor) {
        if((floor > maxFloor || floor < minFloor) && floor != currentFloor) {
            System.out.println("Что-то пошло не так");
        }
        boolean fixFloor = floor <= maxFloor && floor >= minFloor;
        while (fixFloor) {
            if (currentFloor < floor) {
                moveUp();
                System.out.println(getCurrentFloor());
                continue;
            } else if (floor < currentFloor) {
                moveDown();
                System.out.println(getCurrentFloor());
                continue;
            } break;
        }
    }
}
