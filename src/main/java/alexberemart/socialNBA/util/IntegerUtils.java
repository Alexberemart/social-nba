package alexberemart.socialNBA.util;

public class IntegerUtils {

    public static Integer boundsChecking(Integer value) {

        if ((value == null) || (value < 0)) {
            value = 0;
        }

        return value;
    }
}
