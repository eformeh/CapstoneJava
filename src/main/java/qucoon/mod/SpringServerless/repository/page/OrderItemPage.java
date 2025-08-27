
package   qucoon.mod.SpringServerless.repository.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.OrderItem;
import java.util.List;

@Data
@AllArgsConstructor
public class OrderItemPage {
    private List<OrderItem> data;
    private long totalRecords;
}
