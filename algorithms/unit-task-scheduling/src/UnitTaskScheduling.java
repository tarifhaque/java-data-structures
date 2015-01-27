/*********************************************************
 * UnitTaskScheduling.java
 * A class that addresses the unit task scheduling problem.
 *
 * Written by: Tarif Haque
 *********************************************************/

import java.util.ArrayList;
import java.util.Collections;

public class UnitTaskScheduling {

    /*********************************************************
     * The "greedy" part of the algorithm.
     * Returns the latest available time slot in the schedule.
     *
     * Returns null if the schedule cannot meet the deadline.
     *********************************************************/
    private static Integer getLatestAvailableSlot(Task[] schedule, int deadline) {

        // no available slots if the deadline is after last slot
        if (deadline > schedule.length) return null;

        for (int i = deadline - 1; i >= 0; i--) {
            if (schedule[i] == null) return i;
        }

        return null;
    }

    /*********************************************************
     * Schedule them tasks. The centerpiece of the algorithm.
     *********************************************************/
    public static Task[] scheduleTasks(ArrayList<Task> taskList, int timeSlots) {
        // create a schedule with given number of unit time slots
        Task[] schedule = new Task[timeSlots];

        // sort input tasks in order of descending rewards
        Collections.sort(taskList);
        Collections.reverse(taskList);

        int taskCounter = 0;
        while(taskCounter != taskList.size() - 1) {

            // get the task that provides the most reward
            Task greedyTask = taskList.get(taskCounter);
            Integer latestAvailableSlot = getLatestAvailableSlot(schedule, greedyTask.getDeadline());

            // the schedule cannot accommodate the task, so skip it
            if (latestAvailableSlot == null) {
                taskCounter++;
                continue;
            } else { // the schedule can accommodate the task
                schedule[latestAvailableSlot] = greedyTask;
            }

            taskCounter++;
        }

        return schedule;
    }

    /*********************************************************
     * Populate a list of Tasks given their deadlines
     * and rewards.
     *********************************************************/
    public static ArrayList<Task> createTasks(int[] deadlines, int[] rewards) {
        ArrayList<Task> tasks = new ArrayList<Task>();
        for (int i = 0; i < deadlines.length; i++) {
            Task task = new Task(i + 1, deadlines[i], rewards[i]);
            tasks.add(task);
        }
        return tasks;
    }

    /*********************************************************
     * Given a schedule, return the $ reward it provides.
     * The total reward is the sum of the rewards that the
     * schedule accomodates.
     *********************************************************/
    public static int getTotalReward(Task[] schedule) {
        int sum = 0;

        for (int i = 0; i < schedule.length; i++) {
            if (schedule[i] == null) continue;
            else sum += schedule[i].getReward();
        }

        return sum;
    }

}
