
package   qucoon.mod.SpringServerless.repository.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.Order;
import java.util.List;

@Data
@AllArgsConstructor
public class OrderPage {
    private List<Order> data;
    private long totalRecords;
}
