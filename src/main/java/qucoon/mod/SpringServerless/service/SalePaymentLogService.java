
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
import qucoon.mod.SpringServerless.repository.page.SalePaymentLogPage;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.utility.constant.ResponseConstant;
import com.google.gson.Gson;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import qucoon.mod.SpringServerless.model.dto.SalePaymentLogDto;


@Service
public class SalePaymentLogService {

    private final SalePaymentLogRepository salepaymentlogRepository;
    private  final Gson GSON;


    public SalePaymentLogService(SalePaymentLogRepository salepaymentlogRepository) {
        this.salepaymentlogRepository = salepaymentlogRepository;
        this.GSON = new GsonBuilder()
               .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
                .create();
    }



    public BaseResponse create(SalePaymentLogCreateRequest request) {

        SalePaymentLog salepaymentlog = GSON.fromJson(GSON.toJson(request), SalePaymentLog.class);
        if (salepaymentlog.getSalePaymentLogStatus() == null) {
            salepaymentlog.setSalePaymentLogStatus("ACTIVE");
        }
        salepaymentlogRepository.create(salepaymentlog);

        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse bulkCreate(List<SalePaymentLogCreateRequest> request) {
        try {
            String json = GSON.toJson(request);
            SalePaymentLog[] salepaymentlogArray = GSON.fromJson(json, SalePaymentLog[].class);
            List<SalePaymentLog> salepaymentlogs = Arrays.asList(salepaymentlogArray);
            salepaymentlogRepository.bulkCreate(salepaymentlogs);
            return ResponseConstant.INSTANCE.getSUCCESS();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseConstant.INSTANCE.getBAD_REQUEST();
        }
    }

    public BaseResponse update(SalePaymentLogUpdateRequest request) {
        SalePaymentLog salepaymentlog = salepaymentlogRepository.readBySalePaymentLogid(request.getSalePaymentLogid());
        if (salepaymentlog == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        salepaymentlogRepository.update(salepaymentlog);
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse delete(int salePaymentLogid) {
        int updateResponse = salepaymentlogRepository.delete(salePaymentLogid);
        if (updateResponse < 1) {
            throw new CustomExceptions.FailedToUpdateRecord("Record not found");
        }
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public SalePaymentLogReadListResponse read() {
        List<SalePaymentLog> salepaymentlogs = salepaymentlogRepository.read();
       if(salepaymentlogs == null){
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new SalePaymentLogReadListResponse(ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(), ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(), salepaymentlogs);
    }
   public SalePaymentLogReadPagedResponse search(SalePaymentLogFilterRequest filter) {
    // reuse same repository call for search, since filter includes search criteria
       SalePaymentLogPage page = salepaymentlogRepository.findSalePaymentLog(filter);
       int totalPages = (int) Math.ceil((double) page.getTotalRecords() / filter.getPageSize());
       List<SalePaymentLogDto> dtos = page.getData().stream()
            .map(SalePaymentLogDto::from)
            .collect(Collectors.toList());
    return new SalePaymentLogReadPagedResponse(
            ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
            ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
            dtos,
            page.getTotalRecords(),
            filter.getPageNumber(),
            filter.getPageSize(),
            totalPages
    );
}
    public SalePaymentLogReadListResponse readBySalePaymentLogAmount(Double salepaymentlogamount) {
        List<SalePaymentLog> salepaymentlogs = salepaymentlogRepository.readBySalePaymentLogAmount(salepaymentlogamount);
        return new SalePaymentLogReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        salepaymentlogs);
    }
    public SalePaymentLogReadListResponse readBySalePaymentLogCreatedAt(String salepaymentlogcreatedat) {
        List<SalePaymentLog> salepaymentlogs = salepaymentlogRepository.readBySalePaymentLogCreatedAt(salepaymentlogcreatedat);
        return new SalePaymentLogReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        salepaymentlogs);
    }
    public SalePaymentLogReadListResponse readBySalePaymentLogEmployeeid(int salepaymentlogemployeeid) {
        List<SalePaymentLog> salepaymentlogs = salepaymentlogRepository.readBySalePaymentLogEmployeeid(salepaymentlogemployeeid);
        return new SalePaymentLogReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        salepaymentlogs);
    }
    public SalePaymentLogReadSingleResponse readBySalePaymentLogid(int salepaymentlogid) {
        SalePaymentLog salepaymentlog = salepaymentlogRepository.readBySalePaymentLogid(salepaymentlogid);
        if (salepaymentlog == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new SalePaymentLogReadSingleResponse(
                ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
                ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
                salepaymentlog);
    }
    public SalePaymentLogReadListResponse readBySalePaymentLogMethod(String salepaymentlogmethod) {
        List<SalePaymentLog> salepaymentlogs = salepaymentlogRepository.readBySalePaymentLogMethod(salepaymentlogmethod);
        return new SalePaymentLogReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        salepaymentlogs);
    }
    public SalePaymentLogReadListResponse readBySalePaymentLogNotes(String salepaymentlognotes) {
        List<SalePaymentLog> salepaymentlogs = salepaymentlogRepository.readBySalePaymentLogNotes(salepaymentlognotes);
        return new SalePaymentLogReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        salepaymentlogs);
    }
    public SalePaymentLogReadListResponse readBySalePaymentLogSaleid(int salepaymentlogsaleid) {
        List<SalePaymentLog> salepaymentlogs = salepaymentlogRepository.readBySalePaymentLogSaleid(salepaymentlogsaleid);
        return new SalePaymentLogReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        salepaymentlogs);
    }
    public SalePaymentLogReadListResponse readBySalePaymentLogStatus(String salepaymentlogstatus) {
        List<SalePaymentLog> salepaymentlogs = salepaymentlogRepository.readBySalePaymentLogStatus(salepaymentlogstatus);
        return new SalePaymentLogReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        salepaymentlogs);
    }
    public SalePaymentLogReadListResponse readBySalePaymentUpdatedAt(String salepaymentupdatedat) {
        List<SalePaymentLog> salepaymentlogs = salepaymentlogRepository.readBySalePaymentUpdatedAt(salepaymentupdatedat);
        return new SalePaymentLogReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        salepaymentlogs);
    }
}
