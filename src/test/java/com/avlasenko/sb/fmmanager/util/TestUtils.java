package com.avlasenko.sb.fmmanager.util;

import com.avlasenko.sb.fmmanager.model.BaseEntity;
import com.avlasenko.sb.fmmanager.model.Individual;

import java.util.Collection;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * Created by A. Vlasenko on 04.08.2016.
 */
public abstract class TestUtils {
    public static <T extends BaseEntity> void assertEntityEquals(T expected, T actual) {
        if (expected == null || actual == null) {
            assertEquals(expected, actual);
        } else {
            assertEquals(expected.toString(), actual.toString());
        }
    }

    public static <T extends BaseEntity> void assertCollectionEquals(Collection<T> expected, Collection<T> actual) {
        if (expected == null || actual == null) {
            assertEquals(expected, actual);
        } else {
            Collection<String> exp = expected.stream()
                    .sorted((o1, o2) -> Integer.compare(o1.getId(), o2.getId()))
                    .map(BaseEntity::toString)
                    .collect(Collectors.toList());
            Collection<String> act = actual.stream()
                    .sorted((o1, o2) -> Integer.compare(o1.getId(), o2.getId()))
                    .map(BaseEntity::toString)
                    .collect(Collectors.toList());

            assertEquals(exp, act);
        }
    }

    public static void assertDeepEquals(Individual expected, Individual actual) {
        assertEntityEquals(expected, actual);
        assertEntityEquals(expected.getAddress(), actual.getAddress());
        assertEntityEquals(expected.getWork(), actual.getWork());
        assertEntityEquals(expected.getContact(), actual.getContact());
        assertEntityEquals(expected.getEntrepreneurInfo(), actual.getEntrepreneurInfo());
        assertEntityEquals(expected.getFmInfo(), actual.getFmInfo());
        assertEntityEquals(expected.getAccOpener(), actual.getAccOpener());
        assertEntityEquals(expected.getRepresentative(), actual.getRepresentative());
        assertCollectionEquals(expected.getDocuments(), actual.getDocuments());
        assertCollectionEquals(expected.getAccounts(), actual.getAccounts());
    }
}
