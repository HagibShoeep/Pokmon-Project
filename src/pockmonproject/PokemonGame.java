package pockmonproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/*
start PokemonGame:
pros: file contains field of Pokomn
step 1:
  SLL: new PockmonLL
step 2: Start While:
   Scanner in sc
   pocumon:- new Pockmon
   pokomn->id= sc->next casting to int ..for all fields

End While
step 3:
display Message:- ""**************************************************************************\n"
                + "****                     Welcome to Pokemon Game                      ****\n"
                + "**************************************************************************\n"
                + "Pokemons Information..."
Start traversToConsole:
       start function 
       print  pockmon in SLL;
       End Function
End traversToConsole 
   
step 4:
 Display message:- 'Total number of pokemons = '
 Start getCount
  initialization :
  count=0
  iterator in SLL 
   count =count+1
   return count
 End getCount
step 5:
 Display message:- "Number of Electric pokemons"
 Start getCountByType:
        pros :type the pokmon is call
        initialization count=0 
        p=head
        Start while:
             condition:    P in SLL And P->next!=null
              p->type == type
               count= count+1
        End While
        Start IF
          p->type == type
          count= count+1   
        End IF

        return count
    DISPLAY THE RESULTE
 STEP 5:       
    End getCountByType
    Display message:-"Number of Electric pokemons = "
    CALL getCountByType:= WITH TYPE="Electric"
    EXECUTE STEP 4
    Display message:-"Number of Grass pokemons = "
    CALL getCountByType:= WITH TYPE="Grass"
    EXECUTE STEP 4
    Display message:-"Number of Fire pokemons = "
    CALL getCountByType:= WITH TYPE="Fire"
    EXECUTE STEP 4
    Display message:-"Number  of Water pokemons =  "
    CALL getCountByType:= WITH TYPE="Water"
    EXECUTE STEP 4 
STEP 6:
    Display message:- "The strongest pokemon is "
    START getStrongestName:
        pros :TOTAL WITH LARGE  IN POKOMN IS RETURN
        initialization TUTAL=0         
        MAX=:HEAD
        P=:HEAD->NEXT
        START WHILE:
             CON:    P IN SLL AND P->NEXT != null
             START IF   MAX->TOTAL < P.TOTAL
               MAX =: P
             END IF
             P=:P->NEXT
        End While
        Start IF MAX IS NULL OR MAX->TOTAL LESS THEN P
           RETURN P->NAME
           EXIT   START getStrongestName:
        END IF 
        START ELSE 
         RETURN MAX->nAME
        END ELSE
     
    END getStrongestName
    DISPLAY NAME
    END LINE
    DISPLAY MESSAGE:= "The average of all pokemons power is "
    START  getAveragePower

  

  
  

 */
public class PokemonGame {

