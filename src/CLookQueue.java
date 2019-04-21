import java.util.ArrayList;

public class CLookQueue implements SchedulingQueue {

	ArrayList<Integer> arr = new ArrayList<>();
	final int DISK_SIZE = 199;
	int totalHead = 0;

	CLookQueue(){}
	CLookQueue(ArrayList<Integer> arr)
	{
		init(arr);
	}

	@Override
	public int pop(int headPos) {
		if(arr.size()<=0)
			return -1;

		int index = getMyIndex(headPos);
		if(index >= this.arr.size() || index < 0)
		{
			return pop(0);
		}
		else
		{
			int e = arr.get(index);
			arr.remove(index);
			return e;
		}
	}

	@Override
	public void init(ArrayList<Integer> arr) {
		for(int i=0;i<arr.size();i++)
			this.arr.add(arr.get(i));
		this.arr.sort(null);
	}

	@Override
	public int run(int head) {
		while(true)
		{
			int i = this.pop(head);
			if(i == -1)
				break;

			System.out.print(i+" --> ");
			this.totalHead += Math.abs(head-i);
			head = i;
		}
		System.out.println("||");
		return this.totalHead;
	}


	public int getMyIndex(int head)
	{
		int i = -1;
		if(this.arr.size()>0)
		{
			i = 0;
			while(i<arr.size() && head>this.arr.get(i))
				i++;

		}
		return i;
	}
}
