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
public class User  {
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  userCreatedAt;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  userEmail;
@Column(type="int",nullable=true )
public int  userEmployeeId;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  userFirstName;
@Column(type="INT", primaryKey=true,autoIncrement=true,startValue=100,step=1)
public int  userId;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  userLastLoginDate;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  userLastLoginIpAddress;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  userLastName;
@Column(type="int",defaultValue="0",nullable=true )
public int  userLoginCount;
@Column(type="VARCHAR(n)",nullable=true , length=255)
public String  userPassword;
@Column(type="int",nullable=true )
public int  userRoleId;
@Column(type="VARCHAR(n)",defaultValue="ACTIVE'",nullable=true , length=255)
public String  userStatus;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  userUpdatedAt;
}
