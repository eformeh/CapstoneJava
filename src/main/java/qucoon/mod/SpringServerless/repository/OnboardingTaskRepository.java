
package   qucoon.mod.SpringServerless.repository;

import org.springframework.stereotype.Repository;
import qucoon.mod.SpringServerless.model.entity.Module;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.repository.page.OnboardingTaskPage;
import qucoon.mod.SpringServerless.model.request.OnboardingTaskFilterRequest;

import java.util.List;

@Repository
    public interface OnboardingTaskRepository {


    // Additional query methods can be defined here.
    int create(OnboardingTask onboardingtask);
    void bulkCreate(List<OnboardingTask>  onboardingtask);
    int update(OnboardingTask  onboardingtask);
    int delete(int onboardingTaskId);
    OnboardingTaskPage findOnboardingTask(OnboardingTaskFilterRequest filter);
    boolean truncate();
    List<OnboardingTask> read();
    List<OnboardingTask> readByOnboardingTaskCreatedAt(String onboardingTaskCreatedAt);
    List<OnboardingTask> readByOnboardingTaskCreatedBy(int onboardingTaskCreatedBy);
    List<OnboardingTask> readByOnboardingTaskDescription(String onboardingTaskDescription);
    OnboardingTask readByOnboardingTaskId(int onboardingTaskId);
    List<OnboardingTask> readByOnboardingTaskStatus(String onboardingTaskStatus);
    List<OnboardingTask> readByOnboardingTaskUpdatedAt(String onboardingTaskUpdatedAt);
}
