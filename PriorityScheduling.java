package SchedulingAlgorithms;

import java.util.*;
import SchedulingAlgorithms.Process;
import SchedulingAlgorithms.Input;
import SchedulingAlgorithms.Output;

public class PriorityScheduling {
    static Scanner sc = new Scanner(System.in);

    public PriorityScheduling(Process[] p) {

        System.out.println("Enter Priority of given process: (0-has highest priority)");
        for (int i = 0; i < p.length; i++) {
            System.out.print(p[i].process_id + ": ");
            p[i].priority = sc.nextInt();
            System.out.println();
        }

        System.out.println("Priority Scheduling Algorithm of given process is:");

        priorityScheduling(p);
        // printProcess(p);
        Output op = new Output();
        op.printProcess(p);
        op.printAvgTAT(p);
        op.printAvgWT(p);

    }

    public static class sortByAt implements Comparator<Process> {

        public int compare(Process p1, Process p2) {
            // if (p1.arrivalTime == p2.arrivalTime) {
            // return Integer.compare(p2.priority, p1.priority);
            // }
            return Integer.compare(p1.arrivalTime, p2.arrivalTime);

        }

    }

    public static void priorityScheduling(Process p[]) {
        Arrays.sort(p, new sortByAt());
        PriorityQueue<Process> pq = new PriorityQueue<>(new Comparator<Process>() {
            public int compare(Process p1, Process p2) {
                if (p1.priority == p2.priority) {
                    return Integer.compare(p1.arrivalTime, p2.arrivalTime);
                }
                return Integer.compare(p1.priority, p2.priority);
            }
        });

        int time = 0;
        int i = 0;
        int n = p.length;
        while (!pq.isEmpty() || i < n) {
            while (i < n && p[i].arrivalTime <= time) {
                pq.add(p[i]);
                i++;
            }
            if (!pq.isEmpty()) {
                Process curr = pq.poll();
                time = time + curr.burstTime;
                curr.completionTime = time;
                curr.calculateTAT();
                curr.calculateWT();
            }
        }

    }

    public static void main(String[] args) {

        // System.out.println("Scheduling Algorithm");

    }

}
