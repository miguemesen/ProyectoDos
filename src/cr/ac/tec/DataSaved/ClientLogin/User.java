package cr.ac.tec.DataSaved.ClientLogin;


import cr.ac.tec.DataSaved.InAppData.Recipes.MyMenu.MyMenu;
import cr.ac.tec.DataSaved.InAppData.Recipes.Recipe;
import cr.ac.tec.DataSaved.Interfaces.RecipeOwners;
import java.util.ArrayList;

public class User extends RecipeOwners {
    private String FirstName;
    private String LastName;
    private String UserName;//Email
    private String password;
    private int age;
    private ArrayList<User> follows;
    private ArrayList<User> followers;

    public User(String UserName, String PassWord,String FirstName,String LastName, int age){
        this.password=PassWord;
        this.UserName= UserName;
        this.age=age;
        this.followers=new ArrayList<>();
        this.follows=new ArrayList<>();
        this.LastName=LastName;
        this.FirstName=FirstName;
       this.myMenu=new MyMenu(this);
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

    public String getFirstName() {
        return FirstName;
    }
    public void setRecipe(ArrayList<Recipe> array){

    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void AddFollower(User user){
        if(user==null)return;
        this.followers.add(user);
        user.follows.add(this);
    }
    public void AddFollows(User user){
        if(user==null)return;
        this.follows.add(user);
        user.followers.add(user);
    }
    public void addRecipe(Recipe recipe){
        myMenu.add(recipe);
    }
    public MyMenu getMyMenu(){
        return this.myMenu;
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

    @Override
    public ArrayList<User> getOwner() {
        ArrayList<User> member=new ArrayList<>();
        member.add(this);
        return member;
    }
}
