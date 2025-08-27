
package   qucoon.mod.SpringServerless.repository.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.Department;
import java.util.List;

@Data
@AllArgsConstructor
public class DepartmentPage {
    private List<Department> data;
    private long totalRecords;
}
