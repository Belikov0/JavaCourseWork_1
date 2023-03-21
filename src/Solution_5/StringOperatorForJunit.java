import java.util.HashSet;

public class StringOperatorForJunit {
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
        //Distinction: StringBuffer is a variable type while String is not.
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
}
