package com.avlasenko.sb.fmmanager.repository;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by A. Vlasenko on 05.08.2016.
 */
@ActiveProfiles("test")
@ContextConfiguration({"classpath:spring/appCtx.xml", "classpath:spring/dbCtx.xml"})
@Sql(scripts = "classpath:db/tables_populate.sql", config = @SqlConfig(encoding = "UTF-8"),
        executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public abstract class AbstractJpaRepositoryTest {

}
