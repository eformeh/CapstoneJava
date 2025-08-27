package qucoon.mod.SpringServerless.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.dto.InventoryItemDto;
import java.util.List;

@Data
@AllArgsConstructor
public class InventoryItemReadPagedResponse {
    private String responseCode;
    private String responseMessage;
    private List<InventoryItemDto> data;
    private long totalRecords;
    private int pageNumber;
    private int pageSize;
    private int totalPages;
}
