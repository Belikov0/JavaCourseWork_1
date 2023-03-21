package Solution_8_textBookPractice;

import java.io.*;
import java.util.Scanner;

public class SolutionForPractice9 {
    public static void main(String[] args) throws IOException {

//        BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(System.in);
        System.out.println("请输入个数以及差值：");
        int num = in.nextInt();
        int disc = in.nextInt();
        System.out.println("请输入一串数字");
        int[] arr = new int[100];

        for (int i = 0; i < num; i++){
            arr[i] = in.nextInt();
            if (i > 0 && arr[i]-arr[i-1] > disc){
                System.out.println("数列从第" + i + "个数开始断开");
                break;
            }
            if (i == num-1){
                System.out.println("这是" + num + "个数组成的连续数列，插值为" + disc);
            }
        }

    }
}
