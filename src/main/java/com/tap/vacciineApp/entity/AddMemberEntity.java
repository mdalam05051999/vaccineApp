package com.tap.vacciineApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "add_member")
public class AddMemberEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MEMBER_ID")
	private int memberID;
	
	@Column(name = "MEMBER_NAME")
	private String memberName;
	
	@Column(name = "MEMBER_GENDER")
	private String memberGender;
	
	@Column(name = "MEMBER_DOB")
	private String memberDOB;
	
	@Column(name = "MEMBER_IDPROOF")
	private String memberIdProof;
	
	@Column(name = "MEMBER_IDPROOF_NO")
	private String memberIdProofNo;
	
	@Column(name = "MEMBER_VACCINETYPE")
	private String memberIVaccineType;
	
	@Column(name = "MEMBER_DOSE")
	private int memberDose;
	
	@Column(name = "USER_EMAIL")
	private String email;
	
	
	public AddMemberEntity() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	public AddMemberEntity(int memberID, String memberName, String memberGender, String memberDOB, String memberIdProof,
			String memberIdProofNo, String memberIVaccineType, int memberDose, String email) {
		super();
		this.memberID = memberID;
		this.memberName = memberName;
		this.memberGender = memberGender;
		this.memberDOB = memberDOB;
		this.memberIdProof = memberIdProof;
		this.memberIdProofNo = memberIdProofNo;
		this.memberIVaccineType = memberIVaccineType;
		this.memberDose = memberDose;
		this.email = email;
	}





	public AddMemberEntity(String memberName, String memberGender, String memberDOB, String memberIdProof,
			String memberIdProofNo, String memberIVaccineType, int memberDose, String email) {
		super();
		this.memberName = memberName;
		this.memberGender = memberGender;
		this.memberDOB = memberDOB;
		this.memberIdProof = memberIdProof;
		this.memberIdProofNo = memberIdProofNo;
		this.memberIVaccineType = memberIVaccineType;
		this.memberDose = memberDose;
		this.email = email;
	}





	public AddMemberEntity(String memberName, String memberGender, String memberDOB, String memberIdProof,
			String memberIdProofNo, String memberIVaccineType, int memberDose) {
		super();
		this.memberName = memberName;
		this.memberGender = memberGender;
		this.memberDOB = memberDOB;
		this.memberIdProof = memberIdProof;
		this.memberIdProofNo = memberIdProofNo;
		this.memberIVaccineType = memberIVaccineType;
		this.memberDose = memberDose;
	}
	public int getMemberID() {
		return memberID;
	}
	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberGender() {
		return memberGender;
	}
	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}
	public String getMemberDOB() {
		return memberDOB;
	}
	public void setMemberDOB(String memberDOB) {
		this.memberDOB = memberDOB;
	}
	public String getMemberIdProof() {
		return memberIdProof;
	}
	public void setMemberIdProof(String memberIdProof) {
		this.memberIdProof = memberIdProof;
	}
	public String getMemberIdProofNo() {
		return memberIdProofNo;
	}
	public void setMemberIdProofNo(String memberIdProofNo) {
		this.memberIdProofNo = memberIdProofNo;
	}
	public String getMemberIVaccineType() {
		return memberIVaccineType;
	}
	public void setMemberIVaccineType(String memberIVaccineType) {
		this.memberIVaccineType = memberIVaccineType;
	}
	public int getMemberDose() {
		return memberDose;
	}
	public void setMemberDose(int memberDose) {
		this.memberDose = memberDose;
	}
	@Override
	public String toString() {
		return "AddMemberEntity [memberID=" + memberID + ", memberName=" + memberName + ", memberGender=" + memberGender
				+ ", memberDOB=" + memberDOB + ", memberIdProof=" + memberIdProof + ", memberIdProofNo="
				+ memberIdProofNo + ", memberIVaccineType=" + memberIVaccineType + ", memberDose=" + memberDose
				+ "]";
	}
	
	

}
