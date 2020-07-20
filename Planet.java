public class Planet implements Comparable <Planet>{
    //Сущность-Планета
    private final static String PLANET_FORMAT_STRING =
    "Планета: %10d, %15s, %5.2f, %10.5f, %b";
    //поля-скрыты в классе
    private int cipher; //шифр планеты
    private String name; //Название планеты
    private double mass; //Масса планеты
    private double distance; //Расстояние до звезды
    private boolean atmosphere; //Наличие атмосферы
    //конструктор без параметров
    public Planet(){
        cipher=0;
        name="";
        mass=0.0;
        distance=0.0;
        atmosphere=false;
    }
    //конструктор с параметрами
    public Planet(int cipher, String name, double mass, double distance, boolean atmosphere){
        this.cipher=cipher;
        this.name=name; 
        this.mass=mass; 
        this.distance=distance;
        this.atmosphere=atmosphere;
    }
    //геттеры
    public int getCipher(){return cipher;}
    public String getName(){return name;}
    public double getMass(){return mass;}
    public double getDistance() {return distance;}
    public boolean getAtmosphere() {return atmosphere;}
    //сеттеры
    public void setCipher(int cipher) {this.cipher=cipher;}
    public void setName(String name) {this.name=name;}
    public void setMass(double mass) {this.mass=mass;}
    public void setDistance(double distance){this.distance=distance;}
    public void setAtmosphere(boolean atmosphere){this.atmosphere=atmosphere;}
    //Переопредеяется метод  toString класса Object
    //(возвращает строку описания объекта
    public String toString(){
        return String.format(PLANET_FORMAT_STRING, cipher, name, mass, distance, atmosphere);
    }
    //Переопределяется метод equals класса Object
    //(задает способ сравнения объектов на равенство,
    //возвращает true, если запускающий объект
    //равен объекту-параметру) 
    public boolean equals (Object ob){
    if (ob==this) return true; // ссылки равны – один
    // и тот же объект
    if (ob==null) return false; //в метод передана null-ссылка
    if (getClass()!=ob.getClass())return false; //объекты разных классов
    Planet pl=(Planet)ob; // преобразуем Object в Planet
    return cipher == pl.cipher;	//cipher – ключевое поле объекта
    }
    //Переопределяется метод hashCode класса Object
    //Возвращает хэш-код объекта
    //(у равных объектов должны быть равные hash-коды)
    public int hashCode(){
    return 7* (new Integer(cipher)).hashCode();
    }
    //Определяем метод СоmpareTo интерфейса Сomparable
    //Для определения естественного порядка перечисления элементов
    public int compareTo(Planet plan){ 
        if (cipher < plan.cipher) 
        return -1;
        else if (cipher == plan.cipher) 
        return 0; 
        else 
        return 1;
}
}
