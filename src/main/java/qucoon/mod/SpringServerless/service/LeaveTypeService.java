
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
import qucoon.mod.SpringServerless.repository.page.LeaveTypePage;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.utility.constant.ResponseConstant;
import com.google.gson.Gson;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import qucoon.mod.SpringServerless.model.dto.LeaveTypeDto;


@Service
public class LeaveTypeService {

    private final LeaveTypeRepository leavetypeRepository;
    private  final Gson GSON;


    public LeaveTypeService(LeaveTypeRepository leavetypeRepository) {
        this.leavetypeRepository = leavetypeRepository;
        this.GSON = new GsonBuilder()
               .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
                .create();
    }



    public BaseResponse create(LeaveTypeCreateRequest request) {

        LeaveType leavetype = GSON.fromJson(GSON.toJson(request), LeaveType.class);
        if (leavetype.getLeaveTypeStatus() == null) {
            leavetype.setLeaveTypeStatus("ACTIVE");
        }
        leavetypeRepository.create(leavetype);

        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse bulkCreate(List<LeaveTypeCreateRequest> request) {
        try {
            String json = GSON.toJson(request);
            LeaveType[] leavetypeArray = GSON.fromJson(json, LeaveType[].class);
            List<LeaveType> leavetypes = Arrays.asList(leavetypeArray);
            leavetypeRepository.bulkCreate(leavetypes);
            return ResponseConstant.INSTANCE.getSUCCESS();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseConstant.INSTANCE.getBAD_REQUEST();
        }
    }

    public BaseResponse update(LeaveTypeUpdateRequest request) {
        LeaveType leavetype = leavetypeRepository.readByLeaveTypeId(request.getLeaveTypeId());
        if (leavetype == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        leavetypeRepository.update(leavetype);
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse delete(int leaveTypeId) {
        int updateResponse = leavetypeRepository.delete(leaveTypeId);
        if (updateResponse < 1) {
            throw new CustomExceptions.FailedToUpdateRecord("Record not found");
        }
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public LeaveTypeReadListResponse read() {
        List<LeaveType> leavetypes = leavetypeRepository.read();
       if(leavetypes == null){
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new LeaveTypeReadListResponse(ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(), ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(), leavetypes);
    }
   public LeaveTypeReadPagedResponse search(LeaveTypeFilterRequest filter) {
    // reuse same repository call for search, since filter includes search criteria
       LeaveTypePage page = leavetypeRepository.findLeaveType(filter);
       int totalPages = (int) Math.ceil((double) page.getTotalRecords() / filter.getPageSize());
       List<LeaveTypeDto> dtos = page.getData().stream()
            .map(LeaveTypeDto::from)
            .collect(Collectors.toList());
    return new LeaveTypeReadPagedResponse(
            ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
            ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
            dtos,
            page.getTotalRecords(),
            filter.getPageNumber(),
            filter.getPageSize(),
            totalPages
    );
}
    public LeaveTypeReadListResponse readByLeaveTypeAccrualRatePerMonth(Double leavetypeaccrualratepermonth) {
        List<LeaveType> leavetypes = leavetypeRepository.readByLeaveTypeAccrualRatePerMonth(leavetypeaccrualratepermonth);
        return new LeaveTypeReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        leavetypes);
    }
    public LeaveTypeReadListResponse readByLeaveTypeCreatedAt(String leavetypecreatedat) {
        List<LeaveType> leavetypes = leavetypeRepository.readByLeaveTypeCreatedAt(leavetypecreatedat);
        return new LeaveTypeReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        leavetypes);
    }
    public LeaveTypeReadListResponse readByLeaveTypeDescription(String leavetypedescription) {
        List<LeaveType> leavetypes = leavetypeRepository.readByLeaveTypeDescription(leavetypedescription);
        return new LeaveTypeReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        leavetypes);
    }
    public LeaveTypeReadSingleResponse readByLeaveTypeId(int leavetypeid) {
        LeaveType leavetype = leavetypeRepository.readByLeaveTypeId(leavetypeid);
        if (leavetype == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new LeaveTypeReadSingleResponse(
                ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
                ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
                leavetype);
    }
    public LeaveTypeReadListResponse readByLeaveTypeName(String leavetypename) {
        List<LeaveType> leavetypes = leavetypeRepository.readByLeaveTypeName(leavetypename);
        return new LeaveTypeReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        leavetypes);
    }
    public LeaveTypeReadListResponse readByLeaveTypeResetPolicy(String leavetyperesetpolicy) {
        List<LeaveType> leavetypes = leavetypeRepository.readByLeaveTypeResetPolicy(leavetyperesetpolicy);
        return new LeaveTypeReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        leavetypes);
    }
    public LeaveTypeReadListResponse readByLeaveTypeStatus(String leavetypestatus) {
        List<LeaveType> leavetypes = leavetypeRepository.readByLeaveTypeStatus(leavetypestatus);
        return new LeaveTypeReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        leavetypes);
    }
    public LeaveTypeReadListResponse readByLeaveTypeUpdatedAt(String leavetypeupdatedat) {
        List<LeaveType> leavetypes = leavetypeRepository.readByLeaveTypeUpdatedAt(leavetypeupdatedat);
        return new LeaveTypeReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        leavetypes);
    }
}
