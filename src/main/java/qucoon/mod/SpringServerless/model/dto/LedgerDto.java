package qucoon.mod.SpringServerless.model.dto;


import lombok.Data;
import qucoon.mod.SpringServerless.model.entity.Ledger;


@Data
public class LedgerDto  {

private Integer ledgerAccountId;
private Double ledgerBalanceAfter;
private String ledgerCreatedAt;
private Double ledgerCredit;
private Double ledgerDebit;
private Integer ledgerId;
private Integer ledgerjournalEntryLineAccountId;
private String ledgerStatus;
private String ledgerUpdatedAt;

public static LedgerDto from(Ledger p) {
    LedgerDto dto = new LedgerDto();

    dto.setLedgerAccountId(p.getLedgerAccountId());
    dto.setLedgerBalanceAfter(p.getLedgerBalanceAfter());
    dto.setLedgerCreatedAt(p.getLedgerCreatedAt());
    dto.setLedgerCredit(p.getLedgerCredit());
    dto.setLedgerDebit(p.getLedgerDebit());
    dto.setLedgerId(p.getLedgerId());
    dto.setLedgerjournalEntryLineAccountId(p.getLedgerjournalEntryLineAccountId());
    dto.setLedgerStatus(p.getLedgerStatus());
    dto.setLedgerUpdatedAt(p.getLedgerUpdatedAt());
    return dto;
   }
}
