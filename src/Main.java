import java.util.*;

public class Main {

        static Scanner input = new Scanner(System.in);
        static int choice;
        public static void main(String[] args) {
                while (true) {
                        ArrayList<Integer> data = new ArrayList<>();
                        System.out.println("choice the number of the Algorithm:");
                        System.out.println("(1) FCFS");
                        System.out.println("(2) SSFT");
                        System.out.println("(3) SCAN");
                        System.out.println("(4) CSCAN");
                        System.out.println("(5) CLOOK");
                        System.out.println("(6) Optimized real time");
                        System.out.println("other key to cancel");
                        choice = input.nextInt();
                        int element;
                        System.out.println("Enter the all elements util enter -1 : ");
                        while (true){
                                element = input.nextInt();
                                if(element < 0) break;
                                data.add(element);
                        }

                        System.out.println("enter the start head : ");
                        int head = input.nextInt();
                        System.out.println("Start Head :"+head);
                        SchedulingQueue algo = null;

                        switch (choice){
                                case 1:
                                        algo = new FCFSQueue(data);
                                        System.out.println("FCFS is running ...");
                                        break;
                                case 2:
                                        algo = new SSTFQueue(data);
                                        System.out.println("SSTF is running ...");
                                        break;
                                case 3:
                                        algo = new SCAN(data);
                                        System.out.println("SCAN is running ...");
                                        break;
                                case 4:
                                        algo = new CSCAN(data);
                                        System.out.println("CSCAN is running ...");
                                        break;
                                case 5:
                                        algo = new CLookQueue(data);
                                        System.out.println("CLook is running ...");
                                        break;
                                case 6:
                                        algo = new OptimizedRealTimeQueue(data);
                                        System.out.println("OptimizedRealTime is running ...");
                                        break;
                                default:
                                        return;
                        }
                        int dis = algo.run(head);
                        System.out.println();
                        System.out.println(dis);

                }


        }


}

