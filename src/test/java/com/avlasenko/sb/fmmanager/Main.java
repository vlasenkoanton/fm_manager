package com.avlasenko.sb.fmmanager;

import com.avlasenko.sb.fmmanager.config.SecurityConfig;
import com.avlasenko.sb.fmmanager.model.Document;
import com.avlasenko.sb.fmmanager.model.Individual;
import com.avlasenko.sb.fmmanager.repository.address.AddressJpaRepository;
import com.avlasenko.sb.fmmanager.repository.individual.IndividualJpaRepository;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import java.util.Arrays;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        try (ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/webCtx.xml", "spring/appCtx.xml")) {


            System.out.println(Arrays.toString(appCtx.getBeanDefinitionNames()));

            IndividualJpaRepository repository = (IndividualJpaRepository) appCtx.getBean("individualJpaRepositoryImpl");

            AddressJpaRepository addressJpaRepository = (AddressJpaRepository) appCtx.getBean("addressJpaRepositoryImpl");

            Individual withAllProperties = repository.getWithAllProperties(1);
            Set<Document> documents = withAllProperties.getDocuments();
            System.out.println(documents.getClass().getName());
            System.out.println(withAllProperties);


        }

    }


}
