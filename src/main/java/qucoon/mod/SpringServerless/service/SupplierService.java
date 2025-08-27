
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
import qucoon.mod.SpringServerless.repository.page.SupplierPage;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.utility.constant.ResponseConstant;
import com.google.gson.Gson;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import qucoon.mod.SpringServerless.model.dto.SupplierDto;


@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;
    private  final Gson GSON;


    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
        this.GSON = new GsonBuilder()
               .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
                .create();
    }



    public BaseResponse create(SupplierCreateRequest request) {

        Supplier supplier = GSON.fromJson(GSON.toJson(request), Supplier.class);
        if (supplier.getSupplierStatus() == null) {
            supplier.setSupplierStatus("ACTIVE");
        }
        supplierRepository.create(supplier);

        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse bulkCreate(List<SupplierCreateRequest> request) {
        try {
            String json = GSON.toJson(request);
            Supplier[] supplierArray = GSON.fromJson(json, Supplier[].class);
            List<Supplier> suppliers = Arrays.asList(supplierArray);
            supplierRepository.bulkCreate(suppliers);
            return ResponseConstant.INSTANCE.getSUCCESS();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseConstant.INSTANCE.getBAD_REQUEST();
        }
    }

    public BaseResponse update(SupplierUpdateRequest request) {
        Supplier supplier = supplierRepository.readBySupplierId(request.getSupplierId());
        if (supplier == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        supplierRepository.update(supplier);
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse delete(int supplierId) {
        int updateResponse = supplierRepository.delete(supplierId);
        if (updateResponse < 1) {
            throw new CustomExceptions.FailedToUpdateRecord("Record not found");
        }
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public SupplierReadListResponse read() {
        List<Supplier> suppliers = supplierRepository.read();
       if(suppliers == null){
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new SupplierReadListResponse(ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(), ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(), suppliers);
    }
   public SupplierReadPagedResponse search(SupplierFilterRequest filter) {
    // reuse same repository call for search, since filter includes search criteria
       SupplierPage page = supplierRepository.findSupplier(filter);
       int totalPages = (int) Math.ceil((double) page.getTotalRecords() / filter.getPageSize());
       List<SupplierDto> dtos = page.getData().stream()
            .map(SupplierDto::from)
            .collect(Collectors.toList());
    return new SupplierReadPagedResponse(
            ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
            ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
            dtos,
            page.getTotalRecords(),
            filter.getPageNumber(),
            filter.getPageSize(),
            totalPages
    );
}
    public SupplierReadListResponse readBySupplierAddress(String supplieraddress) {
        List<Supplier> suppliers = supplierRepository.readBySupplierAddress(supplieraddress);
        return new SupplierReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        suppliers);
    }
    public SupplierReadListResponse readBySupplierContactPerson(String suppliercontactperson) {
        List<Supplier> suppliers = supplierRepository.readBySupplierContactPerson(suppliercontactperson);
        return new SupplierReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        suppliers);
    }
    public SupplierReadListResponse readBySupplierCreatedAt(String suppliercreatedat) {
        List<Supplier> suppliers = supplierRepository.readBySupplierCreatedAt(suppliercreatedat);
        return new SupplierReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        suppliers);
    }
    public SupplierReadListResponse readBySupplierCreatedByUserId(int suppliercreatedbyuserid) {
        List<Supplier> suppliers = supplierRepository.readBySupplierCreatedByUserId(suppliercreatedbyuserid);
        return new SupplierReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        suppliers);
    }
    public SupplierReadListResponse readBySupplierEmail(String supplieremail) {
        List<Supplier> suppliers = supplierRepository.readBySupplierEmail(supplieremail);
        return new SupplierReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        suppliers);
    }
    public SupplierReadSingleResponse readBySupplierId(int supplierid) {
        Supplier supplier = supplierRepository.readBySupplierId(supplierid);
        if (supplier == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new SupplierReadSingleResponse(
                ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
                ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
                supplier);
    }
    public SupplierReadListResponse readBySupplierName(String suppliername) {
        List<Supplier> suppliers = supplierRepository.readBySupplierName(suppliername);
        return new SupplierReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        suppliers);
    }
    public SupplierReadListResponse readBySupplierPhoneNumber(String supplierphonenumber) {
        List<Supplier> suppliers = supplierRepository.readBySupplierPhoneNumber(supplierphonenumber);
        return new SupplierReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        suppliers);
    }
    public SupplierReadListResponse readBySupplierStatus(String supplierstatus) {
        List<Supplier> suppliers = supplierRepository.readBySupplierStatus(supplierstatus);
        return new SupplierReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        suppliers);
    }
    public SupplierReadListResponse readBySupplierUpdatedAt(String supplierupdatedat) {
        List<Supplier> suppliers = supplierRepository.readBySupplierUpdatedAt(supplierupdatedat);
        return new SupplierReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        suppliers);
    }
}
