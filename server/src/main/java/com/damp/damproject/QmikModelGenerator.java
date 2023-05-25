package com.damp.damproject;

import java.io.IOException;

import com.qmik.model.ModelGenerator;

public class QmikModelGenerator {
	
	public static void main(String[] args) {
		try {
			ModelGenerator.generate(QmikModelGenerator.class.getPackageName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
