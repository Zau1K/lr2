import java.util.Scanner;

class Book {
    String author;
    String name;
    int year;
    int kol_page;
    public Book(){

    }
    public Book(String author, String name, int y, int page){
        this.author = author;
        this.name = name;
        this.year = y;
        this.kol_page = page;
    }

    public static  String insertAuthor(){
        System.out.println("Введите имя автора ");
        Scanner sc = new Scanner(System.in);
        String name_author = sc.nextLine();
        return name_author;
    }
    public static  String insertName(){
        System.out.println("Введите название книги ");
        Scanner sc = new Scanner(System.in);
        String name_book = sc.nextLine();
        return name_book;
    }
    public  static  int insertYear(){
        System.out.println("Введите год выпуска ");
        Scanner sc = new Scanner(System.in);
        int _year = sc.nextInt();
        return _year;
    }
    public static  int insertPage(){
        System.out.println("Введите количество страниц ");
        Scanner sc = new Scanner(System.in);
        int page = sc.nextInt();
        return page;
    }
    public void create(){
        System.out.println("Введите имя автора ");
        Scanner sc = new Scanner(System.in);
        if(sc.hasNextLine())
            author = sc.nextLine();
        System.out.println("Введите название книги ");
        if(sc.hasNextLine())
            name = sc.nextLine();
        System.out.println("Введите год выпуска ");
        if(sc.hasNextInt())
            year = sc.nextInt();
        System.out.println("Введите количество страниц ");
        if(sc.hasNextInt())
            kol_page = sc.nextInt();
    }
    public void show() {
        System.out.println("author = " + author + ", name = " + name+ ", year = " + year + ", kol_page = " + kol_page);
    }
    public static Book[] createMas(int n) {
        Book mas[] = new Book[n];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = new Book();
            mas[i].create();
        }
        return mas;
    }
    public static void showMas(Book[] mas) {
        for (int i = 0; i < mas.length; i++) {
            mas[i].show();
        }
    }
    public static Book nameBook(Book[] mas) {
        int find = 0;
        System.out.println("Введите название книги ");
        Scanner sc = new Scanner(System.in);
        if(sc.hasNextLine()) {
            String find_name = sc.nextLine();
            for (int i = 0; i < mas.length; i++) {
                if (mas[i].name.equals(find_name)) {
                    find = i;
                }
            }
        }
        return mas[find];
    }
    public static  String insertAuthor(String author){
        String name_author = author;
        return name_author;
    }
    public static  String insertName(String name){
        String name_book = name;
        return name_book;
    }
    public  static  int insertYear(int year){
        int _year = year;
        return _year;
    }
    public static  int insertPage(int kol_page){
        int page = kol_page;
        return page;
    }
}
public class U4 {
    public static void main(String[] args) {
        Book mas[]=Book.createMas(3);
        Book.showMas(mas);
        Book find = Book.nameBook(mas);
        System.out.println("Информация о книге ");
        find.show();
        Book.insertAuthor(Book.insertAuthor());
        Book.insertName(Book.insertName());
        Book.insertYear(Book.insertYear());
        Book.insertPage(Book.insertPage());
    }
}