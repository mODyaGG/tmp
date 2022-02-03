package convertorObject;


import java.math.BigDecimal;

public class ConvertorShort extends ConvertNumber<java.lang.Short>{
    @Override
    protected Short from(String baseValue) {
        return Short.valueOf(baseValue);
    }

    protected boolean checkBorders(Number baseValue) {
        return  baseValue.longValue()> Short.MIN_VALUE
                && baseValue.longValue() < Short.MAX_VALUE;
    }

    @Override
    protected Short from(BigDecimal baseValue) {
        if (checkBorders(baseValue))
            return baseValue.shortValueExact();
        throw new IllegalArgumentException("Number is greater than allowed");
    }

    @Override
    protected Short from(Integer baseValue) {
        if (checkBorders(baseValue))
                return baseValue.shortValue();
        throw new IllegalArgumentException("Number is greater than allowed");
    }

    @Override
    protected Short from(Byte baseValue) {
        return baseValue.shortValue();

    }

    @Override
    protected Short from(Long baseValue) {
        if (checkBorders(baseValue))
            return baseValue.shortValue();
        throw new IllegalArgumentException("Number is greater than allowed");
    }

    @Override
    protected Short from(Short baseValue) {
        return baseValue;
    }

    @Override
    protected Short from(Double baseValue) {
        if (checkBorders(baseValue))
            return baseValue.shortValue();
        throw new IllegalArgumentException("Number is greater than allowed");
    }

    @Override
    protected Short from(Float baseValue) {
        if (checkBorders(baseValue))
            return baseValue.shortValue();
        throw new IllegalArgumentException("Number is greater than allowed");
    }
}
