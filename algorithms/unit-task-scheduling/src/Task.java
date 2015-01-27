public class Task implements Comparable<Task> {
    public Task(int n, int d, int r) {
        taskNumber = n;
        reward = r;
        deadline = d;
    }

    private int taskNumber;
    private int reward;
    private int deadline;

    public int getDeadline() {
        return deadline;
    }

    public int getReward() {
        return reward;
    }

    /****************************************************
     * A task is "greater than" another task if it has
     * a greater reward.
     ****************************************************/
    @Override
    public int compareTo(Task task) {
        if (this.reward < task.reward) return -1;
        else if (this.reward > task.reward) return 1;
        else return 0;
    }

    @Override
    public String toString() {
        String str = Integer.toString(taskNumber) + ": " + "["
                + Integer.toString(deadline) + ", " + Integer.toString(reward) + "]";
        return str;
    }
}

