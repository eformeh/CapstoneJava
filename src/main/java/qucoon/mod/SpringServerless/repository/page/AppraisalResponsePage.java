
package   qucoon.mod.SpringServerless.repository.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.AppraisalResponse;
import java.util.List;

@Data
@AllArgsConstructor
public class AppraisalResponsePage {
    private List<AppraisalResponse> data;
    private long totalRecords;
}
