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
public class Supplier  {
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  supplierAddress;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  supplierContactPerson;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  supplierCreatedAt;
@Column(type="int",nullable=true )
public int  supplierCreatedByUserId;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  supplierEmail;
@Column(type="INT", primaryKey=true,autoIncrement=true,startValue=100,step=1)
public int  supplierId;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  supplierName;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  supplierPhoneNumber;
@Column(type="VARCHAR(n)",defaultValue="ACTIVE'",nullable=true , length=255)
public String  supplierStatus;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  supplierUpdatedAt;
}
