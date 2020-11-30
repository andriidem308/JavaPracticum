package multithreadingTasks.task7;

import java.util.ArrayDeque;

public class Main {

    public static void main(String[] args) {
        Tunnel [] tunnels = new Tunnel[2];
        ArrayDeque<Train> trains = new ArrayDeque<>();

        Tunnel tunnel1 = new Tunnel(1, 480000);
        Tunnel tunnel2 = new Tunnel(2, 600000);

        Train train1 = new Train(1, 80);
        Train train2 = new Train(2, 90);
        Train train3 = new Train(3, 120);
        Train train4 = new Train(4, 75);
        Train train5 = new Train(5, 95);

        tunnels[0] = tunnel1;
        tunnels[1] = tunnel2;

        trains.add(train1);
        trains.add(train2);
        trains.add(train3);
        trains.add(train4);
        trains.add(train5);

        MovingThread movingThread = new MovingThread(trains, tunnels);

    }

}
