import java.util.Map;

public class Notable {

    private static final String numberText = "number";
    private static final Map<String, Integer> numberMap = Map.of(
            "one", 1,
            "two", 2,
            "three", 3,
            "four", 4,
            "five", 5,
            "six", 6,
            "seven", 7,
            "eight", 8,
            "nine", 9);
    public static void main(String[] args) {

        System.out.println(parse("Patient presents today with several issues. Number five BMI has increased by "+
                "10% since their last visit number next patient reports experiencing dizziness several times " +
                "in the last two weeks. Number next patient has a persistent cough that hasn’t " +
                "improved for last 4 weeks Number next patient is taking drug number five several " +
                "times a week"));

    }

    public static String parse(String text) {
        if(text.isEmpty())
            return text;
        StringBuilder sb = new StringBuilder();

        // Split the input text with string "number"
        String[] textArray = text.split("(?i)number");

        // Add the first part of the text before first occurrence of string "number"
        sb.append(textArray[0]).append("\n");

        // Find the actual number "n"
        String actualNumber = textArray[1].split(" ")[1];
        int value = numberMap.get(actualNumber.toLowerCase());
        int index = text.indexOf(actualNumber);

        text = text.substring(index + actualNumber.length());

        // Split the input text with string "number"
        String[] splitArr =  text.split("(?i)number next");

        for(int i = 0; i < splitArr.length - 1; i++) {
            sb.append(String.valueOf(value))
                    .append(".").append(" ")
                    .append(splitArr[i].substring(1, 2).toUpperCase())
                    .append(splitArr[i].substring(2));
            sb.append("\n");
            value++;
        }

        sb.append(String.valueOf(value))
                .append(".").append(" ")
                .append(splitArr[splitArr.length - 1].substring(1, 2).toUpperCase())
                .append(splitArr[splitArr.length - 1].substring(2));

        return sb.toString();
    }

}

