package com.avlasenko.sb.fmmanager;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        /*try (ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/webCtx.xml", "spring/appCtx.xml")) {


            System.out.println(Arrays.toString(appCtx.getBeanDefinitionNames()));

            IndividualJpaRepository repository = (IndividualJpaRepository) appCtx.getBean("individualJpaRepositoryImpl");

            AddressJpaRepository addressJpaRepository = (AddressJpaRepository) appCtx.getBean("addressJpaRepositoryImpl");

            Individual withAllProperties = repository.getWithAllProperties(1);
            Set<Document> documents = withAllProperties.getDocuments();
            System.out.println(documents.getClass().getName());
            System.out.println(withAllProperties);




        }*/
        for (Map.Entry<String, List<String>> entry : WebTestData.NEW_CLIENT_PARAMS.entrySet()) {
            System.out.println(entry.getKey()+" "+entry.getValue().get(0));
        }

    }


}
