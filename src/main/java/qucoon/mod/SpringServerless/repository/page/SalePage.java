
package   qucoon.mod.SpringServerless.repository.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.Sale;
import java.util.List;

@Data
@AllArgsConstructor
public class SalePage {
    private List<Sale> data;
    private long totalRecords;
}
