
import java.util.*;
import SchedulingAlgorithms.FCFS;
import SchedulingAlgorithms.SJF;
import SchedulingAlgorithms.RoundRobin;
import SchedulingAlgorithms.Process;
import SchedulingAlgorithms.Input;
import SchedulingAlgorithms.Output;

public class main {
    static Scanner sc = new Scanner(System.in);

    public static void display(Process[] p) {
        int choice;
        do {
            System.out.println("Choose the scheduling algorithm you want to perform: ");
            System.out.println("1. FCFS");
            System.out.println("2. SJF");
            System.out.println("3. Round Robin");
            System.out.println("4. Back to main menu");

            System.out.println("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    new FCFS(p);
                    break;
                case 2:
                    new SJF(p);
                    break;
                case 3:
                    new RoundRobin(p);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 4);

    }

    public static void main(String[] args) {
        System.out.println("\t\tScheduling Algorithms\t\t");

        Process[] p = null;
        System.out.println("Choose a number which operation do you want to peroform: ");
        System.out.println("1. Input:");
        System.out.println("2. Output of Scheduling Algorithm:");
        System.out.println("3. Exit");
        System.out.println("Enter your choice: ");
        int choice = sc.nextInt();

        while (choice != 3) {
            if (choice == 1) {
                Input in = new Input();
                p = in.getInput();
            } else if (choice == 2) {
                if (p == null) {
                    System.out.println("Enter Input first. ");
                } else {
                    display(p);
                }

            } else if (choice == 3) {
                System.out.println("Exiting the program. ");
            } else {
                System.out.println("Invalid choice");
            }

            System.out.println("Choose a number which operation do you want to peroform: ");
            System.out.println("1. Input:");
            System.out.println("2. Output of Scheduling Algorithm:");
            System.out.println("3. Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();

        }

    }

}
