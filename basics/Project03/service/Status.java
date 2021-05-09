package Project03.service;

public class Status {
    private final String NAME;
    public Status(String name) {
        this.NAME = name;
    }
    public static final Status FREE = new Status("FREE");
    public static final Status VOCATION = new Status("VOCATION");
    public static final Status BUSY = new Status("BUSY");

    public String getNAME() {
        return NAME;
    }

    @Override
    public String toString() {
//        return "Status{" +
//                "NAME='" + NAME + '\'' +
//                '}';
        return NAME;
    }
}
