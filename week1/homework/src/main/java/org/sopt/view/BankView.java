package org.sopt.view;

import org.sopt.controller.BankController;
import org.sopt.controller.CustomerController;

import java.util.Scanner;

public class BankView {
    private BankController bankController;
    private CustomerController customerController;

    public BankView(BankController controller, CustomerController customerController) {
        this.bankController = controller;
        this.customerController = customerController;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("원하는 기능을 선택하세요");
            System.out.println("1. 고객 생성");
            System.out.println("2. 계좌 생성");
            System.out.println("3. 입금");
            System.out.println("4. 출금");
            System.out.println("5. 이체");
            System.out.println("6. 잔액조회");
            System.out.println("7. 종료");
            System.out.print("선택: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createCustomer(scanner);
                    break;
                case 2:
                    createAccount(scanner);
                    break;
                case 3:
                    deposit(scanner);
                    break;
                case 4:
                    withdraw(scanner);
                    break;
                case 6:
                    getBalance(scanner);
                    break;
                case 7:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 선택입니다.");
            }
        }
    }

    private void createCustomer(Scanner scanner) {
        System.out.print("고객 이름을 입력하세요: ");
        String customerName = scanner.next();

        System.out.print("인증비밀번호를 입력하세요: ");
        String customerPassword = scanner.next();

        // 생성된 고객을 BankController에 추가
        bankController.addCustomer(customerController.createCustomer(customerName,customerPassword));
    }
    private void createAccount(Scanner scanner) {
        System.out.print("고객 이름을 입력하세요: ");
        String customerName = scanner.next();

        System.out.print("고객 비밀번호를 입력하세요: ");
        String customerPassword = scanner.next();

        System.out.print("10자리의 계좌 번호를 숫자만 입력하세요: ");
        String accountNumber = scanner.next();

        System.out.print("4자리 비밀번호를 입력하세요: ");
        String password = scanner.next();

        bankController.createAccount(customerName,customerPassword,accountNumber,password);
    }
    private void withdraw(Scanner scanner){
        System.out.print("10자리의 계좌 번호를 숫자만 입력하세요: ");
        String accountNumber = scanner.next();

        System.out.print("계좌 4자리 비밀번호를 입력하세요: ");
        String accountPassword = scanner.next();

        System.out.print("출금할 금액을 입력하세요: ");
        double accountAmount = Double.parseDouble(scanner.next());

        bankController.withdraw(accountNumber,accountPassword, accountAmount);
    }

    private void deposit(Scanner scanner){
        System.out.print("10자리의 계좌 번호를 숫자만 입력하세요: ");
        String accountNumber = scanner.next();

        System.out.print("계좌 4자리 비밀번호를 입력하세요: ");
        String accountPassword = scanner.next();

        System.out.print("입금할 금액을 입력하세요: ");
        double accountAmount = Double.parseDouble(scanner.next());


        bankController.deposit(accountNumber,accountPassword, accountAmount);
    }

    private void getBalance(Scanner scanner){
        System.out.print("10자리의 계좌 번호를 숫자만 입력하세요: ");
        String accountNumber = scanner.next();

        System.out.print("계좌 4자리 비밀번호를 입력하세요: ");
        String accountPassword = scanner.next();

        bankController.getBalance(accountNumber,accountPassword);
    }
}
