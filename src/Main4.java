import com.google.gson.Gson;
import cr.ac.tec.DataSaved.ClientLogin.User;
import cr.ac.tec.Files.PlainText;

public class Main4 {
    public static void main(String[] args) {
      //  User[] users=(User[])JsonExchange.getList("C:\\Tecnologico de Costa Rica\\Tercer Semestre\\Algoritmos y estructuras\\COOKTIMEProyect\\pruebas.json", Recipe[].class);
      //  for(int i=0;i<users.length;i++){
      //      System.out.println(users[i]);
      //  }
        User user=new User("Mario","1234","Caca","sdaf",22);
        User user1= new User("Ander","rfrf","AJGFGHJ","FSDfsdf",44);
        User[] userA=new User[2];
        Gson gson=new Gson();
        userA[0]=user;
        userA[1]=user1;
        String text=gson.toJson(userA);
       // MyMenu myMenu=new MyMenu(user);
        //text=gson.toJson(myMenu);
       // ProfileUser profile=new ProfileUser();
        PlainText.writeFile("eureka.json",text);


    }
}
