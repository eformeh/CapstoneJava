
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
import qucoon.mod.SpringServerless.repository.page.InventoryItemPage;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.utility.constant.ResponseConstant;
import com.google.gson.Gson;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import qucoon.mod.SpringServerless.model.dto.InventoryItemDto;


@Service
public class InventoryItemService {

    private final InventoryItemRepository inventoryitemRepository;
    private  final Gson GSON;


    public InventoryItemService(InventoryItemRepository inventoryitemRepository) {
        this.inventoryitemRepository = inventoryitemRepository;
        this.GSON = new GsonBuilder()
               .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
                .create();
    }



    public BaseResponse create(InventoryItemCreateRequest request) {

        InventoryItem inventoryitem = GSON.fromJson(GSON.toJson(request), InventoryItem.class);
        if (inventoryitem.getInventoryItemStatus() == null) {
            inventoryitem.setInventoryItemStatus("ACTIVE");
        }
        inventoryitemRepository.create(inventoryitem);

        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse bulkCreate(List<InventoryItemCreateRequest> request) {
        try {
            String json = GSON.toJson(request);
            InventoryItem[] inventoryitemArray = GSON.fromJson(json, InventoryItem[].class);
            List<InventoryItem> inventoryitems = Arrays.asList(inventoryitemArray);
            inventoryitemRepository.bulkCreate(inventoryitems);
            return ResponseConstant.INSTANCE.getSUCCESS();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseConstant.INSTANCE.getBAD_REQUEST();
        }
    }

    public BaseResponse update(InventoryItemUpdateRequest request) {
        InventoryItem inventoryitem = inventoryitemRepository.readByInventoryItemId(request.getInventoryItemId());
        if (inventoryitem == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        inventoryitemRepository.update(inventoryitem);
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse delete(int inventoryItemId) {
        int updateResponse = inventoryitemRepository.delete(inventoryItemId);
        if (updateResponse < 1) {
            throw new CustomExceptions.FailedToUpdateRecord("Record not found");
        }
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public InventoryItemReadListResponse read() {
        List<InventoryItem> inventoryitems = inventoryitemRepository.read();
       if(inventoryitems == null){
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new InventoryItemReadListResponse(ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(), ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(), inventoryitems);
    }
   public InventoryItemReadPagedResponse search(InventoryItemFilterRequest filter) {
    // reuse same repository call for search, since filter includes search criteria
       InventoryItemPage page = inventoryitemRepository.findInventoryItem(filter);
       int totalPages = (int) Math.ceil((double) page.getTotalRecords() / filter.getPageSize());
       List<InventoryItemDto> dtos = page.getData().stream()
            .map(InventoryItemDto::from)
            .collect(Collectors.toList());
    return new InventoryItemReadPagedResponse(
            ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
            ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
            dtos,
            page.getTotalRecords(),
            filter.getPageNumber(),
            filter.getPageSize(),
            totalPages
    );
}
    public InventoryItemReadListResponse readByInventoryItemAvailableStock(int inventoryitemavailablestock) {
        List<InventoryItem> inventoryitems = inventoryitemRepository.readByInventoryItemAvailableStock(inventoryitemavailablestock);
        return new InventoryItemReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        inventoryitems);
    }
    public InventoryItemReadListResponse readByInventoryItemCategory(String inventoryitemcategory) {
        List<InventoryItem> inventoryitems = inventoryitemRepository.readByInventoryItemCategory(inventoryitemcategory);
        return new InventoryItemReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        inventoryitems);
    }
    public InventoryItemReadListResponse readByInventoryItemCreatedAt(String inventoryitemcreatedat) {
        List<InventoryItem> inventoryitems = inventoryitemRepository.readByInventoryItemCreatedAt(inventoryitemcreatedat);
        return new InventoryItemReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        inventoryitems);
    }
    public InventoryItemReadListResponse readByInventoryItemCurrentStock(int inventoryitemcurrentstock) {
        List<InventoryItem> inventoryitems = inventoryitemRepository.readByInventoryItemCurrentStock(inventoryitemcurrentstock);
        return new InventoryItemReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        inventoryitems);
    }
    public InventoryItemReadListResponse readByInventoryItemDescription(String inventoryitemdescription) {
        List<InventoryItem> inventoryitems = inventoryitemRepository.readByInventoryItemDescription(inventoryitemdescription);
        return new InventoryItemReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        inventoryitems);
    }
    public InventoryItemReadSingleResponse readByInventoryItemId(int inventoryitemid) {
        InventoryItem inventoryitem = inventoryitemRepository.readByInventoryItemId(inventoryitemid);
        if (inventoryitem == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new InventoryItemReadSingleResponse(
                ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
                ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
                inventoryitem);
    }
    public InventoryItemReadListResponse readByInventoryItemMinimumStockLevel(int inventoryitemminimumstocklevel) {
        List<InventoryItem> inventoryitems = inventoryitemRepository.readByInventoryItemMinimumStockLevel(inventoryitemminimumstocklevel);
        return new InventoryItemReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        inventoryitems);
    }
    public InventoryItemReadListResponse readByInventoryItemName(String inventoryitemname) {
        List<InventoryItem> inventoryitems = inventoryitemRepository.readByInventoryItemName(inventoryitemname);
        return new InventoryItemReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        inventoryitems);
    }
    public InventoryItemReadListResponse readByInventoryItemReservedStock(int inventoryitemreservedstock) {
        List<InventoryItem> inventoryitems = inventoryitemRepository.readByInventoryItemReservedStock(inventoryitemreservedstock);
        return new InventoryItemReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        inventoryitems);
    }
    public InventoryItemReadListResponse readByInventoryItemStatus(String inventoryitemstatus) {
        List<InventoryItem> inventoryitems = inventoryitemRepository.readByInventoryItemStatus(inventoryitemstatus);
        return new InventoryItemReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        inventoryitems);
    }
    public InventoryItemReadListResponse readByInventoryItemUnitCost(Double inventoryitemunitcost) {
        List<InventoryItem> inventoryitems = inventoryitemRepository.readByInventoryItemUnitCost(inventoryitemunitcost);
        return new InventoryItemReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        inventoryitems);
    }
    public InventoryItemReadListResponse readByInventoryItemUnitOfMeasure(String inventoryitemunitofmeasure) {
        List<InventoryItem> inventoryitems = inventoryitemRepository.readByInventoryItemUnitOfMeasure(inventoryitemunitofmeasure);
        return new InventoryItemReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        inventoryitems);
    }
    public InventoryItemReadListResponse readByInventoryItemUpdatedAt(String inventoryitemupdatedat) {
        List<InventoryItem> inventoryitems = inventoryitemRepository.readByInventoryItemUpdatedAt(inventoryitemupdatedat);
        return new InventoryItemReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        inventoryitems);
    }
}
