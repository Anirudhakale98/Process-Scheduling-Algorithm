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
        }

        System.out.println("Priority Scheduling Algorithm of given process is:");

        priorityScheduling(p);

        Output op = new Output();
        op.printProcess(p);
        op.printAvgTAT(p);
        op.printAvgWT(p);
    }

    // Sorting processes by arrival time only
    public static class sortByAt implements Comparator<Process> {
        public int compare(Process p1, Process p2) {
            return Integer.compare(p1.arrivalTime, p2.arrivalTime);
        }
    }

    public static void priorityScheduling(Process p[]) {
        Arrays.sort(p, new sortByAt()); // Sort by arrival time
        PriorityQueue<Process> pq = new PriorityQueue<>(new Comparator<Process>() {
            public int compare(Process p1, Process p2) {
                if (p1.priority == p2.priority) {
                    return Integer.compare(p1.arrivalTime, p2.arrivalTime);
                }
                return Integer.compare(p1.priority, p2.priority); // Lower value = higher priority
            }
        });

        int time = 0; // Track CPU time
        int i = 0; // Index for process array
        int n = p.length;

        while (!pq.isEmpty() || i < n) {
            // Add all processes that have arrived until the current time
            while (i < n && p[i].arrivalTime <= time) {
                pq.add(p[i]);
                i++;
            }

            if (!pq.isEmpty()) {
                // Get highest-priority process
                Process curr = pq.poll();
                time += curr.burstTime;
                curr.completionTime = time;
                curr.calculateTAT();
                curr.calculateWT();
            } else {
                // If no process is available, move to the next arrival time
                if (i < n) {
                    time = p[i].arrivalTime;
                }
            }
        }
    }

    public static void main(String[] args) {
        // Test your code here if needed
    }
}
