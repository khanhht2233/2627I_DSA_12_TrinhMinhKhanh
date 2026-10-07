public class linkedList {
    private static class Node{
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    private Node first = null;

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
            return;
        }
        first = first.next;
    }

    public void removeLast(){
        if(first == null) return;
        Node low = null, high = first;
        while(high.next != null){
            low = high;
            high = high.next;
        }
        if(low == null){
            first = null;
        }else{
            low.next = null;
        }
    }
    public void printList(){
        Node tmp = first;
        if (tmp == null) System.out.print("null");
        else {
            while (tmp != null) {
                System.out.print(tmp.data + " -> ");
                tmp = tmp.next;
            }
            System.out.print("null\n");
        }
    }

    public int getSize(){
        int cnt = 0;
        Node tmp = first;

        while (tmp != null){
            cnt += 1;
            tmp = tmp.next;
        }
        return cnt;
    }

    public static void main() {
        linkedList list = new linkedList();
        list.addFirst(1);
        list.addFirst(2);

        list.printList();
        System.out.println(list.getSize());
    }

}
