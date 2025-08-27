
package   qucoon.mod.SpringServerless.repository.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.FinishedGoodDetails;
import java.util.List;

@Data
@AllArgsConstructor
public class FinishedGoodDetailsPage {
    private List<FinishedGoodDetails> data;
    private long totalRecords;
}
