package designpatterns.structural.composite;

import designpatterns.structural.composite.Directory;
import designpatterns.structural.composite.File;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CompositeTest {

    @Test
    void test(){
        File fileA = new File("fileA", "contentA");
        File fileB = new File("fileB", "contentB");
        Directory dirA = new Directory("dirA");
        Directory dirB = new Directory("dirB");

        dirA.addSource(fileA);
        dirA.addSource(dirB);

        dirB.addSource(fileB);

        Assertions.assertEquals("Directory dirA with content: [Directory dirB with content: [File fileB with content: contentB], File fileA with content: contentA]", dirA.getContent());
    }
}
