package cr.ac.tec.DataSaved.Company;

import javax.ejb.Init;

public class Lapse {
    private ConcreteTime init;
    private ConcreteTime Finish;
    public Lapse(int InitHour,int InitMinute,int FinishHour,int FinishMinute){
        init=ConcreteTime.getConcreteTime(InitHour,InitMinute);
        Finish=ConcreteTime.getConcreteTime(FinishHour,FinishMinute);

    }

}
