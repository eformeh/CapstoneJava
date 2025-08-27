
package   qucoon.mod.SpringServerless.repository.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.TransactionCategory;
import java.util.List;

@Data
@AllArgsConstructor
public class TransactionCategoryPage {
    private List<TransactionCategory> data;
    private long totalRecords;
}
