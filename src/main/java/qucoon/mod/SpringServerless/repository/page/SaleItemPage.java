
package   qucoon.mod.SpringServerless.repository.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.SaleItem;
import java.util.List;

@Data
@AllArgsConstructor
public class SaleItemPage {
    private List<SaleItem> data;
    private long totalRecords;
}
