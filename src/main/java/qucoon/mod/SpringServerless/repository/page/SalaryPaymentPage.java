
package   qucoon.mod.SpringServerless.repository.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.SalaryPayment;
import java.util.List;

@Data
@AllArgsConstructor
public class SalaryPaymentPage {
    private List<SalaryPayment> data;
    private long totalRecords;
}
