import javax.swing.plaf.synth.SynthTextAreaUI;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class GuitarHero {

    public GuitarHero(File file){
        try {

            BufferedReader input = new BufferedReader(new FileReader(file));
            String text;
            int[][] helper = new int[5][6];

            createHelper(helper);

            /*
            for(int r=0;r<helper.length; r++){
                for(int j=0;j<helper[0].length; j++){
                    System.out.print(helper[r][j]+" ");
                }
                System.out.println();
            }
            */

            int numOfMeasures = 0;
            int row =0;
            String[][] printout = null;// = new String[numOfMeasures][30];

            while((text=input.readLine()) != null){

                String[] check = text.split(",");
                numOfMeasures = check.length;
                

                if(printout == null) {

                    printout = new String[30][numOfMeasures+1];

                    printout[0][0] = "Measure";
                    printout[1][0] = "G#";
                    printout[2][0] = "G";
                    printout[3][0] = "F#";
                    printout[4][0] = "F";
                    printout[5][0] = "E";
                    printout[6][0] = "D#";
                    printout[7][0] = "D";
                    printout[8][0] = "C#";
                    printout[9][0] = "C";
                    printout[10][0] = "B";
                    printout[11][0] = "A#";
                    printout[12][0] = "A";
                    printout[13][0] = "G#";
                    printout[14][0] = "G";
                    printout[15][0] = "F#";
                    printout[16][0] = "F";
                    printout[17][0] = "E";
                    printout[18][0] = "D#";
                    printout[19][0] = "D";
                    printout[20][0] = "C#";
                    printout[21][0] = "C";
                    printout[22][0] = "B";
                    printout[23][0] = "A#";
                    printout[24][0] = "A";
                    printout[25][0] = "G#";
                    printout[26][0] = "G";
                    printout[27][0] = "F#";
                    printout[28][0] = "F";
                    printout[29][0] = "E";

                }

                for (int m = 0; m < numOfMeasures; m++) {

                    printout[0][m+1] = String.valueOf(m+1);

                    for (int c = 0; c < 6; c++) {

                        if(check[m].charAt(c) == 'o' || check[m].charAt(c) == '*'){

                            int note = helper[row][c];
                            printout[note][m+1] = "O";
                        }

                    }
                }

                row++;
            }

            output(printout);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createHelper(int[][] helper){

        int i=1;
        for(int j=helper[0].length-1; j>=0 ; j--) {
            for (int r = helper.length - 1; r >= 0; r--) {
                if(i>10){
                    helper[r][j] = i-1;
                }
                else {
                    helper[r][j] = i;
                }
                i++;
            }
        }

    }
    public void output(String[][] printout){

        System.out.print(printout[0][0]+"\t\t");

        for(int i=1;i<printout[0].length;i++){
            System.out.print(printout[0][i]+"\t\t\t");
        }
        System.out.println();

        for(int i=1; i<printout.length; i++){
            for(int j=0; j<printout[0].length; j++){
                if(printout[i][j] == null){
                    System.out.print("\t\t\t");
                }
                else {
                    System.out.print(printout[i][j]+"\t\t\t");
                }
            }
            System.out.println();
        }

    }

    public static void main(String[]args){
        GuitarHero app = new GuitarHero(new File("/Users/aravpatel/IntellijProjects/GuitarHero/src/GuitarTabFile.txt"));
    }
}
