package test.java;

import fr.anthonyrey.frontend.FrontEnd;
import fr.anthonyrey.frontend.FrontEndException;
import org.junit.Before;
import org.junit.Test;

public class FrontEndTest {
    private FrontEnd frontEnd;

    @Before
    public void init() {
        frontEnd = new FrontEnd();
    }

    @Test()
    public void nominal_case() {
        try {
            FrontEnd.main(null);
        } catch (NullPointerException e) {
        }
    }



}
