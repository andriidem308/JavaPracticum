package multithreadingTasks.task7;

public class TrainRun extends Thread{
    Tunnel tunnel;
    Train train;
    long time;

    TrainRun(Tunnel tunnel, Train train){
        this.tunnel = tunnel;
        this.train = train;

        time = (long) (tunnel.getDistance() / train.getSpeed());
        start();
    }

    public void run() {
        System.out.println(train + " went through " + tunnel);
        tunnel.setUnavailable();
        try {
            sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tunnel.setAvailable();
        System.out.println(train + " arrived to " + tunnel);
    }
}
