package stacks.stack_with_array;

public class App {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();

        st.push(101);
        st.push(11);
        st.push(1);
        st.push(22);
        st.push(23);
        st.push(293); // --> last element to be added on the stack is the first on the stack (last in first out)

        System.out.println("Size of stack: " + st.size());

        while(!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
    }
}
