public class Set<T> {
  private LinearNode<T> setStart; //The front of the linked list

  public Set() {
    setStart = null;
  }

  public void add(T element) {
    //Creating a new node called newElem that must be added to the linked list
    LinearNode<T> newElem = new LinearNode<T>(element); 
    
    if(setStart == null) { //If there is no element in the linked list
      setStart.setNext(newElem); //Set newElem as the first node
    }
    else {
      LinearNode<T> curr = setStart; //Setting a variable to loop though linked list
      while (curr.getNext() != null) {
        curr = curr.getNext(); //Moving the counter up 1
        if (curr.getNext() == null) { //If the value after curr is null
          curr.getNext().setNext(newElem); //Set that value to newElem
          break; //Break as we have already added our element to the linked list
        }
      }
    } 
  }


  public int getLength() {
    LinearNode<T> curr = setStart; //Setting curr to setStart
    int ct = 0; //Making a counter

    while (curr.getNext() != null) {//Looping through the linked list
      ct += 1; //Inceasing the counter
      curr = curr.getNext(); 
    }
    return ct;  
  }


  public T getElement(int i) {
    LinearNode<T> curr = setStart;

    for (int j = 0; j < i; j++) { //Looping through the linked list i times
      curr = curr.getNext();
    }

    return curr.getElement();
  } 

  public boolean contains(T element) {
    LinearNode<T> curr = setStart;
    while (curr.getNext() != null) { //Looping through the linked list
      curr = curr.getNext(); //Putting it the beginning because setStart has no element
      //If the value at curr == element or .equals element then return true
      if (curr.getElement() == element || curr.getElement().equals(element)) { //Potential erorr here
        return true;
      }
      
    }
    //If not there, return false
    return false;   
  }


  public String toString() {
    LinearNode<T> curr = setStart;
    String s = ""; //Building on the string
    while (curr.getNext() != null) { //Looping through the list
      curr = curr.getNext();
      s += curr.getElement();
      s += " ";
    }

    return s; 
  }
  
}
