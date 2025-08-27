
package   qucoon.mod.SpringServerless.repository.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.Deduction;
import java.util.List;

@Data
@AllArgsConstructor
public class DeductionPage {
    private List<Deduction> data;
    private long totalRecords;
}
