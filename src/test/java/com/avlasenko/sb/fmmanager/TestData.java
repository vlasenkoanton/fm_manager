package com.avlasenko.sb.fmmanager;

import com.avlasenko.sb.fmmanager.model.*;
import com.avlasenko.sb.fmmanager.util.DateTimeUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by A. Vlasenko on 02.08.2016.
 */
public class TestData {
    public static Integer NONEXISTENT_ID = 500;

    public static final Address ADDRESS_1 = new Address(1, 111111, 980, "Cherkaska", "", "Cherkasy", "Sumgaitska", 45, 23);
    public static final Address ADDRESS_2 = new Address(2, 222222, 980, "", "", "Kyiv", "P. Kurinnogo", 5, 6);
    public static final Address ADDRESS_3 = new Address(3, 333333, 980, "Cherkaska", "Chygyrynsryi", "s. Borovytsya", "Golovna", 25, null);
    public static final Address ADDRESS_NEW = new Address(null, 444444, 333, "New region", "New district", "New city", "New street", 7, 7);
    public static final Address ADDRESS_1_UPDATED = new Address(1, 444444, 444, "Upd region", "Upd district", "Upd city", "Upd street", 8, 8);

    public static final Work WORK_1 = new Work(1, "First Corporation", 236589, "Programmer");
    public static final Work WORK_2 = new Work(2, "Second Company", 158421, "Lawyer");
    public static final Work WORK_3 = new Work(3, "Commercial Bank", 256348, "Client service specialist");
    public static final Work WORK_NEW = new Work(null, "New Corporation", 23654, "New Programmer");
    public static final Work WORK_1_UPDATED = new Work(1, "Upd First Corporation", 85236, "Upd Programmer");

    public static final Contact CONTACT_1 = new Contact(1, "044-254-44-55", "044-125-52-63", "063-562-32-52", null, "anton_antonenko@e.mail");
    public static final Contact CONTACT_2 = new Contact(2, "044-222-20-39", "044-564-99-21", "050-503-78-87", null, "ivan_ivanenko@e.mail");
    public static final Contact CONTACT_3 = new Contact(3, "044-325-32-47", "044-889-02-31", "073-564-22-13", null, "petr_petrenko@e.mail");
    public static final Contact CONTACT_NEW = new Contact(null, "044-444-44-44", "033-333-33-33", "063-663-63-63", "fax", "new@e.mail");
    public static final Contact CONTACT_1_UPDATED = new Contact(1, "782872", "36872", "68752578", null, "5875");

    public static final EntrepreneurInfo ENTREPRENEUR_INFO_1 = new EntrepreneurInfo(1, 123654789, "fop registration", DateTimeUtils.toLocalDate("2006-3-26"), "legal activity");
    public static final EntrepreneurInfo ENTREPRENEUR_INFO_2 = new EntrepreneurInfo(2, 456213048, "authority", DateTimeUtils.toLocalDate("2008-9-9"), "second activity");
    public static final EntrepreneurInfo ENTREPRENEUR_INFO_NEW = new EntrepreneurInfo(null, 89658521, "new registration", DateTimeUtils.toLocalDate("2014-8-26"), "new activity");
    public static final EntrepreneurInfo ENTREPRENEUR_INFO_1_UPDATED = new EntrepreneurInfo(1, 9658965, "upd registration", DateTimeUtils.toLocalDate("2008-3-10"), "upd activity");

    public static final FmInfo FM_INFO_1 = new FmInfo(1, "normal client", new IncomeSources(1200000L, 200000L, 0L, 0L, 100000L, 900000L));
    public static final FmInfo FM_INFO_2 = new FmInfo(2, "all right", new IncomeSources(1500000L, 0L, 500000L, 0L, 0L, 700000L));
    public static final FmInfo FM_INFO_3 = new FmInfo(3, "suspicious activity that not relates to month income", new IncomeSources(2800000L, 300000L, 0L, 150000L, 350000L, 2000000L));
    public static final FmInfo FM_INFO_NEW = new FmInfo(null, "new client", new IncomeSources(1200L, 140000L, 10000L, 100L, 1200000L, 9900000L));
    public static final FmInfo FM_INFO_1_UPDATED = new FmInfo(1, "upd client", new IncomeSources(11200000L, 1200000L, 10L, 10L, 1100000L, 1900000L));

    public static final User USER_1 = new User(1, "user", "user123", "Employee", "Employ", "Employevich", "18-25", "senior client manager", new HashSet<>(Arrays.asList(UserRole.ROLE_USER)));

    public static final Individual INDIVIDUAL_1 = new Individual(1, true, "Anton", "Antonenko", "Antonovych", "12365474", DateTimeUtils.toLocalDate("1988-5-5"), "Cherkassy", true, 980, false, DateTimeUtils.toLocalDate("2016-6-18"));
    public static final Individual INDIVIDUAL_2 = new Individual(2, true, "Ivan", "Ivanenko", "Ivanovych", "25412548", DateTimeUtils.toLocalDate("1994-7-24"), "Cherkassy", true, 980, false, DateTimeUtils.toLocalDate("2016-6-22"));
    public static final Individual INDIVIDUAL_3 = new Individual(3, true, "Petr", "Petrenko", "Petrovych", "45216", DateTimeUtils.toLocalDate("1986-2-15"), "Chernigov", true, 980, false, DateTimeUtils.toLocalDate("2016-7-21"));
    public static final Individual INDIVIDUAL_CLEAN = new Individual(4, true, "Carl", "Johns", "", "1235789651", DateTimeUtils.toLocalDate("1985-7-27"), "Alaska", false, 840, false, DateTimeUtils.toLocalDate("2016-8-5"));
    public static final Individual INDIVIDUAL_NEW = new Individual(5, true, "Vasilii", "Vasilenko", "Vasilovych", "566556", DateTimeUtils.toLocalDate("1990-5-5"), "B. Tserkva", true, 980, false, DateTimeUtils.toLocalDate("2016-8-3"));
    public static final Individual INDIVIDUAL_1_COPY = new Individual(1, true, "Anton", "Antonenko", "Antonovych", "12365474", DateTimeUtils.toLocalDate("1988-5-5"), "Cherkassy", true, 980, false, DateTimeUtils.toLocalDate("2016-6-18"));
    public static final Individual INDIVIDUAL_1_UPDATED = new Individual(5, "Anton", "Antonenko", "Antonovych", "12365474", DateTimeUtils.toLocalDate("1988-5-5"), "Cherkassy", true, 980, false);

