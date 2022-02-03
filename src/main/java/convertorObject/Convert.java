package convertorObject;


public abstract class Convert<T> implements IConvertor<T>{

    @Override
    public T convert(Object baseValue){
        if (baseValue instanceof String)
            return  from((String) baseValue);
        if (baseValue instanceof Character)
            return  from((Character) baseValue);
        if (baseValue instanceof Number)
            return  from((Number) baseValue);
        if (baseValue instanceof Boolean)
            return  from((Boolean) baseValue);
        throw new IllegalArgumentException("not convert from this type %s"+ baseValue.getClass());
    }


    protected abstract T from(String baseValue);
    protected abstract T from(Character baseValue);
    protected abstract T from(Boolean baseValue);
    protected abstract T from(Number baseValue);
}