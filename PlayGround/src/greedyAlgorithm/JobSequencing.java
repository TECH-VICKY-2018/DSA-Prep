package greedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class JobSequencing {

    class Job {
        int id, profit, deadline;

        Job(int x, int y, int z) {
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }

    class MaxProfitComparator implements Comparator<Job> {

        @Override
        public int compare(Job o1, Job o2) {
            return o2.profit - o1.profit;
        }
    }


    int[] JobScheduling(Job arr[], int n) {
        // Your code here
        List<Job> jobs = new ArrayList<>(Arrays.asList(arr));
        jobs.sort(new MaxProfitComparator());

        int maxJobSlot = 0;

        for (Job job : jobs) {
            if (job.deadline > maxJobSlot) {
                maxJobSlot = job.deadline;
            }
        }

        boolean[] occupiedSlots = new boolean[maxJobSlot];

        int jobsDone = 0;
        int maxProfit = 0;

        for(Job job : jobs){
            int deadline = job.deadline;

            while(deadline>0 && occupiedSlots[deadline]){
                deadline--;
            }

            if(deadline>0){
                occupiedSlots[deadline] = true;
                maxProfit+= job.profit;
                jobsDone++;
            }
        }

        return new int[]{jobsDone,maxProfit};
    }

}




