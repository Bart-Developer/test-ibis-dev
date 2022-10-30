package back.constants;

import back.exception.NotFoundException;

public enum CarBrand {

    FORD("FORD", false),
    VOLKSWAGEN("VOLKSWAGEN", false),
    PEUGEOT("PEUGEOT", false);

    private String value;

    private boolean isNumber;

    private CarBrand(String value, boolean isNumber) {
        this.value = value;
        this.isNumber = isNumber;
    }

    public static CarBrand findValue(String value) throws NotFoundException {
        CarBrand result = null;
        for (CarBrand doc : CarBrand.values()) {
            if (doc.value().equals(value)) {
                result = doc;
                break;
            }
        }
        if (result == null) {
            throw new NotFoundException();
        }
        return result;
    }

    public String value() {
        return value;
    }

    public boolean isNumber() {
        return isNumber;
    }
}
