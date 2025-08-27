
package   qucoon.mod.SpringServerless.repository.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.ProductionMaterial;
import java.util.List;

@Data
@AllArgsConstructor
public class ProductionMaterialPage {
    private List<ProductionMaterial> data;
    private long totalRecords;
}
