package com.avlasenko.sb.fmmanager.main;

import com.avlasenko.sb.fmmanager.model.Address;
import com.avlasenko.sb.fmmanager.model.Client;
import com.avlasenko.sb.fmmanager.service.ClientService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        try (ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/appCtx.xml")) {

            System.out.println(Arrays.toString(appCtx.getBeanDefinitionNames()));

            ClientService service = (ClientService) appCtx.getBean("clientServiceImpl");

            Client client = service.getWithAllProperties(1);

            System.out.println(client.getDocuments());


        }

    }


}
