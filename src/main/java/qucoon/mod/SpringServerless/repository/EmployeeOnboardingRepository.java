
package   qucoon.mod.SpringServerless.repository;

import org.springframework.stereotype.Repository;
import qucoon.mod.SpringServerless.model.entity.Module;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.repository.page.EmployeeOnboardingPage;
import qucoon.mod.SpringServerless.model.request.EmployeeOnboardingFilterRequest;

import java.util.List;

@Repository
    public interface EmployeeOnboardingRepository {


    // Additional query methods can be defined here.
    int create(EmployeeOnboarding employeeonboarding);
    void bulkCreate(List<EmployeeOnboarding>  employeeonboarding);
    int update(EmployeeOnboarding  employeeonboarding);
    int delete(int employeeOnboardingId);
    EmployeeOnboardingPage findEmployeeOnboarding(EmployeeOnboardingFilterRequest filter);
    boolean truncate();
    List<EmployeeOnboarding> read();
    List<EmployeeOnboarding> readByEmployeeOnboardingAssignedBy(int employeeOnboardingAssignedBy);
    List<EmployeeOnboarding> readByEmployeeOnboardingAttachmentUrl(String employeeOnboardingAttachmentUrl);
    List<EmployeeOnboarding> readByEmployeeOnboardingCompletedDate(String employeeOnboardingCompletedDate);
    List<EmployeeOnboarding> readByEmployeeOnboardingCreatedAt(String employeeOnboardingCreatedAt);
    List<EmployeeOnboarding> readByEmployeeOnboardingDueDate(String employeeOnboardingDueDate);
    List<EmployeeOnboarding> readByEmployeeOnboardingEmployeeId(int employeeOnboardingEmployeeId);
    EmployeeOnboarding readByEmployeeOnboardingId(int employeeOnboardingId);
    List<EmployeeOnboarding> readByEmployeeOnboardingNotes(String employeeOnboardingNotes);
    List<EmployeeOnboarding> readByEmployeeOnboardingStatus(String employeeOnboardingStatus);
    List<EmployeeOnboarding> readByEmployeeOnboardingTaskId(int employeeOnboardingTaskId);
    List<EmployeeOnboarding> readByEmployeeOnboardingUpdatedAt(String employeeOnboardingUpdatedAt);
}
