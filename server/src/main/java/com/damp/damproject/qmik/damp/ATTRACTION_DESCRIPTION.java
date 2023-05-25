package com.damp.damproject.qmik.damp;

import com.qmik.model.Model;
import com.qmik.query.Attribute;

public class ATTRACTION_DESCRIPTION implements Model {

	public final static String DRIVER = "mysql";
	public final static String URL = "jdbc:mysql://localhost:3306/damp";
	public final static String USER = "ssafy";
	public final static String PASSWORD = "ssafy";
	public final static String TABLE = "attraction_description";

	public static Attribute<Integer> content_id = new Attribute<>("content_id");
	public static Attribute<String> homepage = new Attribute<>("homepage");
	public static Attribute<String> overview = new Attribute<>("overview");
	public static Attribute<String> telname = new Attribute<>("telname");

}