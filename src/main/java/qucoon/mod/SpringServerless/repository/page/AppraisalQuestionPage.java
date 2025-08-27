
package   qucoon.mod.SpringServerless.repository.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.AppraisalQuestion;
import java.util.List;

@Data
@AllArgsConstructor
public class AppraisalQuestionPage {
    private List<AppraisalQuestion> data;
    private long totalRecords;
}
