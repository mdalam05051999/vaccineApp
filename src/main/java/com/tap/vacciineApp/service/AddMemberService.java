package com.tap.vacciineApp.service;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tap.vacciineApp.dao.AddMemberDAO;
import com.tap.vacciineApp.entity.AddMemberEntity;
import com.tap.vacciineApp.entity.RegisterEntity;

@Component
public class AddMemberService {
	private static final int maxAddMember = 4;
	private static final int minAddMember =0;
	
	public AddMemberService() {
		// TODO Auto-generated constructor stub
	}
	
	private AddMemberDAO addMemberDAO;
	@Autowired
	public AddMemberService(AddMemberDAO addMemberDAO) {
		super();
		this.addMemberDAO = addMemberDAO;
	}

	public boolean validateAddMember(String memberName, String gender, String dob, String idProof, String idProofNo, String vaccineType,int dose,HttpSession session)
	{
		String  email = (String) session.getAttribute("userEmail");
		boolean flag = true;
		
		if (memberName == "" || memberName.isBlank() || memberName.isEmpty()) {
			flag = false;
			System.out.println("memberName is invalid");
		}
		
		
		if (gender == "" || gender.isBlank() || gender.isEmpty()) {
			flag = false;
			System.out.println("gender is invalid");
		}
		
		
		if (dob == "" || dob.isBlank() || dob.isEmpty()) {
			flag = false;
			System.out.println("dob is invalid");
		}
		
		
		if (idProof == "" || idProof.isBlank() || idProof.isEmpty()) {
			flag = false;
			System.out.println("idProof is invalid");
		}
		
		
		if (idProofNo == "" || idProofNo.isBlank() || idProofNo.isEmpty()) {
			flag = false;
			System.out.println("idProofNo is invalid");
		}
		
		
		if (vaccineType == "" || vaccineType.isBlank() || vaccineType.isEmpty()) {
			flag = false;
			System.out.println("vaccineType is invalid");
		}
		
		
		if (dose <= 0 ) {
			flag = false;
			System.out.println("dose is invalid");
		}
		
		if (flag) {
			if (!checkEmail(email)) {
				 System.out.println("You have exceeded the maximum Add Members limit");
		            return flag = false;
			} else {
				
				//saved member
				 AddMemberEntity entity = new AddMemberEntity(memberName, gender, dob, idProof, idProofNo, vaccineType, dose, email);
				 boolean saveAddMember = addMemberDAO.saveAddMember(entity);
			        System.out.println("AddMemberEntity has been saved :"+saveAddMember);
			        
			     // Update the member count
			        RegisterEntity registerEntity = addMemberDAO.getMemeberCountByEmail(email);
			        int memberCount = registerEntity.getMemberCount();
			        addMemberDAO.updateMemberCount(email, memberCount);
			        System.out.println("you have added Member "+(memberCount));
			        
			        return saveAddMember;
			}
		}
		
		
		return flag;
	}
	
	public boolean checkEmail(String email)
	{
	    boolean flag = true;
	    RegisterEntity entity = addMemberDAO.getMemeberCountByEmail(email);
	    if (entity == null) {
	        flag = false;
	        System.out.println("Member Not Found");
	    } else {
	        int memberCount = entity.getMemberCount();
	        System.out.println(email);
	        System.out.println(memberCount);
	        if (memberCount >= maxAddMember) {
	            flag = false;
	        }
	    }
	    return flag;
		
	}
	
	public List<AddMemberEntity> getAddMemberEntities(String email)
	{
		List<AddMemberEntity> memberList = addMemberDAO.getMemberList(email);
		if (memberList.size()==0) {
			System.out.println("Member is Empty");
			return null;
		}
		return memberList;
		
	}
	
	public int deleteMemberById(int memberID,HttpSession session)
	{
		String  email = (String) session.getAttribute("userEmail");
		int count = 0;
		boolean byIDProofNo = addMemberDAO.deleteMemberByIDProofNo(memberID);
		if (byIDProofNo) {
			count = addMemberDAO.deleteMemberCount(email, minAddMember);
		}
		return count;

		
	}
	
	
	public AddMemberEntity getMemberEntityByID(int memberID)
	{
		return addMemberDAO.getMemberEntityByID(memberID);
	}
	
	
	public boolean updateAddMemberEntity(int memberID, String memberName,String gender, String dob, String idProof,String idProofNo,String vaccineType,int dose,HttpSession session) 
	{
		String  email = (String) session.getAttribute("userEmail");
		System.out.println("updateAddMemberEntity is invoked");
		AddMemberEntity entity = new AddMemberEntity(memberID, memberName, gender, dob, idProof, idProofNo, vaccineType, dose, email);
		return addMemberDAO.updateAddMemberEntity(entity);
		
	}
	
}
