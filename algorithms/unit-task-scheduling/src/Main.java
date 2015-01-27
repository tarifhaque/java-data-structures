import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main (String args[]) {
        int[] deadlines = {2, 3, 5, 2, 3, 4, 5};
        int[] rewards = {10, 16, 18, 12, 20, 8, 14};

        ArrayList<Task> tasks = UnitTaskScheduling.createTasks(deadlines, rewards);

        System.out.println("Input Tasks [ Deadline, Reward ($) ]");
        for (Task t : tasks)
            System.out.println(t.toString());

        System.out.println("\nRunning the Unit Task Scheduling Algorithm... ");

        Task[] schedule = UnitTaskScheduling.scheduleTasks(tasks, 5);

        System.out.println(Arrays.toString(schedule));
        System.out.println("Total Reward: $" + UnitTaskScheduling.getTotalReward(schedule));
    }

}
