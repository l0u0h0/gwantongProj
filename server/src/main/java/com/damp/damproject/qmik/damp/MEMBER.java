package com.damp.damproject.qmik.damp;

import com.qmik.model.Model;
import com.qmik.query.Attribute;

public class MEMBER implements Model {

	public final static String DRIVER = "mysql";
	public final static String URL = "jdbc:mysql://localhost:3306/damp";
	public final static String USER = "ssafy";
	public final static String PASSWORD = "ssafy";
	public final static String TABLE = "member";

	public static Attribute<Integer> id = new Attribute<>("id");
	public static Attribute<String> member_id = new Attribute<>("member_id");
	public static Attribute<String> password = new Attribute<>("password");
	public static Attribute<String> name = new Attribute<>("name");
	public static Attribute<String> email = new Attribute<>("email");
	public static Attribute<String> address = new Attribute<>("address");

}