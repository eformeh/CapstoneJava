
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
import qucoon.mod.SpringServerless.repository.page.DeductionPage;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.utility.constant.ResponseConstant;
import com.google.gson.Gson;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import qucoon.mod.SpringServerless.model.dto.DeductionDto;


@Service
public class DeductionService {

    private final DeductionRepository deductionRepository;
    private  final Gson GSON;


    public DeductionService(DeductionRepository deductionRepository) {
        this.deductionRepository = deductionRepository;
        this.GSON = new GsonBuilder()
               .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
                .create();
    }



    public BaseResponse create(DeductionCreateRequest request) {

        Deduction deduction = GSON.fromJson(GSON.toJson(request), Deduction.class);
        if (deduction.getDeductionStatus() == null) {
            deduction.setDeductionStatus("ACTIVE");
        }
        deductionRepository.create(deduction);

        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse bulkCreate(List<DeductionCreateRequest> request) {
        try {
            String json = GSON.toJson(request);
            Deduction[] deductionArray = GSON.fromJson(json, Deduction[].class);
            List<Deduction> deductions = Arrays.asList(deductionArray);
            deductionRepository.bulkCreate(deductions);
            return ResponseConstant.INSTANCE.getSUCCESS();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseConstant.INSTANCE.getBAD_REQUEST();
        }
    }

    public BaseResponse update(DeductionUpdateRequest request) {
        Deduction deduction = deductionRepository.readByDeductionId(request.getDeductionId());
        if (deduction == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        deductionRepository.update(deduction);
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse delete(int deductionId) {
        int updateResponse = deductionRepository.delete(deductionId);
        if (updateResponse < 1) {
            throw new CustomExceptions.FailedToUpdateRecord("Record not found");
        }
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public DeductionReadListResponse read() {
        List<Deduction> deductions = deductionRepository.read();
       if(deductions == null){
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new DeductionReadListResponse(ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(), ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(), deductions);
    }
   public DeductionReadPagedResponse search(DeductionFilterRequest filter) {
    // reuse same repository call for search, since filter includes search criteria
       DeductionPage page = deductionRepository.findDeduction(filter);
       int totalPages = (int) Math.ceil((double) page.getTotalRecords() / filter.getPageSize());
       List<DeductionDto> dtos = page.getData().stream()
            .map(DeductionDto::from)
            .collect(Collectors.toList());
    return new DeductionReadPagedResponse(
            ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
            ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
            dtos,
            page.getTotalRecords(),
            filter.getPageNumber(),
            filter.getPageSize(),
            totalPages
    );
}
    public DeductionReadListResponse readByDeductionAmount(Double deductionamount) {
        List<Deduction> deductions = deductionRepository.readByDeductionAmount(deductionamount);
        return new DeductionReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        deductions);
    }
    public DeductionReadListResponse readByDeductionCreatedAt(String deductioncreatedat) {
        List<Deduction> deductions = deductionRepository.readByDeductionCreatedAt(deductioncreatedat);
        return new DeductionReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        deductions);
    }
    public DeductionReadSingleResponse readByDeductionId(int deductionid) {
        Deduction deduction = deductionRepository.readByDeductionId(deductionid);
        if (deduction == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new DeductionReadSingleResponse(
                ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
                ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
                deduction);
    }
    public DeductionReadListResponse readByDeductionSalaryId(int deductionsalaryid) {
        List<Deduction> deductions = deductionRepository.readByDeductionSalaryId(deductionsalaryid);
        return new DeductionReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        deductions);
    }
    public DeductionReadListResponse readByDeductionStatus(String deductionstatus) {
        List<Deduction> deductions = deductionRepository.readByDeductionStatus(deductionstatus);
        return new DeductionReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        deductions);
    }
    public DeductionReadListResponse readByDeductionType(String deductiontype) {
        List<Deduction> deductions = deductionRepository.readByDeductionType(deductiontype);
        return new DeductionReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        deductions);
    }
    public DeductionReadListResponse readByDeductionUpdatedAt(String deductionupdatedat) {
        List<Deduction> deductions = deductionRepository.readByDeductionUpdatedAt(deductionupdatedat);
        return new DeductionReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        deductions);
    }
}
