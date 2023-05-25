package com.damp.damproject.qmik.damp;

import com.qmik.model.Model;
import com.qmik.query.Attribute;

public class ATTRACTION_INFO implements Model {

	public final static String DRIVER = "mysql";
	public final static String URL = "jdbc:mysql://localhost:3306/damp";
	public final static String USER = "ssafy";
	public final static String PASSWORD = "ssafy";
	public final static String TABLE = "attraction_info";

	public static Attribute<Integer> content_id = new Attribute<>("content_id");
	public static Attribute<Integer> content_type_id = new Attribute<>("content_type_id");
	public static Attribute<String> title = new Attribute<>("title");
	public static Attribute<String> addr1 = new Attribute<>("addr1");
	public static Attribute<String> addr2 = new Attribute<>("addr2");
	public static Attribute<String> zipcode = new Attribute<>("zipcode");
	public static Attribute<String> tel = new Attribute<>("tel");
	public static Attribute<String> first_image = new Attribute<>("first_image");
	public static Attribute<String> first_image2 = new Attribute<>("first_image2");
	public static Attribute<Integer> readcount = new Attribute<>("readcount");
	public static Attribute<Integer> sido_code = new Attribute<>("sido_code");
	public static Attribute<Integer> gugun_code = new Attribute<>("gugun_code");
	public static Attribute<Double> latitude = new Attribute<>("latitude");
	public static Attribute<Double> longitude = new Attribute<>("longitude");
	public static Attribute<String> mlevel = new Attribute<>("mlevel");

}