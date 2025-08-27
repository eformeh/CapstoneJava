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
public class Employee  {
@Column(type="DateTime",nullable=true )
public String  employeeContractEndDate;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  employeeCreatedAt;
@Column(type="DateTime",nullable=true )
public String  employeeDateOfBirth;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  employeeEmail;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  employeeEmploymentStatus;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  employeeEmploymentType;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  employeeFirstName;
@Column(type="DateTime",nullable=true )
public String  employeeHireDate;
@Column(type="INT", primaryKey=true,autoIncrement=true,startValue=100,step=1)
public int  employeeId;
@Column(type="int",nullable=true )
public int  employeeJobId;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  employeeLastName;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  employeeMaritalStatus;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  employeeNationality;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  employeePhone;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  employeePhotoUrl;
@Column(type="VARCHAR(n)",defaultValue="ACTIVE'",nullable=true , length=255)
public String  employeeStatus;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  employeeUpdatedAt;
}
