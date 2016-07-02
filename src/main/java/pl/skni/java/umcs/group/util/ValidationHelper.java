package pl.skni.java.umcs.group.util;

import java.security.InvalidParameterException;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Jakub Pyda on 03.04.2016.
 */
public class ValidationHelper {

    public static void validateNotNullParams(Object... params) {
        for (Object param : params) {
            checkNotNull(param, InvalidParameterException.class);
        }
    }
}
