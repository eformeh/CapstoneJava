
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
import qucoon.mod.SpringServerless.repository.page.OrderPage;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.utility.constant.ResponseConstant;
import com.google.gson.Gson;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import qucoon.mod.SpringServerless.model.dto.OrderDto;


@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private  final Gson GSON;


    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
        this.GSON = new GsonBuilder()
               .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
                .create();
    }



    public BaseResponse create(OrderCreateRequest request) {

        Order order = GSON.fromJson(GSON.toJson(request), Order.class);
        if (order.getOrderStatus() == null) {
            order.setOrderStatus("ACTIVE");
        }
        orderRepository.create(order);

        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse bulkCreate(List<OrderCreateRequest> request) {
        try {
            String json = GSON.toJson(request);
            Order[] orderArray = GSON.fromJson(json, Order[].class);
            List<Order> orders = Arrays.asList(orderArray);
            orderRepository.bulkCreate(orders);
            return ResponseConstant.INSTANCE.getSUCCESS();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseConstant.INSTANCE.getBAD_REQUEST();
        }
    }

    public BaseResponse update(OrderUpdateRequest request) {
        Order order = orderRepository.readByOrderId(request.getOrderId());
        if (order == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        orderRepository.update(order);
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse delete(int orderId) {
        int updateResponse = orderRepository.delete(orderId);
        if (updateResponse < 1) {
            throw new CustomExceptions.FailedToUpdateRecord("Record not found");
        }
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public OrderReadListResponse read() {
        List<Order> orders = orderRepository.read();
       if(orders == null){
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new OrderReadListResponse(ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(), ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(), orders);
    }
   public OrderReadPagedResponse search(OrderFilterRequest filter) {
    // reuse same repository call for search, since filter includes search criteria
       OrderPage page = orderRepository.findOrder(filter);
       int totalPages = (int) Math.ceil((double) page.getTotalRecords() / filter.getPageSize());
       List<OrderDto> dtos = page.getData().stream()
            .map(OrderDto::from)
            .collect(Collectors.toList());
    return new OrderReadPagedResponse(
            ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
            ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
            dtos,
            page.getTotalRecords(),
            filter.getPageNumber(),
            filter.getPageSize(),
            totalPages
    );
}
    public OrderReadListResponse readByOrderActualDeliveryDate(String orderactualdeliverydate) {
        List<Order> orders = orderRepository.readByOrderActualDeliveryDate(orderactualdeliverydate);
        return new OrderReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        orders);
    }
    public OrderReadListResponse readByOrderCreatedAt(String ordercreatedat) {
        List<Order> orders = orderRepository.readByOrderCreatedAt(ordercreatedat);
        return new OrderReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        orders);
    }
    public OrderReadListResponse readByOrderCreatedByUserId(int ordercreatedbyuserid) {
        List<Order> orders = orderRepository.readByOrderCreatedByUserId(ordercreatedbyuserid);
        return new OrderReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        orders);
    }
    public OrderReadListResponse readByOrderExpectedDeliveryDate(String orderexpecteddeliverydate) {
        List<Order> orders = orderRepository.readByOrderExpectedDeliveryDate(orderexpecteddeliverydate);
        return new OrderReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        orders);
    }
    public OrderReadSingleResponse readByOrderId(int orderid) {
        Order order = orderRepository.readByOrderId(orderid);
        if (order == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new OrderReadSingleResponse(
                ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
                ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
                order);
    }
    public OrderReadListResponse readByOrderOrderDate(String orderorderdate) {
        List<Order> orders = orderRepository.readByOrderOrderDate(orderorderdate);
        return new OrderReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        orders);
    }
    public OrderReadListResponse readByOrderStatus(String orderstatus) {
        List<Order> orders = orderRepository.readByOrderStatus(orderstatus);
        return new OrderReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        orders);
    }
    public OrderReadListResponse readByOrderSupplierId(int ordersupplierid) {
        List<Order> orders = orderRepository.readByOrderSupplierId(ordersupplierid);
        return new OrderReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        orders);
    }
    public OrderReadListResponse readByOrderTotalCost(Double ordertotalcost) {
        List<Order> orders = orderRepository.readByOrderTotalCost(ordertotalcost);
        return new OrderReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        orders);
    }
    public OrderReadListResponse readByOrderType(String ordertype) {
        List<Order> orders = orderRepository.readByOrderType(ordertype);
        return new OrderReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        orders);
    }
    public OrderReadListResponse readByOrderUpdatedAt(String orderupdatedat) {
        List<Order> orders = orderRepository.readByOrderUpdatedAt(orderupdatedat);
        return new OrderReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        orders);
    }
}
