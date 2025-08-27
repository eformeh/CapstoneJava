
package   qucoon.mod.SpringServerless.repository.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.LeaveBalance;
import java.util.List;

@Data
@AllArgsConstructor
public class LeaveBalancePage {
    private List<LeaveBalance> data;
    private long totalRecords;
}
