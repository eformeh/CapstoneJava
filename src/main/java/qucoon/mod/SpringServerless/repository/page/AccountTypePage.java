
package   qucoon.mod.SpringServerless.repository.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.AccountType;
import java.util.List;

@Data
@AllArgsConstructor
public class AccountTypePage {
    private List<AccountType> data;
    private long totalRecords;
}
