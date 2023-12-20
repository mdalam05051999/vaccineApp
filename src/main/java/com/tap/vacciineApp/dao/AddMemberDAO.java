package com.tap.vacciineApp.dao;

import java.util.List;


import com.tap.vacciineApp.entity.AddMemberEntity;
import com.tap.vacciineApp.entity.RegisterEntity;

public interface AddMemberDAO {
	boolean saveAddMember(AddMemberEntity addMemberEntity);
	RegisterEntity getMemeberCountByEmail(String email);
	int updateMemberCount(String email,int countMember);
	
	boolean deleteMemberByIDProofNo(int memberID);
	int deleteMemberCount(String email,int countMember);
	
	
	AddMemberEntity getMemberEntityByID(int memberID);
	boolean updateAddMemberEntity(AddMemberEntity entity);
	
	List<AddMemberEntity> getMemberList(String email);
}
