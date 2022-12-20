// Написать программу, определяющую правильность расстановки скобок в выражении.
// a+(d*3) - истина
// [a+(1*3) - ложь
// [6+(3*3)] - истина
// {a}[+]{(d*3)} - истина
// <{a}+{(d*3)}> - истина
// {a+]}{(d*3)} - ложь

import java.util.ArrayList;
import java.util.Arrays;

public class T3 {
    public static void main(String[] args) {
        String str = "a+(d*3)";
        // String str = "[a+(1*3)";
        // String str = "[6+(3*3)]";
        // String str = "{a}[+]{(d*3)}";
        // String str = "<{a}+{(d*3)}>";
        // String str = "{a+]}{(d*3)}";
        String[] s = str.split("");

        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(s));
        System.out.println(arrayList);

        RemoveBrackets(arrayList, "(", ")");
        RemoveBrackets(arrayList, "[", "]");
        RemoveBrackets(arrayList, "{", "}");
        RemoveBrackets(arrayList, "<", ">");

        System.out.println(arrayList);

        System.out.println(Checking(arrayList));

    }

    public static ArrayList<String> RemoveBrackets(ArrayList<String> arrayList, String fBracket, String sBracket) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).equals(fBracket)) {
                for (int j = 0; j < arrayList.size(); j++) {
                    if (arrayList.get(j).equals(sBracket)) {
                        arrayList.remove(j);
                        arrayList.remove(i);
                        break;
                    }
                }
            }
        }
        return arrayList;
    }

    public static boolean Checking(ArrayList<String> arrayList) {
        boolean result = true;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).equals("(") || arrayList.get(i).equals(")") || arrayList.get(i).equals("[")
                    || arrayList.get(i).equals("]") || arrayList.get(i).equals("{") || arrayList.get(i).equals("}")
                    || arrayList.get(i).equals("<") || arrayList.get(i).equals(">")) {
                result = false;
            }
        }
        return result;
    }
}