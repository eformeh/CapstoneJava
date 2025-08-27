
package   qucoon.mod.SpringServerless.repository.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.ExpenseClaim;
import java.util.List;

@Data
@AllArgsConstructor
public class ExpenseClaimPage {
    private List<ExpenseClaim> data;
    private long totalRecords;
}
