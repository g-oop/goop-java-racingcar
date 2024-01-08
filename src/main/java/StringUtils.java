import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringUtils {
    private static final Set<Integer> targetBrackets;

    static {
        targetBrackets = Stream
                .of('(', ')')
                .map(v->(int) v)
                .collect(Collectors.toSet());
    }

    public static String[] splitByComma(String t){
        return t.split(",");
    }

    public static String removeBracket(String t){
        return t.chars()
                .filter(nc -> !targetBrackets.contains(nc))
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public static char charAt(String t, int i){
        if(t.length() <= i) {
            throw new IndexOutOfBoundsException(){
                @Override
                public String getMessage() {
                    return String.format("Index: %d, Size: %d", t.length(), i);
                }
            };
        }
        return t.charAt(i);
    }
}
