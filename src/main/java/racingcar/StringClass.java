package racingcar;

public class StringClass {

    String value;

    public StringClass(String inputString) {
        this.value = inputString;
    }

    public String[] split() {
        return value.split(",");
    }

    public String substring() {
        return value.substring(1, 4);
    }
}
