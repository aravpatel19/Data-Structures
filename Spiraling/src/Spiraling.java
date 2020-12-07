import java.io.*;
import java.nio.Buffer;

public class Spiraling {

    public Spiraling(File file){
        try {

            BufferedReader input = new BufferedReader(new FileReader(file));
            String text;

            while((text = input.readLine()) != null){

                int dim = Integer.parseInt(text);
                String[][] grid = new String[dim][dim];

                //put white spaces for each spot on the grid
                for(int x=0; x<grid.length; x++){
                    for(int y=0; y<grid[0].length; y++){
                        grid[x][y] = "-";
                    }
                }

                spiral(grid);

                for(int x=0; x<grid.length; x++){
                    for(int y=0; y<grid[0].length; y++){
                        System.out.print(grid[x][y]);
                    }
                    System.out.println();
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void spiral(String[][] grid){

        int startR = 0;
        int startC = 0;
        int endR = grid.length-1;
        int endC = grid[0].length-1;

        while((startR <= endR) && (startC <= endC)) {

            //right
            for (int c = startC; c <= endC; c++) {
                grid[startR][c] = "*";
            }
            startR++;

            if(startC>=1){
                startC++;
            }

            //down
            for(int r=startR; r <= endR; r++){
                grid[r][endC] = "*";
            }
            endC--;

            //left
            for(int c=endC; c >= startC ; c--){
                grid[endR][c] = "*";
            }
            endR--;

            //up
            for(int r=endR; r >= startR+1; r--){
                grid[r][startC] = "*";
            }
            startC++;
            startR++;
            endC--;
            endR--;

        }

        if(grid.length % 4 ==2){
            grid[grid.length/2][(grid.length/2)-1] = "-";
        }

    }

    public static void main(String[]args){
        Spiraling app = new Spiraling(new File("/Users/aravpatel/IntellijProjects/Spiraling/src/Spiraling.txt"));
    }
}
