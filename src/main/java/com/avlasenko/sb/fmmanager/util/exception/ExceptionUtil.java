package com.avlasenko.sb.fmmanager.util.exception;

/**
 * Created by A. Vlasenko on 14.07.2016.
 */
public abstract class ExceptionUtil {

    public static void checkNotFoundByOwner(boolean found, int ownerId) {
        checkNotFound(found, "by ownerId=" + ownerId);
    }

    public static <T> T checkNotFoundByOwner(T entry, int ownerId) {
        return checkNotFound(entry, "by ownerId=" + ownerId);
    }

    public static <T> T checkNotFound(T entry, String msg) {
        checkNotFound(entry != null, msg);
        return entry;
    }

    public static void checkNotFound(boolean found, String msg) {
        if (!found) throw new EntryNotFoundException("Can't found entry " + msg);
    }
}
