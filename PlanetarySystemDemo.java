public class PlanetarySystemDemo{ 
public static void main (String[ ] args){
//Создаем планетные системы
PlanetarySystem ps1=new PlanetarySystem ("ваамчв"); 
PlanetarySystem ps2=new PlanetarySystem ("вавскус");
// в массив args при запуске метода main (String[ ] args)
// ввели 10 планет: по 5 для каждой системы.

int j=0; //индекс массива args
// добавление планет в первую систему
for (int i=0; i<5; i++){
int cipher=Integer.valueOf(args[j]); j++; // получен int-эквивалент из String
String name=args[j];
 j++;
//получаем float-эквивалент из String
double mass=Float.valueOf(args[j]); j++;
//добавить планету
ps1.addPlan(new Planet(cipher, name,  mass, distance, atmosphere));
}
// добавление планет во вторую систему
for (int i=0; i<5; i++){
int cipher=Integer.valueOf(args[j]); 
j++; 
String name=args[j]; 
j++;
float mass=Float.valueOf(args[j]); j++;
//добавить планету
ps2.addPlan(new Planet(cipher, name, mass, distance, atmosphere));
}
//Выборка данных
// Вывод всевозможных списков планет
// Вывод основного списка без сортировки
System.out.println("Планетная система (без сортировки)"); 
ps1.putPlanetarySystem();
// попытка вставить планету с тем же шифром 
System.out.println("Попытка добавить планету: 32348, Юпитер,5.0, 345.53, false"); 
ps1.addPlan(new Planet (32348, "Юпитер",5.0, 345.53, false));
// снова выводим основной список
// (теперь с естественным порядком сортировки)
System.out.println(
"Планетная система (с естественным порядком сортировки)"); 
ps1.sort().putPlanetarySystem();
// другие списки:
System.out.println(
"Планетная система (с сортировкой по возрастанию шифра)"); 
ps1.aboveAvgCipher().sort(new CompCipherAsc()).putPlanetarySystem(); 
System.out.println(
"Планетная система (с сортировкой по убыванию шифра)"); 
ps1.betweenCipher(3.2f,4.2f).sort(new CompCipherDesc()).putPlanetarySystem();
// удаление планеты по шифру
ps1.delPlan(12345);
//выводим список планет ps1 после удаления планеты 
System.out.println ("После удаления студента c id=12345:"); System.out.println(
"Планетная система (с естественным порядком сортировки)"); 
ps1.putPlanetarySystem();
// Выводим списки планет для второй системы
System.out.println(
"Планетная система (с сортировкой по возрастанию названия и"); System.out.println(" убыванию шифра)");
ps2.sort(new CompNameAscCipherDesc()).putPlanetarySystem();
// другие списки для второй системы:
System.out.println(
"Планетная система (с сортировкой по возрастанию шифра)"); 
ps2.aboveAvgCipher().sort(new CompCipherAsc()).putPlanetarySystem(); 
System.out.println(
"Планетная система (с сортировкой по убыванию шифра)"); 
ps2.betweenCipher(3.2f,4.2f).sort(new CompCipherDesc()).putPlanetarySystem();
//Проверяем,есть ли в первой системе планета
// с заданным шифром
int n=23345;
Planet p1=ps1.getPlan(n);
if (p1==null) 
System.out.println ("В системе "+ps1.getCipher()+ " нет планеты с шифром "+n);
else System.out.println(p1); n=70000;
p1=ps1.getPlan(n);
if (p1==null) 
System.out.println ("В системе "+ps1.getCipher()+ " нет планеты с шифром "+n);
else System.out.println(p1);
//Проверяем,есть ли во второй системе планета с заданным шифром
n=53349;
p1=ps2.getPlan(n);
if (p1==null) 
System.out.println ("В системе "+ps1.getCipher()+ " нет планеты с шифром "+n);
else System.out.println(p1);
}
}
