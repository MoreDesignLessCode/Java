package com.cvshealth.mscoe.common.types;

import java.util.UUID;

public final class Uuid {

    public static class UuidType {
        private final String value;

        private UuidType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public static UuidType Uuid() {
        return new UuidType(UUID.randomUUID().toString());
    }

    public static UuidType parseUuid(String uuid) {
        if (UUID.fromString(uuid) != null) {
            return new UuidType(uuid);
        }
        throw new IllegalArgumentException("Invalid UUID");
    }
}
