package convertorObject;


import java.math.BigDecimal;

public class ConvertorDouble extends ConvertNumber<java.lang.Double>{


    @Override
    protected Double from(String baseValue) {
        return Double.valueOf(baseValue);
    }

    @Override
    protected Double from(BigDecimal baseValue) {
        return baseValue.doubleValue();
    }

    @Override
    protected Double from(Integer baseValue) {
        return baseValue.doubleValue();
    }

    @Override
    protected Double from(Byte baseValue) {
        return baseValue.doubleValue();
    }

    @Override
    protected Double from(Long baseValue) {
        return baseValue.doubleValue();
    }

    @Override
    protected Double from(Short baseValue) {
        return baseValue.doubleValue();
    }

    @Override
    protected Double from(Double baseValue) {
        return baseValue;
    }

    @Override
    protected Double from(Float baseValue) {

        return baseValue.doubleValue();

    }
}
