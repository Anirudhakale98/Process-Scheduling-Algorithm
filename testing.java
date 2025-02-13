package SchedulingAlgorithms.test;

import SchedulingAlgorithms.Process;

import java.util.PriorityQueue;

import SchedulingAlgorithms.FCFS;
import SchedulingAlgorithms.Input;
import SchedulingAlgorithms.Output;
import SchedulingAlgorithms.PriorityScheduling;

public class testing {

    public static void main(String[] args) {
        System.out.println("Scheduling Algorithm");
        Process p[] = { new Process("p1", 2, 3), new Process("p2", 3, 4), new Process("p3", 4, 5) };

        new PriorityScheduling(p);
    }
}
