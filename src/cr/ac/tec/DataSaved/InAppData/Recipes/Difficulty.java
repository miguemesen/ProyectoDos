package cr.ac.tec.DataSaved.InAppData.Recipes;

public class Difficulty {
    private int grade=0;
    public Difficulty(int number){
        setGrade(number);
    }

    public void setGrade(int number) {
        if(number<0 ||number>100)return;
        grade=number;
    }
    public int getGrade(){
        return grade;
    }

    @Override
    public String toString() {
        return "Difficulty "+grade;
    }
}
