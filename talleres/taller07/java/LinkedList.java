public class LinkedList{
  Node head;
  int size;

  public LinkedList(){
    head = null;
    size = 0;
  }

  public void add(int data){
    Node newNode = new Node(data);

    if(this.head == null){
      head = newNode;
    }else {
      Node last = getLastNode();
      last.next = newNode;
    }
    size += 1;
  }

  public Node getLastNode(){
    if (this.head == null) {
      return null;
    }else{
      Node last = this.head;
      Node aux = this.head;
      while (aux != null){
        last = aux;
        aux = last.next;
      }
      return last;
    }
  }

  public Node getNodeAt(int index){
    if (this.head == null || (this.size-1) < index) {
      return null;
    }

    Node aux = this.head;
    int x = 0;
    while (aux != null) {
      if (x == index) {
        break;
      }
      x += 1;
      aux = aux.next;
    }
    return aux; 
  }

  public void append(Node node, int data) {
     if (this.head == null || node == null) {
      return;
     }
     Node newNode = new Node(data);

     Node prev = node;
     Node next = node.next;

     prev.next = newNode;
     newNode.next = next;

     size += 1;
  }

  public void delete(Node node){
    if (this.head == null || node == null) {
      return;
    }

    Node aux = this.head;
    Node temp = null;

    if (node == head) {
      temp = this.head;
      this.head = this.head.next;

      temp = null;
    }else {
      while (aux.next != node) {
        aux = aux.next;
      }

      temp = aux.next;
      aux.next = temp.next;
      temp = null;
    }
    this.size -= 1;
  }

  public void print(){
   Node node = this.head;
   
   while (node != null){
    System.out.println(node.data);
    node = node.next;
   }

  }

  public void search(int data){
    if (this.head == null){
      System.out.println("Linked List is empty");
      return;
    }
    Node node = this.head;
    int i = 0;
    while (node != null) {
      if (node.data == data){
        System.out.println("Abeja encontrada en la posicion: "+i);
        return;
      }
      node = node.next;
      i += 1;
    }
  }
}
