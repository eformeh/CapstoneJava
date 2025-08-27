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
public class Overtime  {
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  overtimeCreatedAt;
@Column(type="DateTime",nullable=true )
public String  overtimeDate;
@Column(type="int",nullable=true )
public int  overtimeEmployeeId;
@Column(type="double",nullable=true )
public Double  overtimeHours;
@Column(type="INT", primaryKey=true,autoIncrement=true,startValue=100,step=1)
public int  overtimeId;
@Column(type="VARCHAR(n)",defaultValue="ACTIVE'",nullable=true , length=255)
public String  overtimeStatus;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  overtimeUpdatedAt;
}
