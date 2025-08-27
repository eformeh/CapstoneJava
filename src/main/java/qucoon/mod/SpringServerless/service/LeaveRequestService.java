
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
import qucoon.mod.SpringServerless.repository.page.LeaveRequestPage;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.utility.constant.ResponseConstant;
import com.google.gson.Gson;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import qucoon.mod.SpringServerless.model.dto.LeaveRequestDto;


@Service
public class LeaveRequestService {

    private final LeaveRequestRepository leaverequestRepository;
    private  final Gson GSON;


    public LeaveRequestService(LeaveRequestRepository leaverequestRepository) {
        this.leaverequestRepository = leaverequestRepository;
        this.GSON = new GsonBuilder()
               .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
                .create();
    }



    public BaseResponse create(LeaveRequestCreateRequest request) {
        //Unique Attribute Check
        List<LeaveRequest> leaverequest_1 = leaverequestRepository.readByLeaveRequestTypeId(request.getLeaveRequestTypeId());
        if (!leaverequest_1.isEmpty()) {
            throw new CustomExceptions.DuplicateItemException("+LeaveRequest with LeaveRequestTypeId: " + request.getLeaveRequestTypeId() + " already exists");
        }


        LeaveRequest leaverequest = GSON.fromJson(GSON.toJson(request), LeaveRequest.class);
        if (leaverequest.getLeaveRequestStatus() == null) {
            leaverequest.setLeaveRequestStatus("ACTIVE");
        }
        leaverequestRepository.create(leaverequest);

        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse bulkCreate(List<LeaveRequestCreateRequest> request) {
        try {
            String json = GSON.toJson(request);
            LeaveRequest[] leaverequestArray = GSON.fromJson(json, LeaveRequest[].class);
            List<LeaveRequest> leaverequests = Arrays.asList(leaverequestArray);
            leaverequestRepository.bulkCreate(leaverequests);
            return ResponseConstant.INSTANCE.getSUCCESS();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseConstant.INSTANCE.getBAD_REQUEST();
        }
    }

    public BaseResponse update(LeaveRequestUpdateRequest request) {
        LeaveRequest leaverequest = leaverequestRepository.readByLeaveRequestId(request.getLeaveRequestId());
        if (leaverequest == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        leaverequestRepository.update(leaverequest);
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse delete(int leaveRequestId) {
        int updateResponse = leaverequestRepository.delete(leaveRequestId);
        if (updateResponse < 1) {
            throw new CustomExceptions.FailedToUpdateRecord("Record not found");
        }
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public LeaveRequestReadListResponse read() {
        List<LeaveRequest> leaverequests = leaverequestRepository.read();
       if(leaverequests == null){
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new LeaveRequestReadListResponse(ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(), ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(), leaverequests);
    }
   public LeaveRequestReadPagedResponse search(LeaveRequestFilterRequest filter) {
    // reuse same repository call for search, since filter includes search criteria
       LeaveRequestPage page = leaverequestRepository.findLeaveRequest(filter);
       int totalPages = (int) Math.ceil((double) page.getTotalRecords() / filter.getPageSize());
       List<LeaveRequestDto> dtos = page.getData().stream()
            .map(LeaveRequestDto::from)
            .collect(Collectors.toList());
    return new LeaveRequestReadPagedResponse(
            ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
            ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
            dtos,
            page.getTotalRecords(),
            filter.getPageNumber(),
            filter.getPageSize(),
            totalPages
    );
}
    public LeaveRequestReadListResponse readByLeaveRequestCreatedAt(String leaverequestcreatedat) {
        List<LeaveRequest> leaverequests = leaverequestRepository.readByLeaveRequestCreatedAt(leaverequestcreatedat);
        return new LeaveRequestReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        leaverequests);
    }
    public LeaveRequestReadListResponse readByLeaveRequestDecisionDate(String leaverequestdecisiondate) {
        List<LeaveRequest> leaverequests = leaverequestRepository.readByLeaveRequestDecisionDate(leaverequestdecisiondate);
        return new LeaveRequestReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        leaverequests);
    }
    public LeaveRequestReadListResponse readByLeaveRequestEmployeeId(int leaverequestemployeeid) {
        List<LeaveRequest> leaverequests = leaverequestRepository.readByLeaveRequestEmployeeId(leaverequestemployeeid);
        return new LeaveRequestReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        leaverequests);
    }
    public LeaveRequestReadListResponse readByLeaveRequestEndDate(String leaverequestenddate) {
        List<LeaveRequest> leaverequests = leaverequestRepository.readByLeaveRequestEndDate(leaverequestenddate);
        return new LeaveRequestReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        leaverequests);
    }
    public LeaveRequestReadSingleResponse readByLeaveRequestId(int leaverequestid) {
        LeaveRequest leaverequest = leaverequestRepository.readByLeaveRequestId(leaverequestid);
        if (leaverequest == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new LeaveRequestReadSingleResponse(
                ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
                ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
                leaverequest);
    }
    public LeaveRequestReadListResponse readByLeaveRequestReason(String leaverequestreason) {
        List<LeaveRequest> leaverequests = leaverequestRepository.readByLeaveRequestReason(leaverequestreason);
        return new LeaveRequestReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        leaverequests);
    }
    public LeaveRequestReadListResponse readByLeaveRequestReviewerId(int leaverequestreviewerid) {
        List<LeaveRequest> leaverequests = leaverequestRepository.readByLeaveRequestReviewerId(leaverequestreviewerid);
        return new LeaveRequestReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        leaverequests);
    }
    public LeaveRequestReadListResponse readByLeaveRequestStartDate(String leaverequeststartdate) {
        List<LeaveRequest> leaverequests = leaverequestRepository.readByLeaveRequestStartDate(leaverequeststartdate);
        return new LeaveRequestReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        leaverequests);
    }
    public LeaveRequestReadListResponse readByLeaveRequestStatus(String leaverequeststatus) {
        List<LeaveRequest> leaverequests = leaverequestRepository.readByLeaveRequestStatus(leaverequeststatus);
        return new LeaveRequestReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        leaverequests);
    }
    public LeaveRequestReadListResponse readByLeaveRequestSubmittedAt(String leaverequestsubmittedat) {
        List<LeaveRequest> leaverequests = leaverequestRepository.readByLeaveRequestSubmittedAt(leaverequestsubmittedat);
        return new LeaveRequestReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        leaverequests);
    }
    public LeaveRequestReadSingleResponse readByLeaveRequestTypeId(int leaverequesttypeid) {
        List<LeaveRequest> leaverequest = leaverequestRepository.readByLeaveRequestTypeId(leaverequesttypeid);
        if (leaverequest == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new LeaveRequestReadSingleResponse(
                ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
                ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
                leaverequest.get(0));
    }
    public LeaveRequestReadListResponse readByLeaveRequestUpdatedAt(String leaverequestupdatedat) {
        List<LeaveRequest> leaverequests = leaverequestRepository.readByLeaveRequestUpdatedAt(leaverequestupdatedat);
        return new LeaveRequestReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        leaverequests);
    }
}
