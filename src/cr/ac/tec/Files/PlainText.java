package cr.ac.tec.Files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class PlainText {
    public static String readFile(String route){
        try {
            File file=new File(route);
            FileReader fileReader=new FileReader(file);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String returning="";
            String step;
            while((step=bufferedReader.readLine())!=null){
                returning+=step;
            }
            fileReader.close();
            return returning;
        }
        catch (Exception e){
            return "";
        }
    }
    public static void writeFile(String route, String text){
        if(route==null || text==null)return;
        try {
            FileWriter fileWriter=new FileWriter(route);
            fileWriter.write(text);
            fileWriter.flush();

        }
        catch (Exception e){
            route="";
            System.out.println(e.getMessage());
        }
    }

}
