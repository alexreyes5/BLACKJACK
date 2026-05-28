import java.util.ArrayList;
public class Player{

private String name;
private ArrayList<Card> hand;

public Player(String name){
this.name = name;
hand = new ArrayList<>();

}
public void addCard(Card firstCard){
hand.add(firstCard);
}

public String toString(){
return name + ":" + hand.toString();
}
public int getHandValue(){
int sum = 0;
for(int i = 0; i < hand.size(); i++){
sum += hand.get(i).getValue();
}
return sum;
}
//FOR DEALER AFTER FIRST CARD DEALT
public int getFirstValue(){
return hand.get(0).getValue();
}
public Card getfirstCard(int index){
return hand.get(index);
}
}