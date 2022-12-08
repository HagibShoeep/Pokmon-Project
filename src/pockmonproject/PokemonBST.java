
package pockmonproject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class PokemonBST {
    
    private PokemonBSTNode root;
    
    public PokemonBST(PokemonBSTNode root) {
        this.root = root;
    }
    /*
    constructr:
    pros :pockmonLL with list Node Value is Pokmon
    step1: check the pockmonLL ==null
      root= null
      Exit 
    step2: 
    curent =pockmonLL->head
    step 3: Start While 
    condition: curent->next!=null
      then 
        insert=:curent->pokmon
         curent=curent->nect
    EndWhile
   step 4:
     insert=:curent->pokmon
    
     EXit
    */
    /*
    insert:
    pros :Pokmon
    */
    public PokemonBST(PockmonLL pockmonLL) {
        if (pockmonLL == null) {
            root = null;
            return;
        }
        PokemonLLNode curent = pockmonLL.getHead();
        
        while (curent.getNext() != null) {
            insert(curent.getPockmon());
            curent = curent.getNext();
        }
        insert(curent.getPockmon());
    }

    // A utility function to search a given key in BST
    public PokemonBST() {
        root = null;
    }

    // This method mainly calls deleteRec()
    void deleteKey(int key) {
        root = deleteRec(root, key);
    }

    /* A recursive function to 
      delete an existing key in BST
     */
    PokemonBSTNode deleteRec(PokemonBSTNode root, int key) {
        /* Base Case: If the tree is empty */
        if (root == null) {
            return root;
        }

        /* Otherwise, recur down the tree */
        if (key < root.getPokemon().getTotal()) {
            root.setLeft(deleteRec(root.getLeft(), key));
        } else if (key > root.getPokemon().getTotal()) {
            root.setRight(deleteRec(root.getRight(), key));
        } // if key is same as root's 
        // key, then This is the
        // node to be deleted
        else {
            // node with only one child or no child
            if (root.getLeft() == null) {
                return root.getRight();
            } else if (root.getRight() == null) {
                return root.getLeft();
            }

            // node with two children: Get the inorder
            // successor (smallest in the right subtree)
            root.setPokemon(minValue(root.getRight()));

            // Delete the inorder successor
            root.setRight(deleteRec(root.getRight(), root.getPokemon().getTotal()));
        }
        
        return root;
    }
    //get the min value

    Pockmon minValue(PokemonBSTNode root) {
        Pockmon minv = root.getPokemon();
        while (root.getLeft() != null) {
            minv = root.getLeft().getPokemon();
            root = root.getLeft();
        }
        return minv;
    }

    // This method mainly calls insertRec()
    void insert(Pockmon key) {
        root = insertRec(root, key);
    }

    /* A recursive function to 
       insert a new key in BST */
    PokemonBSTNode insertRec(PokemonBSTNode root, Pockmon key) {

        /* If the tree is empty,
          return a new node */
        if (root == null) {
            root = new PokemonBSTNode(key);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (key.getTotal() < root.getPokemon().getTotal()) {
            root.setLeft(insertRec(root.getLeft(), key));
        } else if (key.getTotal() > root.getPokemon().getTotal()) {
            root.setRight(insertRec(root.getRight(), key));
        }

        /* return the (unchanged) node pointer */
        return root;
    }

    // This method mainly calls InorderRec()
    void inorder() {
        inorderRec(root);
    }
    //

    // A utility function to do inorder traversal of BST
    void inorderRec(PokemonBSTNode root) {
        if (root != null) {
            inorderRec(root.getLeft());
            System.out.println(root.getPokemon().toString() + " ");
            inorderRec(root.getRight());
        }
        
    }
    //search by total key 
    

   
}
