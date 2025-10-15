package com.dao;

import java.util.List;

import com.pojos.*;

public interface MemberDao {

	int saveMember(MemberPojo  emp);
	int  updateMember(MemberPojo emp);
	int deleteMember(MemberPojo emp);
	

	List<MemberPojo> getMembers();
	MemberPojo getMembersByContactNumber(String contact);




	
	
	
	
}