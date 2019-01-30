package designpatterns.creational.builder;

import designpatterns.creational.builder.api.ClaimDocumentBuilder;
import designpatterns.creational.builder.api.Director;
import designpatterns.creational.builder.api.Document;
import designpatterns.creational.builder.api.LetterDocumentBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuilderClientServiceImpl implements BuilderClientService{

    @Autowired
    private Director director;

    public Document buildLetterDocument(){
        return director.constructDocument(new LetterDocumentBuilder());
    }

    public Document buildClaimDocument(){
        return director.constructDocument(new ClaimDocumentBuilder());
    }

}
