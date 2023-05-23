package com.damp.damproject.vo;

public class TripVO {
	
	private String title;
	private String addr1;
	private String addr2;
	private String tel;
	private double latitude;
	private double longitude;
	private int readcount;
	private String first_image;
	
	public TripVO() {
		super();
	}
	
	public TripVO(String title, String addr1, String addr2, String tel, double latitude, double longitude, int readcount, String first_image) {
		setTitle(title);
		setAddr1(addr1);
		setAddr2(addr2);
		setTel(tel);
		setLatitude(latitude);
		setLongitude(longitude);
		setReadcount(readcount);
		setFirst_image(first_image);
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		if (title == null || "".equals(title.trim())) return;
		this.title = title;
	}
	
	public String getAddr1() {
		return addr1;
	}
	
	public void setAddr1(String addr1) {
		if (addr1 == null || "".equals(addr1.trim())) return;
		this.addr1 = addr1;
	}
	
	public String getAddr2() {
		return addr2;
	}
	
	public void setAddr2(String addr2) {
		if (addr2 == null || "".equals(addr2.trim())) return;
		this.addr2 = addr2;
	}
	
	public String getTel() {
		return tel;
	}
	
	public void setTel(String tel) {
		if (tel == null || "".equals(tel.trim())) return;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public void setLatitude(double latitude) {
		if (latitude < -90 || latitude > 90) return;
		this.latitude = latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}
	
	public void setLongitude(double longitude) {
		if (longitude < -180 || longitude > 180) return;
		this.longitude = longitude;
	}
	
	public int getReadcount() {
		return readcount;
	}
	
	public void setReadcount(int readcount) {
		if (readcount < 0) return;
		this.readcount = readcount;
	}
	
	public String getFirst_image() {
		return first_image;
	}
	
	public void setFirst_image(String first_image) {
		if (first_image == null || "".equals(first_image.trim())) return;
		this.first_image = first_image;
	}
	
	@Override
	public String toString() {
		return "TripVO [title=" + title + ", addr1=" + addr1 + ", addr2=" + addr2 + ", tel=" + tel + ", latitude="
				+ latitude + ", longitude=" + longitude + ", readCount=" + readcount + ", first_image=" + first_image
				+ "]";
	}
	
}
