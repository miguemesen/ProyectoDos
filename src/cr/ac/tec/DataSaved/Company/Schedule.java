package cr.ac.tec.DataSaved.Company;

import java.time.DayOfWeek;
import java.util.ArrayList;

public class Schedule {
    private ArrayList<DayOfWeek>Days;
    private double InitTime;
    private double FinalTime;
    public Schedule(Builder builder){
        if(builder==null)return;
        builder.build();
        this.Days=builder.Days;
    }

    public static class Builder{
        private ArrayList<DayOfWeek> Days;
        private double InitTime;
        private double FinalTime;
        {
            Days=new ArrayList<>();
            InitTime=8.0;
            FinalTime=17.30;
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
        public Builder Init(double Init){
            if(Init>=0 ^ Init<24){
                InitTime=Init;
            }
            return this;
        }
        public Builder End(double End){
            if(End>=0 && End<24){
                this.FinalTime=End;
            }
            return this;
        }
        public void build(){
            if(InitTime>FinalTime){
                double temp=InitTime;
                InitTime=FinalTime;
                FinalTime=temp;
            }
        }


    }

}
