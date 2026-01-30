import java.util.ArrayList;
import java.util.Scanner;

class bank{
    private int accountNo;
    private String name;
    private double balance;

    //constructor
    bank(int accountNo, String name, double balance){
        this.accountNo = accountNo;
        this.name = name;
        this.balance = balance;
    }
    // getters and setters
    public int getAccountNo() {
        return accountNo;
    }
    public double getBalance() {
        return balance;
    }
    // deposit
    public void deposit(double amount){
        if (amount <0){
            System.out.println("Invalid amount. Try again");
        }else{
            balance = amount+balance;
            System.out.println(amount + " TK has been deposited. Your current balance is: "+ balance);
        }
    }
    //withdraw
    public void withdraw(double amount){
        if (amount > balance){
            System.out.println("You don't have enough money.");
        }else if(amount < 0){
            System.out.println("Invalid amount. Input valid amount");
        }else{
            balance = balance-amount;
            System.out.println(amount + " Tk has been withdrawn. Your current balance is: "+ balance);
        }
    }
    //view all information
    public void viewinfo() {
        System.out.println("Account Number: " + accountNo + " Name: " + name + "Balance: " + balance);
    }
}

class Bank{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<bank> customers = new ArrayList<>();
        while(true){
            System.out.println("======Banking System======");
            System.out.println("1.Create Account");
            System.out.println("2.View all accounts");
            System.out.println("3.Add money");
            System.out.println("4.Withdraw Money");
            System.out.println("5.Check balance");
            System.out.println("6.Remove account");
            System.out.println("7.Exit");
            System.out.print("Enter your choice:");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.print("Enter account owners name:");
                    sc.nextLine();
                    String name = sc.nextLine();

                    System.out.print("Enter account Number: ");
                    int accountNo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter opening balance");
                    double balance = sc.nextInt();
                    sc.nextLine();

                    bank customer = new bank(accountNo,name,balance);
                    customers.add(customer);
                    System.out.println("Your bank account has been created");
                    break;

                case 2:
                    if (customers.isEmpty()){
                        System.out.println("There is no customer to show");
                    }else{
                        for (int i=0; i< customers.size(); i++){
                            System.out.print((i+1)+". ");
                            customers.get(i).viewinfo();
                        }
                    }
                    break;

                case 3:
                    if (customers.isEmpty()){
                        System.out.println("There is no account. Create account first.");
                    }else{
                        System.out.println("Enter the account number:");
                        int depositacc = sc.nextInt();
                        boolean found = false;
                        for(bank c: customers){
                            if (c.getAccountNo() == depositacc){
                                System.out.print("Enter the amount you want to add:");
                                double cash = sc.nextDouble();
                                c.deposit(cash);
                                found = true;
                                break;
                            }
                        }
                        if(!found){
                            System.out.println("There is no account with this account number");
                        }
                    }
                    break;

                case 4:
                    if (customers.isEmpty()){
                        System.out.println("There is no account. Create account first");
                    }else{
                        System.out.print("Enter the account number: ");
                        int withdrawAcc = sc.nextInt();
                        bank withdrawCustomer = null;
                        for(bank c: customers){
                            if(c.getAccountNo() == withdrawAcc){
                                withdrawCustomer = c;
                                break;
                            }
                        }
                        if (withdrawCustomer == null){
                            System.out.println("There is no account with this acc number");
                        }else{
                            System.out.print("Enter the amount:");
                            double amount = sc.nextDouble();
                            withdrawCustomer.withdraw(amount);
                        }
                    }
                    break;

                case 5:
                    if (customers.isEmpty()){
                        System.out.println("There is no account. Create account first");
                    }else{
                        System.out.print("Enter the account number:");
                        int checkacc = sc.nextInt();
                        bank withdrawCustomer = null;
                        for(bank c: customers){
                            if(c.getAccountNo() == checkacc){
                                withdrawCustomer = c;
                                break;
                            }
                        }
                        if (withdrawCustomer == null){
                            System.out.println("There is no account with this acc number");
                        }else{
                            withdrawCustomer.viewinfo();
                        }
                    }
                    break;

                case 6:
                    if (customers.isEmpty()){
                        System.out.println("There is no account. Create account first");
                    }else{
                        System.out.print("Enter the customers account number: ");
                        int acc = sc.nextInt();
                        boolean found = true;
                        for(int i=0; i< customers.size(); i++){
                            if(customers.get(i).getAccountNo() == acc){
                                customers.remove(i);
                                found = true;
                                break;
                            }
                        }
                        if(!found){
                            System.out.println("There is no account. With this account number");
                        }
                    }
                    break;

                case 7:
                    System.out.println("Existing the Bank account system. Thank you for using our system. Good bye");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please input valid choice");
            }
        }
    }
}