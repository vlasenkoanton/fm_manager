package com.avlasenko.sb.fmmanager.util.exception;

/**
 * Created by A. Vlasenko on 14.07.2016.
 */
public abstract class ExceptionUtil {

    public static void checkNotFoundByClient(int notFound, int clientId) {
        checkNotFound(notFound, "by clientId=" + clientId);
    }

    public static <T> T checkNotFoundByClient(T entry, int clientId) {
        return checkNotFound(entry, "by clientId=" + clientId);
    }

    public static <T> T checkNotFound(T entry, String msg) {
        checkNotFound(entry == null, msg);
        return entry;
    }

    public static void checkNotFound(boolean notFound, String msg) {
        if (notFound) throw new EntryNotFoundException("Can't found entry " + msg);
    }


}
