import java.io.*;
import java.sql.Time;
import java.util.*;

public class QueueDemo {


    public QueueDemo(){

        //Task 1:

        File file = new File("/Users/aravpatel/IntellijProjects/QueueDemo/src/Paragraph.txt");
        try {
            Queue<Word> queue = new LinkedList<Word>();
            PriorityQueue<Word> pq = new PriorityQueue<Word>();

            BufferedReader input = new BufferedReader(new FileReader(file));
            String text;
            String paragraph = "";
            while((text = input.readLine()) != null){
                paragraph += text;
            }
            //System.out.println(paragraph);

            String[] p = paragraphToList(paragraph);

            for(int i=0; i<p.length; i++){
                Word word = new Word(p[i]);
                queue.add(word);
                pq.add(word);
                //System.out.println(pq);
            }
            /*System.out.println();
            System.out.println(pq);
            System.out.println();
            System.out.println(queue);*/
            //System.out.println(pq.size());

            //for(int i=0;i<pq.size();i++){
            while(pq.peek() != null){
                System.out.println(String.format("%-25s%20s", queue.poll().toString(), pq.poll().toString()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\n\n\n");



        //Task 2:
        File f2 = new File("/Users/aravpatel/IntellijProjects/QueueDemo/src/PassengerInfo.txt");

        try {
            Queue<Passenger> queue = new LinkedList<Passenger>();
            PriorityQueue<Passenger> pq = new PriorityQueue<Passenger>();

            BufferedReader input = new BufferedReader(new FileReader(f2));
            String text;

            while((text = input.readLine()) != null){

                String name = text;
                //System.out.println(name);
                text = input.readLine();

                String city = text;
                //System.out.println(city);
                text = input.readLine();

                String time = text;
                //System.out.println(time);

                Passenger passenger = new Passenger(name, city, time);
                if(passenger.etdCalc().getHours() < 1){
                    pq.add(passenger);
                }
                else{
                    queue.add(passenger);
                }
            }

            System.out.println("Priority Queue Flights");
            while(pq.peek() != null){
                System.out.println(pq.poll());
            }

            System.out.println("\n\n");

            System.out.println("Queue Flights");
            while(queue.peek() != null){
                System.out.println(queue.poll());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String[] paragraphToList(String paragraph){

        paragraph = paragraph.toLowerCase();
        paragraph = paragraph.replaceAll(",","");
        paragraph = paragraph.replaceAll("\\."," ");

        return paragraph.split(" ");
    }

    public static void main(String[]args){
        QueueDemo app = new QueueDemo();
    }
}
