package Solution_3;
import java.lang.Integer;

//Describes a matrix using a string
public class Matrix {
    private String inArr;
    private int n;

    //Constructors
    Matrix(){}
    Matrix(String _inArr, int _n){
        this.inArr = _inArr;
        this.n = _n;
    }

    //Matrix's addition
    public String add(String inArr, int n){
        String s = new String();
        int[][] curMatrix = disposeString(this.inArr, n);
        int[][] inMatrix = disposeString(inArr, n);
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                inMatrix[i][j] += curMatrix[i][j];
                s += inMatrix[i][j];
                if (!(i == n-1 && j == n-1))
                    s += ',';
            }
        }
        return s;
    }

    //Matrix's subtraction
    public String subtraction(String inArr, int n){
        String s = new String();
        int[][] curMatrix = disposeString(this.inArr, n);
        int[][] inMatrix = disposeString(inArr, n);
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                inMatrix[i][j] -= curMatrix[i][j];
                s += inMatrix[i][j];
                if (!(i == n-1 && j == n-1))
                    s += ',';
            }
        }
        return s;
    }

    //Matrixes multiply
    public String multiply(String inArr, int n){
        String s = new String();
        int[][] curMatrix = disposeString(this.inArr, n);
        int[][] inMatrix = disposeString(inArr, n);
        int[][] resMatrix = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                for (int k = 0; k < n; k++){
                    resMatrix[i][j] += curMatrix[i][k]*inMatrix[k][j];
                }
                s += resMatrix[i][j];
                if (!(i == n-1 && j == n-1))
                    s += ',';
            }
        }
        return s;
    }

    //Matrix's rotation
    public String rotation(){
        String s = new String();
        int[][] curMatrix = disposeString(this.inArr, this.n);
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                s += curMatrix[j][i];
                if (!(i == n-1 && j == n-1))
                    s += ',';
            }
        }

        return s;
    }

    //Dispose String type matrix into a 2D-Array
    private int[][] disposeString(String inArr, int n){
        int[][] matrix = new int[n][n];
        int[] tmp = new int[n*n];
        int i = 0;
        int j = 0;
        //
        while(j < n*n) {
            int nextCommaIndex = this.inArr.indexOf(',', i);
            int curNumber = 0;
            if (nextCommaIndex != -1)
                curNumber = Integer.parseInt(this.inArr.substring(i, nextCommaIndex));
            else {
                curNumber = Integer.parseInt(this.inArr.substring(i));
            }
//            System.out.print(curNumber + " ");
            tmp[j++] = curNumber;
            i = nextCommaIndex+1;
        }
        int k = 0;
        for (i = 0; i < n; i++){
            for (j = 0; j < n; j++){
                matrix[i][j] = tmp[k++];
            }
        }
        return matrix;
    }

    public String toString(){
        return this.inArr;
    }

    public static void main(String[] args) {
        String a = new String("1,2,3,4,5,6,7,8,9");
        String b = new String(a);
        Matrix mA = new Matrix(a, 3);
        Matrix mB = new Matrix(b, 3);
        //print matrix A and B
        System.out.println("Matrix A: " + mA.toString());
        System.out.println("Matrix B: " + mB.toString());

        //test add()
        String add = mA.add(mB.inArr, 3);
        System.out.println("Matrix A add Matrix B: " + add);

        //test subtraction()
        String sub = mA.subtraction(mB.inArr, 3);
        System.out.println("Matrix A subtract Matrix B: " + sub);

        //test multiply()
        String mul = mA.multiply(mB.inArr, 3);
        System.out.println("Matrix A multiply Matrix B: " + mul);

        //test rotation()
        String rot = mA.rotation();
        System.out.println("Matrix A rotates: " + rot);
    }
}
