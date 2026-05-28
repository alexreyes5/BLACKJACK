
import java.util.Scanner;
public class Main{

public static void main(String[] args) throws InterruptedException{
//Intro + Name
Scanner sc = new Scanner(System.in);
System.out.println("Enter Name: ");
String name = sc.nextLine();
System.out.println("Welcome " + name + "!");
//Objects created
Deck d = new Deck();
d.shuffle();
Player p1 = new Player(name);
Player dealer = new Player("Dealer");

// DEAL 2 CARDS TO PLAYER
p1.addCard(d.dealCard());
p1.addCard(d.dealCard());
// ADDS cards
System.out.println(p1);
System.out.println( name + "'s" +" HAND: " + p1.getHandValue());
// DEAL 2 DEALER
dealer.addCard(d.dealCard());
dealer.addCard(d.dealCard());
System.out.println("Dealer shows: " + dealer.getfirstCard(0));
System.out.println("DEALER HAND: " + dealer.getFirstValue());
System.out.println("Dealer's other card is hidden.");
System.out.println("\nPress Enter to continue...");
sc.nextLine();


boolean playing = true;
while(playing && p1.getHandValue() <= 21){

    System.out.println("Would you like to Hit or Stand?");
    String response = sc.nextLine();
    
    if(response.equalsIgnoreCase("hit")){
    Card newCard = d.dealCard();
    System.out.println("You drew: " + newCard); 
    p1.addCard(newCard);
    System.out.println("Updated hand---" + p1);
    System.out.println("Your new total is " + p1.getHandValue());
    System.out.println("\nPress Enter to continue...");
      sc.nextLine();
    }
    else if (response.equalsIgnoreCase("stand")){
    
    playing = false;
    }

}



if(p1.getHandValue() > 21){
    System.out.println("You Busted! - Dealer Wins!");
}
else{
    System.out.println("\nDealer reveals second card...");
   sc.nextLine();
    System.out.println(dealer); 
    System.out.println("Dealer Total: " + dealer.getHandValue());

    while(dealer.getHandValue() < 17){
        System.out.println("Dealer total under 17, will draw again");
        System.out.println("Press Enter to watch dealer draw.");
         sc.nextLine();
        
        Card newDealerCard = d.dealCard();
        System.out.println("Dealer drew: " + newDealerCard);
         dealer.addCard(newDealerCard);
         
       System.out.println("Dealer new total: " + dealer.getHandValue());
    }

    System.out.println("Dealer final hand:");
    System.out.println(dealer);
    System.out.println("Dealer Total: " + dealer.getHandValue());

    if(dealer.getHandValue() > 21){
        System.out.println("Dealer Busted! - You Win!");
    }
    else if(p1.getHandValue() > dealer.getHandValue()){
        System.out.println("You Win!");
    }
    else if(p1.getHandValue() < dealer.getHandValue()){
        System.out.println("Dealer Wins!");
    }
    else{
        System.out.println("Push! It's a tie.");
    }
}
}
}
