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
  Node new2 = new Node(value);
  new2.setNext(null);
  Node current = start;
  while (current.getNext() != null) {
    current = current.getNext();
  }
  current.setNext(new2);
  size = size + 1;
  return true;
}
public void add(int index, String value){
  Node hold = new Node(value);
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
  private Node move(int index){
     if(index < 0 || index >= size()){
          throw new IndexOutOfBoundsException("Index is out of bounds!");
     }
     if (index == 0) return start;
     if (index == size - 1) return end;
     Node current = start;
     for(int i = 0; i < index; i++){
       current = current.getNext();
     }
     return current;
   }

  public String get(int index){
  if(index < 0 || index >= size()){
       throw new IndexOutOfBoundsException("Index is out of bounds!");
  }
   Node current = move(index);
   return current.getData();
 }
 public String set(int index, String value){
  if(index < 0 || index >= size()){
    throw new IndexOutOfBoundsException("Index is out of bounds!");
  }
  Node current = move(index);
  String prev = current.getData();
  current.setData(value);
  return prev;
}
  public String toString(){
   String s = "";

		if (start != null) {
			Node current = start.getNext();
			while (current != null) {
				s += current.getData().toString();
        if(current.getNext() != null){
          s += ", ";
        }
				current = current.getNext();
			}

		}
		return "[" + s + "]";
 }
 public String remove(int index){

   String oldValue = "";
   if(size() == 1){
     oldValue = start.getData();
     start = null;
     end = null;
   }else if(index == 0){
     oldValue = start.getData();
     Node head = start.getNext();
     head.setPrev(null);
     start.setNext(null);//does this break the linked list? only needed if it does?
     start = head;
   }else if(index == size() -1){
     oldValue = end.getData();
     Node old = end.getPrev();
     old.setNext(null);
     end.setPrev(null);
     end = old;
   }else{
     Node old = move(index);
     oldValue = old.getData();
     old.getPrev().setNext(old.getNext());//set the previous one's next to the old node's next
     old.getNext().setPrev(old.getPrev());//set the next one's previous to the old node's previous
     old.setNext(null);
     old.setPrev(null);
   }
   size=size - 1;
   return oldValue;
 }
 public void extend(MyLinkedList other){
   size = other.size + size;
   end.setNext(other.start);
  other.start.setPrev(end);

   other.size = 0;
   other.start = null;
  other.end = null;
 }

}
