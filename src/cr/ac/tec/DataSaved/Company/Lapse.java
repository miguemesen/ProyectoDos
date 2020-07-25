package cr.ac.tec.DataSaved.Company;
public class Lapse {
    private ConcreteTime init;
    private ConcreteTime Finish;
    public Lapse(int InitHour,int InitMinute,int FinishHour,int FinishMinute){
        init=ConcreteTime.getConcreteTime(InitHour,InitMinute);
        Finish=ConcreteTime.getConcreteTime(FinishHour,FinishMinute);
        Switch();
    }
    public Lapse(){}
    private void Switch(){
        if(init.compareTo(Finish)>1){
            ConcreteTime temp=init;
            init=Finish;
            Finish=temp;
        }
    }

}
