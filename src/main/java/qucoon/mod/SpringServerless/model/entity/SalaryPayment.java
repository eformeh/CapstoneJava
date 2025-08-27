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
public class SalaryPayment  {
@Column(type="double",nullable=true )
public Double  salaryPaymentAmount;
@Column(type="int",nullable=true )
public int  salaryPaymentApprovedBy;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  salaryPaymentChannel;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  salaryPaymentCreatedAt;
@Column(type="int",nullable=true )
public int  salaryPaymentEmployeeAccountId;
@Column(type="INT", primaryKey=true,autoIncrement=true,startValue=100,step=1)
public int  salaryPaymentId;
@Column(type="int",nullable=true )
public int  salaryPaymentSalaryId;
@Column(type="VARCHAR(n)",defaultValue="ACTIVE'",nullable=true , length=255)
public String  salaryPaymentStatus;
@Column(type="int",nullable=true )
public int  salaryPaymentTransactionId;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  salaryPaymentUpdatedAt;
}
