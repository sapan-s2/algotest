import java.io.IOException;
import java.util.Scanner;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


public class CommonChilString {
    static int commonChild(String s1, String s2) {
        // int temp[] = new int [s1.length() + s2.length()];
        HashSet<Character> temp = new HashSet();
        int count = 0;
        for(int i=0 ; i < s1.length() ; i++){
            for(int j=0 ; j< s2.length() ; j++){
                if(s1.charAt(i)  == s2.charAt(j)){
                    // temp[count] = s1.charAt(i);
                    temp.add(s1.charAt(i));
                    count ++;
                }
            }
        }
        return temp.size() ;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String s1 = scanner.nextLine();
//
//        String s2 = scanner.nextLine();
//
        int result = commonChild("OUDFRMYMAW",
                                "AWHYFCCMQX");
        System.out.println(result);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
//
//        scanner.close();
    }
}
