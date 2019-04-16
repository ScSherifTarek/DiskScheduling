import java.util.ArrayList;

public class CScanQueue implements SchedulingQueue {
	
	ArrayList<Integer> arr = new ArrayList<>();
	Boolean toRight = false;
	final int DISK_SIZE = 199;
	int totalHead = 0;
	
	CScanQueue(){}
	CScanQueue(ArrayList<Integer> arr)
    {
    	init(arr);
    }
	
	@Override
	public int pop(int headPos) {
//		return getMyIndex(headPos);
		if(arr.size()<=0)
			return -1;
		
		int index = getMyIndex(headPos);
		if(index >= this.arr.size() || index < 0)
		{
			totalHead += DISK_SIZE;
			if(toRight)
			{
				totalHead += Math.abs(DISK_SIZE - headPos);
				return pop(0);
			}
			else
			{
				totalHead += headPos;
				return pop(DISK_SIZE);
			}		
		}
		else if(index == 0 && !toRight && this.arr.size() > 1 )
		{
			int e = arr.get(index);
			arr.remove(index);
			totalHead += Math.abs(headPos - e);
			
			totalHead += e;
			return DISK_SIZE;
		}
		else
		{
			int e = arr.get(index);
			arr.remove(index);
			totalHead += Math.abs(headPos - e);
			return e;
		}
	}

	@Override
	public void init(ArrayList<Integer> arr) {
		for(int i=0;i<arr.size();i++)
			this.arr.add(arr.get(i));
		this.arr.sort(null);
//		System.out.println(this.arr);
	}
	
	@Override
	public int run(int head) {
        while(true)
        {
        	int i = this.pop(head);
        	if(i == -1)
        		break;
        	
        	System.out.print(i+", ");
        	head = i;
        }
		return this.totalHead;
	}
	
	
	public int getMyIndex(int head)
	{
		int i = -1;
		if(toRight && this.arr.size()>0)
		{
			i = 0;
			while(i<arr.size() && head>this.arr.get(i))
				i++;
		}
		else
		{
			System.out.println(this.arr);
			System.out.println(head);
			i = arr.size()-1;
			while(i>0 && head<this.arr.get(i))
				i--;
			
			System.out.println(i);
		}
		return i;
	}
}
