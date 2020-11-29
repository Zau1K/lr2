import java.util.Scanner;

class Circle {
    public double radius;
    public double kor_x;
    public double kor_y;
    public Circle(){

    }
    public Circle(int r){
        this.radius = r;
    }
    public Circle(int x, int y){
        this.kor_x = x;
        this.kor_y = y;
    }
    public Circle(int r, int x, int y){
        this.radius = r;
        this.kor_x = x;
        this.kor_y = y;
    }
    public void setKor_x(){
        System.out.println("Введите координату y ");
        Scanner sc = new Scanner(System.in);
        if(sc.hasNextInt())
            kor_x = sc.nextInt();
    }
    public void setKor_y(){
        System.out.println("Введите кординату x ");
        Scanner sc = new Scanner(System.in);
        if(sc.hasNextInt())
            kor_y = sc.nextInt();
    }
    public void setRadius(){
        System.out.println("Введите радиус круга r");
        Scanner sc = new Scanner(System.in);
        if(sc.hasNextDouble())
            radius = sc.nextDouble();

    }
    public double plus_X(){
        System.out.println("Введите значение для увеличения кординаты x");
        Scanner sc = new Scanner(System.in);
        if(sc.hasNextDouble()) {
            double plus_x = sc.nextDouble();
            this.kor_x = this.kor_x + plus_x;
        }
        return kor_y;
    }
    public double plus_Y(){
        System.out.println("Введите значение для увеличения кординаты y");
        Scanner sc = new Scanner(System.in);
        if(sc.hasNextDouble()) {
            double plus_y = sc.nextDouble();
            this.kor_y = this.kor_y + plus_y;
        }
        return kor_y;
    }
    public double plus_R(){
        System.out.println("Введите значение для увеличения радиуса r ");
        Scanner sc = new Scanner(System.in);
        if(sc.hasNextDouble()) {
            double plus_r = sc.nextDouble();
            this.radius = this.radius + plus_r;
        }
        return radius;
    }

    public double squareCircle(){
        double square = (Math.PI) * Math.pow(radius, 2);
        return square;

    }
    public double lengthCircle(){
        double length = 2 * Math.PI * radius;
        return length;
    }
    public void ShowParamentr(){
        System.out.println("Параметры круга");
        System.out.println(kor_x);
        System.out.println(kor_y);
        System.out.println(radius);
    }
}

public class U2 {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.setKor_x();
        circle.setKor_y();
        circle.setRadius();
        circle.ShowParamentr();
        System.out.println("Площадь круга " + circle.squareCircle());
        System.out.println("Длина круга " + circle.lengthCircle());
        circle.plus_X();
        circle.plus_Y();
        circle.plus_R();
        circle.ShowParamentr();
        System.out.println("Площадь круга " + circle.squareCircle());
        System.out.println("Длина круга " + circle.lengthCircle());
    }
}
