package test;

class SaleTicket extends Thread {
	static int num = 10;

	public SaleTicket(String name) {
		// TODO Auto-generated constructor stub
		super(name);
	}

	@Override
	public void run() {
		while (true) {
			if (num > 0) {
				System.out.println("�۳��˵�" + num + "��Ʊ!");
				num--;
			} else {
				System.out.println("����!");
				break;
			}
		}
	}
}

public class SaleTicketThread {
	public static void main(String[] args) {
		SaleTicket saleTicket1 = new SaleTicket("����1");
		SaleTicket saleTicket2 = new SaleTicket("����2");
		SaleTicket saleTicket3 = new SaleTicket("����3");

		saleTicket1.start();
		saleTicket2.start();
		saleTicket3.start();
	}

}
