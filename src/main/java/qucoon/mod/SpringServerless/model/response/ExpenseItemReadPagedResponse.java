package qucoon.mod.SpringServerless.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.dto.ExpenseItemDto;
import java.util.List;

@Data
@AllArgsConstructor
public class ExpenseItemReadPagedResponse {
    private String responseCode;
    private String responseMessage;
    private List<ExpenseItemDto> data;
    private long totalRecords;
    private int pageNumber;
    private int pageSize;
    private int totalPages;
}
