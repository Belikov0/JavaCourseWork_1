package Solution_1;

public class PositionTest {
    public static void main(String[] args) {
        //Create an array containing point arr[0], arr[1] and arr[2] as a, b and c respectively
        Position[] arr = new Position[3];
        arr[0] = new Position(0,0);
        arr[1] = new Position(4,3);
        arr[2] = new Position(12,9);

        //Prints original coordinates
        System.out.println("Initial positions: ");
        System.out.println("a: "+arr[0].toString());
        System.out.println("b: "+arr[1].toString());
        System.out.println("c: "+arr[2].toString() + "\n");

        //Moves a to b
        arr[0].move(arr[1].getX()-arr[0].getX(), arr[1].getY()-arr[0].getY());
        System.out.println("After moving, a's position: " + arr[0].toString() + "\n");

        //Stretches(sacles) b
        arr[1].scale(arr[2].getX()/arr[1].getX());
        System.out.println("After stretching, b's position: " + arr[1].toString() + "\n");

        //Calculates distances
        System.out.println("Distance between a and b is: " + arr[0].distance(arr[1]));
        System.out.println("Distance between b and c is: " + arr[1].distance(arr[2]));
        System.out.println("Distance between a and c is: " + arr[2].distance(arr[0]) + "\n");

        //Tests copy constructor
        Position copyB = new Position(arr[1]);
        System.out.println("b's position: " + arr[1].toString());
        System.out.println("copyB's position: " + copyB.toString());
    }
}
