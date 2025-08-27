
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
import qucoon.mod.SpringServerless.repository.page.AppraisalQuestionPage;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.utility.constant.ResponseConstant;
import com.google.gson.Gson;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import qucoon.mod.SpringServerless.model.dto.AppraisalQuestionDto;


@Service
public class AppraisalQuestionService {

    private final AppraisalQuestionRepository appraisalquestionRepository;
    private  final Gson GSON;


    public AppraisalQuestionService(AppraisalQuestionRepository appraisalquestionRepository) {
        this.appraisalquestionRepository = appraisalquestionRepository;
        this.GSON = new GsonBuilder()
               .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
                .create();
    }



    public BaseResponse create(AppraisalQuestionCreateRequest request) {

        AppraisalQuestion appraisalquestion = GSON.fromJson(GSON.toJson(request), AppraisalQuestion.class);
        if (appraisalquestion.getAppraisalQuestionStatus() == null) {
            appraisalquestion.setAppraisalQuestionStatus("ACTIVE");
        }
        appraisalquestionRepository.create(appraisalquestion);

        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse bulkCreate(List<AppraisalQuestionCreateRequest> request) {
        try {
            String json = GSON.toJson(request);
            AppraisalQuestion[] appraisalquestionArray = GSON.fromJson(json, AppraisalQuestion[].class);
            List<AppraisalQuestion> appraisalquestions = Arrays.asList(appraisalquestionArray);
            appraisalquestionRepository.bulkCreate(appraisalquestions);
            return ResponseConstant.INSTANCE.getSUCCESS();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseConstant.INSTANCE.getBAD_REQUEST();
        }
    }

    public BaseResponse update(AppraisalQuestionUpdateRequest request) {
        AppraisalQuestion appraisalquestion = appraisalquestionRepository.readByAppraisalQuestionId(request.getAppraisalQuestionId());
        if (appraisalquestion == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        appraisalquestionRepository.update(appraisalquestion);
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse delete(int appraisalQuestionId) {
        int updateResponse = appraisalquestionRepository.delete(appraisalQuestionId);
        if (updateResponse < 1) {
            throw new CustomExceptions.FailedToUpdateRecord("Record not found");
        }
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public AppraisalQuestionReadListResponse read() {
        List<AppraisalQuestion> appraisalquestions = appraisalquestionRepository.read();
       if(appraisalquestions == null){
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new AppraisalQuestionReadListResponse(ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(), ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(), appraisalquestions);
    }
   public AppraisalQuestionReadPagedResponse search(AppraisalQuestionFilterRequest filter) {
    // reuse same repository call for search, since filter includes search criteria
       AppraisalQuestionPage page = appraisalquestionRepository.findAppraisalQuestion(filter);
       int totalPages = (int) Math.ceil((double) page.getTotalRecords() / filter.getPageSize());
       List<AppraisalQuestionDto> dtos = page.getData().stream()
            .map(AppraisalQuestionDto::from)
            .collect(Collectors.toList());
    return new AppraisalQuestionReadPagedResponse(
            ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
            ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
            dtos,
            page.getTotalRecords(),
            filter.getPageNumber(),
            filter.getPageSize(),
            totalPages
    );
}
    public AppraisalQuestionReadListResponse readByAppraisalFormId(int appraisalformid) {
        List<AppraisalQuestion> appraisalquestions = appraisalquestionRepository.readByAppraisalFormId(appraisalformid);
        return new AppraisalQuestionReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        appraisalquestions);
    }
    public AppraisalQuestionReadListResponse readByAppraisalQuestionCreatedAt(String appraisalquestioncreatedat) {
        List<AppraisalQuestion> appraisalquestions = appraisalquestionRepository.readByAppraisalQuestionCreatedAt(appraisalquestioncreatedat);
        return new AppraisalQuestionReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        appraisalquestions);
    }
    public AppraisalQuestionReadSingleResponse readByAppraisalQuestionId(int appraisalquestionid) {
        AppraisalQuestion appraisalquestion = appraisalquestionRepository.readByAppraisalQuestionId(appraisalquestionid);
        if (appraisalquestion == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new AppraisalQuestionReadSingleResponse(
                ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
                ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
                appraisalquestion);
    }
    public AppraisalQuestionReadListResponse readByAppraisalQuestionStatus(String appraisalquestionstatus) {
        List<AppraisalQuestion> appraisalquestions = appraisalquestionRepository.readByAppraisalQuestionStatus(appraisalquestionstatus);
        return new AppraisalQuestionReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        appraisalquestions);
    }
    public AppraisalQuestionReadListResponse readByAppraisalQuestionText(String appraisalquestiontext) {
        List<AppraisalQuestion> appraisalquestions = appraisalquestionRepository.readByAppraisalQuestionText(appraisalquestiontext);
        return new AppraisalQuestionReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        appraisalquestions);
    }
    public AppraisalQuestionReadListResponse readByAppraisalQuestionType(String appraisalquestiontype) {
        List<AppraisalQuestion> appraisalquestions = appraisalquestionRepository.readByAppraisalQuestionType(appraisalquestiontype);
        return new AppraisalQuestionReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        appraisalquestions);
    }
    public AppraisalQuestionReadListResponse readByAppraisalQuestionUpdatedAt(String appraisalquestionupdatedat) {
        List<AppraisalQuestion> appraisalquestions = appraisalquestionRepository.readByAppraisalQuestionUpdatedAt(appraisalquestionupdatedat);
        return new AppraisalQuestionReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        appraisalquestions);
    }
    public AppraisalQuestionReadListResponse readByAppraisalQuestionWeight(Double appraisalquestionweight) {
        List<AppraisalQuestion> appraisalquestions = appraisalquestionRepository.readByAppraisalQuestionWeight(appraisalquestionweight);
        return new AppraisalQuestionReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        appraisalquestions);
    }
}
