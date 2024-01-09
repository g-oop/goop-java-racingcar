package util;

public class InputStringParser {

    private InputStringParser() { }

    public static String[] splitInput(String input) {
        int length = input.length();
        int beginIndex = input.charAt(0) == '(' ? 1 : 0;
        int endIndex = input.charAt(length - 1) == ')' ? length - 1 : length;
        return input.substring(beginIndex, endIndex).split(",");
    }
}
