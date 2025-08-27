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
public class AccountMapping  {
@Column(type="int",nullable=true )
public int  accountMappingCrAccountId;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  accountMappingCreatedAt;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  accountMappingDescription;
@Column(type="int",nullable=true )
public int  accountMappingDrAccountId;
@Column(type="INT", primaryKey=true,autoIncrement=true,startValue=100,step=1)
public int  accountMappingId;
@Column(type="VARCHAR(n)",defaultValue="ACTIVE'",nullable=true , length=255)
public String  accountMappingStatus;
@Column(type="int",nullable=true )
public int  accountMappingTransactionCategoryId;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  accountMappingUpdatedAt;
}
