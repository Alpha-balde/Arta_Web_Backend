package com.ibmap.dental.domaine;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.UUID;
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BusinessKeyGenerator {

    public static final int BK_LENGTH = 40;

    public static String generateBusinessKey(Class<?> clazz) {
        final UUID uuid = UUID.randomUUID();

        final StringBuilder sb = new StringBuilder(uuid.toString().replace("-", ""));

        if (clazz != null) {
            sb.append(Integer.valueOf(clazz.hashCode()));
        }

        boolean hasGoodLength = false;

        while (!hasGoodLength) {
            if (sb.length() < BK_LENGTH) {
                sb.append(sb);
            } else {
                hasGoodLength = true;
            }
        }

        return sb.substring(0, BK_LENGTH);
    }
}
