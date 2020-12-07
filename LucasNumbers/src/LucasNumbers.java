import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;

public class LucasNumbers {

    public LucasNumbers(File file){

        try {
            BufferedReader input = new BufferedReader(new FileReader(file));
            String text;

            while( (text=input.readLine()) != null){

                System.out.println(returnValue(Integer.parseInt(text)));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BigInteger returnValue(int x){

        //BigInteger b = BigInteger.valueOf(12);
        //System.out.println(b.compareTo(BigInteger.valueOf(20)));
        ArrayList<BigInteger> list = new ArrayList<>();
        list.add(BigInteger.TWO);
        list.add(BigInteger.ONE);

        for(BigInteger i= BigInteger.ZERO ; i.compareTo(BigInteger.valueOf(x)) < 1 ; i=i.add(BigInteger.ONE)){

            BigInteger a = list.get(i.intValue());
            a = a.add(list.get(i.add(BigInteger.ONE).intValue()));
            list.add(a);

        }

        return list.get(x);
    }

    public static void main(String[]args){
        LucasNumbers app = new LucasNumbers(new File("/Users/aravpatel/IntellijProjects/LucasNumbers/src/LucasNumFile.txt"));
    }
}
