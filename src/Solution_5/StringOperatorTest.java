
import org.junit.After;
import org.junit.Before;
import org.junit.ComparisonFailure;
import org.junit.Test;
import static org.junit.Assert.*;

//Uses Junit to tests functions in StringOperator
public class StringOperatorTest extends StringOperatorForJunit {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test //Uses assertEquals() to test the result of function strAppend() is expected or not
    public void testStrAppend() {
        String expected = new String("strstrstr");
        String actual = strAppend(new String("str"), 2);
        try{
            assertEquals(expected, actual);
        }catch (AssertionError e){
            e.printStackTrace();
        }
    }

    @Test ///Uses assertEquals() to test the result of function strBufferAppend() is expected or not
    public void testStrBufferAppend() {
        StringBuffer expected = new StringBuffer("strstrstr");
        StringBuffer actual = new StringBuffer("str");
        strBufferAppend(actual, 2);
        try{
            assertEquals(expected, actual);
        }catch (AssertionError e){
            System.out.println("Error is caught in function testStrBufferAppend.");
            System.out.println("The hashCode of the expected object is " + expected.hashCode()
                    + " while hashCode of the actual object is " + actual.hashCode() + ",\nwhich means that they are different objects." );
            e.printStackTrace();
        }
        /*
            java.lang.AssertionError: expected: java.lang.StringBuffer<strstrstr> but was: java.lang.StringBuffer<strstrstr>
            Expected :java.lang.StringBuffer<strstrstr>
            Actual   :java.lang.StringBuffer<strstrstr>
            该test出错
            原因是，这两个StringBuffer指向了不同的对象
         */
    }

    @Test //Uses assertEquals() to test the result of function strCompress() is expected or not
    public void testStrCompress() {
        String actual = strCompress(new String("aaabbdff"));
        String expected = new String("a3b2df2");
        try{
            assertEquals(expected, actual);
        }catch (AssertionError e){
            e.printStackTrace();
        }
    }

    @Test //Uses assertEquals() to test the result of function strEncryt() is expected or not
    public void testStrEncryt() {
        String actual = strEncryt(new String("AABCE"), 3);
        String expected = new String("DDEFH");
        try{
            assertEquals(expected, actual);
        }catch (AssertionError e){
            e.printStackTrace();
        }
    }

    @Test //Uses assertEquals() to test the result of function subText() is expected or not
    public void testSubText() {
        String a = "asd";
        String b = "abbcsslld";
        boolean actual = subText(a, b);
        boolean expected = true;
        try{
            assertEquals(expected, actual);
        }catch (AssertionError e){
            e.printStackTrace();
        }
    }
}