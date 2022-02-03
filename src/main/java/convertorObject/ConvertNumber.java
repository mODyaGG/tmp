package convertorObject;




import java.math.BigDecimal;

public abstract class ConvertNumber<T extends Number> extends Convert<T>{

    @Override
    protected T from(Number baseValue){
        if (baseValue instanceof Integer)
            return from((Integer) baseValue);
        if (baseValue instanceof Short)
            return from((Short) baseValue);
        if (baseValue instanceof Long)
            return from((Long) baseValue);
        if (baseValue instanceof Byte)
            return from((Byte) baseValue);
        if (baseValue instanceof Double)
            return from((Double) baseValue);
        if (baseValue instanceof Float)
            return from((Float) baseValue);
        if (baseValue instanceof BigDecimal)
            return from((BigDecimal) baseValue);
        throw new IllegalArgumentException("Type is not smart" + baseValue.getClass());
    }


    @Override
    protected T from(Character baseValue){
        return from(Character.getNumericValue(baseValue));
    }

    protected T from(Boolean baseValue){
        if(baseValue)
            return from(1);
        return from(0);
    }

    protected abstract T from(BigDecimal baseValue);
    protected abstract T from(Integer baseValue);
    protected abstract T from(Byte baseValue);
    protected abstract T from(Long baseValue);
    protected abstract T from(Short baseValue);
    protected abstract T from(Double baseValue);
    protected abstract T from(Float baseValue);
}
