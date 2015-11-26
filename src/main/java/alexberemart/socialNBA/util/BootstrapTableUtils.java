package alexberemart.socialNBA.util;

public class BootstrapTableUtils {

    public static Boolean getBooleanOrder(String order) {

        Boolean asc = Boolean.TRUE;

        switch (order) {
            case "asc":
                asc = Boolean.TRUE;
                break;
            case "desc":
                asc = Boolean.FALSE;
                break;
        }
        return asc;

    }
}
