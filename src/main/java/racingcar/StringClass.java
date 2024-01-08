package racingcar;

public class StringClass {

    private String value;

    public StringClass(String inputString) {
        this.value = inputString;
    }

    public String[] split() {
        return value.split(",");
    }

    public String substring() {
        return value.substring(1, 4);
    }

    public char charAt(int index) {
        return value.charAt(index);
    }
}
