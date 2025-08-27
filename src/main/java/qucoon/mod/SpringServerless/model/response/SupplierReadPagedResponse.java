package qucoon.mod.SpringServerless.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.dto.SupplierDto;
import java.util.List;

@Data
@AllArgsConstructor
public class SupplierReadPagedResponse {
    private String responseCode;
    private String responseMessage;
    private List<SupplierDto> data;
    private long totalRecords;
    private int pageNumber;
    private int pageSize;
    private int totalPages;
}
