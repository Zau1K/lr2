import java.util.Scanner;

class Patient {
    private int id;
    private String surname;
    private  String name;
    private  String dadName;
    private  String address;
    private   int phone;
    private  int number_card;
    private  String diagnosis;
    public Patient(){

    }
    public Patient( int id,String surname, String name, String dadName, String address, int phone, int number_card, String diagnosis){
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.dadName = dadName;
        this.address = address;
        this.phone = phone;
        this.number_card = number_card;
        this.diagnosis = diagnosis;
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
        else{
            System.out.println("Вы ввели не int");
            return;
        }
        System.out.println("введите номер медецинской карты ");
        sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            number_card = sc.nextInt();
        }
        else{
            System.out.println("Вы ввели не int");
            return;
        }
        System.out.println("введите диагноз ");
        sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            diagnosis = sc.nextLine();
        }
    }
    public void show() {
        System.out.println("id = " + id + ", surname = " + surname + ", name = " + name + ", dadName = " + dadName + ", address = " + address +
                ", phone =" + phone + ", number_card = " + number_card + ", diagnosis = " + diagnosis);
    }
    public static Patient[] createMas(int n) {
        Patient mas[] = new Patient[n];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = new Patient();
            mas[i].create();
        }
        return mas;
    }
    public static void showMas(Patient[] mas) {
        for (int i = 0; i < mas.length; i++) {
            mas[i].show();
        }
    }
    public  static void nameDiagnosis(Patient[] mas){
        System.out.println("Введите диагноз ");
        Scanner sc = new Scanner(System.in);
        String diagnos = null;
        if(sc.hasNextLine()) {
            diagnos = sc.nextLine();
        }
        for(int i = 0; i < mas.length; i++){
            if(mas[i].diagnosis.equals(diagnos)){
                mas[i].show();
            }
        }
    }
    public static void namePatient(Patient[] mas){
        System.out.println("Введите диапазон номеров карт пациентов");
        Scanner sc = new Scanner(System.in);
        int a = 0, b = 0;
        if(sc.hasNextInt()) {
            a = sc.nextInt();
        }
        else{
            System.out.println("Вы ввели не int");
            return;
        }
        if (sc.hasNextInt()){
            b = sc.nextInt();
        }
        else{
            System.out.println("Вы ввели не int");
            return;
        }
        for(int i = 0; i < mas.length; i++){
            if(a <= mas[i].number_card && mas[i].number_card <= b && a < b){
                mas[i].show();
            }
        }
    }
}
public class U1_2 {
    public static void main(String[] args) {
        Patient mas[] = Patient.createMas(3);
        Patient.showMas(mas);
        System.out.println("Пациенты с таким диагназом ");
        Patient.nameDiagnosis(mas);
        Patient.namePatient(mas);
    }
}