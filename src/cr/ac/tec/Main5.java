package cr.ac.tec;

import cr.ac.tec.Random.Random;

public class Main5 {
    public static void main(String[] args) {

        String s="Celiac%Perro";
        String[] a=s.split("%");
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}
