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
    
  }
  
}
