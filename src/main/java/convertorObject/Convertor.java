package convertorObject;


import java.math.BigDecimal;

public class Convertor {

    private static final ConvertorInteger convertorInt = new ConvertorInteger();
    private static final ConvertorLong convertorLong = new ConvertorLong();
    private static final ConvertorByte convertorByte = new ConvertorByte();
    private static final ConvertorShort convertorShort = new ConvertorShort();
    private static final ConvertorString convertorString = new ConvertorString();
    private static final ConvertorDouble convertorDouble = new ConvertorDouble();
    private static final ConvertorFloat convertorFloat = new ConvertorFloat();
    private static final CovertortChar convertorChar = new CovertortChar();
    private static final ConvertorBigDecimal convertorBigDecimal = new ConvertorBigDecimal();

    public static Integer convertToInteger(Object obj) {
        return convertorInt.convert(obj);
    }

    public static Long convertToLong(Object obj) {
        return convertorLong.convert(obj);
    }

    public static Byte convertToByte(Object obj) {
        return convertorByte.convert(obj);
    }

    public static Short convertToShort(Object obj) {
        return convertorShort.convert(obj);
    }

    public static String convertToString(Object obj) {
        return convertorString.convert(obj);
    }

    public static Double convertToDouble(Object obj) {
        return convertorDouble.convert(obj);
    }

    public static Float convertToFloat(Object obj) {
        return convertorFloat.convert(obj);
    }

    public static Character convertToCharacter(Object obj) {
        return convertorChar.convert(obj);
    }

    public static BigDecimal convertorToBigDecimal(Object obj) {
        return convertorBigDecimal.convert(obj);
    }


}
