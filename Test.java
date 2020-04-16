
public class Test {
    public static void main(String[] args) {
        composeEmailTest();
    }

    public static void composeEmailTest() {
        Device d = new Device();
        d.registerTestAccounts();
        d.login();
        System.out.println(d.currentAccount.accountName);
        d.composeEmail();
        d.viewSent();
        d.logout();
        d.login();
        d.viewInbox();

    }
}