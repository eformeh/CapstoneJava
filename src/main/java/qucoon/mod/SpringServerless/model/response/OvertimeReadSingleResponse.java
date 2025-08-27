
package qucoon.mod.SpringServerless.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.*;

@Data
@AllArgsConstructor
public class OvertimeReadSingleResponse {
    public String responseCode;
    public String responseMessage;
    public Overtime data;
}
