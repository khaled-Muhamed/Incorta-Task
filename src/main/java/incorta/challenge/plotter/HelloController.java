package incorta.challenge.plotter;
import Model.Columns;
import Model.Column;
import Model.Data;
import Model.Dimension;
import Model.Measure;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String welcome(Model model) throws JsonProcessingException {
        String jsonString ="{\"columns\": [{\"name\": \"Product\",\"function\": \"dimension\"},{\"name\": \"Year\",\"function\": \"dimension\"},{\"name\": \"Country\",\"function\": \"dimension\"},{\"name\": \"Cost\",\"function\": \"measure\"},{\"name\": \"Revenue\",\"function\": \"measure\"},{\"name\": \"Units sold\",\"function\": \"measure\"}]}";
        ObjectMapper objectMapper = new ObjectMapper();
        Columns columnsResponse= objectMapper.readValue(jsonString, Columns.class);
//        System.out.println(columnsResponse.getColumns().get(5).getName());
        model.addAttribute("columns",columnsResponse.getColumns());
        return "Welcome/Welcome";
    }

//    @GetMapping("/columns/{measure}/{dimension}")
    @GetMapping("/hello2")
//    public String getData(@PathVariable String measure,@PathVariable String dimension) throws JsonProcessingException {
     public String welcome2(Model model) throws JsonProcessingException {
       //suppose we sent the request and get the response
        String response = "{\"data\": [{\"name\": \"Product\",\"values\": [\"Diskette\",\"Memory Card\",\"HDTV Tuner\",\"Flat Panel Graphics Monitor\",\"Digital Camera\",\"Minitower Speaker\",\"Extension Cable\",\"Y Box\"]},{\"name\": \"Cost\",\"values\": [333.08,7.07,10.77,194.76,13.18,143.3,20.2,405]}]}";

        JsonObject convertedObject = new Gson().fromJson(response, JsonObject.class);
        ObjectMapper objectMapper = new ObjectMapper();

        Dimension DataDimension = objectMapper.readValue(convertedObject.get("data").getAsJsonArray().get(0).toString(), Dimension.class);
        Measure DataMeasure = objectMapper.readValue(convertedObject.get("data").getAsJsonArray().get(1).toString(), Measure.class);

        Data dataObj = new Data();
        dataObj.setMyDimension(DataDimension);
        dataObj.setMyMeasure(DataMeasure);


        model.addAttribute("DataObj",dataObj);
        return "Welcome/Welcome";
    }
}
