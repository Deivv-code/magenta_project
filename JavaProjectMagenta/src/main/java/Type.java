public enum Type {
    T("T"),
    RH("RH"),
    PM10("PM10"),
    PM2_5("PM2.5");

    private final String text;

    Type(String text) {
        this.text = text;
    }


    @Override
    public String toString() {
        return text;
    }
}
