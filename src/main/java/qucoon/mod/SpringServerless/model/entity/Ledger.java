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
public class Ledger  {
@Column(type="int",nullable=true )
public int  ledgerAccountId;
@Column(type="double",nullable=true )
public Double  ledgerBalanceAfter;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  ledgerCreatedAt;
@Column(type="double",nullable=true )
public Double  ledgerCredit;
@Column(type="double",nullable=true )
public Double  ledgerDebit;
@Column(type="INT", primaryKey=true,autoIncrement=true,startValue=100,step=1)
public int  ledgerId;
@Column(type="int",nullable=true )
public int  ledgerjournalEntryLineAccountId;
@Column(type="VARCHAR(n)",defaultValue="ACTIVE'",nullable=true , length=255)
public String  ledgerStatus;
@Column(type="DateTime",defaultValue="getdate()",nullable=true )
public String  ledgerUpdatedAt;
}
