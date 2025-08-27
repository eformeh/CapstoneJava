
package   qucoon.mod.SpringServerless.repository.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.JournalEntryLine;
import java.util.List;

@Data
@AllArgsConstructor
public class JournalEntryLinePage {
    private List<JournalEntryLine> data;
    private long totalRecords;
}
