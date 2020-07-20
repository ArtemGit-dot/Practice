import java.util.*;
public class CompCipherDesc implements Comparator{ 
    public int compare (Object ob1, Object ob2){
    Planet plan1 = (Planet) ob1; 
    Planet plan2 = (Planet) ob2;
    if (plan1.getCipher() < plan2.getCipher()) return 1;
    else if (plan1.getCipher() == plan2.getCipher()) return 0; 
    else return -1;
 }
}
