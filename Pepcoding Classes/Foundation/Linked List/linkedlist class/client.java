public class client{
    public static void main(String[] args) throws Exception{
        linkedlist ll1 = new linkedlist();
        for(int i=0;i<10;i++) ll1.addLast(i * 10);

        ll1.display();
        ll1.removeFirst();
        ll1.removeLast();
        System.out.println(ll1.getAt(2));
        ll1.display();
    }
}