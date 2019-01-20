package com.example.orikademo.domain.mappinglist;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.util.ArrayList;
import java.util.List;

public class MappingListApplication {

    public static void main(String[] args) {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

        mapperFactory.classMap(BasicPerson.class, BasicPersonDto.class)
                .field("nameParts[0]", "firstName")
                .field("nameParts[1]", "lastName")
                .register();

        List<String> nameParts = new ArrayList<String>();
        nameParts.add("Howdy");
        nameParts.add("Doody");

        BasicPerson basicPerson = new BasicPerson();
        basicPerson.setNameParts(nameParts);

        MapperFacade mapper = mapperFactory.getMapperFacade();
        BasicPersonDto personDest = mapper.map(basicPerson, BasicPersonDto.class);
        System.out.println(personDest);


    }

}
