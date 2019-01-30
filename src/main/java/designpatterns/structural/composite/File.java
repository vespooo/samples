package designpatterns.structural.composite;

public class File implements Source {

    private String name;
    private String content;

    public File(String name, String content) {
        this.name = name;
        this.content = content;
    }

    @Override
    public String getContent() {
        return "File " + name + " with content: " + content;
    }
}
