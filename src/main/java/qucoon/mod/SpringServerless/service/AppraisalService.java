
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
import qucoon.mod.SpringServerless.repository.page.AppraisalPage;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.utility.constant.ResponseConstant;
import com.google.gson.Gson;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import qucoon.mod.SpringServerless.model.dto.AppraisalDto;


@Service
public class AppraisalService {

    private final AppraisalRepository appraisalRepository;
    private  final Gson GSON;


    public AppraisalService(AppraisalRepository appraisalRepository) {
        this.appraisalRepository = appraisalRepository;
        this.GSON = new GsonBuilder()
               .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
                .create();
    }



    public BaseResponse create(AppraisalCreateRequest request) {

        Appraisal appraisal = GSON.fromJson(GSON.toJson(request), Appraisal.class);
        if (appraisal.getAppraisalStatus() == null) {
            appraisal.setAppraisalStatus("ACTIVE");
        }
        appraisalRepository.create(appraisal);

        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse bulkCreate(List<AppraisalCreateRequest> request) {
        try {
            String json = GSON.toJson(request);
            Appraisal[] appraisalArray = GSON.fromJson(json, Appraisal[].class);
            List<Appraisal> appraisals = Arrays.asList(appraisalArray);
            appraisalRepository.bulkCreate(appraisals);
            return ResponseConstant.INSTANCE.getSUCCESS();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseConstant.INSTANCE.getBAD_REQUEST();
        }
    }

    public BaseResponse update(AppraisalUpdateRequest request) {
        Appraisal appraisal = appraisalRepository.readByAppraisalId(request.getAppraisalId());
        if (appraisal == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        appraisalRepository.update(appraisal);
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse delete(int appraisalId) {
        int updateResponse = appraisalRepository.delete(appraisalId);
        if (updateResponse < 1) {
            throw new CustomExceptions.FailedToUpdateRecord("Record not found");
        }
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public AppraisalReadListResponse read() {
        List<Appraisal> appraisals = appraisalRepository.read();
       if(appraisals == null){
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new AppraisalReadListResponse(ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(), ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(), appraisals);
    }
   public AppraisalReadPagedResponse search(AppraisalFilterRequest filter) {
    // reuse same repository call for search, since filter includes search criteria
       AppraisalPage page = appraisalRepository.findAppraisal(filter);
       int totalPages = (int) Math.ceil((double) page.getTotalRecords() / filter.getPageSize());
       List<AppraisalDto> dtos = page.getData().stream()
            .map(AppraisalDto::from)
            .collect(Collectors.toList());
    return new AppraisalReadPagedResponse(
            ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
            ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
            dtos,
            page.getTotalRecords(),
            filter.getPageNumber(),
            filter.getPageSize(),
            totalPages
    );
}
    public AppraisalReadListResponse readByAppraisalCreatedAt(String appraisalcreatedat) {
        List<Appraisal> appraisals = appraisalRepository.readByAppraisalCreatedAt(appraisalcreatedat);
        return new AppraisalReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        appraisals);
    }
    public AppraisalReadListResponse readByAppraisalDate(String appraisaldate) {
        List<Appraisal> appraisals = appraisalRepository.readByAppraisalDate(appraisaldate);
        return new AppraisalReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        appraisals);
    }
    public AppraisalReadListResponse readByAppraisalEmployeeIdRoleId(int appraisalemployeeidroleid) {
        List<Appraisal> appraisals = appraisalRepository.readByAppraisalEmployeeIdRoleId(appraisalemployeeidroleid);
        return new AppraisalReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        appraisals);
    }
    public AppraisalReadListResponse readByAppraisalFormId(int appraisalformid) {
        List<Appraisal> appraisals = appraisalRepository.readByAppraisalFormId(appraisalformid);
        return new AppraisalReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        appraisals);
    }
    public AppraisalReadListResponse readByAppraisalGeneralFeedback(String appraisalgeneralfeedback) {
        List<Appraisal> appraisals = appraisalRepository.readByAppraisalGeneralFeedback(appraisalgeneralfeedback);
        return new AppraisalReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        appraisals);
    }
    public AppraisalReadSingleResponse readByAppraisalId(int appraisalid) {
        Appraisal appraisal = appraisalRepository.readByAppraisalId(appraisalid);
        if (appraisal == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new AppraisalReadSingleResponse(
                ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
                ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
                appraisal);
    }
    public AppraisalReadListResponse readByAppraisalOverallScore(Double appraisaloverallscore) {
        List<Appraisal> appraisals = appraisalRepository.readByAppraisalOverallScore(appraisaloverallscore);
        return new AppraisalReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        appraisals);
    }
    public AppraisalReadListResponse readByAppraisalReviewerId(int appraisalreviewerid) {
        List<Appraisal> appraisals = appraisalRepository.readByAppraisalReviewerId(appraisalreviewerid);
        return new AppraisalReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        appraisals);
    }
    public AppraisalReadListResponse readByAppraisalStatus(String appraisalstatus) {
        List<Appraisal> appraisals = appraisalRepository.readByAppraisalStatus(appraisalstatus);
        return new AppraisalReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        appraisals);
    }
    public AppraisalReadListResponse readByAppraisalUpdatedAt(String appraisalupdatedat) {
        List<Appraisal> appraisals = appraisalRepository.readByAppraisalUpdatedAt(appraisalupdatedat);
        return new AppraisalReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        appraisals);
    }
}
