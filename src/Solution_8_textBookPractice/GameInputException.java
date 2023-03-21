package Solution_8_textBookPractice;

public class GameInputException extends Throwable {
    public void menuInputError(){
        System.out.println("Error input!");
        System.out.println("Choose mode or exit: ");
    }

    public void setFasterError(){
        System.out.println("Error input!");
        System.out.print("Select who is the first: ");
    }
}
