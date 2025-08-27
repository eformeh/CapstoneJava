
package   qucoon.mod.SpringServerless.repository.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.Appraisal;
import java.util.List;

@Data
@AllArgsConstructor
public class AppraisalPage {
    private List<Appraisal> data;
    private long totalRecords;
}
