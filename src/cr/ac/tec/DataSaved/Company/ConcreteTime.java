package cr.ac.tec.DataSaved.Company;

public class ConcreteTime implements Comparable {
    private static final int HourMax=24;
    private static final int MinuteMax=60;
    private  int Hour=0;
    private  int Minute=0;
   private ConcreteTime(int Hours,int Minute){
        this.Hour=Hours;
        this.Minute=Minute;
   }
   public static ConcreteTime getConcreteTime(int Hours,int Minutes){
       if(verification(Hours,Minutes)){
           return new ConcreteTime(Hours,Minutes);
       }
       return null;
   }
   private static boolean verification(int Hours,int Minute){
       return Hours<HourMax && Minute<MinuteMax;
   }
   public int getHour(){
       return Hour;
   }
   public int getMinute(){
       return Minute;
   }
    @Override
    public int compareTo(Object o) {
        if(o==null)return 1;
        if(o==this)return 0;
        if(!(o instanceof ConcreteTime))return 1;
        ConcreteTime concreteTime=(ConcreteTime)o;
        if(this.Hour>concreteTime.Hour)return 1;
        if(this.Hour<concreteTime.Hour)return -1;
        if(this.Minute>concreteTime.Minute)return 1;
        if(this.Minute==concreteTime.Minute)return 0;
        return -1;
    }
}
