package designpatterns.creational.builder.api;

public class LetterDocumentBuilder implements Builder {

    Document document;

    public LetterDocumentBuilder() {
        this.document = new Document();
    }

    @Override
    public void buildHeader() {
       document.setHeader("Dear friend. ");
    }

    @Override
    public void buildBody() {
        document.setBody("How are you? ");
    }

    @Override
    public void buildBottom() {
        document.setBottom("Regards, Tatiana");
    }

    @Override
    public Document getResult() {
        return document;
    }
}
