package Solution_8_textBookPractice;
import java.lang.*;
public class SolutionForPractice4 {
    public static int dice(){
        //Math.random()随机获取一个在[0,1)之间的数
        //(Math.random()*6+1)随机获得一个在[1,7)之间的数
        //强制转换为byte后可以等概率随机获得自然数1~6
        return (byte)(Math.random()*6+1);
    }

    public static void main(String[] args){
        //投掷第一次
        int first = dice();
        //投掷第二次
        int second = dice();

        //按照要求打印结果
        System.out.println("The first dice comes up "+first);
        System.out.println("The second dice comes up "+second);
        System.out.println("Your total roll is "+(first+second));
        System.out.println("Your average roll is "+(int)((first+second)/2.0));
    }
}
