
package   qucoon.mod.SpringServerless.repository.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.Employee;
import java.util.List;

@Data
@AllArgsConstructor
public class EmployeePage {
    private List<Employee> data;
    private long totalRecords;
}
