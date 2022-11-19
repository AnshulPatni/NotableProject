import org.junit.Assert;
import org.junit.Test;


public class NotableTest {

    @Test
    public void parseNumberLowerCaseTest() {
        String testInput = "Patient presents today with several issues. Number five BMI has increased by "+
                "10% since their last visit number next patient reports experiencing dizziness several times " +
                "in the last two weeks. Number next patient has a persistent cough that hasn’t " +
                "improved for last 4 weeks Number next patient is taking drug number five several " +
                "times a week";

        String expectedOutput = "Patient presents today with several issues. \n" +
                "5. BMI has increased by 10% since their last visit \n" +
                "6. Patient reports experiencing dizziness several times in the last two weeks. \n" +
                "7. Patient has a persistent cough that hasn’t improved for last 4 weeks \n" +
                "8. Patient is taking drug number five several times a week";

        Assert.assertEquals(Notable.parse(testInput), expectedOutput);
    }

    @Test
    public void parseNumberUpperCaseTest() {
        String testInput = "Patient presents today with several issues. Number Five BMI has increased by "+
                "10% since their last visit number next patient reports experiencing dizziness several times " +
                "in the last two weeks. Number next patient has a persistent cough that hasn’t " +
                "improved for last 4 weeks Number next patient is taking drug number five several " +
                "times a week";

        String expectedOutput = "Patient presents today with several issues. \n" +
                "5. BMI has increased by 10% since their last visit \n" +
                "6. Patient reports experiencing dizziness several times in the last two weeks. \n" +
                "7. Patient has a persistent cough that hasn’t improved for last 4 weeks \n" +
                "8. Patient is taking drug number five several times a week";

        Assert.assertEquals(Notable.parse(testInput), expectedOutput);
    }

    @Test
    public void parseEmptyStringTest() {
        String testInput = "";

        String expectedOutput = "";

        Assert.assertEquals(Notable.parse(testInput), expectedOutput);
    }

}
