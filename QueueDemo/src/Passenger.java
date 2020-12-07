import java.sql.Time;

public class Passenger implements Comparable<Passenger>{

    private String first;
    private String last;
    private String city;
    private String time;
    private String currentTimeString = "9:03 AM";

    public Passenger(String name, String city, String time){
        this.first = name.split(" ")[0];
        this.last = name.split(" ")[1];
        this.city = city;
        this.time = time;
    }

    public String getLastName(){
        return last;
    }
    public String getFirstName(){
        return first;
    }
    public String flightCity(){
        return city;
    }
    public String flightTime(){
        return time;
    }

    public Time etdCalc(){
        Time currentTime = convertToTime(currentTimeString);
        Time flightTime = convertToTime(time);

        int hour = flightTime.getHours() - currentTime.getHours();
        int minute = flightTime.getMinutes() - currentTime.getMinutes();

        return new Time(hour, minute, 0);
    }

    public Time convertToTime(String text){
        int hour = Integer.parseInt(text.split(":")[0]);
        if(text.contains("PM") && hour != 12) {
            hour += 12;
        }

        text = text.replace(" AM", "");
        text = text.replace(" PM", "");

        //System.out.println(text);
        int minute = Integer.parseInt(text.split(":")[1]);

        return new Time(hour, minute, 0);
    }

    @Override
    public int compareTo(Passenger o) {

        /*if(etdCalc().getHours() < o.etdCalc().getHours()){
            return -1;
        }
        else if(etdCalc().getHours() > o.etdCalc().getHours()){
            return 1;
        }

        else{
            if(etdCalc().getMinutes() < o.etdCalc().getMinutes()){
                return -1;
            }
            else if(etdCalc().getMinutes() > o.etdCalc().getMinutes()){
                return 1;
            }
        }

        return 0;
         */

        return etdCalc().compareTo(o.etdCalc());
    }

    public String toString(){

        if(etdCalc().getHours() == 0) {
            return last + ", " + first + " - " + city + " - " + time + " - " + etdCalc().getMinutes() + " Minutes";
        }

        return last + ", " + first + " - " + city + " - " + " time " + " - " +
                etdCalc().getHours() + " Hours " + etdCalc().getMinutes() + " Minutes";
    }
}
