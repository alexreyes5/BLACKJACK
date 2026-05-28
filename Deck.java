import java.util.Collections;
import java.util.ArrayList;
public class Deck {

private ArrayList<Card> deck;

public Deck(){
deck = new ArrayList<>();
String[] suits = {"Spades", "Hearts", "Clubs", "Diamonds"};
String[] ranks = {"Ace","2","3","4","5","6","7","8","9","10","King","Jack","Queen"};
for(int i = 0; i < suits.length;i++){
for(int j = 0; j < ranks.length; j++){
int value;
   if(ranks[j].equals("King") || ranks[j].equals("Jack") || ranks[j].equals("Queen") ){
   value = 10;
   }
   else if(ranks[j].equals("Ace")){
   value = 11;
   }
   else{
   value = Integer.parseInt(ranks[j]);
   }
   deck.add(new Card(suits[i],ranks[j],value));
}
}
}

public String toString() {
return deck.toString();
}

public Card dealCard(){
Card temp = deck.get(0);
deck.remove(0);
return temp;
}
public void shuffle(){
Collections.shuffle(deck);
}

}