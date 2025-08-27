
package   qucoon.mod.SpringServerless.repository.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.Allowance;
import java.util.List;

@Data
@AllArgsConstructor
public class AllowancePage {
    private List<Allowance> data;
    private long totalRecords;
}
