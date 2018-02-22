package test.java;

import fr.anthonyrey.frontend.FrontEnd;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import static org.junit.Assert.*;

public class FrontEndTest {
    Scanner scan = new Scanner(System.in);
    FrontEnd fe = new FrontEnd();
    @Before
    public void setUp() throws Exception {
        String str = "3";
        InputStream is = new ByteArrayInputStream(str.getBytes("UTF-8"));
        try {
            System.setIn(is);
        } finally {
            System.setIn(System.in);
        }
    }

    /*
    @Test
    public void main() {
        try {
            fe.main(null);
        } catch(NullPointerException e) {
            assertTrue(true);
        }
    }
    */
}