package Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Columns {
    List<Column> columns;

    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> cars) {
        this.columns = cars;
    }

    @Override
    public String toString() {
        return "CarResponse{" +
                "cars=" + columns +
                '}';
    }
}
