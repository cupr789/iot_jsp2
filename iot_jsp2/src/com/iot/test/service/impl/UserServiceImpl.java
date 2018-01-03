package com.iot.test.service.impl;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.iot.test.service.UserService;

public class UserServiceImpl implements UserService{

	@Override
	public HashMap<String, Object> login(HttpServletRequest req) {
		String id = req.getParameter("userId");
		System.out.println(id+"                      3333");
		String pwd = req.getParameter("userPwd");
		System.out.println(pwd+"                      3333");
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("msg", "오 로그인 성공하셨네요!");
		hm.put("login", "ok");
		if(id.equals("cupr")) {
			if(!pwd.equals("1111")) {
				hm.put("msg", "비밀번호를 확인해주세요");
				hm.put("login", "no");
			}
			else {
				HttpSession hs = req.getSession();
				hs.setAttribute("id", id);
				hs.setAttribute("pwd", pwd);
			}
		}else {
			hm.put("msg", "아이디를 확인해주세요!");
			hm.put("login", "no");
		}
		
		return hm;
	}

	@Override
	public void logout(HttpServletRequest req) {
		HttpSession hs = req.getSession();
		hs.invalidate();
		
	}

}
