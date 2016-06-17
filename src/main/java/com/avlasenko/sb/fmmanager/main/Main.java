package com.avlasenko.sb.fmmanager.main;

import com.avlasenko.sb.fmmanager.model.Client;
import com.avlasenko.sb.fmmanager.service.ClientService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        try (ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/appCtx.xml")) {

            System.out.println("------------------------------------------------------");
            System.out.println(Arrays.toString(appCtx.getBeanDefinitionNames()));

            Client client1 = new Client();
            client1.setId(1);
            client1.setFirstName("Vasilii");
            client1.setLastName("Vasilenko");
            client1.setMiddleName("Vasilievich");
            client1.setIdentNumber(111111);

            Client client2 = new Client();
            client2.setId(1);
            client2.setFirstName("Petro");
            client2.setLastName("Petrenko");
            client2.setMiddleName("Petrovych");
            client2.setIdentNumber(222222);

            ClientService service = (ClientService) appCtx.getBean("clientServiceImpl");

            service.save(client1);
            service.save(client2);


        }

    }


}
