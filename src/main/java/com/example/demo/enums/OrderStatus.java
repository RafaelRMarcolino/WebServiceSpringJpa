package com.example.demo.enums;

public enum OrderStatus {
	
	WAITING_PAYMENT(1, "Waiting Payment"),
	PAID(2, "Paid"),
	SHIPPED(3, "Shipped"),
	DELIVERED(4, "Delivered"),
	CANCELED(5, "Canceled");
	
	private int cod;
	private String msg;
	
	private OrderStatus(int cod, String msg) {
		this.cod = cod;
		this.msg = msg;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public static OrderStatus valueOf(int cod) {
		for(OrderStatus value : OrderStatus.values()){
			
			if(value.getCod() == cod) {
				return value;
			}
			
		}
		throw new IllegalArgumentException("Codigo invalido" + cod);
		
	}
	

}
