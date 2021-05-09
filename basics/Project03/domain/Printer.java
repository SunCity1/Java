package Project03.domain;

public class Printer implements Equipment {
    private String name;    //名字
    private String type;    //机器类型

    public Printer(){

    }
    public Printer(String name, String type){
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setType(String type) {
        this.type = type;
    }


    @Override
    public String getDescription() {
        return getName() + "("+ getType() + ")";
    }
}
