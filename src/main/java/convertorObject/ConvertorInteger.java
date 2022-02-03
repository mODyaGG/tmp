package convertorObject;


import java.math.BigDecimal;

public class ConvertorInteger extends ConvertNumber<java.lang.Integer> {

    @Override
    protected Integer from(String baseValue) {

        return Integer.valueOf(baseValue);
    }

    @Override
    protected Integer from(BigDecimal baseValue) {
        if(checkBorders(baseValue))
            return baseValue.intValueExact();
        throw new IllegalArgumentException("Number is greater than allowed");
    }

    @Override
    protected Integer from(Integer baseValue) {
        return baseValue;
    }

    @Override
    protected Integer from(Byte baseValue) {

        return  baseValue.intValue();
    }

    @Override
    protected Integer from(Long baseValue) {
        if(checkBorders(baseValue))
            return baseValue.intValue();
        throw new IllegalArgumentException("Number is greater than allowed");
    }

    @Override
    protected Integer from(Short baseValue) {
        return baseValue.intValue();
    }

    @Override
    protected Integer from(Double baseValue) {
        if (checkBorders(baseValue))
            return baseValue.intValue();
        throw new IllegalArgumentException("Number is greater than allowed");
    }

    @Override
    protected Integer from(Float baseValue) {
        if(checkBorders(baseValue))
            return baseValue.intValue();
        throw new IllegalArgumentException("Number is greater than allowed");
     }

    protected boolean checkBorders(Number baseValue){
        return  baseValue.doubleValue()> Integer.MIN_VALUE
                && baseValue.doubleValue() < Integer.MAX_VALUE;
    }
}
