
package   qucoon.mod.SpringServerless.repository.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.LeaveRequest;
import java.util.List;

@Data
@AllArgsConstructor
public class LeaveRequestPage {
    private List<LeaveRequest> data;
    private long totalRecords;
}
