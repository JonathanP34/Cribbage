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
    total += pairs();
    total += runs();
    total += fifteen();

    return total;
  }

  private int hisKnobs() {
    //First checking if a jack is present in the hand
    Set<Card> tempSet = new Set<Card>(); //Creating a dummy set object called tempSet
    for (int i = 0; i < cardps.getLength(); i++) { 
      //Checking every card in the power set, if its a jack find suit
      tempSet = cardps.getSet(i); //Checking every set
      
      //*** can make this more efficient by only looking at the sets with 1 value but later
      if (tempSet.getLength() == 1) {
        if (tempSet.getElement(0).getLabel().equals("J")) { //If there is a jack
          if (tempSet.getElement(0).getSuit().equals(starter.getSuit())) { //If it has the same suit as the starter
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
      tempSet = cardps.getSet(i); //Checking every set in the powerset
      if (tempSet.getLength() == 2) { //Checking only sets with length 2 for pairs
        if (tempSet.getElement(0).getLabel().equals(tempSet.getElement(1).getLabel())) { //Comparing the label of each card
          pairs += 2; //Adding 2 for each pair
        }  
      }
    }
    return pairs;
  }


  
  private boolean isRun (Set<Card> set) {
		// In this method, we are going through the given set to check if it constitutes a run of 3 or more
		// consecutive cards. To do this, we are going to create an array of 13 cells to represent the
		// range of card ranks from 1 to 13. We go through each card and increment the cell corresponding to
		// each card's rank. For example, an Ace (rank 1) would cause the first (index 0) cell to increment.
		// An 8 would cause the 8th (index 7) cell to increment. When this loop is done, the array will
		// contain 5 or less cells with values of 1 or more to represent the number of cards with each rank.
		// Then we can use this array to search for 3 or more consecutive non-zero values to represent a run.
		
		int n = set.getLength();
		
		if (n <= 2) return false; // Run must be at least 3 in length.
		
		int[] rankArr = new int[13];
		for (int i = 0; i < 13; i++) rankArr[i] = 0; // Ensure the default values are all 0.
		
		for (int i = 0; i < n; i++) {
			rankArr[set.getElement(i).getRunRank()-1] += 1;
		}

		// Now search in the array for a sequence of n consecutive 1's.
		int streak = 0;
		int maxStreak = 0;
		for (int i = 0; i < 13; i++) {
			if (rankArr[i] == 1) {
				streak++;
				if (streak > maxStreak) maxStreak = streak;
			} else {
				streak = 0;
			}
		}
		if (maxStreak == n) { // Check if this is the maximum streak.
			return true;
		} else {
			return false;
		}
	}
  
  
  private int runs() {
    int longest = 0;
    int timesSeen = 0;
    
    Set<Card> tempSet = new Set<Card>(); //Creating a dummy set
    for (int i = 0; i < cardps.getLength(); i++) {
      tempSet = cardps.getSet(i); 

      if (isRun(tempSet)) { //If the run is a set
        if (tempSet.getLength() > longest) { //Checking if the run is the longest
          longest = tempSet.getLength(); //If it is set it to longest
          timesSeen = 1; //And set the times seen to 1
        }
        else if (tempSet.getLength() == longest) { //If same size
          timesSeen++;//Increase timesSeen by one
        }
      }
      
    }
    return (longest * timesSeen); //The points from runs is the longest * timeseen   
  }

  
  private int fifteen() {
    int points = 0;
    int val = 0;
    Set<Card> tempSet = new Set<Card>();

    for (int i = 0; i < cardps.getLength(); i++) { //Loooing through every set
      tempSet = cardps.getSet(i); //Setting those sets to temp set
      val = 0; //Resetting val
      for (int j = 0; j < tempSet.getLength(); j++) { //Looping through the values of the set
        val += tempSet.getElement(j).getFifteenRank();//Getting the value of each card
      }
      if (val == 15) { //If the values add up to 15 points add 2 points
        points += 2;
      }     
    }
    return points;
  }

  private int flush() { //Not finished yet
    int points = 0;
    Set<Card> tempSet = new Set<Card>();
    boolean containsStarter = true;

    for (int i = 0; i < cardps.getLength(); i++) {
      tempSet = cardps.getSet(i); //Looping through the temp set

      if (tempSet.getLength() == 4) {
        String suit = tempSet.getElement(3).getSuit();
        for (int j = 0; j < tempSet.getLength(); j++) { //Looping through all 4 of the cards in the set to make sure none of them contain 
          if (tempSet.getElement(i).getLabel().equals(starter.getLabel()) && tempSet.getElement(i).getSuit().equals(starter.getSuit())) {
            break; //If the set contains the starter break
          }
          containsStarter = false; //Will only set to false if there is no starter
        }       
      }

      if (containsStarter == false) { //If the set of 4 doesnt have the starter
        for (int i)
      }
      
    }
  }
  
}
