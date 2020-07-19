package cr.ac.tec.DataSaved.InAppData.Recipes;

public class Step {
    private String title="";
    private String body="";
    public Step(String title,String body){

    }
    public void setTitle(String title){
        if(title==null)return;
        this.title=title;
    }
    public void setBody(String body){
        if(body==null)return;
        this.body=body;
    }

    @Override
    public String toString() {
        return "Step{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
