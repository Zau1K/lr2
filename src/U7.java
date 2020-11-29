import java.util.Scanner;

class Mnozhestvo {
    private String[] mnozhestvo;

    public Mnozhestvo () {
    }
    public Mnozhestvo (String... mnozhestvo) {
        this.mnozhestvo = mnozhestvo;
    }
    public Mnozhestvo (int size) {

        this.mnozhestvo = new String[size];
    }

    public String[] getmnozhestvo() {

        return this.mnozhestvo;
    }
    public String getValue(int index) {
        return this.mnozhestvo[index];
    }
    public int getCount() {
        return this.mnozhestvo.length;
    }
    public void setmnozhestvo(String[] mnozhestvo) {
        this.mnozhestvo = mnozhestvo;
    }

    public String toString() {
        String result = "";
        for (String tmpValue : mnozhestvo) {
            result += tmpValue +" ";
        }
        return result;
    }

    public static int insertNumMn() {
        Scanner sc = new Scanner(System.in);
        int num;
        for(;;) {
            System.out.println("Введите количество множеств в массиве кратное двум: ");
            if(sc.hasNext()) {
                if(sc.hasNextInt()) {
                    num = sc.nextInt();
                    if(num>0 && num%2==0)break;
                }
                System.out.println("Введено нечетное число");
                sc.nextLine();
            }
            else { System.out.println("Введено неверное число");}
        }
        return num;
    }
    //метод ввода размерности множеств
    public static int insertRazmmnozhestvo() {
        Scanner sc = new Scanner(System.in);
        int kol=0;
        for(;;) {
            System.out.println("Введите количество множества: ");
            if(sc.hasNext()) {
                if(sc.hasNextInt()) {
                    kol = sc.nextInt();
                    if(kol>0)break;
                }
                System.out.println("Введено неверное число");
                sc.nextLine();
            }
            else { System.out.println("Введено неверное число");}
        }
        return kol;
    }


