class Main{
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
            System.out.println("khong the xoa phan tu");
            return;
        }
        first = first.next;
    }

    public void printList(){
        if (first == null) return;
        Node tmp = first;
        while (tmp != null){
            System.out.print(tmp.data + " -> ");
            tmp = tmp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
            Main list = new Main();

            list.addFirst(20);
            list.addFirst(10); // Danh sách: 10 -> 20 -> null
            list.addLast(30);   // Danh sách: 10 -> 20 -> 30 -> null

            System.out.print("Danh sách hiện tại: ");
            list.printList();

            list.removeFirst(); // Xóa 10
            System.out.print("Sau khi removeFirst: ");
            list.printList();
        }
    }
