package com.damp.damproject.qmik.dampsecure;

import com.qmik.model.Model;
import com.qmik.query.Attribute;

public class MEMBER_SECURE implements Model {

	public final static String DRIVER = "postgresql";
	public final static String URL = "jdbc:postgresql://localhost:5432/damp";
	public final static String USER = "ssafy";
	public final static String PASSWORD = "ssafy";
	public final static String TABLE = "member_secure";

	public static Attribute<String> member_id = new Attribute<>("member_id");
	public static Attribute<String> salt = new Attribute<>("salt");

}