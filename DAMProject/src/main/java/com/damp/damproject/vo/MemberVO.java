package com.damp.damproject.vo;

public class MemberVO {
	
	private int id;
	private String memberId;
	private String password;
	private String name;
	private String email;
	private String address;
	
	public MemberVO() {
		super();
	}
	
	public MemberVO(int id, String memberId, String password, String name, String email, String address) {
		setId(id);
		setMemberId(memberId);
		setPassword(password);
		setName(name);
		setEmail(email);
		setAddress(address);
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		if (id <= 0) return;
		this.id = id;
	}
	
	public String getMemberId() {
		return memberId;
	}
	
	public void setMemberId(String memberId) {
		if (memberId == null || "".equals(memberId.trim())) return;
		this.memberId = memberId;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		if (password == null || "".equals(password.trim())) return;
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		if (name == null || "".equals(name.trim())) return;
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		if (email == null || "".equals(email.trim())) return;
		this.email = email;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		if (address == null || "".equals(address.trim())) return;
		this.address = address;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", memberId=" + memberId + ", password=" + password + ", name=" + name
				+ ", email=" + email + ", address=" + address + "]";
	}
	
}
