import java.util.LinkedList;
import java.util.Queue;

public class TestSuperListRunner {

    public TestSuperListRunner(){

        SuperList<Integer> list = new SuperList<>();
        for(int i=0;i<10;i++){
            list.add(i);
        }                   //list is made: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

        System.out.println("Oringinal List: " + list);   //print out list

        System.out.println();

        list.push(4);          //push out 4
        System.out.println("List after push(4): "+ list);   //4 should be at end of list

        System.out.println();

        System.out.println("pop() = "+list.pop());  //should return and remove last index: value = 4
        System.out.println("List after pop(): "+ list);        //list should not have 4 at the end of list anymore

        System.out.println();

        System.out.println("poll() = "+ list.poll());  //should return and remove the first index: value = 0
        System.out.println("List after poll(): "+ list);        //list should not have 0 at the beginning of the list anymore.

        System.out.println();

        System.out.println("get(5) = "+list.get(5));  //list should return the 5th index of list, which is the value 6

        System.out.println();

        System.out.println("remove(5) = "+list.remove(5));  //should remove and return the 5th value of the list, which is the value 6
        System.out.println("List after remove(5): "+ list);   //list should not have the value 6 anymore. the size of the list also shrinks.

        System.out.println();

        list.clear();   //should clear the list
        System.out.println("List after clear(): "+ list);   //List should be empty
        System.out.println("isEmpty(): "+list.isEmpty());  //should return true because list is empty

        System.out.println();

        list.push(1);
        list.push(3);
        list.push(5);
        list.push(7);
        list.push(9);  //pushed 5 values into the list

        System.out.println("List after pushes: "+ list);   //printing list with pushed values
        System.out.println("isEmpty(): "+ list.isEmpty());  //should return false

        System.out.println();

        System.out.println("contains(7): "+ list.contains(7));  //should return true
        System.out.println("contains(8): "+ list.contains(8));  //should return false

        System.out.println();

        list.add(2, 4);   //should add the value 4 after the value 3
        System.out.println("List after add(2,4): "+list);   //prints new list. (with 4 in between the 3 and 5).

        System.out.println();

        System.out.println("stackPeek: "+ list.stackPeek());
        System.out.println("queuePeek: "+ list.queuePeek());
        System.out.println("size: " + list.size());

        System.out.println();

        while(!(list.isEmpty())){
            System.out.print(list.pop()+" ");
        }
        System.out.println("\n"+list);
    }

    public static void main(String[]args){

        TestSuperListRunner app = new TestSuperListRunner();
    }
}
