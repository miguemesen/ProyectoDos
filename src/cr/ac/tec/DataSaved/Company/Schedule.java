package cr.ac.tec.DataSaved.Company;

import java.time.DayOfWeek;
import java.util.ArrayList;
public class Schedule {
    private ArrayList<DayOfWeek>Days;
    private Lapse lapse;
    public Schedule(Builder builder){
        if(builder==null)return;
        builder.build();
        this.Days=builder.Days;
        this.lapse=builder.lapse;
    }
    public static class Builder{
        private ArrayList<DayOfWeek> Days;
        private Lapse lapse;
        {
            Days=new ArrayList<>();
            lapse=new Lapse();
        }
        public Builder AddDays(String...days){
            if(Days==null)return this;
            DayOfWeek temp;
            for(int i=0;i<days.length;i++){
                try {
                    temp=DayOfWeek.valueOf(days[i]);
                    Days.add(temp);
                }
                catch (EnumConstantNotPresentException e){
                }
            }
            return this;
        }
        public Builder setLapse(int IH,int IM,int FH,int FM){
            this.lapse=new Lapse(IH,IM,FH,FM);
            return this;
        }
        public void build(){

        }



    }

}
