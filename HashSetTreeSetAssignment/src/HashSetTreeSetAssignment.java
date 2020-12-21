import java.net.Proxy;
import java.util.*;

public class HashSetTreeSetAssignment {

    public HashSetTreeSetAssignment(){

        //1
        ArrayList<HashSet<Integer>> list = new ArrayList<>();
        int r = (int)(Math.random()*11)+2;

        for(int i=0; i<r; i++) {
            HashSet<Integer> hashSet = new HashSet<>();
            for(int j=0; j<10; j++){
                int rand = (int)(Math.random()*30)+1;
                while(hashSet.contains(rand)){
                    rand = (int)(Math.random()*30)+1;
                }
                hashSet.add(rand);
            }
            list.add(hashSet);
        }

        System.out.println(list.get(0));
        System.out.println(list.get(1));

        //2
        HashSet<Integer> intersection = intersection(list.get(0), list.get(1));
        System.out.println();
        System.out.println("Intersection: " +intersection);


        //3
        HashSet<Integer> union = union(list.get(0), list.get(1));
        System.out.println("Union: "+ union);

        System.out.println();

        /*HashSet<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(3);
        set1.add(5);
        set1.add(7);

        HashSet<Integer> set2 = new HashSet<>();
        set2.add(2);
        set2.add(4);
        set2.add(6);
        set2.add(8);

        System.out.println(set1);
        System.out.println(set2);
        System.out.println(intersection(set1, set2));
        System.out.println(union(set1, set2));

        System.out.println();*/

        //4
        HashSet<Integer> evenInter = evenIntersection(list.get(0), list.get(1));
        System.out.println("Even Intersection: "+evenInter);

        //5
        HashSet<Integer> evenUnion = evenUnion(list.get(0), list.get(1));
        System.out.println("Even Union: "+evenUnion);

        /*list.get(0).removeAll(list.get(1));
        System.out.println(list.get(0));*/

        System.out.println();

        HashSet<Integer> setNew = new HashSet<>(list.get(0));
        Iterator<Integer> it = setNew.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+ " ");
        }

        HashSet<Integer> a = new HashSet<>();
        a.add(1);
        a.add(2);
        a.add(4);
        a.add(5);

        TreeSet<Integer> b = new TreeSet<>();
        b.add(1);
        b.add(2);

        System.out.println("\n\n");

       for(int i=0; i<4; i++){
           System.out.println(i+": ");
           for(int j=0; j<4; j++){
               if(i == 2){
                   break;
               }
               System.out.print(j+" ");
           }
           System.out.println();
           System.out.println("Hello");
           System.out.println();

           List<List<Integer>> lists = new ArrayList<>();
           ArrayList<Integer> h = new ArrayList<>();
           h.add(3);
           h.add(5);
           lists.add((List<Integer>) h.clone());

           List<Integer> u = h;
           //System.out.println(lists);

            String k = "aw2";
            int t = 400;
            for(int o=0; o<k.length(); o++) {
                try {
                    t = Integer.parseInt(String.valueOf(k.charAt(o)));
                } catch (Exception e) {}
            }
            System.out.println(t);
       }
    }

    public HashSet<Integer> intersection(HashSet<Integer> set1, HashSet<Integer> set2){     //intersection method

        HashSet<Integer> set = new HashSet<>(set1);

        if(set.retainAll(set2) || set.equals(set2)){
            return set;
        }

        set.clear();
        return set;
    }

    public HashSet<Integer> evenIntersection(HashSet<Integer> set1, HashSet<Integer> set2) {   //even intersection method

        HashSet<Integer> set = intersection(set1, set2);
        Object[] arr = set.toArray();
        for(int i=0; i<arr.length; i++){
            if((int)arr[i] % 2 != 0){
                set.remove(arr[i]);
            }
        }
        return set;
    }

    public HashSet<Integer> union(HashSet<Integer> set1, HashSet<Integer> set2){  //union method

        HashSet<Integer> set = new HashSet<>(set1);

        if(set.addAll(set2)){
            return set;
        }

        set.clear();
        return set;
    }

    public HashSet<Integer> evenUnion(HashSet<Integer> set1, HashSet<Integer> set2) {  //even union method

        HashSet<Integer> set = union(set1, set2);
        Object[] arr = set.toArray();
        for(int i=0; i<arr.length; i++){
            if((int)arr[i] % 2 != 0){
                set.remove(arr[i]);
            }
        }
        return set;
    }

    public static void main(String[]args){
        HashSetTreeSetAssignment app = new HashSetTreeSetAssignment();
    }
}
