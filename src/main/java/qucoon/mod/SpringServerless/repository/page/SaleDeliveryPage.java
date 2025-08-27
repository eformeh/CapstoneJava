
package   qucoon.mod.SpringServerless.repository.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.SaleDelivery;
import java.util.List;

@Data
@AllArgsConstructor
public class SaleDeliveryPage {
    private List<SaleDelivery> data;
    private long totalRecords;
}
