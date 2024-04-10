package org.sopt;

import org.sopt.controller.BankController;
import org.sopt.domain.Bank;
import org.sopt.view.BankView;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        BankController controller = new BankController(bank);
        BankView view = new BankView(controller);
        view.run();

    }
}