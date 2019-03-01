package linked_list;

public class App {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();

        list.insert(10);
        list.insert(-2);
        list.insert(3);
        list.insert(15);
        list.insert(20);
        list.insert(1666);
        list.insert(0);


        System.out.println("Linked list: ");
        list.traverseList();

        System.out.println("\nSize of list: " + list.size());

        list.remove(0);
        list.remove(10);
        list.remove(20);

        System.out.println("\nList after removing elem: ");
        list.traverseList();



        // Adding objects to linked list
        Person p = new Person("Me", 55);

        List<Person> pl = new LinkedList<>();
        pl.insert(p);
        pl.insert(new Person("You", 20));
        pl.insert(new Person("Amurica", 15));
        pl.insert(new Person("Rudam", 33));
        pl.insert(new Person("Zeva", 1));

        System.out.println("Person linked list: ");
        pl.traverseList();
        System.out.println("\nSize of the list: " + pl.size());

        pl.remove(p);


        System.out.println("After removing person");
        pl.traverseList();

    }
}
