package cr.ac.tec.DataSaved.Chef;


import com.google.gson.annotations.Expose;
import cr.ac.tec.DataSaved.ClientLogin.User;
import cr.ac.tec.DataSaved.InfoTree.ChefTree;
import cr.ac.tec.DataSaved.InfoTree.UserTree;

import java.util.ArrayList;

public class ApplyRequest {
    @Expose(serialize = false,deserialize = false)
    private static ApplyRequest instance;
    private ArrayList<User> applicants;

    private ApplyRequest(){
        applicants=new ArrayList<>();
    }

    public  synchronized static ApplyRequest getInstance() {
        if(instance==null){
            instance=new ApplyRequest();
        }
        return instance;
    }
    public void addRequest(User user){
        if(user==null)return;
        UserTree userTree=UserTree.getInstance();
        user=userTree.getMember(user);
        applicants.add(user);
    }
    public void turnDownRequest(User user){
        if(user==null)return;
        if(!applicants.contains(user))return;
        applicants.remove(user);
    }
    public void AcceptRequest(User user){
        if(user==null)return;
        if(!applicants.contains(user))return;
        int index=applicants.indexOf(user);
        user=applicants.get(index);
        UserTree userTree=UserTree.getInstance();
        userTree.detach(user);
        Chef chef=Chef.getChef(user);
        ChefTree chefTree=ChefTree.getInstance();
        chefTree.attach(chef);
    }

}
