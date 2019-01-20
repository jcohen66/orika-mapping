package com.example.orikademo.domain.mappingdirect;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class MappingDirectApplication {

    public static void main(String[] args) {
        SpringApplication.run(MappingDirectApplication.class, args);

        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

        mapperFactory.classMap(BasicPerson.class, BasicPersonDto.class)
                .field("name", "fullName")
                .field("age", "currentAge")
                .byDefault()
                .register();

        BasicPerson basicPerson = new BasicPerson();
        basicPerson.setName("Debbie");
        basicPerson.setBirthDate(java.sql.Date.valueOf(LocalDate.now()));
        basicPerson.setAge(53);

        MapperFacade mapper = mapperFactory.getMapperFacade();
        BasicPersonDto personDest = mapper.map(basicPerson, BasicPersonDto.class);
        System.out.println(personDest);

        /*
        BasicPerson basicPerson = new BasicPerson();
        basicPerson.setName("Debbie");
        basicPerson.setAge(24);
        basicPerson.setBirthDate(java.sql.Date.valueOf(LocalDate.now()));


        mapperFactory.classMap(BasicPerson.class, BasicPersonDto.class)
                .constructorA("name", "id")
                .field("name", "fullName")
                .field("age", "currentAge")
                .byDefault()
                .register();


        mapperFactory.classMap(BasicPersonList.class, BasicPersonFnDto.class)
                .field("nameParts[0]", "firstName")
                .field("nameParts[1]", "lastName")
                .register();

        mapperFactory.classMap(BasicPersonList.class, BasicPersonDto.class)
                .field("nameParts['first']", "firstName")
                .field("nameParts[\"last\"]", "lastName")
                .register();

        mapperFactory.classMap(BasicPerson.class, BasicPersonDto.class)
                .field("name.first", "firstName")
                .register();


        mapperFactory.classMap(Person.class, NestedPersonDto.class)
                .field("names{fullName}", "personalNames{key}")
                .field("names{}", "personalNames{value}")
                .register();

*/
    }
}

