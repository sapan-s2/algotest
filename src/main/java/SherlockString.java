import javax.jws.soap.SOAPBinding;
import java.util.*;

public class SherlockString {
    int a ;
    double b ;
    static Integer test;

    public SherlockString() {
    }

    public SherlockString(int a, double b) {
        this.a = a;
        this.b = b;
    }

    public static void main(String[] args) {
//        System.out.println(isValid("aabbcc"));
//        System.out.println(isValid("abc"));
//        System.out.println(isValid("abccd"));
//        System.out.println(isValid("aabbccddeefghi"));
        test = Integer.parseInt("");
        System.out.println(test);
        SherlockString s = new SherlockString();
        System.out.println("a : " + s.a);
        System.out.println("b : " + s.b);

    }

    static String isValid(String s) {
        boolean flag = false;
        HashMap<Character, Integer> maps =  countOfCharInString(s);
        Set<Integer> set = new HashSet<Integer>();

        for( int value :  maps.values()) {
            set.add(value);
        }
        final Object[] objects = set.toArray();

        if(objects.length == 1  ){
            flag = true;
        }

        if(objects.length  == 2  ){
            int array[] = new int[2];
            int i=0;
            for (Integer temp : set){
                array[i] =  temp ;
                i++;
            }
            if( (array[1] - array[0] ) == 1){
            flag = true;
            }
        }

        if(objects.length  > 2 ){
              flag = false;
        }

        if(flag) {
            return "YES" ;
        }
        else
            return null;
    }

    static HashMap<Character, Integer> countOfCharInString(String s){
        HashMap<Character, Integer> map = new HashMap();
        for (int i =0 ; i < s.length(); i++){

            char c  =  s.charAt(i);

            if(map.get(c) != null) {
                map.put( c , map.get(c) +1);
            }
            else{
                map.put( c,1 );
            }

        }
        return map;
    }
}
