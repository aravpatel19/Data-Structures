import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class FantasyFootball {


    public FantasyFootball(File file){

        try {
            BufferedReader input = new BufferedReader(new FileReader(file));
            String text;
            ArrayList<Player> list = new ArrayList<>();

            System.out.println(String.format("%-25s%-5s%5s%8s%8s%8s%10s", "Name", "Pos", "Team", "Low" , "High", "Dif", "Overall"));

            while( (text=input.readLine()) != null){

                String[] line = text.split(";");
                list.add(new Player(line[1], line[2], line[3], Double.parseDouble(line[5]),
                        Double.parseDouble(line[7]), Double.parseDouble(line[8])));

            }

            Collections.sort(list);

            for(int i=0;i<list.size();i++){
                System.out.println(list.get(i));
            }

        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } catch (NumberFormatException e){
            e.printStackTrace();
        }

    }

    public int convert(double x){

        String s = String.valueOf(x);
        String[] sep = s.split("\\.");
        int a = Integer.parseInt(sep[0]) * 12;
        int b;
        if(sep[1].equals("1")){
            b=10;
        }
        else{
            b = Integer.parseInt(sep[1]);
        }
        return a+b;


    }

    public int findDifference(double low, double high){
        int x = convert(low);
        int y = convert(high);
        return x-y;
    }

    public class Player implements Comparable<Player>{

        String name;
        String position;
        String team;
        double overall;
        double high;
        double low;

        public Player(String name, String position, String team, double overall, double high, double low) {
            this.name = name;
            this.position = position;
            this.team = team;
            this.overall = overall;
            this.high = high;
            this.low = low;

        }
        public String getName(){
            return name;
        }
        public String getPosition(){
            return position;
        }
        public String getTeam(){
            return  team;
        }
        public double getOverall(){
            return overall;
        }
        public double getHigh(){
            return high;
        }
        public double getLow(){
            return low;
        }


        public int compareTo(Player o) {

            int yourDifference = findDifference(low, high);
            int oDifference = findDifference(o.getLow(), o.getHigh());

            if((oDifference) > (yourDifference)){
                return -1;
            }
            else if((oDifference) < (yourDifference)){
                return 1;
            }
            else if(o.getOverall() > overall){
                return 1;
            }
            else if(o.getOverall() < overall){
                return -1;
            }

            return 0;
        }

        public String toString(){
            DecimalFormat f = new DecimalFormat("0.00");
            String fLow = f.format(low);
            String fHigh = f.format(high);
            String fOverall = f.format(overall);

            return String.format("%-25s%-5s%5s%8s%8s%8s%8s", name, position, team, fLow, fHigh, findDifference(low, high), fOverall);
        }
    }


    public static void main(String[]args){

        FantasyFootball app = new FantasyFootball(new File("/Users/aravpatel/IntellijProjects/FantasyFootball/src/DraftAverages.txt"));

    }
}
