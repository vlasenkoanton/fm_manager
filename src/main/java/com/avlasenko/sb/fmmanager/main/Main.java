package com.avlasenko.sb.fmmanager.main;

import com.avlasenko.sb.fmmanager.model.Address;
import com.avlasenko.sb.fmmanager.model.Client;
import com.avlasenko.sb.fmmanager.repository.address.AddressJpaRepository;
import com.avlasenko.sb.fmmanager.repository.client.ClientJpaRepository;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        try (ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/appCtx.xml")) {

            System.out.println(Arrays.toString(appCtx.getBeanDefinitionNames()));

            ClientJpaRepository repository = (ClientJpaRepository) appCtx.getBean("clientJpaRepositoryImpl");

            AddressJpaRepository addressJpaRepository = (AddressJpaRepository) appCtx.getBean("addressJpaRepositoryImpl");

            addressJpaRepository.get(1, 1);




        }

    }


}