    public static void main(String[] args) throws Exception {
        //get path 
        //Find codebase directory
        Path codebase = Paths.get(PokemonGame.class.getProtectionDomain().getCodeSource().getLocation().toURI());
        Path absdir = codebase.getParent().normalize().toAbsolutePath();
        Path txtFilePath = absdir.resolve("Pokemons.txt");
        File file = new File(txtFilePath.toString());
        PockmonLL pockmonLL = new PockmonLL();
        //insert to linked list
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                Pockmon pockmon = new Pockmon();
                pockmon.setId(Integer.parseInt(scanner.next()));
                pockmon.setName(scanner.next());
                pockmon.setType(scanner.next());
                pockmon.setAttak(Integer.parseInt(scanner.next()));
                pockmon.setDefense(Integer.parseInt(scanner.next()));
                pockmon.setTotal(Integer.parseInt(scanner.next()));
                PokemonLLNode node = new PokemonLLNode(pockmon);
                pockmonLL.addPockmon(node);

            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //show message
        System.out.println("**************************************************************************\n"
                + "****                     Welcome to Pokemon Game                      ****\n"
                + "**************************************************************************\n"
                + "Pokemons Information...");
        //show the resulte linked list in console
        pockmonLL.traversToConsole();
        //
        System.out.println("\nTotal number of pokemons = " + pockmonLL.getCount());
        System.out.println("Number of Electric pokemons = " + pockmonLL.getCountByType("Electric"));
        System.out.println("Number of Grass pokemons = " + pockmonLL.getCountByType("Grass"));
        System.out.println("Number of Fire pokemons = " + pockmonLL.getCountByType("Fire"));
        System.out.println("Number  of Water pokemons =  " + pockmonLL.getCountByType("Water"));
        System.out.println("The strongest pokemon is " + pockmonLL.getStrongestName());
        System.out.println("The average of all pokemons power is " + pockmonLL.getAveragePower());
        System.out.println("\nPokemons from weakest to strongest..");
        PokemonBST bst = new PokemonBST(pockmonLL);
        bst.inorder();
        System.out.println("*********************************\n");
        System.out.println(" We want to make a competition between 2 players");
        System.out.println("Each player should choose 3 pokemons to fight with");

        int count = 1;
        Scanner sc = new Scanner(System.in);
        //insert first player
        System.out.println("Enter the name of the first player: ");
        String firstName = sc.nextLine();

        //insert secnd player
        System.out.println("Enter the name of the second player: ");
        String lastName = sc.next();

        //message for players
        System.out.println("Each player should choose 3 pokemons to fight with");
        System.out.println("Enter the name of the first player: ");
        System.out.println("your first choice will play the first round and so on..");
        System.out.println("Start with " + firstName);

        //create stack,queue for all player selected
        int count1 = 1, count2 = 1, id = 0;
        PockMoneQueue psockMoneQueue1 = new PockMoneQueue(3);
        PockMoneQueue psockMoneQueue2 = new PockMoneQueue(3);
        PokemonStack pokemonStack1 = new PokemonStack(3);
        PokemonStack pokemonStack2 = new PokemonStack(3);

        //start for player 1 choising
        while (count1 <= 3) {

            System.out.println("Enter the id of pokemon " + count1);
            id = sc.nextInt();
            Pockmon pockmon = pockmonLL.search(id);
            if (pockmon != null) {
                psockMoneQueue1.insert(pockmon);
                count1++;
            } else {
                System.out.println("Wrong pokemon id!!");
            }
        }
        //start the revers or not by chose player
        System.out.println("Do you want to reverse your pokemons (y/n)?");
        char s1 = sc.next().charAt(0);
        if (s1 == 'y') {
            while (!psockMoneQueue1.isQueueEmpty()) {
                pokemonStack1.push(psockMoneQueue1.pop());
            }

        }

        System.out.println("");
        System.out.println("\n" + "Now," + lastName + " turn ");
        //start plaer secnd
        while (count2 <= 3) {

            System.out.println("Enter the id of pokemon " + count2);
            id = sc.nextInt();
            Pockmon pockmon = pockmonLL.search(id);
            if (pockmon != null) {
                psockMoneQueue2.insert(pockmon);
                count2++;
            } else {
                System.out.println("Wrong pokemon id!!");
            }
        }
        //choice player 2 for reverse
        System.out.println("Do you want to reverse your pokemons (y/n)?");
        char s2 = sc.next().charAt(0);

        if (s2 == 'y') {
            while (!psockMoneQueue2.isQueueEmpty()) {
                pokemonStack2.push(psockMoneQueue2.pop());
            }

        }
        //chek if player one is revers the stack using store
        if (!pokemonStack1.isEmpty()) {
            pokemonStack1.display(firstName);
        } //or the Queqe is using store
        else {
            psockMoneQueue1.display(firstName);
        }
        //chek if player tow is revers the stack using store
        if (!pokemonStack2.isEmpty()) {
            pokemonStack2.display(lastName);
        } else {
            psockMoneQueue2.display(lastName);
        }
        //message for start game
        System.out.println("\n\nLet The Battle Starts...");
        Pockmon pokmonPlayer1;
        Pockmon pokmonPlayer2;
        //count the times the player is win countWinner1 increase if player one wins
        int countWinner1 = 0;
        //count the times the player is win countWin2 increase if player second wins
        int countWin2 = 0;

        //pop stack or queqe and test what is win
        for (int round = 1; round <= 3; round++) {
            System.out.println("Round " + round);
            if (!pokemonStack1.isEmpty()) {
                pokmonPlayer1 = pokemonStack1.pop();
            } else {
                pokmonPlayer1 = psockMoneQueue1.pop();
            }
            if (!pokemonStack2.isEmpty()) {
                pokmonPlayer2 = pokemonStack2.pop();
            } else {
                pokmonPlayer2 = psockMoneQueue2.pop();
            }

            //check player one pockomend defines and attak is win
            if (pokmonPlayer1.getAttak() > pokmonPlayer2.getDefense()
                    && pokmonPlayer1.getDefense() > pokmonPlayer2.getAttak()) {
                countWinner1 += 1;
                System.out.println("" + pokmonPlayer1.getName() + " Wins!!");
            } //chek the player tow is win 
            else if (pokmonPlayer1.getAttak() < pokmonPlayer2.getDefense()
                    && pokmonPlayer1.getDefense() < pokmonPlayer2.getAttak()) {
                System.out.println("" + pokmonPlayer2.getName() + " Wins!!");
                countWin2 += 1;
            } //the players is tie
            else {
                System.out.println("it is a Tie..");
            }

        }

        System.out.println("The Final Result of Battale...");
        //count win player one is more the is win
        if (countWinner1 > countWin2) {
            System.out.println(firstName + " Wins..");
        } //count win player tow is more the is win
        else if (countWinner1 < countWin2) {
            System.out.println(lastName + " Wins..");
        } //they is equel
        else {
            System.out.println("it is a Tie..");
        }
        System.out.println("\n\nHope you enjoy our Pokemon game:)\n"
                + "See you in next games..\n\n");
    }

}
