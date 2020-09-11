public class Tester{
  public static void main(String[] args){
    LinkedList list = new LinkedList();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
    
    list.append(list.getNodeAt(1),20);
    list.delete(list.getNodeAt(3));
    
    list.search(4);

    list.print();  
  }
}
