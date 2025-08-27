package qucoon.mod.SpringServerless.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.dto.AppraisalFormDto;
import java.util.List;

@Data
@AllArgsConstructor
public class AppraisalFormReadPagedResponse {
    private String responseCode;
    private String responseMessage;
    private List<AppraisalFormDto> data;
    private long totalRecords;
    private int pageNumber;
    private int pageSize;
    private int totalPages;
}
