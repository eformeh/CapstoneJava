
package   qucoon.mod.SpringServerless.service;


import qucoon.mod.SpringServerless.utility.exception.CustomExceptions;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Service;
import qucoon.mod.SpringServerless.utility.model.response.BaseResponse;
import qucoon.mod.SpringServerless.model.entity.User;
import qucoon.mod.SpringServerless.model.request.*;
import qucoon.mod.SpringServerless.model.response.*;
import qucoon.mod.SpringServerless.utility.LocalDateTimeTypeAdapter;
import qucoon.mod.SpringServerless.repository.*;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.repository.page.JobPage;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.utility.constant.ResponseConstant;
import com.google.gson.Gson;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import qucoon.mod.SpringServerless.model.dto.JobDto;


@Service
public class JobService {

    private final JobRepository jobRepository;
    private  final Gson GSON;


    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
        this.GSON = new GsonBuilder()
               .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
                .create();
    }



    public BaseResponse create(JobCreateRequest request) {

        Job job = GSON.fromJson(GSON.toJson(request), Job.class);
        if (job.getJobStatus() == null) {
            job.setJobStatus("ACTIVE");
        }
        jobRepository.create(job);

        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse bulkCreate(List<JobCreateRequest> request) {
        try {
            String json = GSON.toJson(request);
            Job[] jobArray = GSON.fromJson(json, Job[].class);
            List<Job> jobs = Arrays.asList(jobArray);
            jobRepository.bulkCreate(jobs);
            return ResponseConstant.INSTANCE.getSUCCESS();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseConstant.INSTANCE.getBAD_REQUEST();
        }
    }

    public BaseResponse update(JobUpdateRequest request) {
        Job job = jobRepository.readByJobId(request.getJobId());
        if (job == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        jobRepository.update(job);
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse delete(int jobId) {
        int updateResponse = jobRepository.delete(jobId);
        if (updateResponse < 1) {
            throw new CustomExceptions.FailedToUpdateRecord("Record not found");
        }
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public JobReadListResponse read() {
        List<Job> jobs = jobRepository.read();
       if(jobs == null){
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new JobReadListResponse(ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(), ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(), jobs);
    }
   public JobReadPagedResponse search(JobFilterRequest filter) {
    // reuse same repository call for search, since filter includes search criteria
       JobPage page = jobRepository.findJob(filter);
       int totalPages = (int) Math.ceil((double) page.getTotalRecords() / filter.getPageSize());
       List<JobDto> dtos = page.getData().stream()
            .map(JobDto::from)
            .collect(Collectors.toList());
    return new JobReadPagedResponse(
            ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
            ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
            dtos,
            page.getTotalRecords(),
            filter.getPageNumber(),
            filter.getPageSize(),
            totalPages
    );
}
    public JobReadListResponse readByJobCreatedAt(String jobcreatedat) {
        List<Job> jobs = jobRepository.readByJobCreatedAt(jobcreatedat);
        return new JobReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        jobs);
    }
    public JobReadListResponse readByJobDepartmentId(int jobdepartmentid) {
        List<Job> jobs = jobRepository.readByJobDepartmentId(jobdepartmentid);
        return new JobReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        jobs);
    }
    public JobReadSingleResponse readByJobId(int jobid) {
        Job job = jobRepository.readByJobId(jobid);
        if (job == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new JobReadSingleResponse(
                ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
                ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
                job);
    }
    public JobReadListResponse readByJobRoleId(int jobroleid) {
        List<Job> jobs = jobRepository.readByJobRoleId(jobroleid);
        return new JobReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        jobs);
    }
    public JobReadListResponse readByJobStatus(String jobstatus) {
        List<Job> jobs = jobRepository.readByJobStatus(jobstatus);
        return new JobReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        jobs);
    }
    public JobReadListResponse readByJobUpdatedAt(String jobupdatedat) {
        List<Job> jobs = jobRepository.readByJobUpdatedAt(jobupdatedat);
        return new JobReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        jobs);
    }
}
