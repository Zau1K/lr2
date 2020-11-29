import java.util.Arrays;
import java.util.Scanner;

class Abiturient {
    private int id;
    private String surname;
    private String name;
    private String otchestvo;
    private String address;
    private int phone;
    private int[] marks;

    public Abiturient() {

    }

    public Abiturient(int id, String surname, String name, String otchestvo,
                      String address, int phone, int[] marks) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.otchestvo = otchestvo;
        this.address = address;
        this.phone = phone;
        this.marks = marks;
    }



    public void create() {
        System.out.println("введите id");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            id = sc.nextInt();
        }
        System.out.println("введите фамилию ");
        sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            surname = sc.nextLine();
        }
        System.out.println("введите имя ");
        sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            name = sc.nextLine();
        }
        System.out.println("введите отчество ");
        sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            otchestvo = sc.nextLine();
        }
        System.out.println("введите адрес ");
        sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            address = sc.nextLine();
        }
        System.out.println("введите номер телефона ");
        sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            phone = sc.nextInt();
        }
        System.out.println("введите количество оценок ");
        sc = new Scanner(System.in);
        int n = 0;
        if(sc.hasNextInt()){
            n = sc.nextInt();
        }
        marks = new int[n];
        for (int i = 0; i < marks.length; i ++){
            marks[i] =(int) (Math.random() * 10 + 1);
            System.out.print(marks[i] + " ");
        }
        System.out.println();
    }

    public  void show() {
        System.out.println("id = " + id + ", surname = " + surname + ", name = " + name + ", otchestvo = " + otchestvo + ", address = " + address +
                ", phone =" + phone +  ", marks = " + Arrays.toString(marks));
    }
    public static Abiturient[] createMas(int n) {
        Abiturient mas[] = new Abiturient[n];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = new Abiturient();
            mas[i].create();
        }
        return mas;
    }

    public static void showMas(Abiturient[] mas) {
        for (int i = 0; i < mas.length; i++) {
            mas[i].show();
        }
    }
    public  void min_marks(){
        for (int i = 0; i < marks.length; i++){
            if(marks[i] < 4 ){
                show();
                break;
            }
        }
    }
    public static double insert_mark(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите средний балл");
        double average_marks = 0;
        if(sc.hasNextDouble()) {
            average_marks = sc.nextDouble();
        }
        return average_marks;
    }
    public void average_mark (double average_marks){
        double av_mark = 0, count = 0;
        for (int i = 0; i < marks.length; i++) {
            count += marks[i];
        }
        av_mark = count / marks.length;
        if(av_mark >= average_marks){
            show();
        }
    }
    public static void min_Abiturent(Abiturient[] mas){
        System.out.println("Список абитуриентов, которые имеют неудовлетворяющие оценки ");
        for(int i = 0; i < mas.length; i++){
            mas[i].min_marks();
        }
    }
    public static void average_Abiturent(Abiturient[] mas, double insert_mark){
        System.out.println("Список абитуриентов со средним баллом выше заданного ");
        for(int i = 0; i < mas.length; i++){
            mas[i].average_mark(insert_mark);
        }
    }

}
public class U1_3 {
    public static void main(String[] args) {
        Abiturient mas[] = Abiturient.createMas(3);
        Abiturient.showMas(mas);
        Abiturient.min_Abiturent(mas);
        Abiturient.average_Abiturent(mas, Abiturient.insert_mark());
    }
}