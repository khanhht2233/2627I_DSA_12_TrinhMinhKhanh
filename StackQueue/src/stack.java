

public class stack {
    private static class Node{
        int data;
        Node next;
        int size;

        Node(int data){
            this.data = data;
            this.size = 1;
            this.next = null;
        }
    }

    private Node first = null;

    //PUSH
    public void Push(int data){
        Node tmp = new Node(data);
        tmp.next = first;
        first = tmp;
        first.size += 1;
    }
    //POP
    public void Pop(){
        Node tmp = first;
        tmp = tmp.next;
        first = tmp;
        first.size -= 1;

    }
    //TOP
    public int top() {
        return first.data;
    }

    //isEmpty
    public boolean isEmpty(){
        return first == null;
    }
    //Size
    public int getSize(){
        return first.size;
    }

    //PRINT STACK
    public void printStack(){
        Node tmp = first;
        while (tmp != null){
            System.out.print(tmp.data + " -> ");
            tmp = tmp.next;
        }
        System.out.print("null");
    }
    public static void main() {
        stack s = new stack();
        System.out.println(s.isEmpty());
        s.Push(1);
        s.Push(2);
        s.Push(3);
        System.out.println(s.getSize());
        System.out.println(s.isEmpty());
        s.printStack();
    }
}
