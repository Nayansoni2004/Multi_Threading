class Transaction implements Runnable {
    public void run() {
        Thread x = Thread.currentThread();
        for(int i = 0 ; i < 5 ; i++) {
            System.out.println(x.getName() + " is going to withdraw Rs 10");
            C.ac.withdraw(10);
            System.out.println(x.getName() + " after withdrawal.. the balance is Rs " + C.ac.getBalance());
        }
    }
}
class C {
    static Account ac = new Account();
    // main method
    public static void main(String[] args) {
        Transaction t = new Transaction();
        new Thread(t , "mohan").start();
        new Thread(t , "sohan").start();
    }
}
/*OUTPUT:
D:\javaprac\36_Multi_Threading>java C
sohan is going to withdraw Rs 10
mohan is going to withdraw Rs 10
sohan after withdrawal.. the balance is Rs 40
mohan after withdrawal.. the balance is Rs 30
sohan is going to withdraw Rs 10
mohan is going to withdraw Rs 10
sohan after withdrawal.. the balance is Rs 20
sohan is going to withdraw Rs 10
mohan after withdrawal.. the balance is Rs 10
mohan is going to withdraw Rs 10
sohan after withdrawal.. the balance is Rs 0
sohan is going to withdraw Rs 10
sohan after withdrawal.. the balance is Rs -20
sohan is going to withdraw Rs 10
sohan after withdrawal.. the balance is Rs -30
mohan after withdrawal.. the balance is Rs -10
mohan is going to withdraw Rs 10
mohan after withdrawal.. the balance is Rs -40
mohan is going to withdraw Rs 10
mohan after withdrawal.. the balance is Rs -50
 */