/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.cxf.demo.ws;

 
import com.dhenton9000.jpa.configs.DatabaseConfig;
import com.dhenton9000.cxf.demo.ws.config.SecurityConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author dhenton
 */


@RunWith(SpringJUnit4ClassRunner.class)
@Rollback
@Transactional
//@EnableAutoConfiguration
@TestPropertySource(locations = "classpath:test.properties")
@ContextConfiguration(loader=AnnotationConfigContextLoader.class, 
classes={SecurityConfig.class, DatabaseConfig.class})
public class ConfigTests {
    private Logger log = LoggerFactory.getLogger(ConfigTests.class);
    
    
    @Autowired
    private Environment env;
    
    @Value("#{environment['DATABASE_URL']}")
    private String databaseURL;
    
    @Value("${hibernate.dialect}")
    private String dialect;
    
    @Test
    public void testEnvConfig()
    {
        assertTrue(true);
        assertNotNull(env);
        assertNotNull(databaseURL);
        assertEquals(dialect,"org.hibernate.dialect.PostgreSQLDialect"); // set in application.properties
        assertEquals(databaseURL,"postgres://test:test@localhost:5432/jdatabase");  //set in surefire plugin
    }
    
    
}
