class Queue {
    int front, size, capacity;
    int array[];

    public Queue(int length) {
        capacity = length;
        front = size = 0;
        array = new int[capacity];
    }

    boolean isFull() {
        return (size == capacity);
    }

    boolean isEmpty() {
        return (size == 0);
    }

    void enqueue(int item) {
        if (isFull())
            return;
        int pos;
        pos = (front + size) % capacity;
        array[pos] = item;
        size = size + 1;
        System.out.println(item + " enqueued to queue");
    }

    int dequeue() {
        if (isEmpty())
            return 0;

        int item = array[front];
        front = (front + 1) % capacity;
        size = size - 1;
        return item;
    }

    int front() {
        if (isEmpty())
            return 0;

        return array[front];
    }
}

public class Queue_with_arrays {
    public static void main(String[] args) {
        Queue queue = new Queue(10);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        System.out.println("Queue size: " + queue.size);
        queue.enqueue(77);
        System.out.println(queue.dequeue() + " dequeued from queue\n");
        System.out.println("Front item is " + queue.front());
    }
}

class LinkedList {
    private Node front;
    private Node rear;

    static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public boolean isEmpty() {
        return (front == null);
    }

    public void insertLast(int new_data) { 
        Node new_node = new Node(new_data); 
        if (isEmpty()) {                    
            front = new_node;               
            rear = new_node;
        } else {
            rear.next = new_node;           
            rear = new_node;                
        }
    }

    public int deleteFirst() {
    if (isEmpty()) {
        throw new IllegalStateException("Queue is empty");
    }
    int temp = front.data;
    if (front.next == null) {
        rear = null;
    }
    front = front.next;
    return temp;
}


    void displayList() {
        System.out.println("===Displaying Elements of DEQ===");
        Node current = front;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}
class Queue_2 { 
    LinkedList llist;

    public Queue_2() { 
        llist = new LinkedList(); 
    }

    public boolean isEmpty() { 
        return llist.isEmpty(); 
    }

    public void enqueue(int new_data) { 
        llist.insertLast(new_data); 
    }

    public int dequeue() { 
        return llist.deleteFirst(); 
    }

    public void printQueue() { 
        llist.displayList(); 
    }
}
public class QueueClient { 
    public static void main(String[] args) { 
        Queue_2 list = new Queue_2(); 
        list.enqueue(10); 
        list.enqueue(20); 
        list.enqueue(30); 
        list.enqueue(40); 
        list.printQueue(); 
        list.dequeue(); 
        list.printQueue(); 
    }
}
