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

        String line = "It is all in a count and counts are so fun! The lett'rs are right there to grab one by one";
        TreeMap<Character, Integer> treeMap = new TreeMap<>();
        char[] list = line.toLowerCase().toCharArray();
        for(char x : list){
            if(!treeMap.containsKey(x)){
                treeMap.put(x, 0);
            }
            treeMap.put(x, treeMap.get(x)+1);
        }
        System.out.println(treeMap);

        String text = "21en ilni tidn ifuo yneh wree hcll idna retn eceh tmor fgno lsre ttel xisl";
        for(int i=text.length()-1; i>=0; i--){
            System.out.print(text.charAt(i));
        }
        System.out.println();

        text = "Here's secret 2 - it's a challenging task. Use naught what you see, but what you can't see!";
        System.out.println(text.length());
        System.out.println(text.charAt(text.length()/2));

        int p = 1;
        while( p > 0){
            System.out.println(p);
            p++;
        }
    }

    public static void main(String[]args){
        HashMapTreeMapAssignment app = new HashMapTreeMapAssignment();
    }
}
