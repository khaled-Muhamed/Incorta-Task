package Model;

import java.util.List;

public class Measure{
    String name;
    List<Integer> values;

    public Measure(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getValues() {
        return values;
    }

    public void setValues(List<Integer> values) {
        this.values = values;
    }

    @Override
    public String toString(){
        StringBuilder temp = new StringBuilder();
        temp.append("\"name\" :"  + "\"" + this.name+",\n" +
                "values\": [\n");
        for(int value:values){
            temp.append( value+",\n");
        }
        temp.deleteCharAt(temp.length()-2);
        temp.append("]\n");
        return temp.toString();
    }
}
