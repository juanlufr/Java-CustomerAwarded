public class MyCustomer {
	public String name;
    public int paid;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPaid() {
		return paid;
	}

	public void setPaid(int paid) {
		this.paid = paid;
	}

	public MyCustomer(String name, int paid) {
		super();
		this.name = name;
		this.paid = paid;
	}
}