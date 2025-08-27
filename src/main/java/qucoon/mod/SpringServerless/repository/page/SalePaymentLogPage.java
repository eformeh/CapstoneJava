
package   qucoon.mod.SpringServerless.repository.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.SalePaymentLog;
import java.util.List;

@Data
@AllArgsConstructor
public class SalePaymentLogPage {
    private List<SalePaymentLog> data;
    private long totalRecords;
}
