package Solution_1;

//Describes a point in a 2D plane
public class Position {
    private int x;
    private int y;

    //Non-parameter constructor
    Position(){
        this.x = 0;
        this.y = 0;
    }
    //Constructor
    Position(int _x, int _y){
        this.x = _x;
        this.y = _y;
    }
    //Copy constructor
    Position(Position _p){
        this.x = _p.x;
        this.y = _p.y;
        System.out.println("Copy constructor is called.");
    }
    //Getters
    int getX(){
        return this.x;
    }

    int getY(){
        return this.y;
    }

    //Moves the point from (x, y) to (x+dx, y+dy)
    Position move(int dx, int dy){
        this.x += dx;
        this.y += dy;
        System.out.println("Move method is called.");
        return this;
        //Question: modify itself or return a new object
    }

    //Gets the distance between the caller and the parameter p
    public double distance(Position p){
        return Math.sqrt((double) (this.x-p.x)*(this.x-p.x)+(this.y-p.y)*(this.y-p.y));
    }

    //Scales a point as a vector by f times
    public Position scale(int f){
        this.x *= f;
        this.y *= f;
        System.out.println("Scale method is called.");
        return this;
    }

    @Override
    public String toString(){
        return new String("(" + this.x + ", " + this.y + ")");
    }
}
