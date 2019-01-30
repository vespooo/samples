package designpatterns.creational.builder;

import designpatterns.DesignPatternsConfig;
import static org.junit.jupiter.api.Assertions.assertEquals;

import designpatterns.creational.builder.api.Document;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = DesignPatternsConfig.class)
public class BuilderTest {
    @Autowired
    private BuilderClientService clientService;

    @Test
    public void testLetterDocument(){
        Document doc = clientService.buildLetterDocument();
        assertEquals("Dear friend. ", doc.getHeader());
        assertEquals("How are you? ", doc.getBody());
        assertEquals("Regards, Tatiana", doc.getBottom());
    }

    @Test
    public void testClaimDocumentFullText(){
        Document doc = clientService.buildClaimDocument();
        assertEquals("To Airport Baggage department. Please, find my luggage! Thank you, Tatiana Valova", doc.getText());
    }
}
