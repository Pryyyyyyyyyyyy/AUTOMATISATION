package priority;

import org.junit.runners.Suite;
import org.testng.annotations.Test;
import org.testng.xml.Parser;
import org.testng.xml.XmlSuite;
import org.testng.TestNG;
/*import org.testng.annotations.Suite;*/



import java.util.List;

import static org.testng.Assert.assertTrue;


public class Priority1 {
   @Test (priority=4)
    public void a() {assertTrue(true);  }
    @Test (priority=3)
    public void b() {assertTrue(true);  }
    @Test (priority=2)
    public void c() {assertTrue(true);  }
    @Test (priority=1)
    public void d() {assertTrue(true);  }
}




