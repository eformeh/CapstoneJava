
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
import qucoon.mod.SpringServerless.repository.page.PayPeriodPage;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.utility.constant.ResponseConstant;
import com.google.gson.Gson;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import qucoon.mod.SpringServerless.model.dto.PayPeriodDto;


@Service
public class PayPeriodService {

    private final PayPeriodRepository payperiodRepository;
    private  final Gson GSON;


    public PayPeriodService(PayPeriodRepository payperiodRepository) {
        this.payperiodRepository = payperiodRepository;
        this.GSON = new GsonBuilder()
               .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
                .create();
    }



    public BaseResponse create(PayPeriodCreateRequest request) {

        PayPeriod payperiod = GSON.fromJson(GSON.toJson(request), PayPeriod.class);
        if (payperiod.getPayPeriodStatus() == null) {
            payperiod.setPayPeriodStatus("ACTIVE");
        }
        payperiodRepository.create(payperiod);

        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse bulkCreate(List<PayPeriodCreateRequest> request) {
        try {
            String json = GSON.toJson(request);
            PayPeriod[] payperiodArray = GSON.fromJson(json, PayPeriod[].class);
            List<PayPeriod> payperiods = Arrays.asList(payperiodArray);
            payperiodRepository.bulkCreate(payperiods);
            return ResponseConstant.INSTANCE.getSUCCESS();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseConstant.INSTANCE.getBAD_REQUEST();
        }
    }

    public BaseResponse update(PayPeriodUpdateRequest request) {
        PayPeriod payperiod = payperiodRepository.readByPayPeriodId(request.getPayPeriodId());
        if (payperiod == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        payperiodRepository.update(payperiod);
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse delete(int payPeriodId) {
        int updateResponse = payperiodRepository.delete(payPeriodId);
        if (updateResponse < 1) {
            throw new CustomExceptions.FailedToUpdateRecord("Record not found");
        }
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public PayPeriodReadListResponse read() {
        List<PayPeriod> payperiods = payperiodRepository.read();
       if(payperiods == null){
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new PayPeriodReadListResponse(ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(), ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(), payperiods);
    }
   public PayPeriodReadPagedResponse search(PayPeriodFilterRequest filter) {
    // reuse same repository call for search, since filter includes search criteria
       PayPeriodPage page = payperiodRepository.findPayPeriod(filter);
       int totalPages = (int) Math.ceil((double) page.getTotalRecords() / filter.getPageSize());
       List<PayPeriodDto> dtos = page.getData().stream()
            .map(PayPeriodDto::from)
            .collect(Collectors.toList());
    return new PayPeriodReadPagedResponse(
            ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
            ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
            dtos,
            page.getTotalRecords(),
            filter.getPageNumber(),
            filter.getPageSize(),
            totalPages
    );
}
    public PayPeriodReadListResponse readByPayPeriodCreatedAt(String payperiodcreatedat) {
        List<PayPeriod> payperiods = payperiodRepository.readByPayPeriodCreatedAt(payperiodcreatedat);
        return new PayPeriodReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        payperiods);
    }
    public PayPeriodReadListResponse readByPayPeriodEndDate(String payperiodenddate) {
        List<PayPeriod> payperiods = payperiodRepository.readByPayPeriodEndDate(payperiodenddate);
        return new PayPeriodReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        payperiods);
    }
    public PayPeriodReadSingleResponse readByPayPeriodId(int payperiodid) {
        PayPeriod payperiod = payperiodRepository.readByPayPeriodId(payperiodid);
        if (payperiod == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new PayPeriodReadSingleResponse(
                ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
                ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
                payperiod);
    }
    public PayPeriodReadListResponse readByPayPeriodName(String payperiodname) {
        List<PayPeriod> payperiods = payperiodRepository.readByPayPeriodName(payperiodname);
        return new PayPeriodReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        payperiods);
    }
    public PayPeriodReadListResponse readByPayPeriodPeriodType(String payperiodperiodtype) {
        List<PayPeriod> payperiods = payperiodRepository.readByPayPeriodPeriodType(payperiodperiodtype);
        return new PayPeriodReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        payperiods);
    }
    public PayPeriodReadListResponse readByPayPeriodStartDate(String payperiodstartdate) {
        List<PayPeriod> payperiods = payperiodRepository.readByPayPeriodStartDate(payperiodstartdate);
        return new PayPeriodReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        payperiods);
    }
    public PayPeriodReadListResponse readByPayPeriodStatus(String payperiodstatus) {
        List<PayPeriod> payperiods = payperiodRepository.readByPayPeriodStatus(payperiodstatus);
        return new PayPeriodReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        payperiods);
    }
    public PayPeriodReadListResponse readByPayPeriodUpdatedAt(String payperiodupdatedat) {
        List<PayPeriod> payperiods = payperiodRepository.readByPayPeriodUpdatedAt(payperiodupdatedat);
        return new PayPeriodReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        payperiods);
    }
}
