package cr.ac.tec.Files;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import cr.ac.tec.DataStructures.Tree.BinaryTree;

public class JsonExchange {
    private static  Gson gson=new Gson();
    private static JsonParser parser=new JsonParser();
    public static Object getObjectFromJson(String route, Class cl){
        try {
            if (route == null) return null;
            String text = PlainText.readFile(route);
            parser.parse(text);
            Object o = gson.fromJson(text, cl);
            return o;
        }
        catch (Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }
    public static void toJsonFromObject(String route, Object object){
        try {
           String text= gson.toJson(object);
            System.out.println(text);
            PlainText.writeFile(route,text);
        }
        catch (Exception e){

        }

    }
    public static String getStringFromObject(Object object){
        try {
            return gson.toJson(object);
        }
        catch (Exception e){return "";}
    }



}
