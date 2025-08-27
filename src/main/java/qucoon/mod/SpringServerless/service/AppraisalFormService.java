
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
import qucoon.mod.SpringServerless.repository.page.AppraisalFormPage;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.utility.constant.ResponseConstant;
import com.google.gson.Gson;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import qucoon.mod.SpringServerless.model.dto.AppraisalFormDto;


@Service
public class AppraisalFormService {

    private final AppraisalFormRepository appraisalformRepository;
    private  final Gson GSON;


    public AppraisalFormService(AppraisalFormRepository appraisalformRepository) {
        this.appraisalformRepository = appraisalformRepository;
        this.GSON = new GsonBuilder()
               .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
                .create();
    }



    public BaseResponse create(AppraisalFormCreateRequest request) {

        AppraisalForm appraisalform = GSON.fromJson(GSON.toJson(request), AppraisalForm.class);
        if (appraisalform.getAppraisalFormStatus() == null) {
            appraisalform.setAppraisalFormStatus("ACTIVE");
        }
        appraisalformRepository.create(appraisalform);

        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse bulkCreate(List<AppraisalFormCreateRequest> request) {
        try {
            String json = GSON.toJson(request);
            AppraisalForm[] appraisalformArray = GSON.fromJson(json, AppraisalForm[].class);
            List<AppraisalForm> appraisalforms = Arrays.asList(appraisalformArray);
            appraisalformRepository.bulkCreate(appraisalforms);
            return ResponseConstant.INSTANCE.getSUCCESS();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseConstant.INSTANCE.getBAD_REQUEST();
        }
    }

    public BaseResponse update(AppraisalFormUpdateRequest request) {
        AppraisalForm appraisalform = appraisalformRepository.readByAppraisalFormId(request.getAppraisalFormId());
        if (appraisalform == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        appraisalformRepository.update(appraisalform);
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse delete(int appraisalFormId) {
        int updateResponse = appraisalformRepository.delete(appraisalFormId);
        if (updateResponse < 1) {
            throw new CustomExceptions.FailedToUpdateRecord("Record not found");
        }
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public AppraisalFormReadListResponse read() {
        List<AppraisalForm> appraisalforms = appraisalformRepository.read();
       if(appraisalforms == null){
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new AppraisalFormReadListResponse(ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(), ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(), appraisalforms);
    }
   public AppraisalFormReadPagedResponse search(AppraisalFormFilterRequest filter) {
    // reuse same repository call for search, since filter includes search criteria
       AppraisalFormPage page = appraisalformRepository.findAppraisalForm(filter);
       int totalPages = (int) Math.ceil((double) page.getTotalRecords() / filter.getPageSize());
       List<AppraisalFormDto> dtos = page.getData().stream()
            .map(AppraisalFormDto::from)
            .collect(Collectors.toList());
    return new AppraisalFormReadPagedResponse(
            ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
            ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
            dtos,
            page.getTotalRecords(),
            filter.getPageNumber(),
            filter.getPageSize(),
            totalPages
    );
}
    public AppraisalFormReadListResponse readByAppraisalFormCreatedAt(String appraisalformcreatedat) {
        List<AppraisalForm> appraisalforms = appraisalformRepository.readByAppraisalFormCreatedAt(appraisalformcreatedat);
        return new AppraisalFormReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        appraisalforms);
    }
    public AppraisalFormReadListResponse readByAppraisalFormCreatedBy(int appraisalformcreatedby) {
        List<AppraisalForm> appraisalforms = appraisalformRepository.readByAppraisalFormCreatedBy(appraisalformcreatedby);
        return new AppraisalFormReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        appraisalforms);
    }
    public AppraisalFormReadListResponse readByAppraisalFormDescription(String appraisalformdescription) {
        List<AppraisalForm> appraisalforms = appraisalformRepository.readByAppraisalFormDescription(appraisalformdescription);
        return new AppraisalFormReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        appraisalforms);
    }
    public AppraisalFormReadSingleResponse readByAppraisalFormId(int appraisalformid) {
        AppraisalForm appraisalform = appraisalformRepository.readByAppraisalFormId(appraisalformid);
        if (appraisalform == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new AppraisalFormReadSingleResponse(
                ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
                ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
                appraisalform);
    }
    public AppraisalFormReadListResponse readByAppraisalFormName(String appraisalformname) {
        List<AppraisalForm> appraisalforms = appraisalformRepository.readByAppraisalFormName(appraisalformname);
        return new AppraisalFormReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        appraisalforms);
    }
    public AppraisalFormReadListResponse readByAppraisalFormStatus(String appraisalformstatus) {
        List<AppraisalForm> appraisalforms = appraisalformRepository.readByAppraisalFormStatus(appraisalformstatus);
        return new AppraisalFormReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        appraisalforms);
    }
    public AppraisalFormReadListResponse readByAppraisalFormUpdatedAt(String appraisalformupdatedat) {
        List<AppraisalForm> appraisalforms = appraisalformRepository.readByAppraisalFormUpdatedAt(appraisalformupdatedat);
        return new AppraisalFormReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        appraisalforms);
    }
}
