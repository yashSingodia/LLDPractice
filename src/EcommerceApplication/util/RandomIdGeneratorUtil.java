package EcommerceApplication.util;

import java.util.UUID;

public class RandomIdGeneratorUtil {
    public static String generateId() {
        return UUID.randomUUID().toString();
    }
}
