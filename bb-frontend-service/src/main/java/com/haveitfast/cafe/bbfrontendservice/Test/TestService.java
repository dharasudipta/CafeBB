package com.haveitfast.cafe.bbfrontendservice.Test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TestService {
	private static List<Test> listTest = new ArrayList();
	private static int idCounter=0;
	
	static {
		listTest.add(new Test(++idCounter,"Ram","owner"));
		listTest.add(new Test(++idCounter,"Shyam","manager"));
		listTest.add(new Test(++idCounter,"Jodu","user"));
	}
	public List<Test> findAll()
	{
		return listTest;
	}
}
