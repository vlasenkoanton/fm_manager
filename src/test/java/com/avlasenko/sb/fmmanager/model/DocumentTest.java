package com.avlasenko.sb.fmmanager.model;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Created by A. Vlasenko on 29.07.2016.
 */
@RunWith(JUnitParamsRunner.class)
public class DocumentTest {
    private static final Object[] getDocument() {
        return new Object[]{
                new Object[]{
                        new Document(1, "passport", "hg", 125874L),
                        new Document(1, "passport", "hg", 125874L)
                },
                new Object[]{
                        new Document(1, null, "hg", 125874L),
                        new Document(1, null, "hg", 125874L)
                },
                new Object[]{
                        new Document(1, "passport", null, 125874L),
                        new Document(1, "passport", null, 125874L)
                }
        };
    }

    @Test
    @Parameters(method = "getDocument")
    public void testEquals(Document d1, Document d2) throws Exception {
        assertEquals(d1, d2);
    }

    @Test
    @Parameters(method = "getDocument")
    public void testHashCode(Document d1, Document d2) throws Exception {
        assertEquals(d1.hashCode(), d2.hashCode());
    }

    @Test
    @Parameters(method = "getDocument")
    public void testEqualWithMeaninglessField(Document d1, Document d2) throws Exception {
        d1.setAuthority("authority");
        assertEquals(d1, d2);
    }

    @Test
    @Parameters(method = "getDocument")
    public void testHashCodeWithMeaninglessField(Document d1, Document d2) throws Exception {
        d1.setAuthority("authority");
        assertEquals(d1.hashCode(), d2.hashCode());
    }
}