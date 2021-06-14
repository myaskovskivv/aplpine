package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
    private final Properties properties = new Properties();
    private static TestProperties INSTANCE = null;
    private TestProperties(){
        try {
            System.out.println(System.getProperty("environment")); // почему то выводит Null из за этого заменил на прямой путь.
            // хотя одно время работало, а потом почему то перестало.
            // Хотя все установил в системную переменную путь к properties файлу
            //mvn clean -Denvironment=application test
            // эта запись перестала работать
            //properties.load(new FileInputStream(new File("./" + System.getProperty("environment") + ".properties")));
            properties.load(new FileInputStream(new File("C:/projects/firsttest/environment.properties")));



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static TestProperties getInstance() {
        if (INSTANCE == null){
            INSTANCE = new TestProperties();
        }
        return INSTANCE;
    }
    public Properties getProperties() {
        return properties;
    }

}
