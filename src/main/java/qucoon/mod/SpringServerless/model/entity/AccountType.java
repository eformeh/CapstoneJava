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
public class AccountType  {
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  accountTypeAccountTypeName;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  accountTypeCreatedAt;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  accountTypeDescription;
@Column(type="INT", primaryKey=true,autoIncrement=true,startValue=100,step=1)
public int  accountTypeId;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  accountTypeNormalBalance;
@Column(type="VARCHAR(n)",defaultValue="ACTIVE'",nullable=true , length=255)
public String  accountTypeStatus;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  accountTypeUpdatedAt;
}
