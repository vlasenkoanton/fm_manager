package com.avlasenko.sb.fmmanager.main;

import com.avlasenko.sb.fmmanager.model.Individual;
import com.avlasenko.sb.fmmanager.repository.address.AddressJpaRepository;
import com.avlasenko.sb.fmmanager.repository.individual.IndividualJpaRepository;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        try (ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/appCtx.xml")) {

            System.out.println(Arrays.toString(appCtx.getBeanDefinitionNames()));

            IndividualJpaRepository repository = (IndividualJpaRepository) appCtx.getBean("individualJpaRepositoryImpl");

            AddressJpaRepository addressJpaRepository = (AddressJpaRepository) appCtx.getBean("addressJpaRepositoryImpl");






        }

    }


}
