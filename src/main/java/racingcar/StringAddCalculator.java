package racingcar;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public Map<String, String> parse(String inputString) {

        Map<String, String> resultMap = new HashMap<>();
        if (inputString == null || inputString.isEmpty()) {
            resultMap.put("delimiter", "");
            resultMap.put("inputString", "");
        } else {
            Matcher matcher = Pattern.compile("\\/\\/(.+)\\\\n(.+)").matcher(inputString);
            if (matcher.find()) {
                resultMap.put("delimiter", matcher.group(1));
                resultMap.put("inputString", matcher.group(2));
            } else {
                resultMap.put("delimiter", "[,:]");
                resultMap.put("inputString", inputString);
            }
        }
        return resultMap;
    }

    public int splitAndSum(String delimiter, String inputString) {

        if (inputString.isEmpty()) return 0;

        int sum = 0;
        for (String s : inputString.split(delimiter)) {
            try {
                int i = Integer.parseInt(s);
                if (i < 0) throw new RuntimeException("음수는 입력될 수 없습니다.");
                sum += i;
            } catch (NumberFormatException e) {
                throw new RuntimeException("숫자가 아닌 값이 입력되었습니다.");
            }
        }

        return sum;
    }
}
