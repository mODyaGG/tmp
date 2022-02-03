package convertorObject;


public class ConvertorString extends Convert<String> {
    @Override
    protected String from(String baseValue) {
        return baseValue;
    }

    @Override
    protected String from(Character baseValue) {
        return baseValue.toString();
    }

    @Override
    protected String from(Boolean baseValue) {
        return baseValue.toString();
    }

    @Override
    protected String from(Number baseValue) {
        return baseValue.toString();
    }
}
