import com.sun.source.tree.Tree;

import javax.swing.tree.TreeNode;
import java.io.*;
import java.nio.Buffer;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class HashMapTreeMapAssignment {

    public HashMapTreeMapAssignment(){
                                                                        // value = priority queue of bowlers
        TreeMap<Integer, PriorityQueue<Bowler>> map = new TreeMap<>();  // key = score


        File file = new File("/Users/aravpatel/IntellijProjects/HashMapTreeMapAssignment/src/BowlingData.txt");
        try {
            BufferedReader input = new BufferedReader(new FileReader(file));
            String text;

            // first last score
            while((text = input.readLine()) != null){
                String first = text.split(" ")[0];
                String last = text.split(" ")[1];
                int score = Integer.parseInt(text.split(" ")[2]);
                if(!map.containsKey(score))
                    map.put(score, new PriorityQueue<Bowler>());
                map.get(score).add(new Bowler(first, last, score));
            }
            System.out.println(map);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();

        //just printing keys:
        System.out.println("KEYS: ");
        Iterator<Integer> keys = map.keySet().iterator();
        while(keys.hasNext()){
            System.out.println(keys.next());
        }

        System.out.println();

        //printing entries
        System.out.println("ENTRY SET:");
        Iterator entries = map.entrySet().iterator();
        while(entries.hasNext()){
            System.out.println(entries.next());
        }

        System.out.println();

        //just printing values
        System.out.println("VALUES:");
        Iterator<PriorityQueue<Bowler>> values = map.values().iterator();
        while(values.hasNext()){
            System.out.println(values.next());
        }
        System.out.println();
    }

    public static void main(String[]args){
        HashMapTreeMapAssignment app = new HashMapTreeMapAssignment();
    }
}
