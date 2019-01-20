package com.example.orikademo.domain.nestedmulti;


import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.util.ArrayList;
import java.util.List;

public class NestedMultiApplication {

    public static void main(String[] args) {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

        mapperFactory.classMap(Person.class, PersonDto.class)
                .mapNulls(true)
                .field("names{fullName}", "personalNames{key}")
                .field("names{}", "personalNames{key}")
                .byDefault()
                .register();

        Name name1 = new Name();
        name1.setFirst("Howdy");
        name1.setLast("Doody");
        name1.setFullName("Howdy Doody");

        Name name2 = new Name();
        name2.setFirst("Susan");
        name2.setLast("Foo");
        name2.setFullName("Susan Foo");

        List<Name> names = new ArrayList<Name>();
        names.add(name1);
        names.add(name2);

        Person person = new Person();
        person.setNames(names);



        MapperFacade mapper = mapperFactory.getMapperFacade();

        PersonDto personDest = mapper.map(person, PersonDto.class);

        System.out.println(personDest);
    }


}
