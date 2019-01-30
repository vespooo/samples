package designpatterns.creational.builder.api;

public class ClaimDocumentBuilder implements Builder {

    Document document;

    public ClaimDocumentBuilder() {
        this.document = new Document();
    }

    @Override
    public void buildHeader() {
        document.setHeader("To Airport Baggage department. ");
    }

    @Override
    public void buildBody() {
        document.setBody("Please, find my luggage! ");
    }

    @Override
    public void buildBottom() {
        document.setBottom("Thank you, Tatiana Valova");
    }

    @Override
    public Document getResult() {
        return document;
    }
}
