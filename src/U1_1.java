import java.time.LocalDate;
import java.util.Scanner;

class Student {
    private int id;
    private String surname;
    private String name;
    private String dadName;
    private LocalDate data;
    private String address;
    private long phone;
    private String faculty;
    private int cour;
    private int group;


    public Student() {

    }

// 29.11.2020
    public Student(int id, String surname, String name, String dadName, String data, String address, long phone, String faculty, int cour, int group) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.dadName = dadName;
        String dates[] = data.split("\\.");
        this.data = LocalDate.of(Integer.parseInt(dates[2]),Integer.parseInt(dates[1]),Integer.parseInt(dates[0]));
        this.address = address;
        this.phone = phone;
        this.faculty = faculty;
        this.cour = cour;
        this.group = group;
    }
    public void create() {
        System.out.println("введите id");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            id = sc.nextInt();
        }
        else{
            System.out.println("Вы ввели не int");
            return;
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
            dadName = sc.nextLine();
        }
        System.out.println("введите дату рождения в формате дд.мм.гггг ");
        sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            String dates[] = sc.nextLine().split("\\.");
            data = LocalDate.of(Integer.parseInt(dates[2]),Integer.parseInt(dates[1]),Integer.parseInt(dates[0]));
        }
        System.out.println("введите адрес ");
        sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            address = sc.nextLine();
        }
        System.out.println("введите номер телефона ");
        sc = new Scanner(System.in);
        if (sc.hasNextLong()) {
            phone = sc.nextLong();
        }
        else{
            System.out.println("Вы ввели не int");
            return;
        }
        System.out.println("введите факультет ");
        sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            faculty = sc.nextLine();
        }
        System.out.println("введите курс ");
        sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            cour = sc.nextInt();
        }
        else{
            System.out.println("Вы ввели не int");
            return;
        }
        System.out.println("введите номер группы ");
        sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            group = sc.nextInt();
        }
        else{
            System.out.println("Вы ввели не int");
            return;
        }
    }

    public void show() {
        System.out.println("id =" + id + ", surname=" + surname + ", name = " + name+ ", dadNow =" + dadName + ", data=" + data + ", address = " + address+
                ", phone=" + phone + ", faculty = " + faculty + ", cour =" + cour + ", group = " + group);
    }

    public static Student[] createMas(int n) {
        Student mas[] = new Student[n];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = new Student();
            mas[i].create();
        }
        return mas;
    }
    public static void showMas(Student[] mas) {
        for (int i = 0; i < mas.length; i++) {
            mas[i].show();
        }
    }
    public static void nameStudent(Student[] mas) {
        System.out.println("Введите название факультета ");
        Scanner sc = new Scanner(System.in);
        String findName = null;
        if(sc.hasNextLine()) {
            findName = sc.nextLine();
        }
        for (int i = 0; i < mas.length; i++) {
            if (mas[i].name.equals(findName)) {
                mas[i].show();
            }
        }
    }
    public  static void nameGroup(Student[] mas){

        System.out.println("Введите номер группы ");
        Scanner sc = new Scanner(System.in);
        int numberGroup = 0;
        if(sc.hasNextInt()) {
            numberGroup = sc.nextInt();
        }
        else{
            System.out.println("Вы ввели не int");
            return;
        }
        for(int i = 0; i < mas.length; i++){
            if(mas[i].group == numberGroup){
                mas[i].show();
            }
        }
    }
    public  static void nameFacultyCour(Student[] mas){
        System.out.println("Введите факультет ");
        Scanner sc = new Scanner(System.in);
        String name_faculty = null;
        int number_cour = 0;
        if(sc.hasNextLine()){
            name_faculty = sc.nextLine();
        }
        System.out.println("Введите курс ");
        if(sc.hasNextInt()){
            number_cour = sc.nextInt();
        }
        else{
            System.out.println("Вы ввели не int");
            return;
        }
        for(int i = 0; i < mas.length; i++){
            if(mas[i].faculty.equals(name_faculty) && mas[i].cour == number_cour){
                mas[i].show();
            }
        }
    }
    public static void nameData(Student[]mas){
        System.out.println("Введите год рождения ");
        Scanner sc = new Scanner(System.in);
        String year_data = null;
        if(sc.hasNextLine()){
            year_data = sc.nextLine();
        }
        for(int i = 0; i < mas.length; i++){
            if(mas[i].data.equals(year_data)){
            }
            else  {
                mas[i].show();
            }
        }

    }
}

public class U1_1 {
    public static void main(String[] args) {
        Student mas[]=Student.createMas(1);
        Student.showMas(mas);
        Student.nameStudent(mas);
        Student.nameFacultyCour(mas);
        Student.nameData(mas);
        Student.nameGroup(mas);

    }
}

