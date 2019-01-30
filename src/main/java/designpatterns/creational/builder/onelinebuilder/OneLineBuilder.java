package designpatterns.creational.builder.onelinebuilder;

public class OneLineBuilder {

    private String option1;
    private String option2;

    public OneLineBuilder addOption1(String option){
        this.option1 = option;
        return this;
    }
    public OneLineBuilder addOption2(String option){
        this.option2 = option;
        return this;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }
}
