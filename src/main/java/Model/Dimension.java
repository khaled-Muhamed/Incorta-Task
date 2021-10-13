package Model;

import java.util.List;

public class Dimension {
    String name;
    List<String> values;

    public Dimension(){
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    @Override
    public String toString(){
        StringBuilder temp = new StringBuilder();
        temp.append("\"name\" :"  + "\"" + this.name+",\n" +
                "values\": [\n");
        for(String value:values){
            temp.append( "\""+value+"\",\n");
        }
        temp.deleteCharAt(temp.length()-2);
        temp.append("]\n");
        return temp.toString();
    }
}
