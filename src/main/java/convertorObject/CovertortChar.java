package convertorObject;

public class CovertortChar extends Convert<java.lang.Character>{
    @Override
    protected Character from(String baseValue) {
        if(baseValue.length()== 1)
        {
            return baseValue.charAt(0);
        }
        throw new IllegalArgumentException("Cannot convert to character");
    }

    @Override
    protected Character from(Character baseValue) {
        return baseValue;
    }

    @Override
    protected Character from(Boolean baseValue) {
        if(baseValue)
            return from(1);
        return from(0);
    }

    @Override
    protected Character from(Number baseValue) {
        if (baseValue instanceof Integer && baseValue.intValue()>0 && baseValue.intValue()<=65535) {
            return (char) baseValue.intValue();
        }
        if (baseValue instanceof Short && baseValue.shortValue()>0) {
            return (char) baseValue.shortValue();
        }
        if (baseValue instanceof Long  && baseValue.intValue()>0 && baseValue.intValue()<=65535) {
            return (char) baseValue.intValue();
        }
        if (baseValue instanceof Byte && baseValue.byteValue()>0) {
            return  (char) baseValue.intValue();
        }
        throw new IllegalArgumentException("Type not supported " + baseValue.getClass());
    }
}
