package designpatterns.creational.builder.api;

import org.springframework.stereotype.Component;

@Component
public class Director {

    public Document constructDocument(Builder builder){
        builder.buildHeader();
        builder.buildBody();
        builder.buildBottom();
        return builder.getResult();
    }

}
