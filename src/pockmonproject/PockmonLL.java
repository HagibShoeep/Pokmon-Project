package pockmonproject;


/*            
traversToConsole():display the pokmon in console 
getAveragePower():display the average the total in pokmon list
getCount():get counts in linkded lisrt
search(int id): search elemnet in the list by id and return for using to push to queue
getCountByType(String type):return the count number in list by type 
addPockmon(Pokmon):add PoKomon to list
 */
public class PockmonLL {

    private PokemonLLNode head;

    public PokemonLLNode getHead() {
        return head;
    }

    public void setHead(PokemonLLNode head) {
        this.head = head;
    }

    public PockmonLL(PokemonLLNode head) {
        this.head = head;
    }
    //init head to null befor using

    public PockmonLL() {
        this.head = null;
    }

    //calculate the strongets name
    public int getCount() {
        int count = 0;
        if (head == null) {
            return count;
        }
        PokemonLLNode curent = head;
        while (curent.getNext() != null) {

            count++;

            curent = curent.getNext();
        }

        count++;

        return count;
    }

    //the largest pokmon
    public String getStrongestName() {
        int count = 0;
        if (head == null) {
            return "";
        }

        PokemonLLNode max = head;
        PokemonLLNode curent = head.getNext();
        //iterator for all linked list and get node with pokmon total largest and set in max 
        while (curent.getNext() != null) {
            if (curent.getPockmon().getTotal() > max.getPockmon().getTotal()) {
                max = curent;
            }
            curent = curent.getNext();
        }
        //checked the current is null then the head is max or current less then max the max is head
        if (curent == null || curent.getPockmon().getTotal() < max.getPockmon().getTotal()) {
            return max.getPockmon().getName();
        }
        //if current is not less then max then the current is max 
        return curent.getPockmon().getName();
    }

    //
    //accept the arguments by type string 
    public int getCountByType(String type) {
        int count = 0;
        //return 0 the linked is empty
        if (head == null) {
            return count;
        }
        //set iterator for head 
        PokemonLLNode curent = head;
        while (curent.getNext() != null) {
            if (curent.getPockmon().getType().equals(type)) {
                count++;
            }
            curent = curent.getNext();
        }
        if (curent.getPockmon().getType().equals(type)) {
            count++;
        }
        return count;
    }

    //calculate the power average 
    /*
    PROS :CALCULATE THE AVERAGE TOTAL IN SLL
    INI: AVE=:0,SUM=:0
    START IF
      CON:HEAD=:NULL
      RETURN AVG
      EXIT
    END IF
    INT: COUNT=:0 FOR COUNTS NUMBER IN SLL
    
    */
    public double getAveragePower() {

        double average = 0;
        //for calculate the total for all node pokmon
        double sum = 0;
        //chek if pokmon list is not empty
        if (head == null) {
            return average;
        }

        int counts = 1;
        PokemonLLNode curent = head;
        //start  
        while (curent.getNext() != null) {
            sum += curent.getPockmon().getTotal();
            counts++;
            curent = curent.getNext();
        }
        sum += curent.getPockmon().getTotal();
        average = sum / counts;
        return average;
    }

    public void traversToConsole() {
        if (head == null) {
            return;
        }
        PokemonLLNode curent = head;
        while (curent.getNext() != null) {

            System.out.println("" + curent.getPockmon().toString());
            curent = curent.getNext();
        }
        System.out.println("" + curent.getPockmon().toString());
    }

    public void addPockmon(PokemonLLNode pockmon) {
        //cheked the head is null for first add
        if (head == null) {
            head = pockmon;
            head.setNext(null);
            return;
        }

       //set itertor in the head
        PokemonLLNode curent = head;
        
         //iterator to end the list and add the pokmon in linked list
        while (curent.getNext() != null) {
            curent = curent.getNext();
        }
        //
        curent.setNext(pockmon);
        curent.getNext().setNext(null);
    }
    
    //pokmon start earch
    public Pockmon search(int id) {
       //is empty return the null
        if (head == null) {
            return null;
        }
        //set iterator with first node 
        PokemonLLNode curent = head;
          //iterator to end the list orif found item return it
        while (curent.getNext() != null) {
            //return item when is found
            if (curent.getPockmon().getId() == id) {
                return curent.getPockmon();
            }
            
            curent = curent.getNext();
        }
        //sure if the 
        if (curent.getPockmon().getId() == id) {
            return curent.getPockmon();
        }
        return null;
    }

}
