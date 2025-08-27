
package   qucoon.mod.SpringServerless.repository.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.Transaction;
import java.util.List;

@Data
@AllArgsConstructor
public class TransactionPage {
    private List<Transaction> data;
    private long totalRecords;
}
