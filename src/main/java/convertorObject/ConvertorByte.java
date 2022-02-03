package convertorObject;


import java.math.BigDecimal;

public class ConvertorByte extends ConvertNumber<java.lang.Byte>{

    @Override
    protected Byte from(String baseValue) {
        return Byte.valueOf(baseValue);
    }


    protected boolean checkBorders(Number baseValue) {
        return  baseValue.longValue()>= Byte.MIN_VALUE
                && baseValue.longValue() <= Byte.MAX_VALUE;
    }

    @Override
    protected Byte from(BigDecimal baseValue) {
        if (checkBorders(baseValue))
            return baseValue.byteValueExact();
        throw new IllegalArgumentException("Number is greater than allowed");
    }

    @Override
    protected Byte from(Integer baseValue) {
        if (checkBorders(baseValue))
            return baseValue.byteValue();
        throw new IllegalArgumentException("Number is greater than allowed");
    }

    @Override
    protected Byte from(Byte baseValue) {
        return baseValue;
    }

    @Override
    protected Byte from(Long baseValue) {
        if (checkBorders(baseValue))
            return baseValue.byteValue();
        throw new IllegalArgumentException("Number is greater than allowed");
    }

    @Override
    protected Byte from(Short baseValue) {
        if (checkBorders(baseValue))
            return baseValue.byteValue();
        throw new IllegalArgumentException("Number is greater than allowed");
    }

    @Override
    protected Byte from(Double baseValue) {
        if (checkBorders(baseValue))
            return baseValue.byteValue();
        throw new IllegalArgumentException("Number is greater than allowed");
    }

    @Override
    protected Byte from(Float baseValue) {
        if (checkBorders(baseValue))
            return baseValue.byteValue();
        throw new IllegalArgumentException("Number is greater than allowed");
    }
}
