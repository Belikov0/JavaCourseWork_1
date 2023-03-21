package Solution_8_textBookPractice;

public class DateException extends Throwable{
    //年份出错时，异常处理调用的函数
    public void yearException(){
        System.out.print("Wrong year, reinput: ");
    }

    //月份出错时，异常处理调用的函数
    public void monthException(){
        System.out.print("Wrong month, reinput: ");
    }
}
