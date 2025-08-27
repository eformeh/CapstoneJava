
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
import qucoon.mod.SpringServerless.repository.page.SalaryPaymentPage;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.utility.constant.ResponseConstant;
import com.google.gson.Gson;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import qucoon.mod.SpringServerless.model.dto.SalaryPaymentDto;


@Service
public class SalaryPaymentService {

    private final SalaryPaymentRepository salarypaymentRepository;
    private  final Gson GSON;


    public SalaryPaymentService(SalaryPaymentRepository salarypaymentRepository) {
        this.salarypaymentRepository = salarypaymentRepository;
        this.GSON = new GsonBuilder()
               .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
                .create();
    }



    public BaseResponse create(SalaryPaymentCreateRequest request) {

        SalaryPayment salarypayment = GSON.fromJson(GSON.toJson(request), SalaryPayment.class);
        if (salarypayment.getSalaryPaymentStatus() == null) {
            salarypayment.setSalaryPaymentStatus("ACTIVE");
        }
        salarypaymentRepository.create(salarypayment);

        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse bulkCreate(List<SalaryPaymentCreateRequest> request) {
        try {
            String json = GSON.toJson(request);
            SalaryPayment[] salarypaymentArray = GSON.fromJson(json, SalaryPayment[].class);
            List<SalaryPayment> salarypayments = Arrays.asList(salarypaymentArray);
            salarypaymentRepository.bulkCreate(salarypayments);
            return ResponseConstant.INSTANCE.getSUCCESS();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseConstant.INSTANCE.getBAD_REQUEST();
        }
    }

    public BaseResponse update(SalaryPaymentUpdateRequest request) {
        SalaryPayment salarypayment = salarypaymentRepository.readBySalaryPaymentId(request.getSalaryPaymentId());
        if (salarypayment == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        salarypaymentRepository.update(salarypayment);
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse delete(int salaryPaymentId) {
        int updateResponse = salarypaymentRepository.delete(salaryPaymentId);
        if (updateResponse < 1) {
            throw new CustomExceptions.FailedToUpdateRecord("Record not found");
        }
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public SalaryPaymentReadListResponse read() {
        List<SalaryPayment> salarypayments = salarypaymentRepository.read();
       if(salarypayments == null){
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new SalaryPaymentReadListResponse(ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(), ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(), salarypayments);
    }
   public SalaryPaymentReadPagedResponse search(SalaryPaymentFilterRequest filter) {
    // reuse same repository call for search, since filter includes search criteria
       SalaryPaymentPage page = salarypaymentRepository.findSalaryPayment(filter);
       int totalPages = (int) Math.ceil((double) page.getTotalRecords() / filter.getPageSize());
       List<SalaryPaymentDto> dtos = page.getData().stream()
            .map(SalaryPaymentDto::from)
            .collect(Collectors.toList());
    return new SalaryPaymentReadPagedResponse(
            ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
            ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
            dtos,
            page.getTotalRecords(),
            filter.getPageNumber(),
            filter.getPageSize(),
            totalPages
    );
}
    public SalaryPaymentReadListResponse readBySalaryPaymentAmount(Double salarypaymentamount) {
        List<SalaryPayment> salarypayments = salarypaymentRepository.readBySalaryPaymentAmount(salarypaymentamount);
        return new SalaryPaymentReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        salarypayments);
    }
    public SalaryPaymentReadListResponse readBySalaryPaymentApprovedBy(int salarypaymentapprovedby) {
        List<SalaryPayment> salarypayments = salarypaymentRepository.readBySalaryPaymentApprovedBy(salarypaymentapprovedby);
        return new SalaryPaymentReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        salarypayments);
    }
    public SalaryPaymentReadListResponse readBySalaryPaymentChannel(String salarypaymentchannel) {
        List<SalaryPayment> salarypayments = salarypaymentRepository.readBySalaryPaymentChannel(salarypaymentchannel);
        return new SalaryPaymentReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        salarypayments);
    }
    public SalaryPaymentReadListResponse readBySalaryPaymentCreatedAt(String salarypaymentcreatedat) {
        List<SalaryPayment> salarypayments = salarypaymentRepository.readBySalaryPaymentCreatedAt(salarypaymentcreatedat);
        return new SalaryPaymentReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        salarypayments);
    }
    public SalaryPaymentReadListResponse readBySalaryPaymentEmployeeAccountId(int salarypaymentemployeeaccountid) {
        List<SalaryPayment> salarypayments = salarypaymentRepository.readBySalaryPaymentEmployeeAccountId(salarypaymentemployeeaccountid);
        return new SalaryPaymentReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        salarypayments);
    }
    public SalaryPaymentReadSingleResponse readBySalaryPaymentId(int salarypaymentid) {
        SalaryPayment salarypayment = salarypaymentRepository.readBySalaryPaymentId(salarypaymentid);
        if (salarypayment == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new SalaryPaymentReadSingleResponse(
                ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
                ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
                salarypayment);
    }
    public SalaryPaymentReadListResponse readBySalaryPaymentSalaryId(int salarypaymentsalaryid) {
        List<SalaryPayment> salarypayments = salarypaymentRepository.readBySalaryPaymentSalaryId(salarypaymentsalaryid);
        return new SalaryPaymentReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        salarypayments);
    }
    public SalaryPaymentReadListResponse readBySalaryPaymentStatus(String salarypaymentstatus) {
        List<SalaryPayment> salarypayments = salarypaymentRepository.readBySalaryPaymentStatus(salarypaymentstatus);
        return new SalaryPaymentReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        salarypayments);
    }
    public SalaryPaymentReadListResponse readBySalaryPaymentTransactionId(int salarypaymenttransactionid) {
        List<SalaryPayment> salarypayments = salarypaymentRepository.readBySalaryPaymentTransactionId(salarypaymenttransactionid);
        return new SalaryPaymentReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        salarypayments);
    }
    public SalaryPaymentReadListResponse readBySalaryPaymentUpdatedAt(String salarypaymentupdatedat) {
        List<SalaryPayment> salarypayments = salarypaymentRepository.readBySalaryPaymentUpdatedAt(salarypaymentupdatedat);
        return new SalaryPaymentReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        salarypayments);
    }
}
