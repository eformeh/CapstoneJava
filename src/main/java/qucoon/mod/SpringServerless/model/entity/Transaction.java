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
public class Transaction  {
@Column(type="double",nullable=true )
public Double  transactionAmount;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  transactionCreatedAt;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  transactionDescription;
@Column(type="INT", primaryKey=true,autoIncrement=true,startValue=100,step=1)
public int  transactionId;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  transactionNarration;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  transactionReferenceNumber;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  transactionSourceModule;
@Column(type="int",nullable=true )
public int  transactionSourceReferenceId;
@Column(type="VARCHAR(n)",defaultValue="ACTIVE'",nullable=true , length=255)
public String  transactionStatus;
@Column(type="int",nullable=true )
public int  transactionTransactionCategoryId;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  transactionTransactionDate;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  transactionUpdatedAt;
}
