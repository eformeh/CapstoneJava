
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
import qucoon.mod.SpringServerless.repository.page.OnboardingTaskPage;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.utility.constant.ResponseConstant;
import com.google.gson.Gson;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import qucoon.mod.SpringServerless.model.dto.OnboardingTaskDto;


@Service
public class OnboardingTaskService {

    private final OnboardingTaskRepository onboardingtaskRepository;
    private  final Gson GSON;


    public OnboardingTaskService(OnboardingTaskRepository onboardingtaskRepository) {
        this.onboardingtaskRepository = onboardingtaskRepository;
        this.GSON = new GsonBuilder()
               .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
                .create();
    }



    public BaseResponse create(OnboardingTaskCreateRequest request) {

        OnboardingTask onboardingtask = GSON.fromJson(GSON.toJson(request), OnboardingTask.class);
        if (onboardingtask.getOnboardingTaskStatus() == null) {
            onboardingtask.setOnboardingTaskStatus("ACTIVE");
        }
        onboardingtaskRepository.create(onboardingtask);

        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse bulkCreate(List<OnboardingTaskCreateRequest> request) {
        try {
            String json = GSON.toJson(request);
            OnboardingTask[] onboardingtaskArray = GSON.fromJson(json, OnboardingTask[].class);
            List<OnboardingTask> onboardingtasks = Arrays.asList(onboardingtaskArray);
            onboardingtaskRepository.bulkCreate(onboardingtasks);
            return ResponseConstant.INSTANCE.getSUCCESS();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseConstant.INSTANCE.getBAD_REQUEST();
        }
    }

    public BaseResponse update(OnboardingTaskUpdateRequest request) {
        OnboardingTask onboardingtask = onboardingtaskRepository.readByOnboardingTaskId(request.getOnboardingTaskId());
        if (onboardingtask == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        onboardingtaskRepository.update(onboardingtask);
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse delete(int onboardingTaskId) {
        int updateResponse = onboardingtaskRepository.delete(onboardingTaskId);
        if (updateResponse < 1) {
            throw new CustomExceptions.FailedToUpdateRecord("Record not found");
        }
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public OnboardingTaskReadListResponse read() {
        List<OnboardingTask> onboardingtasks = onboardingtaskRepository.read();
       if(onboardingtasks == null){
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new OnboardingTaskReadListResponse(ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(), ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(), onboardingtasks);
    }
   public OnboardingTaskReadPagedResponse search(OnboardingTaskFilterRequest filter) {
    // reuse same repository call for search, since filter includes search criteria
       OnboardingTaskPage page = onboardingtaskRepository.findOnboardingTask(filter);
       int totalPages = (int) Math.ceil((double) page.getTotalRecords() / filter.getPageSize());
       List<OnboardingTaskDto> dtos = page.getData().stream()
            .map(OnboardingTaskDto::from)
            .collect(Collectors.toList());
    return new OnboardingTaskReadPagedResponse(
            ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
            ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
            dtos,
            page.getTotalRecords(),
            filter.getPageNumber(),
            filter.getPageSize(),
            totalPages
    );
}
    public OnboardingTaskReadListResponse readByOnboardingTaskCreatedAt(String onboardingtaskcreatedat) {
        List<OnboardingTask> onboardingtasks = onboardingtaskRepository.readByOnboardingTaskCreatedAt(onboardingtaskcreatedat);
        return new OnboardingTaskReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        onboardingtasks);
    }
    public OnboardingTaskReadListResponse readByOnboardingTaskCreatedBy(int onboardingtaskcreatedby) {
        List<OnboardingTask> onboardingtasks = onboardingtaskRepository.readByOnboardingTaskCreatedBy(onboardingtaskcreatedby);
        return new OnboardingTaskReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        onboardingtasks);
    }
    public OnboardingTaskReadListResponse readByOnboardingTaskDescription(String onboardingtaskdescription) {
        List<OnboardingTask> onboardingtasks = onboardingtaskRepository.readByOnboardingTaskDescription(onboardingtaskdescription);
        return new OnboardingTaskReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        onboardingtasks);
    }
    public OnboardingTaskReadSingleResponse readByOnboardingTaskId(int onboardingtaskid) {
        OnboardingTask onboardingtask = onboardingtaskRepository.readByOnboardingTaskId(onboardingtaskid);
        if (onboardingtask == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new OnboardingTaskReadSingleResponse(
                ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
                ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
                onboardingtask);
    }
    public OnboardingTaskReadListResponse readByOnboardingTaskStatus(String onboardingtaskstatus) {
        List<OnboardingTask> onboardingtasks = onboardingtaskRepository.readByOnboardingTaskStatus(onboardingtaskstatus);
        return new OnboardingTaskReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        onboardingtasks);
    }
    public OnboardingTaskReadListResponse readByOnboardingTaskUpdatedAt(String onboardingtaskupdatedat) {
        List<OnboardingTask> onboardingtasks = onboardingtaskRepository.readByOnboardingTaskUpdatedAt(onboardingtaskupdatedat);
        return new OnboardingTaskReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        onboardingtasks);
    }
}
