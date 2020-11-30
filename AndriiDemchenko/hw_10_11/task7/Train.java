package multithreadingTasks.task7;

public class Train {
    private final int id;
    private double speed;

    public Train(int id, double speed) {
        this.id = id;
        this.speed = speed;
    }

    public double getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return "Train #" + id;
    }
}
