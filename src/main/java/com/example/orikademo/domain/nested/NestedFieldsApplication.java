package com.example.orikademo.domain.nested;


import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.time.LocalDate;

public class NestedFieldsApplication {

    public static void main(String[] args) {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();


        mapperFactory.classMap(BasicPerson.class, BasicPersonDto.class)
                .field("name.first", "firstName")
                .register();

        Name name = new Name();
        name.setFirst("Howdy");
        name.setLast("Doody");
        name.setFullName(name.getFirst() + " " + name.getLast());

        BasicPerson basicPerson = new BasicPerson();
        basicPerson.setName(name);

        MapperFacade mapper = mapperFactory.getMapperFacade();

        BasicPersonDto personDest = mapper.map(basicPerson, BasicPersonDto.class);
        System.out.println(personDest);
    }
}
