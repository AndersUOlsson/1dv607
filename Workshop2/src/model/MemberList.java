package model;

//
//
//  The member list is here for marshalling purposes.
//
//

import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "members")
public class MemberList {
	
	public MemberList() {
	}
	
	@XmlElement(name = "member")
	private List<Member> members = null;
	
	
	public Iterator<Member> getMemberIterator() {
		return members.iterator();
	}
	
	public Member getSpecificMember(int memberId) {
		for (Member m : members) {
			if (m.getMemberID() == memberId) {
				return m;
			}
		}
		return null;
	}
	
	public void setMembers(List<Member> members) {
		this.members = members;
	}
	
	public void deleteMember(int numberIDtoDelete) {
		
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).getMemberID() == numberIDtoDelete) {
				members.remove(i);
			}
		}
		
	}
	
	public void addMember(Member member) {
		members.add(member);
	}
	
	
	public void updateName(int id, String name) {
		
		for (Member m : members) {
			if (m.getMemberID() == id) {
				m.setName(name);
			}
		}
	}
	
	public void updatePersonalNumber(int id, String number) {
		for (Member m : members) {
			if (m.getMemberID() == id) {
				m.setPersonalNumber(number);
			}
		}
	}
}
