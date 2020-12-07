import java.util.Collections;

public class Runner {

    SuperList<Integer> before = new SuperList<>();
    SuperList<Integer> after = new SuperList<>();

    public Runner(){

        SuperList<Integer> list = new SuperList<>();
        for(int i=0; i<30; i++){
            int r = (int)(Math.random()*1000)+1;
            list.add(r);
        }
        System.out.println("List: " + list.toString());  //output list of 30 random integers from 1 to 1000
        System.out.println("Size: " + list.size());

        System.out.println();

        SuperList<Integer> stack = new SuperList<>();
        for(int i=0; i<list.size(); i++){           //list to stack
            stack.push(list.remove(i));
            i--;
        }
        System.out.println("Stack: "+ stack);

        System.out.println();

        SuperList<Integer> queue = new SuperList<>();  //stack to queue
        for(int i=0; i<stack.size(); i++){
            queue.add(stack.pop());
            i--;
        }
        System.out.println("Queue: "+ queue);

        System.out.println();

        for(int i=0; i<queue.size(); i++){  //queue to arraylist
            int r = (int)(Math.random()*list.size());   //randomize positions
            list.add(r, queue.poll());
            i--;
        }
        System.out.println("ArrayList: " + list);

        System.out.println();

        //Sum
        System.out.println("Sum: "+sum(list));
        System.out.println("Even Indexed Sum: "+evenIndexedSum(list));
        System.out.println("Odd Indexed Sum: "+oddIndexedSum(list));

        System.out.println();

        int size = list.size();
        for(int i=0; i<size; i++){
            if(list.get(i)%2 == 0){         //duplicate even values
                list.add(list.get(i));
            }
        }
        System.out.println("Duplicate Even Values: "+ list);

        System.out.println();

        for(int i=0; i<list.size(); i++){
            if(list.get(i)%3 == 0){
                list.remove(i);
                i--;
            }
        }
        System.out.println("Remove instances of 3: "+ list);

        System.out.println();

        list.add(4, 55555);    //inserted the value 55555 into the 4th index
        System.out.println("List after add(4, 55555): "+ list);

        System.out.println();

        sortInteger(list);  //insertion sort of list
        System.out.println("List sorted in ascending order" + list);

        System.out.println();

        double median = median(list);
        System.out.println("Median: "+ median);   //calculated median
        int n = list.size();
        System.out.println("Size: "+ n);
        for(int i=0; i<n; i++){
            if(i<n/2) {
                before.add(list.get(i));
            }
            else if(i == n/2){
                if(n%2 == 0) {
                    after.add(list.get(i));
                }
            }
            else{
                after.add(list.get(i));
            }
        }
        System.out.println("Before Median: "+before);  //before median list
        System.out.println("After Median: " + after);   //after median list

        System.out.println("\n");

        SuperList<String> words = new SuperList<>();
        String sentence = "Improve your goldfish's physical fitness by getting him a bicycle";
        String[] w = sentence.split(" ");
        for(int i=0; i<w.length; i++){
            words.add(w[i]);
        }
        System.out.println("Words of Sentence: "+ words);
        for(int i=0; i<words.size(); i++){
            String word = words.get(i);
            if(word.length() <= 3){
                words.remove(i);
                i--;
            }
        }
        System.out.println("Remove words Less Than 3: "+ words);

        System.out.println();

        sortString(words);         //sorts words alphabetically through insertion sort
        System.out.println("Sorted Words: "+ words);

        System.out.println();

        double avgWordLength = avgWordLength(words);
        System.out.println("Average Word Length: "+ avgWordLength);
        
    }

    public int sum(SuperList<Integer> list){
        int sum = 0;
        for(int i=0; i<list.size(); i++){
            sum += list.get(i);
        }
        return sum;
    }
    public int evenIndexedSum(SuperList<Integer> list){
        int sum = 0;
        for(int i=0; i<list.size(); i+=2){
            sum += list.get(i);
        }
        return sum;
    }
    public int oddIndexedSum(SuperList<Integer> list){
        int sum = 0;
        for(int i=1; i<list.size(); i+=2){
            sum += list.get(i);
        }
        return sum;
    }

    public void sortInteger(SuperList<Integer> list){   //insertion sort method for Integers

        int size = list.size();
        for(int i=1; i<size; i++){
            Integer after = list.get(i);
            list.remove(i);
            int j = i-1;

            while(j >= 0 && after < list.get(j)){

                list.add(j+1, list.get(j));
                list.remove(j);

                j--;
            }
            list.add(j+1, after);
        }
    }
    public void sortString(SuperList<String> list){   //insertion sort method for Strings

        int size = list.size();
        for(int i=1; i<size; i++){
            String after = list.get(i);
            list.remove(i);
            int j = i-1;

            while(j >= 0 && after.compareToIgnoreCase(list.get(j)) < 0){

                list.add(j+1, list.get(j));
                list.remove(j);

                j--;
            }
            list.add(j+1, after);
        }
    }

    public double median(SuperList<Integer> list){    //method to find median

        int n = list.size();
        if(n%2 == 0){
            return (double)(list.get((n/2)-1)+list.get(n/2))/2;
        }
        return (double) list.get(n/2);
    }

    public double avgWordLength(SuperList<String> words){
        int sum = 0;
        for(int i=0; i<words.size(); i++){
            sum += words.get(i).length();
        }
        return (double) sum/words.size();
    }

    public static void main(String[]args){
        Runner app = new Runner();
    }
}
