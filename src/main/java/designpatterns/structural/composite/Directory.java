package designpatterns.structural.composite;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Directory implements Source {
    private List<Source> childSources;
    private String name;

    public Directory(String name) {
        this.name = name;
        this.childSources = new ArrayList<>();
    }

    public void addSource(Source source) {
        childSources.add(source);
    }

    @Override
    public String getContent() {
        return "Directory "+ name + " with content: " + childSources.stream().map(Source::getContent).sorted(Comparator.naturalOrder()).collect(Collectors.toList()).toString();
    }
}
