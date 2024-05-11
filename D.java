class Transaction implements Runnable {
    public void run() {
        Thread x = Thread.currentThread();
        for(int i = 0 ; i < 5 ; i++) {
            if(D.ac.getBalance() >= 10) {
                System.out.println(x.getName() + " is going to withdraw Rs 10");

                try{ Thread.sleep(500); }
                catch(InterruptedException e) { e.printStackTrace(); }

                D.ac.withdraw(10);

                System.out.println(x.getName() + " after withdrawal.. the balance is Rs " + D.ac.getBalance());
            }
        }
    }
}
class D {
    static Account ac = new Account();
    // main method
    public static void main(String[] args) {
        Transaction t = new Transaction();
        Thread a = new Thread(t , "mohan");
        Thread b = new Thread(t , "sohan");

        a.start();
        b.start();
    }
}
/*OUTPUT:
D:\javaprac\36_Multi_Threading>java D
mohan is going to withdraw Rs 10
sohan is going to withdraw Rs 10
mohan after withdrawal.. the balance is Rs 40
mohan is going to withdraw Rs 10
sohan after withdrawal.. the balance is Rs 30
sohan is going to withdraw Rs 10
mohan after withdrawal.. the balance is Rs 20
mohan is going to withdraw Rs 10
sohan after withdrawal.. the balance is Rs 10
sohan is going to withdraw Rs 10
mohan after withdrawal.. the balance is Rs 0
sohan after withdrawal.. the balance is Rs -10
 */