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
public class TransactionCategory  {
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  transactionCategoryCreatedAt;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  transactionCategoryDescription;
@Column(type="INT", primaryKey=true,autoIncrement=true,startValue=100,step=1)
public int  transactionCategoryId;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  transactionCategoryName;
@Column(type="VARCHAR(n)",defaultValue="ACTIVE'",nullable=true , length=255)
public String  transactionCategoryStatus;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  transactionCategoryTransactionNature;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  transactionCategoryUpdatedAt;
}
