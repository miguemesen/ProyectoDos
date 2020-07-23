package cr.ac.tec.DataSaved.InfoTree;

import cr.ac.tec.DataSaved.Chef.Chef;
import cr.ac.tec.DataSaved.ClientLogin.User;

public class TreeConsultant {
    private static UserTree userTree;
    private static ChefTree chefTree;
    private static CompanyTree companyTree;
    private static RecipeTree recipeTree;

    public static void initializer(){
        if(userTree==null)userTree=UserTree.getInstance();
        if(chefTree==null)chefTree=ChefTree.getInstance();
        if(companyTree==null)companyTree=CompanyTree.getInstance();
        if(recipeTree==null)recipeTree=RecipeTree.getInstance();
    }
    public static String getUser(String UserName, String Password){
        if(UserName==null || Password==null || UserName.length()<=0 || Password.length()<=0)return "";
        initializer();
        User user= new User(UserName,Password);//
        if(userTree.fullCheck(user) || chefTree.fullCheck(Chef.getChef(user))){
            return UserName;
        }
        return "";

    }



}
