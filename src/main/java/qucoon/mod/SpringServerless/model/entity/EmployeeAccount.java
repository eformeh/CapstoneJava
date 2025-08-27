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
public class EmployeeAccount  {
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  employeeAccountBankName;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  employeeAccountCreatedAt;
@Column(type="int",nullable=true )
public int  employeeAccountEmployeeId;
@Column(type="INT", primaryKey=true,autoIncrement=true,startValue=100,step=1)
public int  employeeAccountId;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  employeeAccountName;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  employeeAccountNumber;
@Column(type="VARCHAR(n)",defaultValue="ACTIVE'",nullable=true , length=255)
public String  employeeAccountStatus;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  employeeAccountUpdatedAt;
}
