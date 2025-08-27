
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
import qucoon.mod.SpringServerless.repository.page.AllowancePage;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.utility.constant.ResponseConstant;
import com.google.gson.Gson;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import qucoon.mod.SpringServerless.model.dto.AllowanceDto;


@Service
public class AllowanceService {

    private final AllowanceRepository allowanceRepository;
    private  final Gson GSON;


    public AllowanceService(AllowanceRepository allowanceRepository) {
        this.allowanceRepository = allowanceRepository;
        this.GSON = new GsonBuilder()
               .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
                .create();
    }



    public BaseResponse create(AllowanceCreateRequest request) {

        Allowance allowance = GSON.fromJson(GSON.toJson(request), Allowance.class);
        if (allowance.getAllowanceStatus() == null) {
            allowance.setAllowanceStatus("ACTIVE");
        }
        allowanceRepository.create(allowance);

        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse bulkCreate(List<AllowanceCreateRequest> request) {
        try {
            String json = GSON.toJson(request);
            Allowance[] allowanceArray = GSON.fromJson(json, Allowance[].class);
            List<Allowance> allowances = Arrays.asList(allowanceArray);
            allowanceRepository.bulkCreate(allowances);
            return ResponseConstant.INSTANCE.getSUCCESS();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseConstant.INSTANCE.getBAD_REQUEST();
        }
    }

    public BaseResponse update(AllowanceUpdateRequest request) {
        Allowance allowance = allowanceRepository.readByAllowanceId(request.getAllowanceId());
        if (allowance == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        allowanceRepository.update(allowance);
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse delete(int allowanceId) {
        int updateResponse = allowanceRepository.delete(allowanceId);
        if (updateResponse < 1) {
            throw new CustomExceptions.FailedToUpdateRecord("Record not found");
        }
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public AllowanceReadListResponse read() {
        List<Allowance> allowances = allowanceRepository.read();
       if(allowances == null){
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new AllowanceReadListResponse(ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(), ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(), allowances);
    }
   public AllowanceReadPagedResponse search(AllowanceFilterRequest filter) {
    // reuse same repository call for search, since filter includes search criteria
       AllowancePage page = allowanceRepository.findAllowance(filter);
       int totalPages = (int) Math.ceil((double) page.getTotalRecords() / filter.getPageSize());
       List<AllowanceDto> dtos = page.getData().stream()
            .map(AllowanceDto::from)
            .collect(Collectors.toList());
    return new AllowanceReadPagedResponse(
            ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
            ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
            dtos,
            page.getTotalRecords(),
            filter.getPageNumber(),
            filter.getPageSize(),
            totalPages
    );
}
    public AllowanceReadListResponse readByAllowanceAmount(Double allowanceamount) {
        List<Allowance> allowances = allowanceRepository.readByAllowanceAmount(allowanceamount);
        return new AllowanceReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        allowances);
    }
    public AllowanceReadListResponse readByAllowanceCreatedAt(String allowancecreatedat) {
        List<Allowance> allowances = allowanceRepository.readByAllowanceCreatedAt(allowancecreatedat);
        return new AllowanceReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        allowances);
    }
    public AllowanceReadSingleResponse readByAllowanceId(int allowanceid) {
        Allowance allowance = allowanceRepository.readByAllowanceId(allowanceid);
        if (allowance == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new AllowanceReadSingleResponse(
                ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
                ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
                allowance);
    }
    public AllowanceReadListResponse readByAllowanceSalaryId(int allowancesalaryid) {
        List<Allowance> allowances = allowanceRepository.readByAllowanceSalaryId(allowancesalaryid);
        return new AllowanceReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        allowances);
    }
    public AllowanceReadListResponse readByAllowanceStatus(String allowancestatus) {
        List<Allowance> allowances = allowanceRepository.readByAllowanceStatus(allowancestatus);
        return new AllowanceReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        allowances);
    }
    public AllowanceReadListResponse readByAllowanceType(String allowancetype) {
        List<Allowance> allowances = allowanceRepository.readByAllowanceType(allowancetype);
        return new AllowanceReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        allowances);
    }
    public AllowanceReadListResponse readByAllowanceUpdatedAt(String allowanceupdatedat) {
        List<Allowance> allowances = allowanceRepository.readByAllowanceUpdatedAt(allowanceupdatedat);
        return new AllowanceReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        allowances);
    }
}
