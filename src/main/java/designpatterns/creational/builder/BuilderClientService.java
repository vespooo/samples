package designpatterns.creational.builder;

import designpatterns.creational.builder.api.Document;


public interface BuilderClientService {

    Document buildLetterDocument();

    Document buildClaimDocument();
}
