
package   qucoon.mod.SpringServerless.repository.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.AccountMapping;
import java.util.List;

@Data
@AllArgsConstructor
public class AccountMappingPage {
    private List<AccountMapping> data;
    private long totalRecords;
}
