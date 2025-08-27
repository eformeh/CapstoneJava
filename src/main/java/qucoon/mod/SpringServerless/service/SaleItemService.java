
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
import qucoon.mod.SpringServerless.repository.page.SaleItemPage;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.utility.constant.ResponseConstant;
import com.google.gson.Gson;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import qucoon.mod.SpringServerless.model.dto.SaleItemDto;


@Service
public class SaleItemService {

    private final SaleItemRepository saleitemRepository;
    private  final Gson GSON;


    public SaleItemService(SaleItemRepository saleitemRepository) {
        this.saleitemRepository = saleitemRepository;
        this.GSON = new GsonBuilder()
               .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
                .create();
    }



    public BaseResponse create(SaleItemCreateRequest request) {

        SaleItem saleitem = GSON.fromJson(GSON.toJson(request), SaleItem.class);
        if (saleitem.getSaleItemStatus() == null) {
            saleitem.setSaleItemStatus("ACTIVE");
        }
        saleitemRepository.create(saleitem);

        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse bulkCreate(List<SaleItemCreateRequest> request) {
        try {
            String json = GSON.toJson(request);
            SaleItem[] saleitemArray = GSON.fromJson(json, SaleItem[].class);
            List<SaleItem> saleitems = Arrays.asList(saleitemArray);
            saleitemRepository.bulkCreate(saleitems);
            return ResponseConstant.INSTANCE.getSUCCESS();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseConstant.INSTANCE.getBAD_REQUEST();
        }
    }

    public BaseResponse update(SaleItemUpdateRequest request) {
        SaleItem saleitem = saleitemRepository.readBySaleItemId(request.getSaleItemId());
        if (saleitem == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        saleitemRepository.update(saleitem);
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse delete(int saleItemId) {
        int updateResponse = saleitemRepository.delete(saleItemId);
        if (updateResponse < 1) {
            throw new CustomExceptions.FailedToUpdateRecord("Record not found");
        }
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public SaleItemReadListResponse read() {
        List<SaleItem> saleitems = saleitemRepository.read();
       if(saleitems == null){
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new SaleItemReadListResponse(ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(), ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(), saleitems);
    }
   public SaleItemReadPagedResponse search(SaleItemFilterRequest filter) {
    // reuse same repository call for search, since filter includes search criteria
       SaleItemPage page = saleitemRepository.findSaleItem(filter);
       int totalPages = (int) Math.ceil((double) page.getTotalRecords() / filter.getPageSize());
       List<SaleItemDto> dtos = page.getData().stream()
            .map(SaleItemDto::from)
            .collect(Collectors.toList());
    return new SaleItemReadPagedResponse(
            ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
            ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
            dtos,
            page.getTotalRecords(),
            filter.getPageNumber(),
            filter.getPageSize(),
            totalPages
    );
}
    public SaleItemReadListResponse readBySaleItemCreatedAt(String saleitemcreatedat) {
        List<SaleItem> saleitems = saleitemRepository.readBySaleItemCreatedAt(saleitemcreatedat);
        return new SaleItemReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        saleitems);
    }
    public SaleItemReadSingleResponse readBySaleItemId(int saleitemid) {
        SaleItem saleitem = saleitemRepository.readBySaleItemId(saleitemid);
        if (saleitem == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new SaleItemReadSingleResponse(
                ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
                ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
                saleitem);
    }
    public SaleItemReadListResponse readBySaleItemProductId(int saleitemproductid) {
        List<SaleItem> saleitems = saleitemRepository.readBySaleItemProductId(saleitemproductid);
        return new SaleItemReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        saleitems);
    }
    public SaleItemReadListResponse readBySaleItemQuantity(int saleitemquantity) {
        List<SaleItem> saleitems = saleitemRepository.readBySaleItemQuantity(saleitemquantity);
        return new SaleItemReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        saleitems);
    }
    public SaleItemReadListResponse readBySaleItemSaleId(int saleitemsaleid) {
        List<SaleItem> saleitems = saleitemRepository.readBySaleItemSaleId(saleitemsaleid);
        return new SaleItemReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        saleitems);
    }
    public SaleItemReadListResponse readBySaleItemStatus(String saleitemstatus) {
        List<SaleItem> saleitems = saleitemRepository.readBySaleItemStatus(saleitemstatus);
        return new SaleItemReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        saleitems);
    }
    public SaleItemReadListResponse readBySaleItemTotal(Double saleitemtotal) {
        List<SaleItem> saleitems = saleitemRepository.readBySaleItemTotal(saleitemtotal);
        return new SaleItemReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        saleitems);
    }
    public SaleItemReadListResponse readBySaleItemUnitPrice(Double saleitemunitprice) {
        List<SaleItem> saleitems = saleitemRepository.readBySaleItemUnitPrice(saleitemunitprice);
        return new SaleItemReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        saleitems);
    }
    public SaleItemReadListResponse readBySaleItemUpdatedAt(String saleitemupdatedat) {
        List<SaleItem> saleitems = saleitemRepository.readBySaleItemUpdatedAt(saleitemupdatedat);
        return new SaleItemReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        saleitems);
    }
}
