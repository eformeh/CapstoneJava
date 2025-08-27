
package   qucoon.mod.SpringServerless.repository.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.LeaveType;
import java.util.List;

@Data
@AllArgsConstructor
public class LeaveTypePage {
    private List<LeaveType> data;
    private long totalRecords;
}
