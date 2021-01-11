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

}
