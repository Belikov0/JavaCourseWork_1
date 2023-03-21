package Solution_8_textBookPractice;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class SolutionForPractice6 {
    //使用枚举类表示月份
    public enum month {January, February, March, April, May, June, July, August,
        September, October, November, December;};
    //数组存储每个月的天数
    static int[] days = {31, 28, 31, 30, 31, 30 ,31, 31, 30, 31, 30, 31};
    //判断是否是闰年
    public static boolean isLeap(int y){
        return (y%4 == 0 && y%100 != 0) || y%400 == 0;
    }
    //根据输入的年份和月份，获取对应年月的天数
    public static void findDays(int y, month m){
        // 如果是2月且是闰年，则要加一天
        //使用枚举的顺序在days[]中获取月份的天数
        int res = days[m.ordinal()] + (isLeap(y) && m == month.February ? 1 : 0);
        System.out.println(m.toString() + ", " + y + " has " + res + " days.");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int y = 0;
        month m = month.January;
//输入输出语句

        //输入年份并检测输入异常
        System.out.print("Input year: ");
        boolean isFalseInput = true;
        while(isFalseInput){
            try {
                y = in.nextInt();
                if (y < 0 ){
                    throw new DateException();
                }else {
                    isFalseInput = false;
                }
            }catch (DateException e){
                e.yearException();
            }
        }

        //输入月份并检测输入异常
        System.out.print("Input the month: ");
        isFalseInput = true;
        while(isFalseInput){
            try{
                int monthNumber = in.nextInt();
                if (monthNumber <= 0 || monthNumber > 12){
                    throw new DateException();
                }else{
                    m = month.values()[monthNumber-1];
                    isFalseInput = false;
                }
            }catch (DateException e){
                e.monthException();
            }
        }

        //调用函数输出结果
        findDays(y, m);
    }
}
