import java.util.ArrayList;

public class CLookQueue implements SchedulingQueue {
	
	ArrayList<Integer> arr = new ArrayList<>();
	
	
	CLookQueue(){}
	CLookQueue(ArrayList<Integer> arr)
    {
    	init(arr);
    }
	
	@Override
	public int pop(int headPos) {
		return -1;
	}

	@Override
	public void init(ArrayList<Integer> arr) {
		for(int i=0;i<arr.size();i++)
			this.arr.add(arr.get(i));
		this.arr.sort(null);
		System.out.println(this.arr);
	}
	
}
