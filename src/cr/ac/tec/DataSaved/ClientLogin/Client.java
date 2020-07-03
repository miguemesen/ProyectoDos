package cr.ac.tec.DataSaved.ClientLogin;


public class Client implements Comparable {
    private String password;
    private String UserName;

    public Client(String UserName, String PassWord){
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
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return getPassword().equals(client.getPassword()) &&
                getUserName().equals(client.getUserName());
    }

    @Override
    public int compareTo(Object o) {
        if(o==this)return 0;
        if(o==null)return 1;
        if(o.getClass()!=this.getClass())return 1;
        Client client =(Client)o;
        String myString=UserName;
        String theirString= client.UserName;
        return myString.compareTo(theirString);
    }

}
