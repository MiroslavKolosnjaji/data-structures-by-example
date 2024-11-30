package linkedlist;

/**
 * @author Miroslav Kološnjaji
 */
public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
//        System.out.println(linkedList);
        linkedList.addFirst(10);
        linkedList.addFirst(20);
        linkedList.addFirst(30);
        linkedList.addLast(9);
        linkedList.addLast(8);
        linkedList.addLast(7);
        System.out.println(linkedList);
        System.out.println("Has loop: " + linkedList.hasLoop());
        linkedList.printMiddle();

    }
}
