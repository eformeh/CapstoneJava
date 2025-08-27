
package   qucoon.mod.SpringServerless.repository.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.ProductionRecord;
import java.util.List;

@Data
@AllArgsConstructor
public class ProductionRecordPage {
    private List<ProductionRecord> data;
    private long totalRecords;
}
