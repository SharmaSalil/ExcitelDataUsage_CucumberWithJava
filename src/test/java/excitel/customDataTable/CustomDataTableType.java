package excitel.customDataTable;

import excitel.domainObjects.Credentials;
import io.cucumber.java.DataTableType;

import java.util.Map;

public class CustomDataTableType {

    @DataTableType
    public Credentials details(Map<String, String> entry) {
        return new Credentials(entry.get("username"), entry.get("password"));
    }
}
