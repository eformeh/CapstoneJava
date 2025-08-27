
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
import qucoon.mod.SpringServerless.repository.page.EmployeeDocumentPage;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.utility.constant.ResponseConstant;
import com.google.gson.Gson;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import qucoon.mod.SpringServerless.model.dto.EmployeeDocumentDto;


@Service
public class EmployeeDocumentService {

    private final EmployeeDocumentRepository employeedocumentRepository;
    private  final Gson GSON;


    public EmployeeDocumentService(EmployeeDocumentRepository employeedocumentRepository) {
        this.employeedocumentRepository = employeedocumentRepository;
        this.GSON = new GsonBuilder()
               .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
                .create();
    }



    public BaseResponse create(EmployeeDocumentCreateRequest request) {

        EmployeeDocument employeedocument = GSON.fromJson(GSON.toJson(request), EmployeeDocument.class);
        if (employeedocument.getEmployeeDocumentStatus() == null) {
            employeedocument.setEmployeeDocumentStatus("ACTIVE");
        }
        employeedocumentRepository.create(employeedocument);

        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse bulkCreate(List<EmployeeDocumentCreateRequest> request) {
        try {
            String json = GSON.toJson(request);
            EmployeeDocument[] employeedocumentArray = GSON.fromJson(json, EmployeeDocument[].class);
            List<EmployeeDocument> employeedocuments = Arrays.asList(employeedocumentArray);
            employeedocumentRepository.bulkCreate(employeedocuments);
            return ResponseConstant.INSTANCE.getSUCCESS();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseConstant.INSTANCE.getBAD_REQUEST();
        }
    }

    public BaseResponse update(EmployeeDocumentUpdateRequest request) {
        EmployeeDocument employeedocument = employeedocumentRepository.readByEmployeeDocumentId(request.getEmployeeDocumentId());
        if (employeedocument == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        employeedocumentRepository.update(employeedocument);
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse delete(int employeeDocumentId) {
        int updateResponse = employeedocumentRepository.delete(employeeDocumentId);
        if (updateResponse < 1) {
            throw new CustomExceptions.FailedToUpdateRecord("Record not found");
        }
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public EmployeeDocumentReadListResponse read() {
        List<EmployeeDocument> employeedocuments = employeedocumentRepository.read();
       if(employeedocuments == null){
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new EmployeeDocumentReadListResponse(ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(), ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(), employeedocuments);
    }
   public EmployeeDocumentReadPagedResponse search(EmployeeDocumentFilterRequest filter) {
    // reuse same repository call for search, since filter includes search criteria
       EmployeeDocumentPage page = employeedocumentRepository.findEmployeeDocument(filter);
       int totalPages = (int) Math.ceil((double) page.getTotalRecords() / filter.getPageSize());
       List<EmployeeDocumentDto> dtos = page.getData().stream()
            .map(EmployeeDocumentDto::from)
            .collect(Collectors.toList());
    return new EmployeeDocumentReadPagedResponse(
            ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
            ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
            dtos,
            page.getTotalRecords(),
            filter.getPageNumber(),
            filter.getPageSize(),
            totalPages
    );
}
    public EmployeeDocumentReadListResponse readByEmployeeDocumentAccessLevel(String employeedocumentaccesslevel) {
        List<EmployeeDocument> employeedocuments = employeedocumentRepository.readByEmployeeDocumentAccessLevel(employeedocumentaccesslevel);
        return new EmployeeDocumentReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        employeedocuments);
    }
    public EmployeeDocumentReadListResponse readByEmployeeDocumentCreatedAt(String employeedocumentcreatedat) {
        List<EmployeeDocument> employeedocuments = employeedocumentRepository.readByEmployeeDocumentCreatedAt(employeedocumentcreatedat);
        return new EmployeeDocumentReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        employeedocuments);
    }
    public EmployeeDocumentReadListResponse readByEmployeeDocumentEmployeeId(int employeedocumentemployeeid) {
        List<EmployeeDocument> employeedocuments = employeedocumentRepository.readByEmployeeDocumentEmployeeId(employeedocumentemployeeid);
        return new EmployeeDocumentReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        employeedocuments);
    }
    public EmployeeDocumentReadListResponse readByEmployeeDocumentExpiresAt(String employeedocumentexpiresat) {
        List<EmployeeDocument> employeedocuments = employeedocumentRepository.readByEmployeeDocumentExpiresAt(employeedocumentexpiresat);
        return new EmployeeDocumentReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        employeedocuments);
    }
    public EmployeeDocumentReadListResponse readByEmployeeDocumentFileUrl(String employeedocumentfileurl) {
        List<EmployeeDocument> employeedocuments = employeedocumentRepository.readByEmployeeDocumentFileUrl(employeedocumentfileurl);
        return new EmployeeDocumentReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        employeedocuments);
    }
    public EmployeeDocumentReadSingleResponse readByEmployeeDocumentId(int employeedocumentid) {
        EmployeeDocument employeedocument = employeedocumentRepository.readByEmployeeDocumentId(employeedocumentid);
        if (employeedocument == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new EmployeeDocumentReadSingleResponse(
                ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
                ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
                employeedocument);
    }
    public EmployeeDocumentReadListResponse readByEmployeeDocumentStatus(String employeedocumentstatus) {
        List<EmployeeDocument> employeedocuments = employeedocumentRepository.readByEmployeeDocumentStatus(employeedocumentstatus);
        return new EmployeeDocumentReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        employeedocuments);
    }
    public EmployeeDocumentReadListResponse readByEmployeeDocumentType(String employeedocumenttype) {
        List<EmployeeDocument> employeedocuments = employeedocumentRepository.readByEmployeeDocumentType(employeedocumenttype);
        return new EmployeeDocumentReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        employeedocuments);
    }
    public EmployeeDocumentReadListResponse readByEmployeeDocumentUpdatedAt(String employeedocumentupdatedat) {
        List<EmployeeDocument> employeedocuments = employeedocumentRepository.readByEmployeeDocumentUpdatedAt(employeedocumentupdatedat);
        return new EmployeeDocumentReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        employeedocuments);
    }
    public EmployeeDocumentReadListResponse readByEmployeeDocumentUploadedBy(int employeedocumentuploadedby) {
        List<EmployeeDocument> employeedocuments = employeedocumentRepository.readByEmployeeDocumentUploadedBy(employeedocumentuploadedby);
        return new EmployeeDocumentReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        employeedocuments);
    }
    public EmployeeDocumentReadListResponse readByEmployeeDocumentVersion(String employeedocumentversion) {
        List<EmployeeDocument> employeedocuments = employeedocumentRepository.readByEmployeeDocumentVersion(employeedocumentversion);
        return new EmployeeDocumentReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        employeedocuments);
    }
}
