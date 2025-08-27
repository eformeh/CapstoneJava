
package   qucoon.mod.SpringServerless.repository.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.OnboardingTask;
import java.util.List;

@Data
@AllArgsConstructor
public class OnboardingTaskPage {
    private List<OnboardingTask> data;
    private long totalRecords;
}
