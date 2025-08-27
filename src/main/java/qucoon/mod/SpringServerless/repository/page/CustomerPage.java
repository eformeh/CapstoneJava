
package   qucoon.mod.SpringServerless.repository.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.Customer;
import java.util.List;

@Data
@AllArgsConstructor
public class CustomerPage {
    private List<Customer> data;
    private long totalRecords;
}
