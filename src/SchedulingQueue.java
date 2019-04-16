import java.util.ArrayList;

public interface SchedulingQueue {
	int pop(int headPos);
	void init(ArrayList<Integer> arr);
	/**
	 * prints the sequence
	 * @param head the position that head starts at
	 * @return the total head movements
	 */
	int run(int head);
}
