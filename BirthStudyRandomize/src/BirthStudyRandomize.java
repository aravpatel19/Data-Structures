import java.lang.reflect.Array;
import java.util.ArrayList;

public class BirthStudyRandomize {


    public BirthStudyRandomize(){

       //100 highest-income counties list
        ArrayList<Integer> highList = getCounties(100);
        //50 lowest-income counties list
        ArrayList<Integer> lowList = getCounties(50);

        System.out.println("Highest-Income List:");
        for(int high=0;high<highList.size();high++){
            if(high%10==0){
                System.out.println();
            }
            System.out.print(highList.get(high)+" ");
        }

        System.out.println("\n\n");

        System.out.println("Lowest-Income List:");
        for(int low=0;low<lowList.size();low++){
            if(low%10==0){
                System.out.println();
            }
            System.out.print(lowList.get(low)+" ");

        }

        System.out.println();
    }

    public ArrayList<Integer> getCounties(int size){

        ArrayList<Integer> list = new ArrayList<>();
        for(int n=0;n<30;n++) {

            //amount of counties in list
            int r = (int) (Math.random() * size) + 1;

            //check for repeats
            while (list.contains(r)) {
                r = (int) (Math.random() * size) + 1;
            }
            list.add(r);
        }
        return list;
    }

    public static void main(String[]args){
        BirthStudyRandomize app = new BirthStudyRandomize();
    }

}
