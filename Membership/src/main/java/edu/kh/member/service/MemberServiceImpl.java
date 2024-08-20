package edu.kh.member.service;

import edu.kh.member.dao.MemberDao;
import edu.kh.member.dao.MemberDaoImpl;

public class MemberServiceImpl implements MemberService {

	private MemberDao dao = null;
	
	private String[] gradeArr = {"일반", "골드", "다이아"};
	
	
	// 기본 생성자
	// MemberServiceImpl 객체 생성 시
	// MemberDaoImpl 객체도 생성
	
	Public MemberserviceImpl() {
		
		dao = new MemberDaoImpl();
	}


	@Override
	public boolean addMember(String name, String phone) {
		// TODO Auto-generated method stub
		return false;
	}


	}





