
package   qucoon.mod.SpringServerless.repository.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.Ledger;
import java.util.List;

@Data
@AllArgsConstructor
public class LedgerPage {
    private List<Ledger> data;
    private long totalRecords;
}
