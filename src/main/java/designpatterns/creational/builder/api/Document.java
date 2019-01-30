package designpatterns.creational.builder.api;

public class Document {
    private String header;
    private String body;
    private String bottom;

    public void setHeader(String header) {
        this.header = header;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setBottom(String bottom) {
        this.bottom = bottom;
    }

    public String getHeader() {
        return header;
    }

    public String getBody() {
        return body;
    }

    public String getBottom() {
        return bottom;
    }

    public String getText(){
        return new StringBuffer(header).append(body).append(bottom).toString();
    }
}
