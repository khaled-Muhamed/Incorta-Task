package Model;

public class Data {
    private Dimension myDimension;
    private Measure myMeasure;

    public Dimension getMyDimension() {
        return myDimension;
    }

    public void setMyDimension(Dimension myDimension) {
        this.myDimension = myDimension;
    }

    public Measure getMyMeasure() {
        return myMeasure;
    }

    public void setMyMeasure(Measure myMeasure) {
        this.myMeasure = myMeasure;
    }

    @Override
    public String toString(){
        StringBuilder temp = new StringBuilder();
        temp.append("{\n\"data\": [\n{\n\"name\": \""+this.myDimension.getName()+"\",\n" +
                "\"values\": [\n");
        for(String str:this.myDimension.getValues()){
            temp.append("\""+str+"\",\n");
        }
        temp.deleteCharAt(temp.length()-2);
        temp.append("]\n},\n");

        temp.append("{\"name\": \""+this.myMeasure.getName()+"\",\n"+
                "\"values\": [\n");
        for(int value:this.myMeasure.getValues()){
            temp.append(value+",\n");
        }
        temp.deleteCharAt(temp.length()-2);
        temp.append("]\n}\n]\n}");
        return temp.toString();
    }
}
