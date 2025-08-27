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
public class ExpenseItem  {
@Column(type="double",nullable=true )
public Double  expenseItemAmount;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  expenseItemCategory;
@Column(type="int",nullable=true )
public int  expenseItemClaimId;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  expenseItemCreatedAt;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  expenseItemDescription;
@Column(type="INT", primaryKey=true,autoIncrement=true,startValue=100,step=1)
public int  expenseItemId;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  expenseItemReceiptUrl;
@Column(type="VARCHAR(n)",defaultValue="ACTIVE'",nullable=true , length=255)
public String  expenseItemStatus;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  expenseItemUpdatedAt;
}
