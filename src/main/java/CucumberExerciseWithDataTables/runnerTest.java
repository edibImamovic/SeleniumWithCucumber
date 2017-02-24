package CucumberExerciseWithDataTables;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by edibi on 16.2.2017.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty", "html:target/html/test"},
        features = "C:\\Users\\edibi\\Desktop\\selenium tests\\CucumberExercise1\\src\\main",
        tags = {"@Klix"}
)

public class runnerTest {

}
