package cr.ac.tec.DataSaved.Chef;

import cr.ac.tec.DataSaved.ClientLogin.User;
import cr.ac.tec.DataSaved.ClientLogin.UserTree;

public class Chef extends User {
    private int grade;
    private int reactionsNumber;

    private Chef(User user){
        super(user.getUserName(),user.getPassword(),user.getFirstName(),user.getLastName(),user.getAge());
    }
    public static Chef getChef(User user){
        if(user==null)return null;
        UserTree userTree=UserTree.getInstance();
        if(!userTree.IsMember(user))return null;
        return new Chef(user);
    }


}
