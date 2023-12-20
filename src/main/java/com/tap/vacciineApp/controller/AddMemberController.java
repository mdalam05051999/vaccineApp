package com.tap.vacciineApp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.tap.vacciineApp.entity.AddMemberEntity;

import com.tap.vacciineApp.service.AddMemberService;

@Controller
public class AddMemberController {

	public AddMemberController() {
		// TODO Auto-generated constructor stub
	}
	
	private AddMemberService addMemberService;
	@Autowired
	public AddMemberController(AddMemberService addMemberService) {
		super();
		this.addMemberService = addMemberService;
	}

	@RequestMapping(value = "/addMember")
	public String gotoAddMember()
	{
		System.out.println("gotoAddMember is invoked");
		return "/WEB-INF/AddMember.jsp";
	}
	
	@RequestMapping(value = "/saveAddMember")
	public String saveAddMember(
			@RequestParam String memberName,
			@RequestParam String gender,
			@RequestParam String dob,
			@RequestParam String idProof,
			@RequestParam String idProofNo,
			@RequestParam String vaccineType,
			@RequestParam int dose,
			Model model,
			HttpSession session
			)
	{
		System.out.println("saveAddMember is invoked");
		System.err.println("memberName "+memberName);
		System.err.println("gender "+gender);
		System.err.println("dob "+dob);
		System.err.println("idProof "+idProof);
		System.err.println("idProofNo "+idProofNo);
		System.err.println("vaccineType "+vaccineType);
		System.err.println("dose "+dose);
		
		boolean validateAddMember = addMemberService.validateAddMember(memberName, gender, dob, idProof, idProofNo, vaccineType, dose,session);
		 if (validateAddMember) {
			 model.addAttribute("yes", "Member Added");
		} else {
			 model.addAttribute("no", "You have exceeded the maximum Add Members limit! You can't add more than 4 memeber");
		}
		 return "/WEB-INF/AddMember.jsp";
	}
	
	
	
	//-----------------------Get ALl Member-------------------------//
	@RequestMapping(value = "/getAllMember")
	public String getAllMember(Model model,HttpSession session)
	{
		String email = (String) session.getAttribute("userEmail");
		System.out.println("getAllMember is invoked");
		List<AddMemberEntity> addMemberEntities = addMemberService.getAddMemberEntities(email);
		if (addMemberEntities != null && !addMemberEntities.isEmpty()) {
			model.addAttribute("allMember", addMemberEntities);
		} else {
			model.addAttribute("no","AddMemberList is Empty Please Add Member");
		}
		return "/WEB-INF/AddMember.jsp";
		
	}
	
	
	//-----------------------Delete Member By MemberID-------------------------//
	@RequestMapping(value = "/deleteMemberByIdProof/{memberID}")
	public String deleteAirportById(@PathVariable int memberID,Model model,HttpSession session)
	{
		System.out.println("deleteAirportById invoked");
		int deleteMemberById = addMemberService.deleteMemberById(memberID,session);
		if (deleteMemberById>0) {
			model.addAttribute("yes", "Member has been Deleted");
		}
		else {
			model.addAttribute("no", "Member has not been Deleted");
		}
		return "/WEB-INF/AddMember.jsp";
		
	}
	
	
	//-----------------------Update Member By MemberID-------------------------//
	
	@RequestMapping(value = "/editMember/{memberID}")
	public String updateMemberById(@PathVariable int memberID,Model model)
	{
		System.out.println("updateMemberById invoked" +memberID);
		
		AddMemberEntity entity = addMemberService.getMemberEntityByID(memberID);
		model.addAttribute("NAME", entity.getMemberName());
		model.addAttribute("GENDER", entity.getMemberGender());
		model.addAttribute("DOB", entity.getMemberDOB());
		model.addAttribute("IDPROOF", entity.getMemberIdProof());
		model.addAttribute("IDPROOFNO", entity.getMemberIdProofNo());
		model.addAttribute("VACCINETYPE", entity.getMemberIVaccineType());
		model.addAttribute("DOSE", entity.getMemberDose());
		
		
		return "/WEB-INF/EditAddMember.jsp";
	}
	
	@RequestMapping( value = "/updateMember/{memberID}")
	public String updateMember(
			@PathVariable int memberID,
			@RequestParam String memberName,
			@RequestParam String gender,
			@RequestParam String dob,
			@RequestParam String idProof,
			@RequestParam String idProofNo,
			@RequestParam String vaccineType,
			@RequestParam int dose,
			Model model,
			HttpSession session
			)
	{
		System.out.println("invoked updateMember");
		boolean updateAddMemberEntity = addMemberService.updateAddMemberEntity(memberID, memberName, gender, dob, idProof, idProofNo, vaccineType, dose, session);
		if (updateAddMemberEntity) {
			model.addAttribute("yes", "Member has been Updated");
		} else {
			model.addAttribute("no", "Member has not been Updated");
		}
		return"/WEB-INF/AddMember.jsp";
		
		
	}
	
	
}
