package com.avlasenko.sb.fmmanager.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by A. Vlasenko on 14.06.2016.
 */
public class HibernateUtil {
    public final static EntityManagerFactory ENTITY_FACTORY = Persistence.createEntityManagerFactory("test_unit");

}
