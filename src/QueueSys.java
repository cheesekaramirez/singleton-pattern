import java.util.LinkedList;
import java.util.Queue;
public class QueueSys {
    private QueueSys(){}
    private static QueueSys instance = null;
    private final Queue<Integer> queue = new LinkedList<>();
    private int queueNum= 1;
    
    public static synchronized QueueSys getInstance() {
        if(instance == null){
            instance = new QueueSys();
        }
        return instance;
    }

    public synchronized int enqueue() {
        queue.offer(queueNum);
        System.out.println("Your number is: "+queueNum);
        return queueNum++;
    }

    public synchronized void dequeue (int helpdesk) {
        int currServ = queue.poll();
        if (instance == null) {
            System.out.println("Queue is empty.");
        } else {
            System.out.println("Helpdesk "+helpdesk+" is now serving "+currServ+".");
        }
    }

    public synchronized void reset(int helpdesk, int newNum){
        if(newNum < 1) {
            System.out.println("Enter a valid number!");
        }
        queue.clear();
        queueNum = newNum;
        System.out.println("Helpdesk "+helpdesk+" has reset the queue to number "+newNum+".");
    }
}