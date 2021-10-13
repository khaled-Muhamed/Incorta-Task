package Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Column {

    private String name;
    private String function;

    public Column(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String toString(){
        return "column{\n" +
                "name: " +this.name+",\n" +
                "function: " +this.function+",\n" +
                " },";
    }
}
