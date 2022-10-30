package back.constants;

import java.util.regex.Pattern;

public class ConstantValues {
    private static final String exceptionMessage = "Constants class.";

    private ConstantValues() {
        throw new IllegalStateException(exceptionMessage);
    }

    public static class URI {
        private URI() { }

        public static final String GET_ALL_CARS = "?list_length=100";
        public static final String BASE_PATH = "/api";
        public static final String GET_CARS_BY_BRAND = "/get_cars/{brand}";
        public static final String AUTH_ALL = ".*";
        public static final String ENDPOINT_TAG = "Get all Cars by brand";
    }
    public static class Error {
        private Error() { }

        public static final String ERR_COD_006 = "ERR_POP_006";
        public static final String ERR_COD_504 = "ERR_POP_504";
        public static final String ERR_COD_004 = "ERR_POP_004";

        public static final String EMPTY_DATA = "There are no items to display with the indicated query.. ";
        public static final String EMPTY_DATA_FILTER = "There are no products to display with the filter: %s";
        public static final String NOT_FORMAT_VALID = "Please enter a valid email";
        public static final String DUPLICATE_DATA = "There is already a user with this email";
        public static final String INCOMPLETE_DATA_REQUIRED =  "All fields are required in this operation";


        public static class Details {
            private Details() { }

            public static final String INVALID_INPUT_KEY = "input key: '%s' is invalid";
            public static final String SERVICE_TIMEOUT = "service has timed out while processing the information, please try again";
            public static final String ERROR = "unexpected error encountered: ";
        }
    }

    public static class Http {
        private Http() { }

        public static final String METHOD_GET = "GET";
        public static final String GET_ONLY_FORD_CARS_ENDPOINT = "%s?%s";
    }

    public static class Validate{
        public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
                Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    }
}
