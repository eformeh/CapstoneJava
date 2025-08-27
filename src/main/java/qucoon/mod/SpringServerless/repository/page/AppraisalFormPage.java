
package   qucoon.mod.SpringServerless.repository.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.AppraisalForm;
import java.util.List;

@Data
@AllArgsConstructor
public class AppraisalFormPage {
    private List<AppraisalForm> data;
    private long totalRecords;
}
