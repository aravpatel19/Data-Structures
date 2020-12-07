import java.io.*;
import java.util.ArrayList;

public class AmicableNumbers {

    public AmicableNumbers(File file){

        try {
            BufferedReader input = new BufferedReader(new FileReader(file));
            String text;

            while( (text=input.readLine()) != null){

                //splits the two numbers
                String[] numbers = text.split(" ");
                int x = Integer.parseInt(numbers[0]);
                int y = Integer.parseInt(numbers[1]);
                isAmicable(x, y);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //method to find factors
    public ArrayList<Integer> findFactors(int x){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1;i<x;i++){
            if(x%i == 0){
                list.add(i);
                //System.out.print(i+" ");
            }
        }
        //System.out.println();

        return list;
    }

    public void isAmicable(int x, int y) {

        ArrayList<Integer> xFactors = findFactors(x);
        ArrayList<Integer> yFactors = findFactors(y);
        int xSum = findSum(xFactors);
        int ySum = findSum(yFactors);

        //true
        if((xSum == y) && (ySum == x)){
            System.out.println("The numbers "+x+" and "+y+" are amicable.");
        }

        //false
        else{
            System.out.println("The numbers "+x+" and "+y+" are not amicable.");
        }

        printFactors(x, xFactors, xSum);
        printFactors(y, yFactors, ySum);

        System.out.println();
    }

    public void printFactors(int num, ArrayList<Integer> factors, int sum) {

        if (factors.size() > 2) {
            System.out.print("\tFactors of " + num + " are ");
            for (int i = 0; i < factors.size(); i++) {

                if (i == factors.size() - 1) {
                    System.out.println("and " + factors.get(i) + ". Sum is " + sum + ".");
                }

                else {
                    System.out.print(factors.get(i) + ", ");
                }
            }
        }

        else if(factors.size() == 2){
            System.out.println("\tFactors of " + num + " are "+factors.get(0)+" and "+factors.get(1)+". Sum is " + sum + ".");
        }

        else{
            System.out.println("The factor of "+ num +" is "+factors.get(0)+". Sum is "+sum + ".");
        }
    }

    public int findSum(ArrayList<Integer> list){
        int sum = 0;
        for(int i=0;i<list.size();i++){
            sum += list.get(i);
        }
        return sum;
    }

    public static void main(String[]args){

        AmicableNumbers app = new AmicableNumbers(new File("/Users/aravpatel/IntellijProjects/AmicableNumbers/src/AmicableNumsFile.txt"));

    }
}
