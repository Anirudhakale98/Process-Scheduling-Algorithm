package SchedulingAlgorithms;

import java.util.*;
import SchedulingAlgorithms.Process;
import SchedulingAlgorithms.Input;
import SchedulingAlgorithms.Output;

public class FCFS {

    public FCFS(Process[] p) {
        fcfs(p);
        System.out.println("FCFS of given process is:");
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

    public static void fcfs(Process p[]) {

        Arrays.sort(p, new sortByAt());

        int time = 0;

        int i = 0;
        while (i < p.length) {

            if (p[i].arrivalTime <= time) {
                time = time + p[i].burstTime;
                p[i].completionTime = time;
                p[i].calculateTAT();
                p[i].calculateWT();
                i++;
            } else {

                time++;
            }

        }

    }

    public static void main(String[] args) {

    }

}
