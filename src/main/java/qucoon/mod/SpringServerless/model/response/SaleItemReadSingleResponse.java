
package qucoon.mod.SpringServerless.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.*;

@Data
@AllArgsConstructor
public class SaleItemReadSingleResponse {
    public String responseCode;
    public String responseMessage;
    public SaleItem data;
}
