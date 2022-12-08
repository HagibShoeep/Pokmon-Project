package pockmonproject;


 /*
create counstructer for using determine max stack size
pop(): for get elements in stack 
  isEmpty():
  check if stack is empty
 push(Pockmon pockmon):
 insert the Pokmon to stack 
pop: 
return element and remove from staCK

 */
public class PokemonStack {

    private Pockmon[] stack;
    private int maxSize;
    private int top;

    boolean isEmpty() {
        return (top < 0);
    }

    PokemonStack(int size) {
        stack = new Pockmon[size];
        top = -1;
        maxSize = size;
    }

    /*
    push :
    check if the stack is full
    1) IF TOP = maxSize - 1 then
        return false
        Exit;
    2) Otherwise
        top=top+1
        stack[top]=pockmon
       
          return true
          Exit;
    3) End of IF
    4) Exit
    
    
     */
    boolean push(Pockmon pockmon) {
        if (top == maxSize - 1) {
            return false;
        } else {

            top++;
            stack[top] = pockmon;

            return true;
        }
    }

    /*
    pop :
    check if the stack empty
    1) IF TOP = -1 then
        return null
        Exit;
    2) Otherwise
        pockmon: =STACK (TOP);
        stack[top]=null
        TOP:=TOP – 1;
        return pockmon
          Exit;
    3) End of IF
    4) Exit
    
    
     */
    public Pockmon pop() {
        if (top == -1) {

            return null;
        } else {
            Pockmon pockmon = stack[top];
            stack[top] = null;
            top--;
            return pockmon;
        }
    }

    /*
    pros:the name type of pockmon
    1-display the name info
    2-Start For initilazition  iterator = top ... to 0 
       display stack[iterator].name
       
    3) End of FOR
    3-EXit 
     */
    void display(String name) {
        System.out.println("\n" + name + "  Army..");
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i].getName() + ",");
        }
    }

}
