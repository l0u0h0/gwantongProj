package com.damp.damproject.qmik.damp;

import com.qmik.model.Model;
import com.qmik.query.Attribute;

public class GUGUN implements Model {

	public final static String DRIVER = "mysql";
	public final static String URL = "jdbc:mysql://localhost:3306/damp";
	public final static String USER = "ssafy";
	public final static String PASSWORD = "ssafy";
	public final static String TABLE = "gugun";

	public static Attribute<Integer> gugun_code = new Attribute<>("gugun_code");
	public static Attribute<String> gugun_name = new Attribute<>("gugun_name");
	public static Attribute<Integer> sido_code = new Attribute<>("sido_code");

}