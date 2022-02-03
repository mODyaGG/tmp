package convertorObject;

import java.math.BigDecimal;

public class ConvertorLong extends  ConvertNumber<Long>{

    protected boolean checkBorders(Number baseValue) {
        return  baseValue.doubleValue()> Long.MIN_VALUE
                && baseValue.doubleValue() < Long.MAX_VALUE;
    }

    @Override
    protected Long from(String baseValue) {
        return Long.valueOf(baseValue);
    }

    @Override
    protected Long from(BigDecimal baseValue) {
        if(checkBorders(baseValue))
            return baseValue.longValueExact();
        throw new IllegalArgumentException("Number is greater than allowed");
    }

    @Override
    protected Long from(Integer baseValue) {

        return (baseValue.longValue());
    }

    @Override
    protected Long from(Byte baseValue) {
        return baseValue.longValue();
    }

    @Override
    protected Long from(Long baseValue){
        return baseValue;
    }

    @Override
    protected Long from(Short baseValue) {
        return baseValue.longValue();
    }

    @Override
    protected Long from(Double baseValue){
        return baseValue.longValue();
    }

    @Override
    protected Long from(Float baseValue){
        return baseValue.longValue();
    }
}
