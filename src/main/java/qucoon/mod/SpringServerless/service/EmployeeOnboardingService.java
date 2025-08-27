
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
import qucoon.mod.SpringServerless.repository.page.EmployeeOnboardingPage;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.utility.constant.ResponseConstant;
import com.google.gson.Gson;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import qucoon.mod.SpringServerless.model.dto.EmployeeOnboardingDto;


@Service
public class EmployeeOnboardingService {

    private final EmployeeOnboardingRepository employeeonboardingRepository;
    private  final Gson GSON;


    public EmployeeOnboardingService(EmployeeOnboardingRepository employeeonboardingRepository) {
        this.employeeonboardingRepository = employeeonboardingRepository;
        this.GSON = new GsonBuilder()
               .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
                .create();
    }



    public BaseResponse create(EmployeeOnboardingCreateRequest request) {

        EmployeeOnboarding employeeonboarding = GSON.fromJson(GSON.toJson(request), EmployeeOnboarding.class);
        if (employeeonboarding.getEmployeeOnboardingStatus() == null) {
            employeeonboarding.setEmployeeOnboardingStatus("ACTIVE");
        }
        employeeonboardingRepository.create(employeeonboarding);

        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse bulkCreate(List<EmployeeOnboardingCreateRequest> request) {
        try {
            String json = GSON.toJson(request);
            EmployeeOnboarding[] employeeonboardingArray = GSON.fromJson(json, EmployeeOnboarding[].class);
            List<EmployeeOnboarding> employeeonboardings = Arrays.asList(employeeonboardingArray);
            employeeonboardingRepository.bulkCreate(employeeonboardings);
            return ResponseConstant.INSTANCE.getSUCCESS();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseConstant.INSTANCE.getBAD_REQUEST();
        }
    }

    public BaseResponse update(EmployeeOnboardingUpdateRequest request) {
        EmployeeOnboarding employeeonboarding = employeeonboardingRepository.readByEmployeeOnboardingId(request.getEmployeeOnboardingId());
        if (employeeonboarding == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        employeeonboardingRepository.update(employeeonboarding);
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse delete(int employeeOnboardingId) {
        int updateResponse = employeeonboardingRepository.delete(employeeOnboardingId);
        if (updateResponse < 1) {
            throw new CustomExceptions.FailedToUpdateRecord("Record not found");
        }
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public EmployeeOnboardingReadListResponse read() {
        List<EmployeeOnboarding> employeeonboardings = employeeonboardingRepository.read();
       if(employeeonboardings == null){
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new EmployeeOnboardingReadListResponse(ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(), ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(), employeeonboardings);
    }
   public EmployeeOnboardingReadPagedResponse search(EmployeeOnboardingFilterRequest filter) {
    // reuse same repository call for search, since filter includes search criteria
       EmployeeOnboardingPage page = employeeonboardingRepository.findEmployeeOnboarding(filter);
       int totalPages = (int) Math.ceil((double) page.getTotalRecords() / filter.getPageSize());
       List<EmployeeOnboardingDto> dtos = page.getData().stream()
            .map(EmployeeOnboardingDto::from)
            .collect(Collectors.toList());
    return new EmployeeOnboardingReadPagedResponse(
            ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
            ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
            dtos,
            page.getTotalRecords(),
            filter.getPageNumber(),
            filter.getPageSize(),
            totalPages
    );
}
    public EmployeeOnboardingReadListResponse readByEmployeeOnboardingAssignedBy(int employeeonboardingassignedby) {
        List<EmployeeOnboarding> employeeonboardings = employeeonboardingRepository.readByEmployeeOnboardingAssignedBy(employeeonboardingassignedby);
        return new EmployeeOnboardingReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        employeeonboardings);
    }
    public EmployeeOnboardingReadListResponse readByEmployeeOnboardingAttachmentUrl(String employeeonboardingattachmenturl) {
        List<EmployeeOnboarding> employeeonboardings = employeeonboardingRepository.readByEmployeeOnboardingAttachmentUrl(employeeonboardingattachmenturl);
        return new EmployeeOnboardingReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        employeeonboardings);
    }
    public EmployeeOnboardingReadListResponse readByEmployeeOnboardingCompletedDate(String employeeonboardingcompleteddate) {
        List<EmployeeOnboarding> employeeonboardings = employeeonboardingRepository.readByEmployeeOnboardingCompletedDate(employeeonboardingcompleteddate);
        return new EmployeeOnboardingReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        employeeonboardings);
    }
    public EmployeeOnboardingReadListResponse readByEmployeeOnboardingCreatedAt(String employeeonboardingcreatedat) {
        List<EmployeeOnboarding> employeeonboardings = employeeonboardingRepository.readByEmployeeOnboardingCreatedAt(employeeonboardingcreatedat);
        return new EmployeeOnboardingReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        employeeonboardings);
    }
    public EmployeeOnboardingReadListResponse readByEmployeeOnboardingDueDate(String employeeonboardingduedate) {
        List<EmployeeOnboarding> employeeonboardings = employeeonboardingRepository.readByEmployeeOnboardingDueDate(employeeonboardingduedate);
        return new EmployeeOnboardingReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        employeeonboardings);
    }
    public EmployeeOnboardingReadListResponse readByEmployeeOnboardingEmployeeId(int employeeonboardingemployeeid) {
        List<EmployeeOnboarding> employeeonboardings = employeeonboardingRepository.readByEmployeeOnboardingEmployeeId(employeeonboardingemployeeid);
        return new EmployeeOnboardingReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        employeeonboardings);
    }
    public EmployeeOnboardingReadSingleResponse readByEmployeeOnboardingId(int employeeonboardingid) {
        EmployeeOnboarding employeeonboarding = employeeonboardingRepository.readByEmployeeOnboardingId(employeeonboardingid);
        if (employeeonboarding == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new EmployeeOnboardingReadSingleResponse(
                ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
                ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
                employeeonboarding);
    }
    public EmployeeOnboardingReadListResponse readByEmployeeOnboardingNotes(String employeeonboardingnotes) {
        List<EmployeeOnboarding> employeeonboardings = employeeonboardingRepository.readByEmployeeOnboardingNotes(employeeonboardingnotes);
        return new EmployeeOnboardingReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        employeeonboardings);
    }
    public EmployeeOnboardingReadListResponse readByEmployeeOnboardingStatus(String employeeonboardingstatus) {
        List<EmployeeOnboarding> employeeonboardings = employeeonboardingRepository.readByEmployeeOnboardingStatus(employeeonboardingstatus);
        return new EmployeeOnboardingReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        employeeonboardings);
    }
    public EmployeeOnboardingReadListResponse readByEmployeeOnboardingTaskId(int employeeonboardingtaskid) {
        List<EmployeeOnboarding> employeeonboardings = employeeonboardingRepository.readByEmployeeOnboardingTaskId(employeeonboardingtaskid);
        return new EmployeeOnboardingReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        employeeonboardings);
    }
    public EmployeeOnboardingReadListResponse readByEmployeeOnboardingUpdatedAt(String employeeonboardingupdatedat) {
        List<EmployeeOnboarding> employeeonboardings = employeeonboardingRepository.readByEmployeeOnboardingUpdatedAt(employeeonboardingupdatedat);
        return new EmployeeOnboardingReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        employeeonboardings);
    }
}
