import java.util.ArrayList;

public class CSCAN implements SchedulingQueue{

    ArrayList<Integer> queue = new ArrayList<>();
    final int DISK_SIZE = 199;
    boolean withZero = false;
    boolean with199 = false;
    boolean first = true;
    boolean second = false;
    boolean printed199 = false;
    boolean printed0 = false;

    public CSCAN(ArrayList<Integer> list){
        init(list);
        mysort();
        if(queue.get(0) == 0){
            withZero = true;
        }
        if(queue.get(queue.size()-1) == 199){
            with199 = true;
        }
    }

    @Override
    public void init(ArrayList<Integer> arr) {
        for(int i=0;i<arr.size();i++)
            queue.add(arr.get(i));
    }

    @Override
    public int pop(int headPos) {
        if(queue.size() <= 1)
            return -1;

        int idx = getInitalIdx(headPos);

        if(idx < queue.size()-1 ){
            int temp = queue.get(idx+1);
            queue.remove(idx+1);
            return temp;
        }else if(idx == queue.size()-1 && first) {
            first = false;
            second = true;
            return 199;
        }else if (idx == queue.size()-1 && !first && second){
            second = false;
            return 0;
        }else if(idx == queue.size()-1 && !first && !second){
            int temp = queue.get(0);
            queue.remove(0);
            return temp;
        }
        return -1;
    }

    @Override
    public int run(int head) {
        queue.add(head);
        mysort();
        int previous = head;
        int distance = 0;
        while(true)
        {
            int i = this.pop(head);
            if(i == -1)
                break;
            //seq.add(i);
            if(!(!withZero && i == 0) && !(!with199 && i == 199)){
                if(i == 0 && !printed0){
                    System.out.print(i+" --> ");
                    printed0 = true;
                }else if(i == 199 && !printed199) {
                    System.out.print(i + " --> ");
                    printed199 = true;
                }else if(i != 0 && i!= 199){
                    System.out.print(i + " --> ");
                }
            }
            distance += Math.abs(previous-i);
            previous = i;
        }
        System.out.print("||");
        return distance;
    }

    private void mysort(){
        queue.sort(null);
    }

    private int getInitalIdx(int pos){

        return queue.indexOf(pos);
    }
}
