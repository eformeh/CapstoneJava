
package   qucoon.mod.SpringServerless.repository;

import org.springframework.stereotype.Repository;
import qucoon.mod.SpringServerless.model.entity.Module;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.repository.page.JobPage;
import qucoon.mod.SpringServerless.model.request.JobFilterRequest;

import java.util.List;

@Repository
    public interface JobRepository {


    // Additional query methods can be defined here.
    int create(Job job);
    void bulkCreate(List<Job>  job);
    int update(Job  job);
    int delete(int jobId);
    JobPage findJob(JobFilterRequest filter);
    boolean truncate();
    List<Job> read();
    List<Job> readByJobCreatedAt(String jobCreatedAt);
    List<Job> readByJobDepartmentId(int jobDepartmentId);
    Job readByJobId(int jobId);
    List<Job> readByJobRoleId(int jobRoleId);
    List<Job> readByJobStatus(String jobStatus);
    List<Job> readByJobUpdatedAt(String jobUpdatedAt);
}
