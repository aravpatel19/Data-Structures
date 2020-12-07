import java.io.*;

public class FileTemplate {

    public FileTemplate() {

        File fileName = new File("/Users/aravpatel/IdeaProjects/datastructures/src/example.txt");
        try {
            BufferedReader input = new BufferedReader(new FileReader(fileName));
            String text;
            int sum=0;

            while( (text=input.readLine()) != null ){

                String[] pieces = text.split(", ");
                int num;
                try {
                    for(int i=0;i<pieces.length;i++){
                        num = Integer.parseInt(pieces[i]);
                        sum += num;
                    }
                }catch(NumberFormatException ee){
                }

            }
            System.out.println(sum);

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException ef) {
        }
    }

    public static void main(String[]args){

        FileTemplate app = new FileTemplate();
    }
}
