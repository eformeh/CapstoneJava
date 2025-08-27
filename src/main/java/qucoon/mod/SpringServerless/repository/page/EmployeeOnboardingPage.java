
package   qucoon.mod.SpringServerless.repository.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.EmployeeOnboarding;
import java.util.List;

@Data
@AllArgsConstructor
public class EmployeeOnboardingPage {
    private List<EmployeeOnboarding> data;
    private long totalRecords;
}
