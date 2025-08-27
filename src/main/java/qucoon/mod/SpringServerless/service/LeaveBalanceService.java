
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
import qucoon.mod.SpringServerless.repository.page.LeaveBalancePage;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.utility.constant.ResponseConstant;
import com.google.gson.Gson;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import qucoon.mod.SpringServerless.model.dto.LeaveBalanceDto;


@Service
public class LeaveBalanceService {

    private final LeaveBalanceRepository leavebalanceRepository;
    private  final Gson GSON;


    public LeaveBalanceService(LeaveBalanceRepository leavebalanceRepository) {
        this.leavebalanceRepository = leavebalanceRepository;
        this.GSON = new GsonBuilder()
               .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
                .create();
    }



    public BaseResponse create(LeaveBalanceCreateRequest request) {

        LeaveBalance leavebalance = GSON.fromJson(GSON.toJson(request), LeaveBalance.class);
        if (leavebalance.getLeaveBalanceStatus() == null) {
            leavebalance.setLeaveBalanceStatus("ACTIVE");
        }
        leavebalanceRepository.create(leavebalance);

        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse bulkCreate(List<LeaveBalanceCreateRequest> request) {
        try {
            String json = GSON.toJson(request);
            LeaveBalance[] leavebalanceArray = GSON.fromJson(json, LeaveBalance[].class);
            List<LeaveBalance> leavebalances = Arrays.asList(leavebalanceArray);
            leavebalanceRepository.bulkCreate(leavebalances);
            return ResponseConstant.INSTANCE.getSUCCESS();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseConstant.INSTANCE.getBAD_REQUEST();
        }
    }

    public BaseResponse update(LeaveBalanceUpdateRequest request) {
        LeaveBalance leavebalance = leavebalanceRepository.readByLeaveBalanceId(request.getLeaveBalanceId());
        if (leavebalance == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        leavebalanceRepository.update(leavebalance);
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse delete(int leaveBalanceId) {
        int updateResponse = leavebalanceRepository.delete(leaveBalanceId);
        if (updateResponse < 1) {
            throw new CustomExceptions.FailedToUpdateRecord("Record not found");
        }
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public LeaveBalanceReadListResponse read() {
        List<LeaveBalance> leavebalances = leavebalanceRepository.read();
       if(leavebalances == null){
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new LeaveBalanceReadListResponse(ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(), ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(), leavebalances);
    }
   public LeaveBalanceReadPagedResponse search(LeaveBalanceFilterRequest filter) {
    // reuse same repository call for search, since filter includes search criteria
       LeaveBalancePage page = leavebalanceRepository.findLeaveBalance(filter);
       int totalPages = (int) Math.ceil((double) page.getTotalRecords() / filter.getPageSize());
       List<LeaveBalanceDto> dtos = page.getData().stream()
            .map(LeaveBalanceDto::from)
            .collect(Collectors.toList());
    return new LeaveBalanceReadPagedResponse(
            ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
            ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
            dtos,
            page.getTotalRecords(),
            filter.getPageNumber(),
            filter.getPageSize(),
            totalPages
    );
}
    public LeaveBalanceReadListResponse readByLeaveBalanceCreatedAt(String leavebalancecreatedat) {
        List<LeaveBalance> leavebalances = leavebalanceRepository.readByLeaveBalanceCreatedAt(leavebalancecreatedat);
        return new LeaveBalanceReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        leavebalances);
    }
    public LeaveBalanceReadListResponse readByLeaveBalanceEmployeeId(int leavebalanceemployeeid) {
        List<LeaveBalance> leavebalances = leavebalanceRepository.readByLeaveBalanceEmployeeId(leavebalanceemployeeid);
        return new LeaveBalanceReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        leavebalances);
    }
    public LeaveBalanceReadSingleResponse readByLeaveBalanceId(int leavebalanceid) {
        LeaveBalance leavebalance = leavebalanceRepository.readByLeaveBalanceId(leavebalanceid);
        if (leavebalance == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new LeaveBalanceReadSingleResponse(
                ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
                ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
                leavebalance);
    }
    public LeaveBalanceReadListResponse readByLeaveBalanceRemainingDays(int leavebalanceremainingdays) {
        List<LeaveBalance> leavebalances = leavebalanceRepository.readByLeaveBalanceRemainingDays(leavebalanceremainingdays);
        return new LeaveBalanceReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        leavebalances);
    }
    public LeaveBalanceReadListResponse readByLeaveBalanceStatus(String leavebalancestatus) {
        List<LeaveBalance> leavebalances = leavebalanceRepository.readByLeaveBalanceStatus(leavebalancestatus);
        return new LeaveBalanceReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        leavebalances);
    }
    public LeaveBalanceReadListResponse readByLeaveBalanceTotalDays(int leavebalancetotaldays) {
        List<LeaveBalance> leavebalances = leavebalanceRepository.readByLeaveBalanceTotalDays(leavebalancetotaldays);
        return new LeaveBalanceReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        leavebalances);
    }
    public LeaveBalanceReadListResponse readByLeaveBalanceTypeId(int leavebalancetypeid) {
        List<LeaveBalance> leavebalances = leavebalanceRepository.readByLeaveBalanceTypeId(leavebalancetypeid);
        return new LeaveBalanceReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        leavebalances);
    }
    public LeaveBalanceReadListResponse readByLeaveBalanceUpdatedAt(String leavebalanceupdatedat) {
        List<LeaveBalance> leavebalances = leavebalanceRepository.readByLeaveBalanceUpdatedAt(leavebalanceupdatedat);
        return new LeaveBalanceReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        leavebalances);
    }
    public LeaveBalanceReadListResponse readByLeaveBalanceUsedDays(int leavebalanceuseddays) {
        List<LeaveBalance> leavebalances = leavebalanceRepository.readByLeaveBalanceUsedDays(leavebalanceuseddays);
        return new LeaveBalanceReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        leavebalances);
    }
}
