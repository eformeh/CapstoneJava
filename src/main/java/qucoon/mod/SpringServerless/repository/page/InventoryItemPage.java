
package   qucoon.mod.SpringServerless.repository.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.InventoryItem;
import java.util.List;

@Data
@AllArgsConstructor
public class InventoryItemPage {
    private List<InventoryItem> data;
    private long totalRecords;
}
