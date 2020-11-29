import java.util.Scanner;

class Car {
    private int id;
    private String marka;
    private String model;
    private int year;
    private String color;
    private int price;
    private String registration_number;

    public Car(){

    }
    public Car(int id, String marka, String model, int year, String color, int price, String registration_number){
        this.id = id;
        this.marka = marka;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
        this.registration_number = registration_number;

    }
    public void create() {
        System.out.println("введите id");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            id = sc.nextInt();
        }
        System.out.println("введите марку машины ");
        sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            marka = sc.nextLine();
        }
        System.out.println("введите модель машины ");
        sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            model = sc.nextLine();
        }
        System.out.println("введите год выпуска ");
        sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            year = sc.nextInt();
        }
        System.out.println("введите цвет машины ");
        sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            color = sc.nextLine();
        }
        System.out.println("введите цену машины ");
        sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            price = sc.nextInt();
        }
        System.out.println("введите регестрационный номер ");
        sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            registration_number = sc.nextLine();
        }
    }
    public void show() {
        System.out.println("id = " + id + ", marka = " + marka + ", model = " + model + ", year = " + year + ", color = " + color +
                ", price =" + price +  ", marks = " + price + ", registration_number = " + registration_number);
    }
    public static Car[] createMas(int n) {
        Car mas[] = new Car[n];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = new Car();
            mas[i].create();
        }
        return mas;
    }
    public static void showMas(Car[] mas) {
        for (int i = 0; i < mas.length; i++) {
            mas[i].show();
        }
    }
    public static void showMarka(Car[] mas){
        System.out.println("введите марку машины");
        Scanner sc = new Scanner(System.in);
        String _marka = null;
        if(sc.hasNextLine()){
            _marka = sc.nextLine();
        }
        for(int i = 0; i < mas.length; i++){
            if(mas[i].marka.equals(_marka)){
                mas[i].show();
            }
        }
    }
    public static void ageCar(Car[] mas){
        System.out.println("введите года ");
        Scanner sc = new Scanner(System.in);
        String _model = null;
        int _year = 0;
        if(sc.hasNextInt()){
            _year = sc.nextInt();
        }
        if(sc.hasNextLine()){
            _model = sc.nextLine();
        }
        for(int i = 0; i < mas.length; i++){
            if(mas[i].model.equals(_model) && 2019 - mas[i].year > _year){
                mas[i].show();
            }
        }
    }
    public static void priceCar(Car[] mas){
        System.out.println("Вначале введите год выпуска, после введите с какой цены машины");
        Scanner sc = new Scanner(System.in);
        int _year = 0;
        int __price = 0;
        if(sc.hasNextInt()){
            __price = sc.nextInt();
            _year = sc.nextInt();
        }
        for(int i = 0; i < mas.length; i++){
            if(mas[i].year == _year && mas[i].price  >=  __price){
                mas[i].show();
            }
        }
    }
}
public class U1_5 {
    public static void main(String[] args) {
        Car mas[] = Car.createMas(3);
        Car.showMas(mas);
        Car.showMarka(mas);
        Car.ageCar(mas);
        Car.priceCar(mas);
    }
}