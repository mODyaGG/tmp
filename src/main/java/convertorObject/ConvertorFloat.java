package convertorObject;

import java.math.BigDecimal;

public class ConvertorFloat extends ConvertNumber<java.lang.Float>{

    @Override
    protected Float from(String baseValue) {
        return Float.valueOf(baseValue);
    }


    protected boolean checkBorders(Number baseValue) {
        return  baseValue.doubleValue()> Float.MIN_VALUE
                && baseValue.doubleValue() < Float.MAX_VALUE;
    }

    @Override
    protected Float from(BigDecimal baseValue) {
        if (checkBorders(baseValue))
            return baseValue.floatValue();
        throw new IllegalArgumentException("Number is greater than allowed");
    }

    @Override
    protected Float from(Integer baseValue) {
        return baseValue.floatValue();
    }

    @Override
    protected Float from(Byte baseValue) {
        return baseValue.floatValue();
    }

    @Override
    protected Float from(Long baseValue) {
        return baseValue.floatValue();
    }

    @Override
    protected Float from(Short baseValue) {
        return baseValue.floatValue();
    }

    @Override
    protected Float from(Double baseValue) {
        return baseValue.floatValue();
    }

    @Override
    protected Float from(Float baseValue) {
        return baseValue;
    }
}
