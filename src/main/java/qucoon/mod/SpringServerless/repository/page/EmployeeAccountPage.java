
package   qucoon.mod.SpringServerless.repository.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.EmployeeAccount;
import java.util.List;

@Data
@AllArgsConstructor
public class EmployeeAccountPage {
    private List<EmployeeAccount> data;
    private long totalRecords;
}
