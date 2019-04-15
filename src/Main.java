import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	public static void main(String[] args)
	{
        ArrayList<Integer> data = new ArrayList<>();
        data.add(98);
        data.add(183);
        data.add(37);
        data.add(122);
        data.add(14);
        data.add(124);
        data.add(65);
        data.add(67);
        
		SchedulingQueue f = new FCFSQueue(data);
		int distance = doAlgo(f, 53);
        System.out.println();
        System.out.println(distance);

        System.out.println();
        System.out.println("SSTF:");
        f = new SSTFQueue(data);
        
        distance = doAlgo(f,53);
        System.out.println();
        System.out.println(distance);

	}

	private static int doAlgo(SchedulingQueue f,int head) {
        int distance = 0;
        
        while(true)
        {
        	int i = f.pop(head);
        	if(i == -1)
        		break;
        	
        	System.out.print(i+", ");
        	distance += Math.abs(head-i);
        	head = i;
        }
		return distance;
	}
}
