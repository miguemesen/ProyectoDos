package cr.ac.tec.DataSaved.Chef;

import cr.ac.tec.DataSaved.ClientLogin.User;
import cr.ac.tec.DataSaved.InfoTree.UserTree;

public class Chef extends User {
    private double grade;
    private int reactionsNumber;

    private Chef(User user){
        super(user.getUserName(),user.getPassword(),user.getFirstName(),user.getLastName(),user.getAge());
        UserKind="Chef";
        grade=0;
        reactionsNumber=0;
    }
    public synchronized static Chef getChef(User user){
        if(user==null)return null;
        UserTree userTree=UserTree.getInstance();
        if(!userTree.IsMember(user))return null;
        return new Chef(user);
    }


    @Override
    public boolean equals(Object o) {
      if(o==null)return false;
      if(!(o instanceof User))return false;
      User user=(User) o;
      return user.equals(this);
    }


}