    public static String[] insertmnozhestvo(int kol) {
        Scanner sc = new Scanner(System.in);
        String[] num = new String[kol];
        for(int i=0; i<kol; i++) {
            System.out.println("Введите элементы множества: ");
            num[i] = sc.next();
        }
        return num;
    }
    //метод ввода числа
    public static double insertnumber() {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        double kol=0;
        for(;;) {
            if(sc.hasNext()) {
                if(sc.hasNextDouble()) {
                    kol = sc.nextDouble();
                    if(kol>0)break;
                }
                System.out.println("Введено неверное число");
                sc.nextLine();
            }
            else { System.out.println("Введено неверное число");}
        }
        return kol;
    }
    //метод ввода элемента для массива
    public static String insertstr() {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        String kol;
        kol = sc.next();
        return kol;
    }
    //вывод элементов массива, представляющего множество по элементам
    public void returnmassive(String[] mnozhestvo) {
        System.out.print("{ ");
        for(int j=0; j<mnozhestvo.length; j++) {
            System.out.print(mnozhestvo[j]);
            System.out.print("  ");
        }
        System.out.print("}");
    }
    //вывод списка векторов со всеми элементами
    public void show(){
        System.out.print(" Множество: ");
        returnmassive(mnozhestvo);
        System.out.println();
    }
    //сортировка по возрастанию пузырьком
    public static double[] bubbleSort(double[] arr){
        for(int i = arr.length-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){
                if( arr[j] > arr[j+1] ){
                    double tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        return arr;
    }
    //обьединение массивов
    public static String[] concat(String[]... arrays) {
        int length = 0;
        for (String[] array : arrays) {
            length += array.length;
        }
        String[] result = new String[length];
        int pos = 0;
        for (String[] array : arrays) {
            for (String element : array) {
                result[pos] = element;
                pos++;
            }
        }
        return result;
    }
    //метод присваивания
    public static Mnozhestvo prisv1(Mnozhestvo v1, Mnozhestvo v2) {
        Mnozhestvo result = new Mnozhestvo();
        String[] sort = concat(v1.getmnozhestvo(), v2.getmnozhestvo());
        result.setmnozhestvo(sort);
        return result;
    }
    //метод присваивания
    public static Mnozhestvo prisv2(Mnozhestvo v1) {
        Mnozhestvo result = new Mnozhestvo();
        System.out.println("Введите количесвто элементов, которое необходимо присвоить: ");
        int n = (int) insertnumber();
        String[] mas = new String[n];
        System.out.println("Введите элементы для присваивания: ");
        for (int i=0; i<mas.length; i++) {
            System.out.print("№ "+(i+1)+" ");
            mas[i] = insertstr();
            System.out.println();
        }
        String[] sort = concat(v1.getmnozhestvo(), mas);
        result.setmnozhestvo(sort);
        return result;
    }
    //метод определения нахождения элемента в множестве
    public static void find(Mnozhestvo v1) {
        System.out.println("Введите элемент который необходимо найти: ");
        String find = insertstr();
        int count = 0;
        for (int i=0; i<v1.getmnozhestvo().length; i++) {
            if (v1.getValue(i).contentEquals(find)) {
                System.out.print("Элемент "+find+" НАХОДИТСЯ во множестве {"+v1.toString()+"} ");
                count=10;
                break;
            }
        }
        if (count != 10) System.out.print("Элемента "+find+" НЕТ во множестве {"+v1.toString()+"} ");
        System.out.println();
    }
    //метод объединения
    public static Mnozhestvo objed(Mnozhestvo v1, Mnozhestvo v2) {
        Mnozhestvo result = new Mnozhestvo();
        String[] sort = concat(v1.getmnozhestvo(), v2.getmnozhestvo());
        int n = sort.length;
        for ( int i = 0, m = 0; i != n; i++, n = m ){ //выброс одинаковых элементов
            for ( int j = m = i + 1; j != n; j++ ){
                if ( sort[j] != sort[i] ){
                    if ( m != j ) sort[m] = sort[j];
                    m++;
                }
            }
        }
        if ( n != sort.length ){
            String[] b = new String[n];
            for ( int i = 0; i < n; i++ ) b[i] = sort[i];
            sort = b;
        }
        result.setmnozhestvo(sort);
        return result;
    }
    //метод пересечения
    public static Mnozhestvo peres(Mnozhestvo v1, Mnozhestvo v2) {
        Mnozhestvo result = new Mnozhestvo();
        int count=0;
        for (int i = 0; i < v1.getmnozhestvo().length; i++){
            for (int j = 0; j < v2.getmnozhestvo().length; j++){
                if (v1.getValue(i).equals(v2.getValue(j))) {
                    count++;//получаем количество одинаковых элементов в двух массивах
                }
            }
        }
        String[] b = new String[count];//массив с данным числом элементов
        int k=0;
        for (int i = 0; i < v1.getmnozhestvo().length; i++){
            for (int j = 0; j < v2.getmnozhestvo().length; j++){
                if (v1.getValue(i).equals(v2.getValue(j))) {
                    b[k]=v1.getValue(i);//заносим одинаковые элемнты из двух массивов в один
                    k++;
                }
            }
        }
        String[] sort = b;
        int n = count;
        for ( int i = 0, m = 0; i != n; i++, n = m ){ //выброс повторяющихся элементов из данного массива
            for ( int j = m = i + 1; j != n; j++ ){
                if ( sort[j] != sort[i] ){
                    if ( m != j ) sort[m] = sort[j];
                    m++;
                }
            }
        }
        if ( n != sort.length ){
            String[] d = new String[n];
            for ( int i = 0; i < n; i++ ) d[i] = sort[i];
            sort = d;
        }

        result.setmnozhestvo(sort);
        return result;
    }
    //метод разности двух множеств
    public static Mnozhestvo raznost(Mnozhestvo v1, Mnozhestvo v2) {
        Mnozhestvo result = new Mnozhestvo();
        int count=0;
        for (int i = 0; i < v1.getmnozhestvo().length; i++){
            for (int j = 0; j < v2.getmnozhestvo().length; j++){
                if (v1.getValue(i).equals(v2.getValue(j))) {
                    count++;//получаем количество одинаковых элементов в двух массивах
                }
            }
        }
        String[] b = new String[count];//массив с данным числом элементов(одинаковых)
        int k=0;
        for (int i = 0; i < v1.getmnozhestvo().length; i++){
            for (int j = 0; j < v2.getmnozhestvo().length; j++){
                if (v1.getValue(i).equals(v2.getValue(j))) {
                    b[k]=v1.getValue(i);//заносим одинаковые элемнты из двух массивов в один
                    k++;
                }
            }
        }
        String[] sort = b;
        int n = count;
        for ( int i = 0, m = 0; i != n; i++, n = m ){ //выброс повторяющихся элементов из данного массива
            for ( int j = m = i + 1; j != n; j++ ){
                if ( sort[j] != sort[i] ){
                    if ( m != j ) sort[m] = sort[j];
                    m++;
                }
            }
        }
        if ( n != sort.length ){
            String[] d = new String[n];
            for ( int i = 0; i < n; i++ ) d[i] = sort[i];
            sort = d;
        }
        String[] v1mas = v1.getmnozhestvo();
        String[] searchKey = sort;
        for (int y=0; y<searchKey.length; y++) {
            v1mas=remove(v1mas, searchKey[y]);//удаление элементов из первого, которые содеражться в первом
        }
        result.setmnozhestvo(v1mas);
        return result;
    }
    //индексирование множеств
    public static void index(Mnozhestvo[] vec) {
        int nv=0, ind=0;

        Scanner sc = new Scanner(System.in);
        for(;;) {
            System.out.println("Введите номер множества из массива: ");
            if(sc.hasNext()) {
                if(sc.hasNextInt()) {
                    nv = sc.nextInt();
                    if(nv>0 && nv<vec.length+1)break;
                }
                System.out.println("Множества с таким номером нет!");
                sc.nextLine();
            }
            else { System.out.println("Множества с таким номером нет!");}
        }
        for(;;) {
            System.out.println("Введите число для индексации: ");
            if(sc.hasNext()) {
                if(sc.hasNextInt()) {
                    ind = sc.nextInt();
                    if(ind>0 && ind<vec[nv-1].getCount()+1)break;
                }
                System.out.println("В данном множестве компонента с таким номером нет!");
                sc.nextLine();
            }
            else { System.out.println("В данном множестве компонента с таким номером нет!");}
        }
        System.out.println("Множество №"+(nv)+" элемент № "+(ind)+" равен "+vec[nv-1].getValue(ind-1));
    }
    //удаление элемента из массива
    public static String[] remove(String[] mas, String element){
        for (int i = 0; i < mas.length; i++){
            if (mas[i].equals(element)){
                String[] copy = new String[mas.length-1];
                System.arraycopy(mas, 0, copy, 0, i);
                System.arraycopy(mas, i+1, copy, i, mas.length-i-1);
                return copy;
            }
        }
        return mas;
    }
    //метод построения множества из двух разностей пар множеств
    public static Mnozhestvo twoobjbuild(Mnozhestvo v1, Mnozhestvo v2) {
        Mnozhestvo result = new Mnozhestvo();
        String[] mas1 = new String[(raznost(v1,v2)).getmnozhestvo().length];
        String[] mas2 = new String[(raznost(v2,v1)).getmnozhestvo().length];
        mas1 = (raznost(v1,v2)).getmnozhestvo();
        mas2 = (raznost(v2,v1)).getmnozhestvo();
        String[] sort = concat(mas1, mas2);
        result.setmnozhestvo(sort);
        return result;
    }
    //метод выводит все о парах векторов из массива
    public static void showAllParams(Mnozhestvo[] vec) {
        for (int j=0; j<vec.length; j=j+2) {
            System.out.println("Объединение (сумма) {"+vec[j].toString()+"} + {"+vec[j+1].toString()+"} =  "+Mnozhestvo.objed(vec[j],vec[j+1]).toString());
            System.out.println("Пересечение (умножение) {"+vec[j].toString()+"} * {"+vec[j+1].toString()+"} =  "+Mnozhestvo.peres(vec[j],vec[j+1]).toString());
            System.out.println("Разность (вычитание) {"+vec[j].toString()+"} / {"+vec[j+1].toString()+"} =  "+Mnozhestvo.raznost(vec[j],vec[j+1]).toString());
            System.out.println("Присваивание 1 {"+vec[j].toString()+"} := {"+vec[j+1].toString()+"} =  "+Mnozhestvo.prisv1(vec[j],vec[j+1]).toString());
            System.out.println("Присваивание 2 {"+vec[j].toString()+"} := "+Mnozhestvo.prisv2(vec[j]).toString());
        }
    }
}
public class U7 {
    public static void main(String args[]) {
        Mnozhestvo mn1 = new Mnozhestvo(Mnozhestvo.insertmnozhestvo(Mnozhestvo.insertRazmmnozhestvo()));
        Mnozhestvo mn2 = new Mnozhestvo(Mnozhestvo.insertmnozhestvo(Mnozhestvo.insertRazmmnozhestvo()));
        System.out.println("Объединение (сумма) {"+mn1.toString()+"} + {"+mn2.toString()+"} =  "+Mnozhestvo.objed(mn1,mn2).toString());
        System.out.println("Пересечение (умножение) {"+mn1.toString()+"} * {"+mn2.toString()+"} =  "+Mnozhestvo.peres(mn1,mn2).toString());
        System.out.println("Разность (вычитание) {"+mn1.toString()+"} / {"+mn2.toString()+"} =  "+Mnozhestvo.raznost(mn1,mn2).toString());
        System.out.println("Присваивание 1 {"+mn1.toString()+"} := {"+mn2.toString()+"} =  "+Mnozhestvo.prisv1(mn1,mn2).toString());
        System.out.println("Множество из двух разностей множества {"+mn1.toString()+"} и {"+mn2.toString()+"} =  "+Mnozhestvo.twoobjbuild(mn1, mn2).toString());
        System.out.println("Присваивание 2 {"+mn1.toString()+"} := "+Mnozhestvo.prisv2(mn1).toString());
        Mnozhestvo.find(mn1);
        //создание массива объектов
        int i=0;
        int n=Mnozhestvo.insertNumMn();
        Mnozhestvo[] mn = new Mnozhestvo[n];
        for(;;){
            System.out.println("Введите информацию о множестве "+(i+1));
            String[] mnozhestvo=Mnozhestvo.insertmnozhestvo(Mnozhestvo.insertRazmmnozhestvo());
            mn[i] = new Mnozhestvo(mnozhestvo);
            if(i>=n-1)break;
            i++;
        }
        //вывод списка векторов в массиве объектов
        for(Mnozhestvo v : mn){
            v.show();
        }
        //метод обнаружения элемента во множестве
        Mnozhestvo.showAllParams(mn);
        //построение множества из двух разностей
        for (int j=0; j<mn.length; j=j+2) {
            System.out.println("\"Множество из двух разностей множеств {"+mn[j].toString()+"} и {"+mn[j+1].toString()+"} =  "+(Mnozhestvo.twoobjbuild(mn[j], mn[j+1])).toString()+"} ");
        }
    }
}