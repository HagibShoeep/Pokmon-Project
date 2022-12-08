
package pockmonproject;


public class PokemonLLNode {
    private Pockmon pockmon;
    private PokemonLLNode next;

 

    public PokemonLLNode(Pockmon pockmon) {
        this.pockmon = pockmon;
        this.next=null;
    }

    
  public PokemonLLNode() {
      this.pockmon=null;
      this.next=null;
    }
    public Pockmon getPockmon() {
        return pockmon;
    }

    public void setPockmon(Pockmon pockmon) {
        this.pockmon = pockmon;
    }

    public PokemonLLNode getNext() {
        return next;
    }

    public void setNext(PokemonLLNode next) {
        this.next = next;
    }
    
}
