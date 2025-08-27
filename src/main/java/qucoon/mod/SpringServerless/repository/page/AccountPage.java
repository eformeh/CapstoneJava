
package   qucoon.mod.SpringServerless.repository.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.Account;
import java.util.List;

@Data
@AllArgsConstructor
public class AccountPage {
    private List<Account> data;
    private long totalRecords;
}
