package tests.demoqa.properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("systemTests")
public class SystemPropertiesTest {

    @Test
    void someTest1() {
        String browser = System.getProperty("browser");
        System.out.println(browser); //null
    }

    @Test
    void someTest2() {
        String browser = System.getProperty("browser", "safari");
        System.out.println(browser); //safari
    }
    @Test
    void someTest3() {
        String browser = System.getProperty("browser","opera");
        System.out.println(browser); //opera
    }

    @Test
    void someTest4() {
        System.setProperty("browser","safari");
        String browser = System.getProperty("browser","opera");
        System.out.println(browser); //safari (так как opera - только по дефолту!)
    }

    @Test
    @Tag("test5")
    void someTest5() {
        String browser = System.getProperty("browser","chrome");
        String version = System.getProperty("version","100");
        String browserSize = System.getProperty("browserSize","1920x1080");
        System.out.println(browser); //safari (так как opera - только по дефолту!)
        System.out.println(version);
        System.out.println(browserSize);
        // gradle clean test5 -Dbrowser=opera -Dversion=99 -DbrowserSize=300x300
    }

    @Test
    void someTest6() {
        System.out.println("I want to say: " + System.getProperty("message"));
    }
}
