package cr.ac.tec.DataSaved.ClientLogin;


import cr.ac.tec.DataSaved.InAppData.Recipes.Recipe;

import java.util.ArrayList;

public class User implements Comparable {
    private String FirstName;
    private String LastName;
    private String UserName;//Email
    private String password;
    private int age;
    private ArrayList<Recipe> MyMenu;
    private ArrayList<User> follows;
    private ArrayList<User> followers;

    public User(String UserName, String PassWord,String FirstName,String LastName, int age){
        this.password=PassWord;
        this.UserName= UserName;
        this.age=age;
        this.MyMenu=new ArrayList<>();
        this.followers=new ArrayList<>();
        this.follows=new ArrayList<>();
        this.LastName=LastName;
        this.FirstName=FirstName;
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

    public void AddFollower(User user){
        this.followers.add(user);
        user.follows.add(this);
    }
    public void addRecipe(Recipe recipe){
        MyMenu.add(recipe);
    }
    public ArrayList<Recipe> getMyMenu(){
        return this.MyMenu;
    }
    public void setRecipe(ArrayList<Recipe> recipe){
        this.MyMenu=recipe;
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
        User user =(User)o;
        String myString=UserName;
        String theirString= user.UserName;
        return myString.compareTo(theirString);
    }

    @Override
    public String toString() {
        return "User{" +
                "UserName='" + UserName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
