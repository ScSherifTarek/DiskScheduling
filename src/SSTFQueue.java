import java.util.ArrayList;

public class SSTFQueue implements SchedulingQueue {
	ArrayList<Integer> arr = new ArrayList<>();
	
	SSTFQueue(){}
	SSTFQueue(ArrayList<Integer> arr)
    {
    	init(arr);
    }
    
	@Override
	public int pop(int headPos) {
		if(arr.size()<=0)
			return -1;
		
		int i = getMinOne(headPos);
		int e = arr.get(i);
		arr.remove(i);
		return e;
	}

	@Override
	public void init(ArrayList<Integer> arr) {
		for(int i=0;i<arr.size();i++)
			this.arr.add(arr.get(i));
	}

	private int getMinOne(int headPos)
	{
		int min = Integer.MAX_VALUE;
		int index = -1;
		int dist;
		for(int i=0;i<arr.size();i++)
		{
			dist = Math.abs(arr.get(i)-headPos);
			if(dist<min)
			{
				min = dist;
				index = i;
			}
		}
		return index;
	}
	
	@Override
	public int run(int head) {
		int distance = 0;
        
        while(true)
        {
        	int i = this.pop(head);
        	if(i == -1)
        		break;
        	
        	System.out.print(i+" --> ");
        	distance += Math.abs(head-i);
        	head = i;
        }
		System.out.print("||");
		return distance;
	}
	
	
}
