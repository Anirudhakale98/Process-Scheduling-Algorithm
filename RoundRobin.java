package SchedulingAlgorithms;

import java.util.*;
import SchedulingAlgorithms.Process;
import SchedulingAlgorithms.Input;
import SchedulingAlgorithms.Output;

public class RoundRobin {
    static Scanner sc = new Scanner(System.in);

    public RoundRobin(Process[] p) {
        int tq = 2;
        System.out.println("Time Quantum:");
        tq = sc.nextInt();

        System.out.println("RoundRobin of given process is:");

        roundRobin(p, tq);
        // printProcess(p);
        Output op = new Output();
        op.printProcess(p);
        op.printAvgTAT(p);
        op.printAvgWT(p);

    }

    public static class sortByAt implements Comparator<Process> {

        public int compare(Process p1, Process p2) {

            return Integer.compare(p1.arrivalTime, p2.arrivalTime);

        }

    }

    public static void roundRobin(Process p[], int tq) {
        Arrays.sort(p, new sortByAt()); // Sort by Arrival Time
        Queue<Process> q = new LinkedList<>();

        int tempBurstTime[] = new int[p.length]; // Store original burst times
        for (int i = 0; i < p.length; i++) {
            tempBurstTime[i] = p[i].burstTime;
        }

        int time = 0;
        int index = 0; // To track processes that have arrived
        while (index < p.length || !q.isEmpty()) {
            // Add all processes that have arrived by 'time'
            while (index < p.length && p[index].arrivalTime <= time) {
                q.add(p[index]);
                index++;
            }

            if (q.isEmpty()) {
                // If CPU is idle, move time forward
                time = p[index].arrivalTime;
                continue;
            }

            Process temp = q.poll(); // Get process from queue
            int executionTime = Math.min(temp.burstTime, tq);
            time += executionTime;
            temp.burstTime -= executionTime;

            if (temp.burstTime == 0) {
                temp.completionTime = time; // Process finished execution
            } else {
                q.add(temp); // Re-add to queue if it's not finished
            }
        }

        // Restore original burst times and calculate TAT, WT
        for (int i = 0; i < p.length; i++) {
            p[i].burstTime = tempBurstTime[i];
            p[i].calculateTAT();
            p[i].calculateWT();
        }
    }

    public static void main(String[] args) {

        // System.out.println("Scheduling Algorithm");

    }

}
