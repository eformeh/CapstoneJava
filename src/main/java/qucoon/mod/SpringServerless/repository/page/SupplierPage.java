
package   qucoon.mod.SpringServerless.repository.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.Supplier;
import java.util.List;

@Data
@AllArgsConstructor
public class SupplierPage {
    private List<Supplier> data;
    private long totalRecords;
}
