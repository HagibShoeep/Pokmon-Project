package pockmonproject;


/*

display(String playerName) :the pass name player for display pockmon 
*/
public class PockMoneQueue {

    private Pockmon[] queue;
    private int maxZise;
    private int front;
    private int numItems;

    public PockMoneQueue(int size) {
        this.maxZise = size;
        this.queue = new Pockmon[size];
        front = -1;

        numItems = 0;

    }

    public boolean isFull() {
        return (maxZise == numItems);
    }


   

    public boolean isQueueEmpty() {
        return (numItems == 0);
    }

    

    public void insert(Pockmon pockmon) {
        /* Checks whether the queue is full or not */
        if (isFull()) {

            return;
        }
        if (front == maxZise - 1) {
            numItems = 0;
            front = -1;
        }

        queue[numItems] = pockmon;
        numItems++;

    }

    public Pockmon pop() {
        /* Checks whether the queue is empty or not */
        if (isQueueEmpty()) {
           return null;
        }
        /* retrieve queue element then increment */
        Pockmon temp = queue[++front];
        if (front == maxZise-1) {
            front = -1;
        }
        numItems--;
        return temp;
    }

    void display(String playerName) {
        if(front==-1)
            return;
        System.out.println("\n"+playerName+" Army..");
       for(int i=front;i<numItems;i++){
           System.out.print(""+queue[i].getName()+" ,");
       }
      
    }
}
