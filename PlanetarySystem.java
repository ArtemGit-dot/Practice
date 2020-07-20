import java.util.*;
public class PlanetarySystem{//Сущность- планетная система
    //поля-скрыты в классе
    private final static String SYSTEM_FORMAT_STRING=
    "Планетарная система: %-s,%-5d планет";
    private String cipher; //шифр звезды
    private List <Planet> planets; // список (набор) планет
    //конструкторы
    public PlanetarySystem(){
    cipher = ""; //без названия
    planets = new ArrayList <Planet>(); //создаётся пустой список
    }
   public PlanetarySystem(String cipher){
    this.cipher = cipher; //задаётся название звезды
    planets = new ArrayList <Planet>(); //создаётся пустой список
    }
    public PlanetarySystem(String cipher, List list){
    this.cipher = cipher; //задаётся название звезды
    planets = new ArrayList <Planet>(list); //создаётся на основе
                                            //существующего списка
    }
    //методы-сеттеры для private поля
    public void setCipher(String cipher) {this.cipher = cipher;}
    //методы-геттеры для private поля
    public String getCipher() {return cipher;}
    public List <Planet> getPlanets(){
        return planets;
    }
    //Переопределяем метод toString класса Object
    //возвращает строку описания объекта планетная система:
    public String toString(){
    return String.format(SYSTEM_FORMAT_STRING,cipher,getPlanNum());
}
    //Запросы на вставку, удаление, изменение данных:
    public boolean addPlan(Planet plan){
    //Добавить планету в систему
    //(планету нельзя добавить, если в системе планет уже есть планета
    //с таким же шифром)
   if (getPlan(plan.getCipher())!=null) return false; //дополнительная
                                                      // программная проверка
   if (planets.add(plan)) return true; 
   else return false;
   }
    public boolean delPlan(int cipher){
    //удалить планету из списка :
    if (planets.remove(new Planet(cipher,"",0.0, 0.0, false))) 
    return true;
    else return false;
   }
    //запросы на выборку данных
    public Planet getPlan (int cipher){
    // Возвращает планету с заданным шифром:
    for (Planet plan:planets)
    if (plan.getCipher() == cipher) 
    return plan; // если планета найдена
    return null; // планета не найдена
    }
    public int getPlanNum(){
    //Возвращает число планет в системе
    return planets.size();
    }
    public double avgMass() {
    //Возвращает среднюю массу планеты для планетной системы
   int num=planets.size(); 
   if (num==0) return 0; 
   double avg=0;
   for (Planet plan:planets) avg=avg+plan.getMass();
   return avg/num;
   }
       public double avgCipher() {
   int num=planets.size(); 
   if (num==0) return 0; 
   double avg=0;
   for (Planet plan:planets) avg=avg+plan.getCipher();
   return avg/num;
   }
    public PlanetarySystem aboveAvgMass(){
    //вернуть список планет, у которых масса выше средней
    double avg=avgMass();
    PlanetarySystem system = new PlanetarySystem (cipher +
   ": планеты, у которых масса выше средней - " + avg);
   for (Planet plan:planets)
   if (plan.getMass()>avg)system.addPlan(plan); 
   return system;
}
    public PlanetarySystem aboveAvgCipher(){
    double avg=avgCipher();
    PlanetarySystem system = new PlanetarySystem (cipher +
   ": планеты" + avg);
   for (Planet plan:planets)
   if (plan.getCipher()>avg)system.addPlan(plan); 
   return system;
}
    public PlanetarySystem betweenDist(double d1, double d2){
   //вернуть список планет, у которых расстояние до звезды которых находится в заданном интервале
   PlanetarySystem system = new PlanetarySystem (
  String.format (
   "%s: планеты, у которых расстояние до звезды от %4.2f км до %4.2f км", cipher,d1,d2));
   //для просмотра (перечисления) объектов списка
   //используем итератор
   Iterator <Planet> iter = planets.iterator(); while (iter.hasNext()){
   Planet plan = iter.next();
   if ((plan.getMass() >= d1)&&(plan.getMass() <= d2))system.addPlan(plan);
   }
   return system;
   }
       public PlanetarySystem betweenCipher(double d1, double d2){
   PlanetarySystem system = new PlanetarySystem (
  String.format (
   "%s: планеты", cipher,d1,d2));
   //для просмотра (перечисления) объектов списка
   //используем итератор
   Iterator <Planet> iter = planets.iterator(); while (iter.hasNext()){
   Planet plan = iter.next();
   if ((plan.getCipher() >= d1)&&(plan.getCipher() <= d2))system.addPlan(plan);
   }
   return system;
   }
   //Запросы на сортировку данных
   //Для сортировки списков List используются статические
   //методы sort, определенные в классе Collections
   public PlanetarySystem sort(){
   //Cортировка планет в естественном порядке
   //Естественный порядок задает метод CompareTo,
   //переопределенный	в классе Planet
   PlanetarySystem system = new PlanetarySystem (cipher, planets); 
   Collections.sort(system.planets);
   return system;
   }
   public PlanetarySystem sort(Comparator comp){ //coртировка планет
   //по правилу, задаваемому компаратором comp 
   PlanetarySystem system = new PlanetarySystem (cipher, planets); 
   Collections.sort(system.planets, comp);
   return system;
   }
   // Запрос на вывод данных
   public void putPlanetarySystem(){
  // Вывод планетной системы в окно терминала 
  System.out.println(cipher); 
  System.out.printf("%5s%17s%11s%17s%17s\n",
  "Шифр","Название","Масса","Расстояние до звезды", "Наличие атмосферы"); //заголовки столбцов
   int i=1;
   for (Planet plan:planets){
   System.out.printf(" %-7d %-15s  %-10.2f  %-10.2f %-b\n", i, plan.getCipher(), plan.getName(), plan.getMass(), plan.getDistance(), plan.getAtmosphere());
   i=i+1;
}
} 
}
