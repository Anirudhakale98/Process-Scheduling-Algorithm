package SchedulingAlgorithms;

import java.util.*;

public class Process {

    public String process_id;

    public int arrivalTime;

    public int burstTime;

    public int completionTime;

    public int turnAroundTime;

    public int watingTime;

    public int priority;

    public Process(String id, int at, int bt) {

        this.process_id = id;

        this.arrivalTime = at;

        this.burstTime = bt;

    }

    public String getId() {
        return this.process_id;
    }

    public int getArrivalTime() {
        return this.arrivalTime;
    }

    public int getBurstTime() {
        return this.burstTime;
    }

    public int getCompletionTime() {
        return this.completionTime;
    }

    public int getAT() {
        return arrivalTime;
    }

    public void calculateTAT() {
        turnAroundTime = completionTime - arrivalTime;
    }

    public void calculateWT() {
        watingTime = turnAroundTime - burstTime;
    }

    public int getTAT() {
        return turnAroundTime;
    }

    public int getWT() {
        return watingTime;
    }

    public static void main(String args[]) {

    }
}