package priority;

import org.testng.TestNG;
import org.testng.annotations.Test;
import org.testng.xml.Parser;
import org.testng.xml.XmlSuite;

import java.io.File;
import java.io.IOException;
import java.util.List;

/*@SuiteClasses(Priority1.class)*/
public class TestSuite {

    String pathToXmlFile = "C:\\Users\\Admin\\AppData\\Roaming\\JetBrains\\IdeaIC2022.3\\scratches\\testng1.xml";
    File xmlFile = new File(pathToXmlFile);

    @Test
    public static void main(String[] args) {
        TestNG testng1 = new TestNG();
        testng1.setTestClasses(new Class[] { TestSuite.class });
        try {
            testng1.setXmlSuites((List<XmlSuite>) (new Parser("C:\\Users\\Admin\\AppData\\Roaming\\JetBrains\\IdeaIC2022.3\\scratches\\testng1.xml").parseToList()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        testng1.run();
    }
}
