package Solution_4;

import java.util.HashSet;


public class StringOperator {
    //Appends a string n times after itself
    static public String strAppend(String str, int n){
        String res = new String(str);
        for (int i = 0; i < n; i++){
            res += str;
        }
        return res;
    }

    //Appends a StringBuffer type string n times after itself
    static public void strBufferAppend(StringBuffer str, int n){
        //区别在于，StringBuffer是可以修改的引用类型
        String s = new String(str);
        for (int i = 0; i < n; i++){
            str.append(s);
        }
    }

    //Compresses the string by shortening the same letter
    static public String strCompress(String str){
        String res = new String();
        int j = 0;
        int i = 1;
        while (i < str.length()){
            while (i != j && str.charAt(i) == str.charAt(j)){
                i++;
                if (i == str.length())
                    break;
            }
            String integer = "" + (i-j == 1 || i-j == 0 ? "" : (i-j));

            res += (str.charAt(j) + integer);
            j = i++;
        }
        return res;
    }

    //Encryts the string by move the bit of every letter
    public static String strEncryt(String str, int n){
        String s = new String();
        for (int i = 0; i < str.length(); i++){
            char curLetter = str.charAt(i);
            curLetter += n;
            s += curLetter;
        }
        return s;
    }

    //Tests if string every letter in string a is in string b
    public static boolean subText(String a, String b){
        //Use hashset to store every single character
        //and test every single character whether is in the set or not
        HashSet<String> set = new HashSet<String>();
        for (int i = 0; i < b.length(); i++){
            set.add(b.substring(i, i+1));
        }
        for (int i = 0; i < a.length(); i++){
            if (!set.contains(a.substring(i, i+1)))
                return false;
        }
        return true;
    }


    public static void main(String[] args) {
        String s = new String("aaaabbbdff");
        //print original string
        System.out.println("The original string is: " + s);

        //test strAppend()
        String appended = strAppend(s, 2);
        System.out.println("Appended string is: " + appended);

        //test strBufferAppend()
        StringBuffer sb = new StringBuffer(s);
        strBufferAppend(sb, 2);
        System.out.println("Appended stringBuffer is: " + sb);

        //test strCompress()
        String compressed = StringOperator.strCompress(s);
        System.out.println("The compressed string is: " + compressed);

        //test strEncryt()
        int offset = 3;
        String encryted = StringOperator.strEncryt(s, offset);
        System.out.println("The encryted string is(bias is " + offset +"): " + encryted);

        //test subText()
        String test1 = "abd";
        String test2 = "adg";
        System.out.println("test1(" +test1+ ")is subtext of s?: " + subText(test1, s));
        System.out.println("test2(" +test2+ ")is subtext of s?: " + subText(test2, s));
    }
}
