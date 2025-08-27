
package   qucoon.mod.SpringServerless.repository.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.Job;
import java.util.List;

@Data
@AllArgsConstructor
public class JobPage {
    private List<Job> data;
    private long totalRecords;
}
