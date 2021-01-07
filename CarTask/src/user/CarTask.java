package user;

import java.io.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class CarTask {

    Queue<Car> queue;
    Stack<Car> stack;
    PriorityQueue<Car> priorityQueue;

    public CarTask(){

        queue = new LinkedList<>();
        stack = new Stack<>();
        priorityQueue = new PriorityQueue<>();

        //fills queue with car information
        fillQueue();

        System.out.println("Queue");
        System.out.println(String.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s", "Acceleration",
                "Miles Per Gallon", "Horse Power", "Engine Size", "Weight",
                "Cylinders", "Car ID", "Country of Origin"));
        while(queue.peek() != null){

            stack.push(queue.peek());
            System.out.println(queue.poll());
        }

        System.out.println("\n\n\n\n");

        System.out.println("Stack");
        System.out.println(String.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s", "Acceleration",
                "Miles Per Gallon", "Horse Power", "Engine Size", "Weight",
                "Cylinders", "Car ID", "Country of Origin"));
        while(!(stack.isEmpty())){

            priorityQueue.add(stack.peek());
            System.out.println(stack.pop());
        }

        System.out.println("\n\n\n\n");

        System.out.println("Priority Queue");
        System.out.println(String.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s", "Acceleration",
                "Miles Per Gallon", "Horse Power", "Engine Size", "Weight",
                "Cylinders", "Car ID", "Country of Origin"));
        while(priorityQueue.peek() != null){
            System.out.println(priorityQueue.poll());
        }
    }

    public void fillQueue(){

        File file = new File("/Users/aravpatel/IntellijProjects/CarTask/src/user/CarData.txt");
        try {

            BufferedReader input = new BufferedReader(new FileReader(file));
            String text;

            while((text = input.readLine()) != null){

                //System.out.println(text);
                text = text.replaceAll("[^0-9]", " ");
                //System.out.println(text);
                String[] parts = text.split(" ");

                int carID = Integer.parseInt(parts[0]);
                int mpg = Integer.parseInt(parts[1]);
                int engSize = Integer.parseInt(parts[2]);
                int horsePwr = Integer.parseInt(parts[3]);
                int weight = Integer.parseInt(parts[4]);
                int acceleration = Integer.parseInt(parts[5]);
                int countryOfOrigin = Integer.parseInt(parts[6]);
                int cylinders = Integer.parseInt(parts[7]);

                Car car = new Car(carID, mpg, engSize, horsePwr, weight, acceleration, countryOfOrigin, cylinders);
                queue.add(car);
                //System.out.println(car);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[]args){

        CarTask app = new CarTask();
    }
}
