import java.util.ArrayList;
import java.util.HashSet;

public class HashSetTreeSetAssignment {

    public HashSetTreeSetAssignment(){

        ArrayList<HashSet<Integer>> list = new ArrayList<>();
        int r = (int)(Math.random()*11)+2;

        for(int i=0; i<r; i++) {
            HashSet<Integer> hashSet = new HashSet<>();
            for(int j=0; j<10; j++){
                int rand = (int)(Math.random()*30)+1;
                hashSet.add(rand);
            }
            list.add(hashSet);
        }

        //System.out.println(list);;


    }

    public HashSet<Integer> intersection(HashSet<Integer> set1, HashSet<Integer> set2){


        return new HashSet<>();
    }

    public static void main(String[]args){
        HashSetTreeSetAssignment app = new HashSetTreeSetAssignment();
    }
}
