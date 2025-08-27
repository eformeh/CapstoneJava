
package   qucoon.mod.SpringServerless.repository.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.Product;
import java.util.List;

@Data
@AllArgsConstructor
public class ProductPage {
    private List<Product> data;
    private long totalRecords;
}
