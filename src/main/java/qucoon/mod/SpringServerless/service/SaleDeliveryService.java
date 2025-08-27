
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
import qucoon.mod.SpringServerless.repository.page.SaleDeliveryPage;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.utility.constant.ResponseConstant;
import com.google.gson.Gson;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import qucoon.mod.SpringServerless.model.dto.SaleDeliveryDto;


@Service
public class SaleDeliveryService {

    private final SaleDeliveryRepository saledeliveryRepository;
    private  final Gson GSON;


    public SaleDeliveryService(SaleDeliveryRepository saledeliveryRepository) {
        this.saledeliveryRepository = saledeliveryRepository;
        this.GSON = new GsonBuilder()
               .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
                .create();
    }



    public BaseResponse create(SaleDeliveryCreateRequest request) {

        SaleDelivery saledelivery = GSON.fromJson(GSON.toJson(request), SaleDelivery.class);
        if (saledelivery.getSaleDeliveryStatus() == null) {
            saledelivery.setSaleDeliveryStatus("ACTIVE");
        }
        saledeliveryRepository.create(saledelivery);

        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse bulkCreate(List<SaleDeliveryCreateRequest> request) {
        try {
            String json = GSON.toJson(request);
            SaleDelivery[] saledeliveryArray = GSON.fromJson(json, SaleDelivery[].class);
            List<SaleDelivery> saledeliverys = Arrays.asList(saledeliveryArray);
            saledeliveryRepository.bulkCreate(saledeliverys);
            return ResponseConstant.INSTANCE.getSUCCESS();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseConstant.INSTANCE.getBAD_REQUEST();
        }
    }

    public BaseResponse update(SaleDeliveryUpdateRequest request) {
        SaleDelivery saledelivery = saledeliveryRepository.readBySaleDeliveryId(request.getSaleDeliveryId());
        if (saledelivery == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        saledeliveryRepository.update(saledelivery);
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse delete(int saleDeliveryId) {
        int updateResponse = saledeliveryRepository.delete(saleDeliveryId);
        if (updateResponse < 1) {
            throw new CustomExceptions.FailedToUpdateRecord("Record not found");
        }
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public SaleDeliveryReadListResponse read() {
        List<SaleDelivery> saledeliverys = saledeliveryRepository.read();
       if(saledeliverys == null){
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new SaleDeliveryReadListResponse(ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(), ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(), saledeliverys);
    }
   public SaleDeliveryReadPagedResponse search(SaleDeliveryFilterRequest filter) {
    // reuse same repository call for search, since filter includes search criteria
       SaleDeliveryPage page = saledeliveryRepository.findSaleDelivery(filter);
       int totalPages = (int) Math.ceil((double) page.getTotalRecords() / filter.getPageSize());
       List<SaleDeliveryDto> dtos = page.getData().stream()
            .map(SaleDeliveryDto::from)
            .collect(Collectors.toList());
    return new SaleDeliveryReadPagedResponse(
            ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
            ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
            dtos,
            page.getTotalRecords(),
            filter.getPageNumber(),
            filter.getPageSize(),
            totalPages
    );
}
    public SaleDeliveryReadListResponse readBySaleDeliveryAddress(String saledeliveryaddress) {
        List<SaleDelivery> saledeliverys = saledeliveryRepository.readBySaleDeliveryAddress(saledeliveryaddress);
        return new SaleDeliveryReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        saledeliverys);
    }
    public SaleDeliveryReadListResponse readBySaleDeliveryConfirmedAt(String saledeliveryconfirmedat) {
        List<SaleDelivery> saledeliverys = saledeliveryRepository.readBySaleDeliveryConfirmedAt(saledeliveryconfirmedat);
        return new SaleDeliveryReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        saledeliverys);
    }
    public SaleDeliveryReadListResponse readBySaleDeliveryContactName(String saledeliverycontactname) {
        List<SaleDelivery> saledeliverys = saledeliveryRepository.readBySaleDeliveryContactName(saledeliverycontactname);
        return new SaleDeliveryReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        saledeliverys);
    }
    public SaleDeliveryReadListResponse readBySaleDeliveryContactPhone(String saledeliverycontactphone) {
        List<SaleDelivery> saledeliverys = saledeliveryRepository.readBySaleDeliveryContactPhone(saledeliverycontactphone);
        return new SaleDeliveryReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        saledeliverys);
    }
    public SaleDeliveryReadListResponse readBySaleDeliveryCreatedAt(String saledeliverycreatedat) {
        List<SaleDelivery> saledeliverys = saledeliveryRepository.readBySaleDeliveryCreatedAt(saledeliverycreatedat);
        return new SaleDeliveryReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        saledeliverys);
    }
    public SaleDeliveryReadListResponse readBySaleDeliveryExpectedDeliveryDate(String saledeliveryexpecteddeliverydate) {
        List<SaleDelivery> saledeliverys = saledeliveryRepository.readBySaleDeliveryExpectedDeliveryDate(saledeliveryexpecteddeliverydate);
        return new SaleDeliveryReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        saledeliverys);
    }
    public SaleDeliveryReadSingleResponse readBySaleDeliveryId(int saledeliveryid) {
        SaleDelivery saledelivery = saledeliveryRepository.readBySaleDeliveryId(saledeliveryid);
        if (saledelivery == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new SaleDeliveryReadSingleResponse(
                ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
                ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
                saledelivery);
    }
    public SaleDeliveryReadListResponse readBySaleDeliveryNotes(String saledeliverynotes) {
        List<SaleDelivery> saledeliverys = saledeliveryRepository.readBySaleDeliveryNotes(saledeliverynotes);
        return new SaleDeliveryReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        saledeliverys);
    }
    public SaleDeliveryReadListResponse readBySaleDeliveryProvider(String saledeliveryprovider) {
        List<SaleDelivery> saledeliverys = saledeliveryRepository.readBySaleDeliveryProvider(saledeliveryprovider);
        return new SaleDeliveryReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        saledeliverys);
    }
    public SaleDeliveryReadListResponse readBySaleDeliverySaleId(int saledeliverysaleid) {
        List<SaleDelivery> saledeliverys = saledeliveryRepository.readBySaleDeliverySaleId(saledeliverysaleid);
        return new SaleDeliveryReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        saledeliverys);
    }
    public SaleDeliveryReadListResponse readBySaleDeliveryStatus(String saledeliverystatus) {
        List<SaleDelivery> saledeliverys = saledeliveryRepository.readBySaleDeliveryStatus(saledeliverystatus);
        return new SaleDeliveryReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        saledeliverys);
    }
    public SaleDeliveryReadListResponse readBySaleDeliveryTrackingNumber(String saledeliverytrackingnumber) {
        List<SaleDelivery> saledeliverys = saledeliveryRepository.readBySaleDeliveryTrackingNumber(saledeliverytrackingnumber);
        return new SaleDeliveryReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        saledeliverys);
    }
    public SaleDeliveryReadListResponse readBySaleDeliveryUpdatedAt(String saledeliveryupdatedat) {
        List<SaleDelivery> saledeliverys = saledeliveryRepository.readBySaleDeliveryUpdatedAt(saledeliveryupdatedat);
        return new SaleDeliveryReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        saledeliverys);
    }
}
