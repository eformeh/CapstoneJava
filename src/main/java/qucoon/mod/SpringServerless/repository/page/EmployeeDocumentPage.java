
package   qucoon.mod.SpringServerless.repository.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.EmployeeDocument;
import java.util.List;

@Data
@AllArgsConstructor
public class EmployeeDocumentPage {
    private List<EmployeeDocument> data;
    private long totalRecords;
}
