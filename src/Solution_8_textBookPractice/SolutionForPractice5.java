package Solution_8_textBookPractice;

public class SolutionForPractice5 {
    //判断两次投掷是否是Snake Eyes, 如果是则返回True
    public static boolean isSnakeEyes(int first, int second){
        return first == 1 && second == 1;
    }

    public static void main(String[] args){
        int first = 0;  //设置初值进入循环
        int second = 0;
        int cnt = 0;    //记录投掷的次数
        //当不是SnakeEyes时, 重复投掷
        while (!isSnakeEyes(first, second)){
            cnt++;
            first = SolutionForPractice4.dice();
            second = SolutionForPractice4.dice();
            //显示当前投掷的结果
            //printing current dice result
            System.out.println(cnt +" time(s): " + first + "  " + second);
        }
        //打印直到出现Snake Eyes时投掷的次数
        System.out.println("Dicing times until snake eys: " + cnt);
    }
}
