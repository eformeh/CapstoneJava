
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
import qucoon.mod.SpringServerless.repository.page.AppraisalResponsePage;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.utility.constant.ResponseConstant;
import com.google.gson.Gson;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import qucoon.mod.SpringServerless.model.dto.AppraisalResponseDto;


@Service
public class AppraisalResponseService {

    private final AppraisalResponseRepository appraisalresponseRepository;
    private  final Gson GSON;


    public AppraisalResponseService(AppraisalResponseRepository appraisalresponseRepository) {
        this.appraisalresponseRepository = appraisalresponseRepository;
        this.GSON = new GsonBuilder()
               .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
                .create();
    }



    public BaseResponse create(AppraisalResponseCreateRequest request) {

        AppraisalResponse appraisalresponse = GSON.fromJson(GSON.toJson(request), AppraisalResponse.class);
        if (appraisalresponse.getAppraisalResponseStatus() == null) {
            appraisalresponse.setAppraisalResponseStatus("ACTIVE");
        }
        appraisalresponseRepository.create(appraisalresponse);

        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse bulkCreate(List<AppraisalResponseCreateRequest> request) {
        try {
            String json = GSON.toJson(request);
            AppraisalResponse[] appraisalresponseArray = GSON.fromJson(json, AppraisalResponse[].class);
            List<AppraisalResponse> appraisalresponses = Arrays.asList(appraisalresponseArray);
            appraisalresponseRepository.bulkCreate(appraisalresponses);
            return ResponseConstant.INSTANCE.getSUCCESS();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseConstant.INSTANCE.getBAD_REQUEST();
        }
    }

    public BaseResponse update(AppraisalResponseUpdateRequest request) {
        AppraisalResponse appraisalresponse = appraisalresponseRepository.readByAppraisalResponseId(request.getAppraisalResponseId());
        if (appraisalresponse == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        appraisalresponseRepository.update(appraisalresponse);
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse delete(int appraisalResponseId) {
        int updateResponse = appraisalresponseRepository.delete(appraisalResponseId);
        if (updateResponse < 1) {
            throw new CustomExceptions.FailedToUpdateRecord("Record not found");
        }
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public AppraisalResponseReadListResponse read() {
        List<AppraisalResponse> appraisalresponses = appraisalresponseRepository.read();
       if(appraisalresponses == null){
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new AppraisalResponseReadListResponse(ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(), ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(), appraisalresponses);
    }
   public AppraisalResponseReadPagedResponse search(AppraisalResponseFilterRequest filter) {
    // reuse same repository call for search, since filter includes search criteria
       AppraisalResponsePage page = appraisalresponseRepository.findAppraisalResponse(filter);
       int totalPages = (int) Math.ceil((double) page.getTotalRecords() / filter.getPageSize());
       List<AppraisalResponseDto> dtos = page.getData().stream()
            .map(AppraisalResponseDto::from)
            .collect(Collectors.toList());
    return new AppraisalResponseReadPagedResponse(
            ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
            ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
            dtos,
            page.getTotalRecords(),
            filter.getPageNumber(),
            filter.getPageSize(),
            totalPages
    );
}
    public AppraisalResponseReadListResponse readByAppraisalResponseAppraisalId(int appraisalresponseappraisalid) {
        List<AppraisalResponse> appraisalresponses = appraisalresponseRepository.readByAppraisalResponseAppraisalId(appraisalresponseappraisalid);
        return new AppraisalResponseReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        appraisalresponses);
    }
    public AppraisalResponseReadListResponse readByAppraisalResponseCreatedAt(String appraisalresponsecreatedat) {
        List<AppraisalResponse> appraisalresponses = appraisalresponseRepository.readByAppraisalResponseCreatedAt(appraisalresponsecreatedat);
        return new AppraisalResponseReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        appraisalresponses);
    }
    public AppraisalResponseReadSingleResponse readByAppraisalResponseId(int appraisalresponseid) {
        AppraisalResponse appraisalresponse = appraisalresponseRepository.readByAppraisalResponseId(appraisalresponseid);
        if (appraisalresponse == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new AppraisalResponseReadSingleResponse(
                ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
                ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
                appraisalresponse);
    }
    public AppraisalResponseReadListResponse readByAppraisalResponseQuestionId(int appraisalresponsequestionid) {
        List<AppraisalResponse> appraisalresponses = appraisalresponseRepository.readByAppraisalResponseQuestionId(appraisalresponsequestionid);
        return new AppraisalResponseReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        appraisalresponses);
    }
    public AppraisalResponseReadListResponse readByAppraisalResponseScore(Double appraisalresponsescore) {
        List<AppraisalResponse> appraisalresponses = appraisalresponseRepository.readByAppraisalResponseScore(appraisalresponsescore);
        return new AppraisalResponseReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        appraisalresponses);
    }
    public AppraisalResponseReadListResponse readByAppraisalResponseStatus(String appraisalresponsestatus) {
        List<AppraisalResponse> appraisalresponses = appraisalresponseRepository.readByAppraisalResponseStatus(appraisalresponsestatus);
        return new AppraisalResponseReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        appraisalresponses);
    }
    public AppraisalResponseReadListResponse readByAppraisalResponseUpdatedAt(String appraisalresponseupdatedat) {
        List<AppraisalResponse> appraisalresponses = appraisalresponseRepository.readByAppraisalResponseUpdatedAt(appraisalresponseupdatedat);
        return new AppraisalResponseReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        appraisalresponses);
    }
    public AppraisalResponseReadListResponse readByAppraisalResponseValue(String appraisalresponsevalue) {
        List<AppraisalResponse> appraisalresponses = appraisalresponseRepository.readByAppraisalResponseValue(appraisalresponsevalue);
        return new AppraisalResponseReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        appraisalresponses);
    }
}
