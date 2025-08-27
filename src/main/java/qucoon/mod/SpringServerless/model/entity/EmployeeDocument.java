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
public class EmployeeDocument  {
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  employeeDocumentAccessLevel;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  employeeDocumentCreatedAt;
@Column(type="int",nullable=true )
public int  employeeDocumentEmployeeId;
@Column(type="DateTime",nullable=true )
public String  employeeDocumentExpiresAt;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  employeeDocumentFileUrl;
@Column(type="INT", primaryKey=true,autoIncrement=true,startValue=100,step=1)
public int  employeeDocumentId;
@Column(type="VARCHAR(n)",defaultValue="ACTIVE'",nullable=true , length=255)
public String  employeeDocumentStatus;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  employeeDocumentType;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  employeeDocumentUpdatedAt;
@Column(type="int",nullable=true )
public int  employeeDocumentUploadedBy;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  employeeDocumentVersion;
}
