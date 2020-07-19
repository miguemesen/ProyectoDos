package cr.ac.tec.Files;

import com.google.gson.Gson;
import cr.ac.tec.DataStructures.Tree.BinaryTree;

public class JsonExchange {
    public static Object getList(String route, Class cl){
        if(route==null)return null;
        String text= PlainText.readFile(route);
        Gson gson=new Gson();
        Object o= gson.fromJson(text, cl);
        return o;
    }


}
