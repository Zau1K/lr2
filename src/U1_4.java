import java.util.Scanner;

class House {
    private int id;
    private int number_float;
    private int square;
    private int floor;
    private int kol_room;
    private String street;
    private String tip_building;
    private int year;

    public House(){

    }
    public House(int id, int number_float, int square, int floor, int kol_room,
                 String street,String tip_building, int year){
        this.id = id;
        this.number_float = number_float;
        this.square = square;
        this.floor = floor;
        this.kol_room = kol_room;
        this.street = street;
        this.tip_building = tip_building;
        this.year = year;
    }
    public void create() {
        System.out.println("введите id");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            id = sc.nextInt();
        }
        System.out.println("введите номер квартиры ");
        sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            number_float = sc.nextInt();
        }
        System.out.println("введите площадь ");
        sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            square = sc.nextInt();
        }
        System.out.println("введите этаж ");
        sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            floor = sc.nextInt();
        }
        System.out.println("введите количество комнат ");
        sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            kol_room = sc.nextInt();
        }
        System.out.println("введите улицу ");
        sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            street = sc.nextLine();
        }
        System.out.println("введите тип здания  ");
        sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            tip_building = sc.nextLine();
        }
        System.out.println("введите срок эксплуатации ");
        sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            year = sc.nextInt();
        }
    }
    public void show() {
        System.out.println("id = " + id + ", number_float = " + number_float + ", square = " + square + ", floor = " + floor + ", kol_room = " + kol_room +
                ", street =" + street +  ", marks = " + tip_building + ", year = " + year);
    }
    public static House[] createMas(int n) {
        House mas[] = new House[n];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = new House();
            mas[i].create();
        }
        return mas;
    }
    public static void showMas(House[] mas) {
        for (int i = 0; i < mas.length; i++) {
            mas[i].show();
        }
    }
    public static void kolRoom(House[] mas){
        System.out.println("введите количество комнат ");
        Scanner sc = new Scanner(System.in);
        int room = 0;
        if(sc.hasNextInt()){
            room = sc.nextInt();
        }
        for(int i = 0; i < mas.length; i++){
            if(mas[i].kol_room == room){
                mas[i].show();
            }
        }
    }
    public static void listFloat(House[] mas){
        System.out.println("введите число комнат и промежуток этажей ");
        Scanner sc = new Scanner(System.in);
        int _room = 0;
        int lower_floor = 0;
        int high_floor = 0;
        if(sc.hasNextInt()){
            _room = sc.nextInt();
            lower_floor = sc.nextInt();
            high_floor = sc.nextInt();
        }
        for(int i = 0; i < mas.length; i++){
            if(mas[i].kol_room == _room && lower_floor < mas[i].floor && mas[i].floor < high_floor && lower_floor < high_floor){
                mas[i].show();
            }
        }
    }
    public static void Square(House[] mas){
        System.out.println("введите площадь (выведет квартиры площадь которых больше) ");
        Scanner sc = new Scanner(System.in);
        int _square = 0;
        if(sc.hasNextInt()){
            _square = sc.nextInt();
        }
        for(int i = 0; i < mas.length; i++){
            if(mas[i].square > _square){
                mas[i].show();
            }
        }
    }
}
public class U1_4 {
    public static void main(String[] args) {
        House mas[] = House.createMas(3);
        House.showMas(mas);
        House.kolRoom(mas);
        House.listFloat(mas);
        House.Square(mas);
    }
}