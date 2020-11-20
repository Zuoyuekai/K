import java.util.HashSet;
import java.util.Scanner;

/**
 * Create by zyk
 * 2020/11/17 19:24
 */
public class Main {
    public static void fun(String strMust, String strAct) {
        HashSet<Character> setM = new HashSet<>();
        HashSet<Character> setA = new HashSet<>();
        char[] chM = strMust.toUpperCase().toCharArray();
        char[] chA = strAct.toUpperCase().toCharArray();

        for (char i : chA) {
            setA.add(i);
        }

        for (char i : chM) {
            if (!setM.contains(i) && !setA.contains(i)) {
                setM.add(i);
                System.out.print(i);
            }
        }


    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String str1 = input.nextLine();
            String str2 = input.nextLine();
            fun(str1,str2);
        }
    }
}
