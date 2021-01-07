public class MyLinkedList{
 private int size;
 private Node start,end;
 public MyLinkedList(){
   size = 0;
   start = new Node(null);
   end = new Node(null);

}
public int size(){
  return size;
}
public boolean add(String value){
  if (start == null) {
    start = new Node(value);
    return true;
  }
  Node new = new Node(value);
  new.setNext(null);
  Node current = start;
  while (current.getNext() != null) {
    current = current.getNext();
  }
  current.setNext(new);
  size = size + 1;
  return true;
}
public void add(int index, String value){
  node hold = new Node(value);
  Node current = start;
  if (current != null) {
    for(int i = 0; (i < index) && (current.getNext() != null); i++){
       current = current.getNext();
     }
   }
   hold.setNext(current.getNext());
   current.setNext(hold);
   size += 1;
  }

}
