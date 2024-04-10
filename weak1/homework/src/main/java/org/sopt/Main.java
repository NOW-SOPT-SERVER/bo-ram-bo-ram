package org.sopt;

import org.sopt.controller.BankController;
import org.sopt.controller.CustomerController;
import org.sopt.domain.Bank;
import org.sopt.domain.Customer;
import org.sopt.view.BankView;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        BankController bankController = new BankController(bank);
        CustomerController customerController = new CustomerController();

        BankView view = new BankView(bankController, customerController);
        view.run();
    }
}
