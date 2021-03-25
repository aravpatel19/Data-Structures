import javax.swing.*;
import java.awt.font.NumericShaper;
import java.util.Locale;

public class Citizen implements Comparable<Citizen>{

    private String first;
    private String last;
    private String street;
    private int streetNumber;
    private String relation;
    private String ro;          //rent or own
    private double value;
    private String gender;
    private double age;
    private String maritalStatus;
    private int ageFM;          //age of first marriage
    private boolean attendSchool;
    private boolean canRead;
    private String birthplace;
    private String fatherBP;    //father's birthplace
    private String motherBP;    //mother's birthplace
    private String tongue;      //mother tongue
    private int yearImmigrated;
    private String occupation;
    private String industry;
    private String remarks;

    public Citizen(String first, String last, String street, String streetNumber, String relation, String ro, String value,
                   String gender, String age, String maritalStatus, String ageFM, String attendSchool, String canRead,
                   String birthplace, String fatherBP, String motherBP, String tongue, String yearImmigrated,
                   String occupation, String industry, String remarks){

        this.first = first;
        this.last = last;
        this.street = street;
        try {
            this.streetNumber = Integer.parseInt(streetNumber);
        }catch(NumberFormatException e){
            this.streetNumber = -1;
        }
        this.relation = relation;
        this.ro = ro.substring(0,1);
        if(value.charAt(0) == '$'){
            value = value.substring(1);
        }
        try{
            this.value = Double.parseDouble(value);
        }catch(NumberFormatException e){
            if(value.contains("/")){
                String whole = value.substring(0, value.indexOf(" "));
                String n = value.substring(value.indexOf(" ")+1, value.indexOf("/"));
                String d = value.substring(value.indexOf("/")+1);
                this.value = Double.parseDouble(whole) + (Double.parseDouble(n)/Double.parseDouble(d));
            }
        }
        this.gender = gender;
        try {
            this.age = Double.parseDouble(age);
        }catch(NumberFormatException e){
            if(age.charAt(0)=='.' || age.equals("un")){
                this.age = -1;
            }
            else if(age.charAt(1) == ' ' && age.contains("/")){
                String whole = age.substring(0, 1);
                double dec;
                if(age.substring(age.indexOf(" ")+1, age.indexOf("/")).contains("*")){
                    dec = 0.5;
                }
                else{
                    String n = age.substring(age.indexOf(" ")+1, age.indexOf("/"));
                    String d = age.substring(age.indexOf("/")+1);
                    dec = Double.parseDouble(n)/Double.parseDouble(d);
                }
                this.age = Double.parseDouble(whole) + dec;
            }
            else if(age.contains("*")){
                this.age = Double.parseDouble(age.substring(0, age.indexOf("*")));
            }
            else{
                String n = age.substring(0, age.indexOf("/"));
                String d = age.substring(age.indexOf("/")+1);
                this.age = Double.parseDouble(n)/Double.parseDouble(d);
            }
        }
        this.maritalStatus = maritalStatus;
        try {
            this.ageFM = Integer.parseInt(ageFM);
        }catch (NumberFormatException e){
            this.ageFM = -1;
        }
        this.attendSchool = false;
        if(attendSchool.equals("Yes")){
            this.attendSchool = true;
        }
        this.canRead = false;
        if(canRead.equals("Yes")){
            this.canRead = true;
        }

        this.birthplace = birthplace;
        this.fatherBP = fatherBP;
        this.motherBP = motherBP;
        this.tongue = tongue;
        try {
            this.yearImmigrated = Integer.parseInt(yearImmigrated);
        }catch (NumberFormatException e){
            this.yearImmigrated = -1;
        }
        this.occupation = occupation.substring(0,1).toUpperCase() + occupation.substring(1).toLowerCase();
        this.industry = industry;
        this.remarks = remarks;

    }

    public String getFirst(){
        return first;
    }
    public String getLast(){
        return last;
    }
    public String getStreet(){
        return street;
    }
    public int getStreetNumber(){
        return streetNumber;
    }
    public String getRelation(){
        return relation;
    }
    public String getRO(){
        return ro;
    }
    public double getPropValue(){
        return value;
    }
    public String getGender(){
        return gender;
    }
    public double getAge(){
        return age;
    }
    public String getMaritalStatus(){
        return maritalStatus;
    }
    public int getAgeFM(){
        return ageFM;
    }
    public boolean isAttendSchool(){
        return attendSchool;
    }
    public boolean isCanRead(){
        return canRead;
    }
    public String getBirthplace(){
        return birthplace;
    }
    public String getFatherBP(){
        return fatherBP;
    }
    public String getMotherBP(){
        return motherBP;
    }
    public String getTongue(){
        return tongue;
    }
    public int getYearImmigrated(){
        return yearImmigrated;
    }
    public String getOccupation(){
        return occupation;
    }
    public String getIndustry(){
        return industry;
    }
    public String getRemarks(){
        return remarks;
    }

    @Override
    public int compareTo(Citizen o) {

        if(getFirst().compareTo(o.getFirst()) < 0){
            return -1;
        }
        if(getFirst().compareTo(o.getFirst()) > 0){
            return 1;
        }
        if(getLast().compareTo(o.getLast()) < 0){
            return -1;
        }
        if(getLast().compareTo(o.getLast()) > 0){
            return 1;
        }
        if(getStreet().compareTo(o.getStreet()) < 0){
            return -1;
        }
        if(getStreet().compareTo(o.getStreet()) > 0){
            return 1;
        }

        if(getStreetNumber() < o.getStreetNumber()){
            return -1;
        }
        if(getStreetNumber() > o.getStreetNumber()){
            return 1;
        }

        if(getRelation().compareTo(o.getRelation()) < 0){
            return -1;
        }
        if(getRelation().compareTo(o.getRelation()) > 0){
            return 1;
        }
        if(getRO().compareTo(o.getRO()) < 0){
            return -1;
        }
        if(getRO().compareTo(o.getRO()) > 0){
            return 1;
        }

        if(getPropValue() < o.getPropValue()){
            return -1;
        }
        if(getPropValue() > o.getPropValue()){
            return 1;
        }
        if(getGender().compareTo(o.getGender()) < 0){
            return -1;
        }
        if(getGender().compareTo(o.getGender()) > 0){
            return 1;
        }
        if(getAge() < o.getAge()){
            return -1;
        }
        if(getAge() > o.getAge()){
            return 1;
        }
        if(getMaritalStatus().compareTo(o.getMaritalStatus()) < 0){
            return -1;
        }
        if(getMaritalStatus().compareTo(o.getMaritalStatus()) > 0){
            return 1;
        }
        if(getAgeFM() < o.getAgeFM()){
            return -1;
        }
        if(getAgeFM() > o.getAgeFM()){
            return 1;
        }
        if(isAttendSchool()){
            return -1;
        }
        if(!isAttendSchool()){
            return 1;
        }

        return 0;
    }

    public String toString(){
        return String.format("%-25sAge: %s", last + ", "+first, age);
    }
}
