import java.lang.*;
public class PowerSet<T> {
  private Set<T>[] set;

  //Constructor
  public PowerSet(T[] elements) {
    //Creating the power set
    int loop = (int)Math.pow(2, elements.length);
    String s = "";
    for (int i = 0; i < loop; i++) { //Looping 2^elements times 
      s = Integer.toBinaryString(i); //Setting s to a binary value 
      //Making s have the correct number of digits in it
      while (s.length() < elements.length) { //If too small
        s = "0" + s; //Padding the value with a 0
      }
      //Now with the correct value for the binary number we can add the corresponding values from the array
      Set<T> tempSet = new Set<T>();
      for (int j = 0; j < s.length(); j++) {
        if (s.charAt(j) == '1') {
          tempSet.add(elements[j]); //Putting all of the elements from this set in a temporary set
        }
      }
      //Appending the tempSet to the 
      
      
    }
  }
  
}
