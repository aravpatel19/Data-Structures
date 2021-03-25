import com.sun.source.tree.Tree;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;

public class FedCensus {

    ArrayList<Citizen> citizens;
    public FedCensus(){

        // key = street name        value = TreeSet of Citizens
        citizens = new ArrayList<>();
        File file = new File("/Users/aravpatel/IntellijProjects/FedCensus/src/FedCensus1930_CambriaCountyPA.txt");

        try {
            BufferedReader input = new BufferedReader(new FileReader(file));
            String text;

            while((text=input.readLine()) != null){
                if(text.length() > 2 && text.substring(0,2).equals("17")){

                    String first = text.substring(71, 88).trim();
                    String last = text.substring(55, 71).trim();
                    String street = text.substring(20, 36).trim();
                    String streetNumber = text.substring(36, 45).trim();
                    String relation = text.substring(88, 108).trim();
                    String ro = text.substring(108, 113).trim();
                    String value = text.substring(113, 121).trim();
                    String gender = text.substring(133, 138).trim();
                    String age = text.substring(143, 151).trim();
                    String maritalStatus = text.substring(151, 156).trim();
                    String ageFM = text.substring(156, 162).trim();
                    String attendSchool = text.substring(162, 167).trim();
                    String canRead = text.substring(167, 173).trim();
                    String birthplace = text.substring(173, 190).trim();
                    String fatherBP = text.substring(190, 207).trim();
                    String motherBP = text.substring(207, 224).trim();
                    String tongue = text.substring(224, 235).trim();
                    String yearImmigrated = text.substring(235, 241).trim();
                    String occupation = text.substring(252, 274).trim();
                    String industry = text.substring(274, 303).trim();
                    String remarks = text.substring(342).trim();

                    if(!(last.equals(".") && first.equals("."))){
                        citizens.add(new Citizen(first, last, street, streetNumber, relation, ro, value, gender,
                                age, maritalStatus, ageFM, attendSchool, canRead, birthplace, fatherBP,
                                motherBP, tongue, yearImmigrated, occupation, industry, remarks));
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(citizens);

        /*
        for(Citizen c : citizens) {
            System.out.println(c);
        }
        */

        streetMap();
        breakLine();
        birthMap();
        breakLine();
        tongueMap();
        breakLine();
        occupationMap();
        breakLine();
        genderMap();
        breakLine();
        rentOrOwnMap();

        //Extra will be a TreeMap (using canRead as key) with a HashSet of Birthplaces

        breakLine();
        canReadMap();

    }

    public void breakLine(){
        System.out.println("***************************************************************************");
    }

    public void streetMap(){
        System.out.println("Citizens organized by Street\n");

        TreeMap<String, TreeSet<Citizen>> map = new TreeMap<>();

        for(Citizen c : citizens){
            if(!map.containsKey(c.getStreet())){
                map.put(c.getStreet(), new TreeSet<Citizen>());
            }
            map.get(c.getStreet()).add(c);
        }
        Iterator<String> it = map.keySet().iterator();
        while(it.hasNext()){
            String street = it.next();
            System.out.println(street + ":");
            TreeSet<Citizen> temp = map.get(street);
            for(Citizen c: temp){
                System.out.println("\t" + c);
            }
        }
    }

    public void birthMap(){
        System.out.println("People's Ages organized by Birthplace\n");

        TreeMap<String, PriorityQueue<Double>> map = new TreeMap<>();

        for(Citizen c : citizens){
            if(!map.containsKey(c.getBirthplace())){
                map.put(c.getBirthplace(), new PriorityQueue<Double>());
            }
            map.get(c.getBirthplace()).add(c.getAge());
        }

        Iterator<String> it = map.keySet().iterator();


        while(it.hasNext()){
            String birthplace = it.next();
            System.out.println(birthplace + ":");
            System.out.print("{ ");
            PriorityQueue<Double> temp = map.get(birthplace);
            if(birthplace.equals("Pennsylvania")){
                System.out.print(temp.size());
            }
            else{
                while(!temp.isEmpty()){
                    double age = temp.poll();
                    if(age>=0){
                        if(temp.peek() != null){
                            System.out.print(age +", ");
                        }
                        else{
                            System.out.print(age);
                        }
                    }
                }
            }
            System.out.println(" }");
        }
    }

    public void tongueMap(){
        System.out.println("People's names organized by Mother Tongue\n");

        TreeMap<String, ArrayList<String>> map = new TreeMap<>();

        for(Citizen c : citizens){
            String name = c.getLast() + ", " + c.getFirst();
            if(!map.containsKey(c.getTongue())){
                map.put(c.getTongue(), new ArrayList<String>());
            }
            map.get(c.getTongue()).add(name);
        }

        Iterator<String> it = map.keySet().iterator();
        while(it.hasNext()){
            String tongue = it.next();
            System.out.println(tongue +":");

            ArrayList<String> temp = map.get(tongue);
            for(String name : temp){
                System.out.println("\t" +name);
            }
        }
    }

    public void occupationMap(){
        System.out.println("Father's Birthplaces organized by Occupation\n");

        TreeMap<String, HashSet<String>> map = new TreeMap<>();

        for(Citizen c : citizens){
            if(!map.containsKey(c.getOccupation())){
                map.put(c.getOccupation(), new HashSet<String>());
            }
            map.get(c.getOccupation()).add(c.getFatherBP());
        }
        Iterator<String> it = map.keySet().iterator();

        while(it.hasNext()){
            String occupation = it.next();
            System.out.println(occupation +":");
            HashSet<String> temp = map.get(occupation);
            Iterator<String> hashIt = temp.iterator();
            while(hashIt.hasNext()){
                String fatherBP = hashIt.next();
                System.out.println("\t" + fatherBP);
            }
        }
    }

    public void genderMap(){
        System.out.println("Remarks organized by Gender\n");

        TreeMap<String, HashSet<String>> map = new TreeMap<>();

        for(Citizen c : citizens){
            if(!map.containsKey(c.getGender())){
                map.put(c.getGender(), new HashSet<String>());
            }
            map.get(c.getGender()).add(c.getRemarks());
        }

        Iterator<String> it = map.keySet().iterator();

        while(it.hasNext()){
            String gender = it.next();
            System.out.println(gender + ":");

            HashSet<String> temp = map.get(gender);
            Iterator<String> hashIt = temp.iterator();
            while(hashIt.hasNext()){
                String remark = hashIt.next();
                System.out.println("\t"+remark);
            }
        }
    }

    public void rentOrOwnMap(){
        System.out.println("Value of Properties organized by Renting or Owning\n");

        TreeMap<String, TreeSet<Double>> map = new TreeMap<>();

        for(Citizen c : citizens){
            if(!map.containsKey(c.getRO())){
                map.put(c.getRO(), new TreeSet<Double>());
            }
            map.get(c.getRO()).add(c.getPropValue());
        }

        Iterator<String> it = map.keySet().iterator();

        while(it.hasNext()) {
            String rentOrOwn = it.next();
            System.out.println(rentOrOwn + ":");
            TreeSet<Double> temp = map.get(rentOrOwn);
            Iterator<Double> treeIt = temp.iterator();
            while (treeIt.hasNext()) {
                double value = treeIt.next();
                System.out.println("\t" + value);
            }
        }
    }

    //TreeMap (using canRead as key) with a HashSet of Birthplaces
    //I'm curious to where people who cannot read come from
    public void canReadMap(){
        System.out.println("Birthplaces of people who can and cannot read\n");

        TreeMap<Boolean, HashSet<String>> map = new TreeMap<>();

        for(Citizen c : citizens){
            if(!map.containsKey(c.isCanRead())){
                map.put(c.isCanRead(), new HashSet<String>());
            }
            map.get(c.isCanRead()).add(c.getBirthplace());
        }

        Iterator<Boolean> it = map.keySet().iterator();
        while(it.hasNext()){
            boolean hold = it.next();
            String canRead = "Cannot Read";
            if(hold){
                canRead = "Can Read";
            }
            System.out.println(canRead + ":");
            HashSet<String> temp = map.get(hold);
            Iterator<String> hashIt = temp.iterator();
            while(hashIt.hasNext()){
                String birthplace = hashIt.next();
                System.out.println("\t"+birthplace);
            }
        }
    }

    public static void main(String[]args){
        FedCensus app = new FedCensus();
    }
}
