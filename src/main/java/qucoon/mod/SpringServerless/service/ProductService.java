
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
import qucoon.mod.SpringServerless.repository.page.ProductPage;
import qucoon.mod.SpringServerless.model.entity.*;
import qucoon.mod.SpringServerless.utility.constant.ResponseConstant;
import com.google.gson.Gson;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import qucoon.mod.SpringServerless.model.dto.ProductDto;


@Service
public class ProductService {

    private final ProductRepository productRepository;
    private  final Gson GSON;


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
        this.GSON = new GsonBuilder()
               .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
                .create();
    }



    public BaseResponse create(ProductCreateRequest request) {
        //Unique Attribute Check
        List<Product> product_1 = productRepository.readByProductSKU(request.getProductSKU());
        if (!product_1.isEmpty()) {
            throw new CustomExceptions.DuplicateItemException("+Product with ProductSKU: " + request.getProductSKU() + " already exists");
        }


        Product product = GSON.fromJson(GSON.toJson(request), Product.class);
        if (product.getProductStatus() == null) {
            product.setProductStatus("ACTIVE");
        }
        productRepository.create(product);

        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse bulkCreate(List<ProductCreateRequest> request) {
        try {
            String json = GSON.toJson(request);
            Product[] productArray = GSON.fromJson(json, Product[].class);
            List<Product> products = Arrays.asList(productArray);
            productRepository.bulkCreate(products);
            return ResponseConstant.INSTANCE.getSUCCESS();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseConstant.INSTANCE.getBAD_REQUEST();
        }
    }

    public BaseResponse update(ProductUpdateRequest request) {
        Product product = productRepository.readByProductId(request.getProductId());
        if (product == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        productRepository.update(product);
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public BaseResponse delete(int productId) {
        int updateResponse = productRepository.delete(productId);
        if (updateResponse < 1) {
            throw new CustomExceptions.FailedToUpdateRecord("Record not found");
        }
        return ResponseConstant.INSTANCE.getSUCCESS();
    }

    public ProductReadListResponse read() {
        List<Product> products = productRepository.read();
       if(products == null){
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new ProductReadListResponse(ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(), ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(), products);
    }
   public ProductReadPagedResponse search(ProductFilterRequest filter) {
    // reuse same repository call for search, since filter includes search criteria
       ProductPage page = productRepository.findProduct(filter);
       int totalPages = (int) Math.ceil((double) page.getTotalRecords() / filter.getPageSize());
       List<ProductDto> dtos = page.getData().stream()
            .map(ProductDto::from)
            .collect(Collectors.toList());
    return new ProductReadPagedResponse(
            ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
            ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
            dtos,
            page.getTotalRecords(),
            filter.getPageNumber(),
            filter.getPageSize(),
            totalPages
    );
}
    public ProductReadListResponse readByProductBarcode(String productbarcode) {
        List<Product> products = productRepository.readByProductBarcode(productbarcode);
        return new ProductReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        products);
    }
    public ProductReadListResponse readByProductCategory(String productcategory) {
        List<Product> products = productRepository.readByProductCategory(productcategory);
        return new ProductReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        products);
    }
    public ProductReadListResponse readByProductCreatedAt(String productcreatedat) {
        List<Product> products = productRepository.readByProductCreatedAt(productcreatedat);
        return new ProductReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        products);
    }
    public ProductReadListResponse readByProductDescription(String productdescription) {
        List<Product> products = productRepository.readByProductDescription(productdescription);
        return new ProductReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        products);
    }
    public ProductReadSingleResponse readByProductId(int productid) {
        Product product = productRepository.readByProductId(productid);
        if (product == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new ProductReadSingleResponse(
                ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
                ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
                product);
    }
    public ProductReadListResponse readByProductMinimumThreshold(int productminimumthreshold) {
        List<Product> products = productRepository.readByProductMinimumThreshold(productminimumthreshold);
        return new ProductReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        products);
    }
    public ProductReadListResponse readByProductName(String productname) {
        List<Product> products = productRepository.readByProductName(productname);
        return new ProductReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        products);
    }
    public ProductReadListResponse readByProductPrice(Double productprice) {
        List<Product> products = productRepository.readByProductPrice(productprice);
        return new ProductReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        products);
    }
    public ProductReadSingleResponse readByProductSKU(String productsku) {
        List<Product> product = productRepository.readByProductSKU(productsku);
        if (product == null) {
            throw new CustomExceptions.UnableToLocateRecordException("Record not found");
        }
        return new ProductReadSingleResponse(
                ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
                ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
                product.get(0));
    }
    public ProductReadListResponse readByProductStatus(String productstatus) {
        List<Product> products = productRepository.readByProductStatus(productstatus);
        return new ProductReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        products);
    }
    public ProductReadListResponse readByProductStockQuantity(int productstockquantity) {
        List<Product> products = productRepository.readByProductStockQuantity(productstockquantity);
        return new ProductReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        products);
    }
    public ProductReadListResponse readByProductUpdatedAt(String productupdatedat) {
        List<Product> products = productRepository.readByProductUpdatedAt(productupdatedat);
        return new ProductReadListResponse(
        ResponseConstant.INSTANCE.getSUCCESS().getResponseCode(),
        ResponseConstant.INSTANCE.getSUCCESS().getResponseMessage(),
        products);
    }
}
