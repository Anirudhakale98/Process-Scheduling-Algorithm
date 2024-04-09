package SchedulingAlgorithms;

import java.util.*;
import SchedulingAlgorithms.Process;
import SchedulingAlgorithms.Input;
import SchedulingAlgorithms.Output;

public class RoundRobin {

    public static class sortByAt implements Comparator<Process> {

        public int compare(Process p1, Process p2) {

            return Integer.compare(p1.arrivalTime, p2.arrivalTime);

        }

    }

    public static void roundRobin(Process p[], int tq) {
        // tq : time quantum
        Arrays.sort(p, new sortByAt());
        Queue<Process> q = new LinkedList<Process>();
        // Temp Burst Time array is used to make copy of burst time of each process then
        // we have to restore it because in round robin burst time changes every time
        int tempBurstTime[] = new int[p.length];
        for (int i = 0; i < p.length; i++) {
            tempBurstTime[i] = p[i].burstTime;
            q.add(p[i]);
        }

        int time = 0;

        while (!q.isEmpty()) {
            Process temp = q.poll();
            if (temp.arrivalTime <= time) {
                if (temp.burstTime >= tq) {
                    time += tq;
                    temp.burstTime = temp.burstTime - tq;
                    q.add(temp);
                } else {
                    time += temp.burstTime;
                    temp.completionTime = time;
                    temp.burstTime = 0;

                }
            } else {
                q.add(temp);
                time++;
            }
        }

        for (int i = 0; i < p.length; i++) {
            p[i].burstTime = tempBurstTime[i];
            p[i].calculateTAT();
            p[i].calculateWT();
        }

    }

    public static void main(String[] args) {

        // System.out.println("Scheduling Algorithm");
        Scanner sc = new Scanner(System.in);
        Input in = new Input();
        Process[] p = in.getInput();
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

}
