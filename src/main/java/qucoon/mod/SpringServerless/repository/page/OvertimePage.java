
package   qucoon.mod.SpringServerless.repository.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.Overtime;
import java.util.List;

@Data
@AllArgsConstructor
public class OvertimePage {
    private List<Overtime> data;
    private long totalRecords;
}
