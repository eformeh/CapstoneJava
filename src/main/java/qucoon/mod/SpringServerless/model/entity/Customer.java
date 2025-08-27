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
public class Customer  {
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  customerAddress;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  customerCompanyName;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  customerCreatedAt;
@Column(type="double",nullable=true )
public Double  customerCreditBalance;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  customerEmail;
@Column(type="INT", primaryKey=true,autoIncrement=true,startValue=100,step=1)
public int  customerId;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  customerName;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  customerNotes;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  customerPhone;
@Column(type="VARCHAR(n)",defaultValue="ACTIVE'",nullable=true , length=255)
public String  customerStatus;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  customerType;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  customerUpdatedAt;
}
