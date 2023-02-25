public class Counter {
  private PowerSet<Card> cardps;
  private Card starter;

  public Counter(Card[] hand, Card starter) {
    this.starter = starter;
    cardps = new PowerSet<Card>(hand); //Hand already includes the starter
  }

  public int countPoints() {
    //Need to count the points in the hand based of cards given
    //WIll be using helper methods to keep the method clean
    int total = 0; //Counting the total points
    total += hisKnobs();
  }

  private int hisKnobs() {
    //First checking if a jack is present in the hand
    Set<Card> tempSet = new Set<Card>(); //Creating a dummy set object called tempSet
    for (int i = 0; i < cardps.getLength(); i++) { 
      //Checking every card in the power set, if its a jack find suit
      tempSet = cardps.getSet(i); //Checking every set
      
      //*** can make this more efficient by only looking at the sets with 1 value but later
      if (tempSet.getLength() == 1) {
        if (tempSet.getElement(0).getLabel() == "J") { //If there is a jack
          if (tempSet.getElement(0).getSuit() == starter.getSuit()) { //If it has the same suit as the starter
            return 1; //If a J is found with the same suit return 1 for 1 point
          }
        }
      }
      /* Could use this part or not, undecided
      for (int j = 0; j < tempSet.getLength(); j++) { //Checking every card in the 
        if (tempSet.getElement(j).getLabel() == "J") { //If there is a jack
          if (tempSet.getElement(j).getSuit() == starter.getSuit()) { //If it has the same suit as the starter
            return 1; //If a J is found with the same suit return 1 for 1 point
          }
        }
      }*/
    }
    return 0; //No points for his knobs
  }

  private int pairs() {
    //Looping through every element with 2 
    int pairs = 0;

    Set<Card> tempSet = new Set<Card>(); //Creating a dummy set
    for (int i = 0; i < cardps.getLength(); i++) {
      tempSet = cardps.getSet(i);
      if (tempSet.getLength() == 2) { //Checking only sets with length 2
        if (tempSet.getElement(0).getLabel() == tempSet.getElement(1).getLabel()) {
          pairs += 2;
        }  
      }
    }
    return pairs;
  }

  
}
