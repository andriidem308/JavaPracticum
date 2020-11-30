package multithreadingTasks.task7;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class MovingThread extends Thread {
    final long maxTime = 4500;
    private String threadName;
    private ArrayDeque<Train> trains;
    private final Tunnel [] tunnels;

    MovingThread(ArrayDeque<Train> trainsDeque, Tunnel[] tunnelsArray){
        threadName = "MovingThread";
        trains = new ArrayDeque<>(trainsDeque);
        tunnels = tunnelsArray;

        start();
    }

    long getTime(double speed, double distance) {
       return (long) Math.ceil(distance / speed);
    }

    public void run() {
        System.out.println(threadName + " started!");
        Tunnel current = tunnels[0];

        ArrayList<Thread> threads = new ArrayList<>();

        while (!trains.isEmpty()){
            try {
                Thread.sleep(maxTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (current.isAvailable()){
                Train train = trains.remove();
                trains.add(train);
                threads.add(new TrainRun(current, train));

            } else {
                if (threads.get(threads.size()-1).isAlive()) {
                    current = (current == tunnels[0]) ? tunnels[1] : tunnels[0]; ;
                }
            }
        }
    }
}
