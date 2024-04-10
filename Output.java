package SchedulingAlgorithms;

import java.util.*;
import SchedulingAlgorithms.Process;
import SchedulingAlgorithms.Input;
import SchedulingAlgorithms.FCFS;

public class Output {
    public static void printProcess(Process[] p) {
        
        System.out
                .println("Process\t\tArrival Time\t\tBurst Time\t\tCompletion Time\t\tTurnaround Time\t\tWaiting Time");
        for (int i = 0; i < p.length; i++) {
            System.out
                    .println(p[i].getId() + "\t\t\t" + p[i].getArrivalTime() + "\t\t\t" + p[i].getBurstTime() + "\t\t\t"
                            + p[i].getCompletionTime() + "\t\t\t" + p[i].getTAT() + "\t\t\t" + p[i].getWT());
        }
    }

    public static float avgTAT(Process[] p) {
        float avg = 0;
        for (int i = 0; i < p.length; i++) {
            avg += p[i].getTAT();
        }
        return avg / p.length;
    }

    public static float avgWT(Process[] p) {
        float avg = 0;
        for (int i = 0; i < p.length; i++) {
            avg += p[i].getWT();
        }
        return avg / p.length;
    }

    public static void printAvgTAT(Process[] p) {
        System.out.println("Average Turn Around Time: " + avgTAT(p));
    }

    public static void printAvgWT(Process[] p) {
        System.out.println("Average Waiting Time: " + avgWT(p));
    }

    public static void main(String[] args) {

    }

}