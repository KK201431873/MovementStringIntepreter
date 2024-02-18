import java.util.*;
import java.util.concurrent.*;

public class DriveSubsystem {

    private static volatile ExecutorService threadPool;

    public DriveSubsystem() {
        threadPool = Executors.newCachedThreadPool();
    }

    /**
     * Use only for autonomous. Follow the passed MovementSequence. Drive is robot centric.
     * @param movementSequence      The MovementSequence to be followed.
     */
    public void followMovementSequence(MovementSequence movementSequence, String sequenceName) {

        ArrayDeque<Movement> movements = movementSequence.movements.clone();

        String timestamp = "["+Double.toString((double)(System.currentTimeMillis() - Main.START_TIME)/1000)+"s] " ;
        System.out.println(timestamp+"STARTED \""+sequenceName+"\".");

        while (!movements.isEmpty()) {
            ArrayList<MovementThread> threadsToStart = new ArrayList<>();
            ArrayList<Future<?>> threadStatus = new ArrayList<>();

            // fetch all linked movements
            boolean linked = true, trulyLinked = false;
            while (!movements.isEmpty() && linked) {
                Movement movement = movements.removeFirst();
                linked = movement.linkedToNext;
                trulyLinked = movement.linkedToNext || trulyLinked;
                MovementThread thread = new MovementThread(movement, trulyLinked);
                threadsToStart.add(thread);
            }

            if (trulyLinked) {
                timestamp = "["+Double.toString((double)(System.currentTimeMillis() - Main.START_TIME)/1000)+"s] " ;
                System.out.print(timestamp);
            }

            for (MovementThread threadToStart : threadsToStart) {
                Future<?> status = threadPool.submit(threadToStart);
                threadStatus.add(status); // start the MovementThread
            }

            // wait until all linked movements are completed
            boolean running = true;
            while (running) {
                running = false;
                for (Future<?> status : threadStatus)
                    running = !status.isDone() || running; // running is only false if all threads are inactive
            }

            if (trulyLinked) {
                System.out.println();
            }

        }

        timestamp = "["+Double.toString((double)(System.currentTimeMillis() - Main.START_TIME)/1000)+"s] " ;
        System.out.println(timestamp+"FINISHED \""+sequenceName+"\".");

    }
}