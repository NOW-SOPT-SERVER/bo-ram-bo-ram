package org.sopt.view;

import org.sopt.controller.BankController;

import java.util.Scanner;

public class BankView {
    private BankController controller;

    public BankView(BankController controller) {
        this.controller = controller;
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
                    //고객 생성 기능
                    break;
                case 2:
                    //계좌 생성
                    break;
                case 3:
                    // 입금 기능
                    break;
                case 4:
                    // 출금 기능
                    break;
                case 5:
                    // 이체 기능
                    break;
                case 6:
                    // 잔액 조회 기능
                    break;
                case 7:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 선택입니다.");
            }
        }
    }
}
