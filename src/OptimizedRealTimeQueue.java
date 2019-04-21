import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class OptimizedRealTimeQueue implements SchedulingQueue {

    Queue<Integer> queue = new LinkedList<>();
    final int head =0 ;
    int towardsHead = 199 ;
     
    public OptimizedRealTimeQueue(ArrayList<Integer> arr)
    {
        init(arr);
    }

    @Override
    public int pop(int headPos)
    {
        if (queue.size()<=0)
        {
            return -1 ;
        }
        return queue.poll() ;
    }

    @Override
    public void init(ArrayList<Integer> arr) {
        arr.sort(null);
        for (int i =0 ; i< arr.size() ; ++i)
        {
            queue.add(arr.get(i)) ;
        }
    }

    @Override
    public int run(int head) {
        head = this.head ;
        int distance =0 ;

        System.out.print(head +" --> ");

        while (this.towardsHead>=0)
        {
            int i = this.pop(head);
            if(i == -1)
                break;

            System.out.print(i+" --> ");
            distance += i-head;
            head = i;
            this.towardsHead-- ;
        }
        return distance ;
    }
}
