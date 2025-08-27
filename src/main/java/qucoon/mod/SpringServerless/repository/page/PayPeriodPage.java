
package   qucoon.mod.SpringServerless.repository.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.PayPeriod;
import java.util.List;

@Data
@AllArgsConstructor
public class PayPeriodPage {
    private List<PayPeriod> data;
    private long totalRecords;
}
