import java.util.Scanner;

class Fraction {
    private int m; //числитель
    private int n; // знаменатель

    public Fraction() {
    }

    public Fraction(int m, int n) {
        this.m = m;
        this.n = n;
    }
    public int getM() {
        return m;
    }
    public void setM(int m) {
        this.m = m;
    }
    public int getN() {
        return n;
    }
    public void setN(int n) {
        this.n = n;
    }
    public static int insertM() {
        Scanner sc = new Scanner(System.in);
        int kol=0;
        for(;;) {
            System.out.println("Введите числитель дроби: ");
            if(sc.hasNext()) {
                if(sc.hasNextInt()) {
                    kol = sc.nextInt();
                    if(kol>Integer.MIN_VALUE)break;
                }
                System.out.println("Введено неверное число");
                sc.nextLine();
            }
            else { System.out.println("Введено неверное число");}
        }
        return kol;
    }
    public static int insertN() {

        Scanner sc = new Scanner(System.in);
        int kol=0;
        for(;;) {
            System.out.println("Введите знаменатель дроби: ");
            if(sc.hasNext()) {
                if(sc.hasNextInt()) {
                    kol = sc.nextInt();
                    if(kol>Integer.MIN_VALUE && kol!=0)break;
                }
                System.out.println("Введено неверное число");
                sc.nextLine();
            }
            else { System.out.println("Введено неверное число");}
        }
        return kol;
    }

    public static int insertNumDrobi() {
        Scanner sc = new Scanner(System.in);
        int num;
        for(;;) {
            System.out.println("Введите количество дробей: ");
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

    public void create() {
        System.out.println("Введите числитель ");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt())
            m = sc.nextInt();
        System.out.println("Введите знаменатель ");
        if (sc.hasNextInt())
            n = sc.nextInt();
    }

    public void show() {
        System.out.print("" + m + "/" + n + " ");
    }

    public static Fraction[] createMas(int k) {
        Fraction mas[] = new Fraction[k];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = new Fraction();
            mas[i].create();
        }
        return mas;
    }

    public static void showMas(Fraction[] mas) {
        for (int i = 0; i < mas.length; i++) {
            mas[i].show();
        }
    }

    public static void sum(Fraction obj1, Fraction obj2){
        System.out.print("Сумма дробей: ");
        Fraction dr = new Fraction();

        if (abs(obj1.getN()) == abs(obj2.getN())) {
            dr.m = abs(obj1.getM()) + abs(obj2.getM());
            dr.n = abs(obj1.getN());
            System.out.print((dr.m) + " / " + dr.n);
        }
        else {
            dr.m = abs(obj1.getM()) * abs(obj2.getN()) + abs(obj2.getM())*abs(obj1.getN());
            dr.n = abs(obj1.getN()) * abs(obj2.getN());
            System.out.print((dr.m) + " / " + dr.n);
        }
        sokr(dr);
    }

    public static void minus(Fraction obj1, Fraction obj2){
        System.out.print("Разность дробей: ");
        Fraction dr = new Fraction();
        if (abs(obj1.getN()) == abs(obj2.getN())) {
            dr.m = abs(obj1.getM()) - abs(obj2.getM());
            dr.n = abs(obj1.getN());
            System.out.print((dr.m) + " / " + dr.n);
        }
        else {
            dr.m = abs(obj1.getM()) * abs(obj2.getN()) - abs(obj2.getM()) * abs(obj1.getN());
            dr.n = abs(obj1.getN()) * abs(obj2.getN());
            System.out.print((dr.m) + " / " + dr.n);
        }
        sokr(dr);
    }

    public static void multiply(Fraction obj1, Fraction obj2){
        System.out.print("Произведение дробей: ");
        Fraction dr = new Fraction();
        dr.m = abs(obj1.getM()) * abs(obj2.getM());
        dr.n = abs(obj1.getN()) * abs(obj2.getN());
        System.out.print((dr.m) + " / " + dr.n);
        sokr(dr);
    }

    public static void dilive(Fraction obj1, Fraction obj2){
        System.out.print("Деление дробей: ");
        Fraction dr = new Fraction();
        dr.m = abs(obj1.getM()) * abs(obj2.getN());
        dr.n = abs(obj1.getN()) * abs(obj2.getM());
        System.out.print((dr.m) + " / " + dr.n);
        sokr(dr);
    }

    public static void sokr(Fraction obj1){
        int nod;
        nod=gcd(abs(obj1.getM()), abs(obj1.getN()));
        System.out.print(" Сокращенная дробь: ");
        if (obj1.getM() < 0 || obj1.getN() < 0) {
            System.out.print((-1*(abs(obj1.getM())/nod)) + " / " + abs((obj1.getN()/nod)));
            if (obj1.getM() < 0 && obj1.getN() < 0) {
                System.out.print(((abs(obj1.getM())/nod)) + " / " + abs((obj1.getN()/nod)));
            }
        }
        else System.out.print(((abs(obj1.getM())/nod)) + " / " + abs((obj1.getN()/nod)));
        System.out.println();
    }
    public static void Izmenenie(Fraction[] dr){
        for (int j=0; j<dr.length-1; j++) {
            if (j % 2 == 0) {
                if (abs(dr[j].getN()) == abs(dr[j+1].getN())) {
                    dr[j].m = abs(dr[j].getM()) + abs(dr[j+1].getM());
                    dr[j].n = abs(dr[j].getN());
                }
                else {
                    dr[j].m = (abs(dr[j].getM())*abs(dr[j+1].getN()) + abs(dr[j+1].getM())*abs(dr[j].getN()));
                    dr[j].n = abs(dr[j].getN()) * abs(dr[j+1].getN());
                }
            }
        }
        System.out.println();
        System.out.println("Измененный массив объектов: ");
    }

    private static int abs(int n2) {
        int k=0;
        if (n2>0)k=n2;
        else k=n2*(-1);
        return k;
    }
    private static int gcd(int a, int b) {
        if (b == 0) return a;
        int x = a % b;
        return gcd(b, x);
    }
}

public class U5 {
    public static void main(String[] args) {
        Fraction dr1 = new Fraction();
        Fraction dr2 = new Fraction();
        dr1.create();
        dr2.create();
        Fraction.sum(dr1, dr2);
        Fraction.minus(dr1, dr2);
        Fraction.multiply(dr1, dr2);
        Fraction.dilive(dr1, dr2);
        int i=0;
        //создание массива объектов
        int n = Fraction.insertNumDrobi();
        Fraction[] dr = new Fraction[n];
        for(;;){
            System.out.println("Введите дробь № "+(i+1));
            int chisl = Fraction.insertM();
            int znam = Fraction.insertN();
            dr[i] = new Fraction(chisl,znam);
            if(i>=n-1)break;
            i++;
        }

        for(Fraction x : dr){
            x.show();
        }

        Fraction.Izmenenie(dr);
        for(Fraction x : dr){
            x.show();
        }
    }
}
