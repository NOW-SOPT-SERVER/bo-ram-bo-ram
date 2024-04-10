package org.sopt.domain;

public class Bank {
    private final Long id;
    private final String bankName;  //현재는 국민은행 하나로 지정했기 때문에 final 선언

    public Bank() {
        // 국민은행으로 지정
        this.id = 1L;
        this.bankName = "국민은행";
    }

    public Long getId() {
        return id;
    }

    public String getBankName() {
        return bankName;
    }
}
