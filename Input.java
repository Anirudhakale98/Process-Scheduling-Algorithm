package SchedulingAlgorithms;

import java.util.*;
import SchedulingAlgorithms.Process;

public class Input {
    static Scanner sc = new Scanner(System.in);
    int n;
    static Process[] p;

    public Input() {
        System.out.println("Enter number of process: ");
        n = sc.nextInt();
        p = new Process[n];
        takeInput(n, p);
    }

    public static void takeInput(int n, Process[] p) {
        for (int i = 0; i < n; i++) {
            System.out.print("Enter process id: ,");
            System.out.print("Enter arrival time: ,");
            System.out.println("Enter burst time: ");

            String id = sc.next();
            int at = sc.nextInt();
            int bt = sc.nextInt();
            p[i] = new Process(id, at, bt);
        }
    }

    public static Process[] getInput() {
        return p;
    }

    public static void main(String[] args) {

    }
}
