import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FCFSQueue implements SchedulingQueue {
	
    Queue<Integer> queue = new LinkedList<>();

    FCFSQueue(){}
    FCFSQueue(ArrayList<Integer> arr)
    {
    	init(arr);
    }
    
	@Override
	public int pop(int headPos) {
		if(queue.size()<=0)
			return -1;
		
		return queue.poll();
	}

	@Override
	public void init(ArrayList<Integer> arr) {
		// TODO Auto-generated method stub
		for(int i=0;i<arr.size();i++)
			queue.add(arr.get(i));
	}

}
