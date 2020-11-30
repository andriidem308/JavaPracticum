package multithreadingTasks.task7;

public class Tunnel{
    private final int id;
    private boolean available;
    private final double distance;

    Tunnel(int id, double distance){
        this.id = id;
        this.distance = distance;
        available = true;
    }

    void setUnavailable(){available = false;}
    void setAvailable(){available = true;}
    boolean isAvailable(){return available;}

    double getDistance(){ return distance;}

    @Override
    public String toString() {
        return "Tunnel " + id;
    }
}
