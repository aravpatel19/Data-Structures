import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.spi.CalendarNameProvider;

public class TimeTravel {

    public TimeTravel(File file){

        try {
            BufferedReader input = new BufferedReader(new FileReader(file));
            String text;

            while((text=input.readLine()) != null){

                Calendar calendar = Calendar.getInstance();
                System.out.print("Departure Date and Time: ");
                printTime(calendar);

                String[] line = text.split(" ");
                int days = Integer.parseInt(line[0]);
                int hours = Integer.parseInt(line[1]);
                int min = Integer.parseInt(line[2]);

                addTime(calendar, days, hours, min);

                System.out.print("Arrival Date and Time: ");
                printTime(calendar);

                System.out.println();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void printTime(Calendar calendar){
        String date = (new SimpleDateFormat("MM/dd/yyyy")).format(calendar.getTime());
        String time = (new SimpleDateFormat("hh:mm aa")).format(calendar.getTime());
        //calendar.add(Calendar.HOUR, 4);
        System.out.println(time + " on " + date);

    }
    public void addTime(Calendar calendar, int days, int hours, int min){
        calendar.add(Calendar.DAY_OF_YEAR, days);
        calendar.add(Calendar.HOUR, hours);
        calendar.add(Calendar.MINUTE, min);
    }

    public static void main(String[]args){
        TimeTravel app = new TimeTravel(new File("/Users/aravpatel/IntellijProjects/TimeTravel/src/TravelFile.txt"));
    }
}
