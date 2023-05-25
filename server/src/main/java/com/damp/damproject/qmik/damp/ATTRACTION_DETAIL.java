package com.damp.damproject.qmik.damp;

import com.qmik.model.Model;
import com.qmik.query.Attribute;

public class ATTRACTION_DETAIL implements Model {

	public final static String DRIVER = "mysql";
	public final static String URL = "jdbc:mysql://localhost:3306/damp";
	public final static String USER = "ssafy";
	public final static String PASSWORD = "ssafy";
	public final static String TABLE = "attraction_detail";

	public static Attribute<Integer> content_id = new Attribute<>("content_id");
	public static Attribute<String> cat1 = new Attribute<>("cat1");
	public static Attribute<String> cat2 = new Attribute<>("cat2");
	public static Attribute<String> cat3 = new Attribute<>("cat3");
	public static Attribute<String> created_time = new Attribute<>("created_time");
	public static Attribute<String> modified_time = new Attribute<>("modified_time");
	public static Attribute<String> booktour = new Attribute<>("booktour");

}