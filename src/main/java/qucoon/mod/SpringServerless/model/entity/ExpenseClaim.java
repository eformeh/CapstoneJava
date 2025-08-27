package qucoon.mod.SpringServerless.model.entity;


import lombok.Data;
import qucoon.mod.SpringServerless.repository.annotation.Column;
import qucoon.mod.SpringServerless.repository.annotation.Table;
import qucoon.mod.SpringServerless.utility.constant.PrefixConstant;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Date;
import java.time.LocalDateTime;


@Data
@Table
public class ExpenseClaim  {
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  expenseClaimCreatedAt;
@Column(type="DateTime",nullable=true )
public String  expenseClaimDecisionDate;
@Column(type="int",nullable=true )
public int  expenseClaimEmployeeId;
@Column(type="INT", primaryKey=true,autoIncrement=true,startValue=100,step=1)
public int  expenseClaimId;
@Column(type="DateTime",nullable=true )
public String  expenseClaimReimbursementDate;
@Column(type="int",nullable=true )
public int  expenseClaimReviewerId;
@Column(type="VARCHAR(n)",defaultValue="ACTIVE'",nullable=true , length=255)
public String  expenseClaimStatus;
@Column(type="double",nullable=true )
public Double  expenseClaimTotalAmount;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  expenseClaimUpdatedAt;
}
