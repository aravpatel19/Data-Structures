public class Bowler implements Comparable<Bowler>{

    private String first;
    private String last;
    private int score;

    public Bowler(String first, String last, int score){
        this.first = first;
        this.last = last;
        this.score = score;
    }
    public String getFirst(){
        return first;
    }
    public String getLast(){
        return last;
    }
    public int getScore(){
        return score;
    }

    public int compareTo(Bowler other){

        if(!last.equals(other.getLast()))   //sorts last name
            return last.compareTo(other.getLast());

        return first.compareTo(other.getFirst());    //sorts first name
    }

    public String toString(){
        return first + " " + last;
    }
}
