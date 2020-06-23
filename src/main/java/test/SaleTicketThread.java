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
				System.out.println("售出了第" + num + "张票!");
				num--;
			} else {
				System.out.println("售罄!");
				break;
			}
		}
	}
}

public class SaleTicketThread {
	public static void main(String[] args) {
		SaleTicket saleTicket1 = new SaleTicket("窗口1");
		SaleTicket saleTicket2 = new SaleTicket("窗口2");
		SaleTicket saleTicket3 = new SaleTicket("窗口3");

		saleTicket1.start();
		saleTicket2.start();
		saleTicket3.start();
	}

}
