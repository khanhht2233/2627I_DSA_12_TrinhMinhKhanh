public class linkedList {
    private static class Node{
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    private Node first;

    public linkedList(){
        this.first = null;
    }

    public void addFirst(int data){
        Node tmp = new Node(data);
        tmp.next = first;
        first = tmp;
    }

    public void addLast(int data){
        Node add = new Node(data);
        if (first == null){
            first = add;
            return;
        }
        Node tmp = first;
        while(tmp.next != null){
            tmp = tmp.next;
        }
        tmp.next = add;
    }

    public void removeFirst(){
        if (first == null){
            System.out.println("khong the xoa phan tu");
            return;
        }
        first = first.next;
    }

    public void printList(){
        if (first == null) return;
        Node tmp = first;
        while (first == null){
            System.out.println(first.data + " -> ");
            first = first.next;
        }
        System.out.println("null");
    }

}
