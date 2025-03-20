
class DLinkedList {
  Node head;

  public DLinkedList(int d) {
    head = new Node(d);
  }

  public static void main(String[] args) {
    DLinkedList dList = new DLinkedList(1);
    dList.insertAtBegining(2);
    dList.insertAtPos(2, 3);
    DLinkedList.printList(dList.head);
    dList.deleteAtPos(1);
    DLinkedList.printList(dList.head);

  }

  public void insertAtBegining(int d) {
    Node newNode = new Node(d);

    newNode.next = head;


    if(head != null) {
      head.prev = newNode;
    }
    head = newNode;
  }

  public void insertAtPos(int pos, int d) {
    Node newNode = new Node(d);

    if(pos == 1) {
      insertAtBegining(d);
    } else {
      Node curr = head;

      for(int i = 1; i < pos - 1 && curr != null; i++) {
        curr = curr.next;
      }

      if(curr == null) {
        System.out.println("Position out of bounds");
        return;
      }

      newNode.prev = curr;
      newNode.next = curr.next;

      curr.next = newNode;
      if(newNode.next != null) {
        newNode.next.prev = newNode;
      }
    }
  }

  public void deleteAtPos(int pos) {
    if(getLength(head) == 0) {
      return;
    }

    Node nToDelete = head;
    for(int i = 1; i < pos; i++) {
      nToDelete = nToDelete.next;
    }

    if(nToDelete.prev != null) {
      nToDelete.prev.next = nToDelete.next;
    } else {
      head = nToDelete.next;
    }

    if(nToDelete.next != null) {
      nToDelete.next.prev = nToDelete.prev;
    }

    nToDelete.next = nToDelete.prev = null;
  }

  private int getLength(Node curr) {
    int count = 0;
    
    while(curr != null) {
      count++;
      curr = curr.next;
    }
    return count;
  }

  public static void printList(Node head) {
    Node curr = head;
    while(curr != null) {
      System.out.print(curr.data);
      curr = curr.next;
    }
    System.out.println();
  }


} 

class Node {

  int data;

  Node prev;
  Node next;

  Node(int d) {
    data = d;
    prev = next = null;
  }

}

