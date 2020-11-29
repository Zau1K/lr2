import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.*;

class Uravnenie {
    private double a;
    private double b;
    private double c;

    public Uravnenie(){}

    public Uravnenie(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static double inserta() {
        Scanner sc = new Scanner(System.in);
        double kol=0;
        for(;;) {
            System.out.println("Введите переменную а: ");
            if(sc.hasNext()) {
                if(sc.hasNextDouble()) {
                    kol = sc.nextInt();
                    if(kol<0 || kol>0)break;
                }
                System.out.println("Не квадратное уравнение!");
                sc.nextLine();
            }
            else { System.out.println("Не квадратное уравнение!");}
        }
        return kol;
    }

    public static double insertb() {
        Scanner sc = new Scanner(System.in);
        double kol=0;
        for(;;) {
            System.out.println("Введите переменную b: ");
            if(sc.hasNext()) {
                if(sc.hasNextDouble()) {
                    kol = sc.nextInt();
                    if(kol> (-Double.MAX_VALUE) )break;
                }
                System.out.println("Введено неверное число!");
                sc.nextLine();
            }
            else { System.out.println("Введено неверное число!");}
        }
        return kol;
    }

    public static double insertc() {
        Scanner sc = new Scanner(System.in);
        double kol=0;
        for(;;) {
            System.out.println("Введите переменную c: ");
            if(sc.hasNext()) {
                if(sc.hasNextDouble()) {
                    kol = sc.nextInt();
                    if(kol>(-Double.MAX_VALUE))break;
                }
                System.out.println("Введено неверное число!");
                sc.nextLine();
            }
            else { System.out.println("Введено неверное число!");}
        }
        return kol;
    }

    public static int insertNumUr() {
        Scanner sc = new Scanner(System.in);
        int num;
        for(;;) {
            System.out.println("Введите количество уравнений: ");
            if(sc.hasNext()) {
                if(sc.hasNextInt()) {
                    num = sc.nextInt();
                    if(num>0)break;
                }
                System.out.println("Введено неверное число");
                sc.nextLine();
            }
            else { System.out.println("Введено неверное число");}
        }
        return num;
    }

    public double getDiscriminant() {
        return pow(b, 2) - 4 * a * c;
    }

    public double getroot1() {
        double dis = getDiscriminant();
        double x = 0;
        if (dis > 0) {
            x = (-b + sqrt(dis)) / (2 * a);
        } else if (dis == 0) {
            x = -b / (2 * a);
        }
        else {
            x=Double.NaN;
        }
        return x;
    }
    public double getroot2() {
        double dis = getDiscriminant();
        double x = 0;
        if (dis > 0) {
            x = (-b - sqrt(dis)) / (2 * a);
            return x;
        } else if (dis == 0) {
            x = -b / (2 * a);
        }
        else {
            x=Double.NaN;
        }
        return x;
    }

    public double getExtremum() {
        double x=0;
        x = -b / (2 * a);
        return a*pow(x,2)+b*x+c;
    }

    public double getPointExtremum() {
        return -b / (2 * a);
    }

    public static void showur(Uravnenie obj) {
        System.out.println("Уравнение: "+obj.a+" * x^2 + ("+obj.b+") * x + ("+obj.c+") = 0");
    }

    public static void showrootext(Uravnenie obj) {
        System.out.println("Корень х1: "+obj.getroot1()+" Корень х2: "+obj.getroot2()+" Экстремумы: "+obj.getExtremum());
    }
    public static void showintervals(Uravnenie obj) {
        System.out.print("Интервал возрастания = ");
        System.out.println(Arrays.toString(obj.getDecreasingInterval()));
        System.out.print("Интервал убывания = ");
        System.out.println(Arrays.toString(obj.getIncreasingInterval()));
    }

    public double[] getDecreasingInterval() {
        double[] interval = new double[2];
        if (a > 0) {
            interval[0] = Double.NEGATIVE_INFINITY;
            interval[1] = getPointExtremum();
        } else {
            interval[0] = getPointExtremum();
            interval[1] = Double.POSITIVE_INFINITY;
        }
        return interval;
    }
    public double[] getIncreasingInterval() {
        double[] interval = new double[2];
        if (a > 0) {
            interval[0] = getPointExtremum();
            interval[1] = Double.POSITIVE_INFINITY;
        } else {
            interval[0] = Double.NEGATIVE_INFINITY;
            interval[1] = getPointExtremum();
        }
        return interval;
    }

    public static void maxRoot(Uravnenie[] ur){
        double max1=0, max2=0;
        int k=0, l=0;
        max1=ur[0].getroot1();
        for (int j=0; j<ur.length; j++) {
            if (max1 < ur[j].getroot1()) {
                max1 = ur[j].getroot1();
                k=j;
            }
        }
        max2=ur[0].getroot2();
        for (int j=0; j<ur.length; j++) {
            if (max2 < ur[j].getroot2()) {
                max2 = ur[j].getroot2();
                l=j;
            }
        }
        if(ur[k].getroot1()>=ur[l].getroot2()) {
            System.out.println("Максимальный корень: "+ur[k].getroot1());
        }else {
            System.out.println("Максимальный корень: "+ur[l].getroot2());
        }
    }
    public static void minRoot(Uravnenie[] ur){
        double min1=0, min2=0;
        int k=0, l=0;
        min1=ur[0].getroot1();
        for (int j=0; j<ur.length; j++) {
            if (min1 > ur[j].getroot1()) {
                min1 = ur[j].getroot1();
                k=j;
            }
        }
        min2=ur[0].getroot2();
        for (int j=0; j<ur.length; j++) {
            if (min2 > ur[j].getroot2()) {
                min2 = ur[j].getroot2();
                l=j;
            }
        }
        if(ur[k].getroot1()<=ur[l].getroot2()) {
            System.out.println("Минимальный корень: "+ur[k].getroot1());
        }else {
            System.out.println("Минимальный корень: "+ur[l].getroot2());
        }
    }
}
public class U8 {
    public static void main(String[] args) {
        Uravnenie ur1 = new Uravnenie(Uravnenie.inserta(), Uravnenie.insertb(), Uravnenie.insertc());
        Uravnenie.showintervals(ur1);
        Uravnenie.showrootext(ur1);
        Uravnenie.showur(ur1);
        int i=0;
        //создание массива объектов
        int n=Uravnenie.insertNumUr();
        Uravnenie[] ur = new Uravnenie[n];
        for(;;){
            System.out.println("Введите данные уравнения № "+(i+1));
            double a=Uravnenie.inserta();
            double b=Uravnenie.insertb();
            double c=Uravnenie.insertc();
            ur[i] = new Uravnenie(a,b,c);
            if(i>=n-1)break;
            i++;
        }
        //вывод списка уравнений
        for(Uravnenie x : ur){
            Uravnenie.showur(x);
            Uravnenie.showrootext(x);
            Uravnenie.showintervals(x);

        }
        //max min корень
        Uravnenie.maxRoot(ur);
        Uravnenie.minRoot(ur);
    }
}