    public static final Individual PROXY = new Individual(null, false, "proxy", "prox", "pro", "1233211478", LocalDate.now(), "proxyland", true, 999, false, LocalDate.now());

    public static final Document DOCUMENT_1 = new Document(1, 1, true, "National Passport", "KK", 123654, "some authority", DateTimeUtils.toLocalDate("1996-5-8"), null);
    public static final Document DOCUMENT_2 = new Document(2, 1, true, "National Passport", "FF", 456932, "some another authority", DateTimeUtils.toLocalDate("2005-8-28"), null);
    public static final Document DOCUMENT_3 = new Document(3, 2, false, "Foreign Passport", "GR", 1254874, "foreign embassy", DateTimeUtils.toLocalDate("2010-2-1"), DateTimeUtils.toLocalDate("2020-1-31"));
    public static final Document DOCUMENT_NEW = new Document(null, 1, true, "New Passport", "NN", 123654, "New authority", DateTimeUtils.toLocalDate("1997-5-18"), null);
    public static final Document DOCUMENT_1_UPDATED = new Document(1, 1, true, "Upd Passport", "UP", 888874, "Upd authority", DateTimeUtils.toLocalDate("2004-11-3"), null);

    public static final Account ACCOUNT_1 = new Account(1, "current account", 26200000000001L, 5000L, DateTimeUtils.toLocalDateTime("2016-7-27 15:53:45"), DateTimeUtils.toLocalDateTime("2016-7-27 15:53:45"), null);
    public static final Account ACCOUNT_2 = new Account(2, "deposit account", 26300000000001L, 700000L, DateTimeUtils.toLocalDateTime("2016-7-27 15:56:23"), DateTimeUtils.toLocalDateTime("2016-7-27 15:56:23"), null);

    //Setting all relations
    static {
        INDIVIDUAL_1.setAddress(ADDRESS_1);
        INDIVIDUAL_1.setWork(WORK_1);
        INDIVIDUAL_1.setContact(CONTACT_1);
        INDIVIDUAL_1.setFmInfo(FM_INFO_1);
        INDIVIDUAL_1.setEntrepreneurInfo(ENTREPRENEUR_INFO_1);
        INDIVIDUAL_1.setResponsible(USER_1);
        INDIVIDUAL_1.setDocuments(new HashSet<>(Arrays.asList(DOCUMENT_1)));
        INDIVIDUAL_1.setAccounts(new HashSet<>(Arrays.asList(ACCOUNT_1, ACCOUNT_2)));

        INDIVIDUAL_2.setAddress(ADDRESS_2);
        INDIVIDUAL_2.setWork(WORK_2);
        INDIVIDUAL_2.setContact(CONTACT_2);
        INDIVIDUAL_2.setFmInfo(FM_INFO_2);
        INDIVIDUAL_2.setEntrepreneurInfo(ENTREPRENEUR_INFO_2);
        INDIVIDUAL_2.setResponsible(USER_1);
        INDIVIDUAL_2.setDocuments(new HashSet<>(Arrays.asList(DOCUMENT_2, DOCUMENT_3)));

        INDIVIDUAL_3.setAddress(ADDRESS_3);
        INDIVIDUAL_3.setWork(WORK_3);
        INDIVIDUAL_3.setContact(CONTACT_3);
        INDIVIDUAL_3.setFmInfo(FM_INFO_3);
        INDIVIDUAL_3.setResponsible(USER_1);
        INDIVIDUAL_3.setAccOpener(INDIVIDUAL_1);
        INDIVIDUAL_3.setRepresentative(INDIVIDUAL_2);

        USER_1.setIndividuals(new HashSet<>(Arrays.asList(INDIVIDUAL_1, INDIVIDUAL_2, INDIVIDUAL_3)));

        DOCUMENT_1.setOwner(INDIVIDUAL_1);
        DOCUMENT_2.setOwner(INDIVIDUAL_2);
        DOCUMENT_3.setOwner(INDIVIDUAL_2);

        ACCOUNT_1.setOwner(INDIVIDUAL_1);
        ACCOUNT_2.setOwner(INDIVIDUAL_1);
    }

    //Setting collection of all elements
    public static final Collection<Individual> ALL_INDIVIDUALS = new ArrayList<>();

    static {
        ALL_INDIVIDUALS.add(INDIVIDUAL_1);
        ALL_INDIVIDUALS.add(INDIVIDUAL_2);
        ALL_INDIVIDUALS.add(INDIVIDUAL_3);
        ALL_INDIVIDUALS.add(INDIVIDUAL_CLEAN);
    }

}
