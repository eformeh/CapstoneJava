
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
import qucoon.mod.SpringServerless.repository.page.SalePage;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.utility.constant.ResponseConstant;
import com.google.gson.Gson;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import qucoon.mod.SpringServerless.model.dto.SaleDto;


@Service
public class SaleService {

    private final SaleRepository saleRepository;
    private  final Gson GSON;


    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
        this.GSON = new GsonBuilder()
               .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
                .create();
    }



    public BaseResponse create(SaleCreateRequest request) {

        Sale sale = GSON.fromJson(GSON.toJson(request), Sale.class);
        if (sale.getSaleStatus() == null) {
            sale.setSaleStatus("ACTIVE");
        }
        saleRepository.create(sale);

        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse bulkCreate(List<SaleCreateRequest> request) {
        try {
            String json = GSON.toJson(request);
            Sale[] saleArray = GSON.fromJson(json, Sale[].class);
            List<Sale> sales = Arrays.asList(saleArray);
            saleRepository.bulkCreate(sales);
            return ResponseConstant.INSTANCE.getSUCCESS();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseConstant.INSTANCE.getBAD_REQUEST();
        }
    }

    public BaseResponse update(SaleUpdateRequest request) {
        Sale sale = saleRepository.readBySaleId(request.getSaleId());
        if (sale == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        saleRepository.update(sale);
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse delete(int saleId) {
        int updateResponse = saleRepository.delete(saleId);
        if (updateResponse < 1) {
            throw new CustomExceptions.FailedToUpdateRecord("Record not found");
        }
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public SaleReadListResponse read() {
        List<Sale> sales = saleRepository.read();
       if(sales == null){
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new SaleReadListResponse(ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(), ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(), sales);
    }
   public SaleReadPagedResponse search(SaleFilterRequest filter) {
    // reuse same repository call for search, since filter includes search criteria
       SalePage page = saleRepository.findSale(filter);
       int totalPages = (int) Math.ceil((double) page.getTotalRecords() / filter.getPageSize());
       List<SaleDto> dtos = page.getData().stream()
            .map(SaleDto::from)
            .collect(Collectors.toList());
    return new SaleReadPagedResponse(
            ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
            ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
            dtos,
            page.getTotalRecords(),
            filter.getPageNumber(),
            filter.getPageSize(),
            totalPages
    );
}
    public SaleReadListResponse readBySaleAmountPaid(Double saleamountpaid) {
        List<Sale> sales = saleRepository.readBySaleAmountPaid(saleamountpaid);
        return new SaleReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        sales);
    }
    public SaleReadListResponse readBySaleCreatedAt(String salecreatedat) {
        List<Sale> sales = saleRepository.readBySaleCreatedAt(salecreatedat);
        return new SaleReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        sales);
    }
    public SaleReadListResponse readBySaleCreditDue(String salecreditdue) {
        List<Sale> sales = saleRepository.readBySaleCreditDue(salecreditdue);
        return new SaleReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        sales);
    }
    public SaleReadListResponse readBySaleCustomerId(int salecustomerid) {
        List<Sale> sales = saleRepository.readBySaleCustomerId(salecustomerid);
        return new SaleReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        sales);
    }
    public SaleReadListResponse readBySaleDeliveryType(String saledeliverytype) {
        List<Sale> sales = saleRepository.readBySaleDeliveryType(saledeliverytype);
        return new SaleReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        sales);
    }
    public SaleReadListResponse readBySaleEmployeeId(int saleemployeeid) {
        List<Sale> sales = saleRepository.readBySaleEmployeeId(saleemployeeid);
        return new SaleReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        sales);
    }
    public SaleReadSingleResponse readBySaleId(int saleid) {
        Sale sale = saleRepository.readBySaleId(saleid);
        if (sale == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new SaleReadSingleResponse(
                ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
                ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
                sale);
    }
    public SaleReadListResponse readBySaleStatus(String salestatus) {
        List<Sale> sales = saleRepository.readBySaleStatus(salestatus);
        return new SaleReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        sales);
    }
    public SaleReadListResponse readBySaleTotalAmount(Double saletotalamount) {
        List<Sale> sales = saleRepository.readBySaleTotalAmount(saletotalamount);
        return new SaleReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        sales);
    }
    public SaleReadListResponse readBySaleType(String saletype) {
        List<Sale> sales = saleRepository.readBySaleType(saletype);
        return new SaleReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        sales);
    }
    public SaleReadListResponse readBySaleUpdatedAt(String saleupdatedat) {
        List<Sale> sales = saleRepository.readBySaleUpdatedAt(saleupdatedat);
        return new SaleReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        sales);
    }
}
