package convertorObject;


import java.math.BigDecimal;

public class ConvertorBigDecimal extends ConvertNumber<BigDecimal> {
    @Override
    protected BigDecimal from(String baseValue) {
        return new BigDecimal(baseValue);
    }

    @Override
    protected BigDecimal from(BigDecimal baseValue) {
        return baseValue;
    }

    @Override
    protected BigDecimal from(Integer baseValue) {
        return new BigDecimal(baseValue);
    }

    @Override
    protected BigDecimal from(Byte baseValue) {
        return new BigDecimal(baseValue);
    }

    @Override
    protected BigDecimal from(Long baseValue) {
        return new BigDecimal(baseValue);
    }

    @Override
    protected BigDecimal from(Short baseValue) {
        return new BigDecimal(baseValue);
    }

    @Override
    protected BigDecimal from(Double baseValue) {
        return new BigDecimal(baseValue);
    }

    @Override
    protected BigDecimal from(Float baseValue) {
        return new BigDecimal(baseValue);
    }
}
