package Utilities;

import java.io.IOException;
import java.time.Duration;

public class BaseDriver {


    static {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    public static void waitAndQuit() {
        MyMethods.myWait(3);
        try {
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
