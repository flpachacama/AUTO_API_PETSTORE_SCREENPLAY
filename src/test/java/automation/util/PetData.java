package automation.util;

import java.util.concurrent.ThreadLocalRandom;

public final class PetData {

    private PetData() {
    }

    public static long randomPetId() {
        return ThreadLocalRandom.current().nextLong(1_000_000L, 9_999_999L);
    }
}
