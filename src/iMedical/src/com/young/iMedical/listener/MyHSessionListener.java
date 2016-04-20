package com.young.iMedical.listener;

import java.util.LinkedHashMap;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.young.iMedical.domain.Medicine;

public class MyHSessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		se.getSession().setAttribute("medMap",
				new LinkedHashMap<Medicine, Integer>());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
	}

}
