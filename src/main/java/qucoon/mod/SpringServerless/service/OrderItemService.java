
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
import qucoon.mod.SpringServerless.repository.page.OrderItemPage;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.utility.constant.ResponseConstant;
import com.google.gson.Gson;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import qucoon.mod.SpringServerless.model.dto.OrderItemDto;


@Service
public class OrderItemService {

    private final OrderItemRepository orderitemRepository;
    private  final Gson GSON;


    public OrderItemService(OrderItemRepository orderitemRepository) {
        this.orderitemRepository = orderitemRepository;
        this.GSON = new GsonBuilder()
               .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
                .create();
    }



    public BaseResponse create(OrderItemCreateRequest request) {

        OrderItem orderitem = GSON.fromJson(GSON.toJson(request), OrderItem.class);
        if (orderitem.getOrderItemStatus() == null) {
            orderitem.setOrderItemStatus("ACTIVE");
        }
        orderitemRepository.create(orderitem);

        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse bulkCreate(List<OrderItemCreateRequest> request) {
        try {
            String json = GSON.toJson(request);
            OrderItem[] orderitemArray = GSON.fromJson(json, OrderItem[].class);
            List<OrderItem> orderitems = Arrays.asList(orderitemArray);
            orderitemRepository.bulkCreate(orderitems);
            return ResponseConstant.INSTANCE.getSUCCESS();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseConstant.INSTANCE.getBAD_REQUEST();
        }
    }

    public BaseResponse update(OrderItemUpdateRequest request) {
        OrderItem orderitem = orderitemRepository.readByOrderItemId(request.getOrderItemId());
        if (orderitem == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        orderitemRepository.update(orderitem);
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse delete(int orderItemId) {
        int updateResponse = orderitemRepository.delete(orderItemId);
        if (updateResponse < 1) {
            throw new CustomExceptions.FailedToUpdateRecord("Record not found");
        }
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public OrderItemReadListResponse read() {
        List<OrderItem> orderitems = orderitemRepository.read();
       if(orderitems == null){
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new OrderItemReadListResponse(ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(), ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(), orderitems);
    }
   public OrderItemReadPagedResponse search(OrderItemFilterRequest filter) {
    // reuse same repository call for search, since filter includes search criteria
       OrderItemPage page = orderitemRepository.findOrderItem(filter);
       int totalPages = (int) Math.ceil((double) page.getTotalRecords() / filter.getPageSize());
       List<OrderItemDto> dtos = page.getData().stream()
            .map(OrderItemDto::from)
            .collect(Collectors.toList());
    return new OrderItemReadPagedResponse(
            ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
            ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
            dtos,
            page.getTotalRecords(),
            filter.getPageNumber(),
            filter.getPageSize(),
            totalPages
    );
}
    public OrderItemReadListResponse readByOrderItemCreatedAt(String orderitemcreatedat) {
        List<OrderItem> orderitems = orderitemRepository.readByOrderItemCreatedAt(orderitemcreatedat);
        return new OrderItemReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        orderitems);
    }
    public OrderItemReadSingleResponse readByOrderItemId(int orderitemid) {
        OrderItem orderitem = orderitemRepository.readByOrderItemId(orderitemid);
        if (orderitem == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new OrderItemReadSingleResponse(
                ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
                ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
                orderitem);
    }
    public OrderItemReadListResponse readByOrderItemInventoryItemId(int orderiteminventoryitemid) {
        List<OrderItem> orderitems = orderitemRepository.readByOrderItemInventoryItemId(orderiteminventoryitemid);
        return new OrderItemReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        orderitems);
    }
    public OrderItemReadListResponse readByOrderItemOrderId(int orderitemorderid) {
        List<OrderItem> orderitems = orderitemRepository.readByOrderItemOrderId(orderitemorderid);
        return new OrderItemReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        orderitems);
    }
    public OrderItemReadListResponse readByOrderItemQuantityOrdered(int orderitemquantityordered) {
        List<OrderItem> orderitems = orderitemRepository.readByOrderItemQuantityOrdered(orderitemquantityordered);
        return new OrderItemReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        orderitems);
    }
    public OrderItemReadListResponse readByOrderItemStatus(String orderitemstatus) {
        List<OrderItem> orderitems = orderitemRepository.readByOrderItemStatus(orderitemstatus);
        return new OrderItemReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        orderitems);
    }
    public OrderItemReadListResponse readByOrderItemTotalCost(Double orderitemtotalcost) {
        List<OrderItem> orderitems = orderitemRepository.readByOrderItemTotalCost(orderitemtotalcost);
        return new OrderItemReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        orderitems);
    }
    public OrderItemReadListResponse readByOrderItemUnitCost(Double orderitemunitcost) {
        List<OrderItem> orderitems = orderitemRepository.readByOrderItemUnitCost(orderitemunitcost);
        return new OrderItemReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        orderitems);
    }
    public OrderItemReadListResponse readByOrderItemUpdatedAt(String orderitemupdatedat) {
        List<OrderItem> orderitems = orderitemRepository.readByOrderItemUpdatedAt(orderitemupdatedat);
        return new OrderItemReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        orderitems);
    }
}
