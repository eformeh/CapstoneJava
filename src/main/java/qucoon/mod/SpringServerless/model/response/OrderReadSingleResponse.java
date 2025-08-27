
package qucoon.mod.SpringServerless.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.*;

@Data
@AllArgsConstructor
public class OrderReadSingleResponse {
    public String responseCode;
    public String responseMessage;
    public Order data;
}
