package incorta.challenge.plotter;
import Model.Columns;
import Model.Column;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

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
//
//    @GetMapping("/columns")
//    public String columns(Model model){
//        //model.addAttribute("message","Hello Khaled");
//        restTemplate.getForObject("https://plotter-task.herokuapp.com/columns", Column.class);
//        return "Welcome/Welcome";
//    }
}
