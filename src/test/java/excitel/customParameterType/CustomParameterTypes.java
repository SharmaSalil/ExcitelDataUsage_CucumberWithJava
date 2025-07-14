package excitel.customParameterType;

import excitel.domainObjects.CalenderMonth;
import io.cucumber.java.ParameterType;

public class CustomParameterTypes {

    @ParameterType(".*")
    public CalenderMonth month(String month){
        return new CalenderMonth(month.replaceAll("\"", ""));
    }
}
