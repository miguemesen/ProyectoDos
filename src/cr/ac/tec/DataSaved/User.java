package cr.ac.tec.DataSaved;



import java.util.Objects;

public class User implements Comparable {
    private String password;
    private String UserName;

    public User(String UserName,String PassWord){
        this.password=PassWord;
        this.UserName= UserName;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return UserName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getPassword().equals(user.getPassword()) &&
                getUserName().equals(user.getUserName());
    }

    @Override
    public int compareTo(Object o) {
        if(o==this)return 0;
        if(o==null)return 1;
        if(o.getClass()!=this.getClass())return 1;
        User user=(User)o;
        String myString=UserName;
        String anotherString=user.UserName;
        if(myString.compareTo(anotherString)==0)return 0;
        if(myString.compareTo(anotherString)>0)return 1;
        return -1;


    }
}
