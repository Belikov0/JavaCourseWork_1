package Solution_8_textBookPractice;

//Describes a corporation's employee's working hour and salary
public class Corporation {
    public static void getSalary(double salaryPerHour, double hours){
        if (salaryPerHour < 8){
            System.out.println("Error hourly wage.");
            return;
        }
        if (hours > 60){
            System.out.println("Error hours.");
            return;
        }
        double total = (hours > 40) ? 40*salaryPerHour+(hours-40)*salaryPerHour*1.5 : hours*salaryPerHour;
        System.out.println("The total salary is:"+total);
    }
}
