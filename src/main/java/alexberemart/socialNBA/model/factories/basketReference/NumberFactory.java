package alexberemart.socialNBA.model.factories.basketReference;

public class NumberFactory {

    public Integer parseToInteger(String number) {
        if (number == null){
            return 0;
        }
        return Integer.parseInt(number);
    }
}
