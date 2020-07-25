package cr.ac.tec.DataSaved.InAppData.Recipes;

import cr.ac.tec.DataStructures.LinkedList.Sorting.Numerable;

public class Difficulty implements Numerable<Difficulty> {
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

    @Override
    public int compareTo(Object o) {
        if(o==null)return 1;
        if(o.getClass()!=this.getClass())return 1;
       Difficulty difficulty=(Difficulty) o;
       if(grade==difficulty.grade)return 0;
       if(grade>difficulty.grade)return 1;
       return -1;

    }

    @Override
    public int getNumber() {
        return grade;
    }

    @Override
    public Difficulty[] getArray(int len) {
        return new Difficulty[len];
    }

}
