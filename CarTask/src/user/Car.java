package user;

public class Car implements Comparable<Car>{

    private int id;
    private int mpg;
    private int engSize;
    private int horsePwr;
    private int weight;
    private int acceleration;
    private int countryOfOrigin;
    private int cylinders;

    public Car(int id, int mpg, int engSize, int horsePwr, int weight, int acceleration, int countryOfOrigin, int cylinders){
        this.id = id;
        this.mpg = mpg;
        this.engSize = engSize;
        this.horsePwr = horsePwr;
        this.weight = weight;
        this.acceleration = acceleration;
        this.countryOfOrigin = countryOfOrigin;
        this.cylinders = cylinders;
    }

    public int getID(){
        return id;
    }
    public int getMPG(){
        return mpg;
    }
    public int getEngSize(){
        return engSize;
    }
    public int getHorsePwr(){
        return horsePwr;
    }
    public int getWeight(){
        return weight;
    }
    public int getAcceleration(){
        return acceleration;
    }
    public int getCountryOfOrigin(){
        return countryOfOrigin;
    }
    public int getCylinders(){
        return cylinders;
    }

    @Override
    public int compareTo(Car o) {

        //higher acceleration gets priority
        if(acceleration > o.getAcceleration()){
            return -1;
        }
        else if(acceleration < o.getAcceleration()){
            return 1;
        }

        //accelerations equal
        //higher mpg gets priority
        else if(mpg > o.getMPG()){
            return -1;
        }
        else if(mpg < o.getMPG()){
            return 1;
        }

        //mpgs equal
        //higher horse power gets priority
        else if(horsePwr > o.getHorsePwr()){
            return -1;
        }
        else if(horsePwr < o.getHorsePwr()){
            return 1;
        }

        //horse powers equal
        //bigger engine size gets priority
        else if(engSize > o.getEngSize()){
            return -1;
        }
        else if(engSize < o.getEngSize()){
            return 1;
        }

        //engine sizes equal
        //higher weight gets priority
        else if(weight > o.getWeight()){
            return -1;
        }
        else if(weight < o.getWeight()){
            return 1;
        }

        //weights equal
        //more cylinders gets priority
        else if(cylinders > o.getCylinders()){
            return -1;
        }
        else if(cylinders < o.getCylinders()){
            return 1;
        }

        //cylinders equal
        //lower car id gets priority
        else if(id < o.getID()){
            return -1;
        }
        else if (id > o.getID()){
            return 1;
        }

        //if everything is equal (which will probably never happen)
        return 0;
    }

    public String toString(){

        //acceleration, mpg, horsepwr, engsize, weight, cylinders, id, countryoforigin
        return String.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s", acceleration, mpg, horsePwr, engSize, weight, cylinders, id, countryOfOrigin);
    }
}
