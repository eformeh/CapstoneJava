
package   qucoon.mod.SpringServerless.repository.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.ExpenseItem;
import java.util.List;

@Data
@AllArgsConstructor
public class ExpenseItemPage {
    private List<ExpenseItem> data;
    private long totalRecords;
}
