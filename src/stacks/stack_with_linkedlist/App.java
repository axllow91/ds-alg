package stacks.stack_with_linkedlist;

public class App {
    public static void main(String[] args) {
        Stack<Integer> ms = new Stack<>();
        ms.push(10);
        ms.push(100);
        ms.push(1000);
        ms.push(10000);

        System.out.println(ms.size());

        System.out.println("Peeking: " + ms.peek());

        System.out.println(ms.pop());
        System.out.println(ms.pop());
        System.out.println(ms.pop());

    }

}
