package Solution_2;

//Static tool class for asserting equals
public class TestUtils {
    //Asserts if the expected string and the actual string are equal, if not, throw an exception.
    public static void assertEquals(String expected, String actual, String message){

        if (!expected.equals(actual))//Operator "==" is deprecated, method "String.equals()" is appreciated
            throw new AssertionError(message + "expecting " + expected
                    + "(" + expected.getClass() + ")" + "but got " + actual +
                    "(" + actual.getClass() + ")");
    }

    //Asserts if the expected integer and the actual integer are equal, if not, throw an exception.
    public static void assertEquals(int expected, int actual, String message){
        if (expected != actual)
            throw new AssertionError(message + "expecting " + expected
                    + "(" + (new Integer(expected)).getClass() + ")" + "but got " + actual
                    + "(" + (new Integer(actual)).getClass() + ")");
    }

    public static void main(String[] args) {
        //Tests two methods
        assertEquals("1", "2", "Strings not equal!!");
        assertEquals(1,2, "Intergers not equal!!");
    }
}
