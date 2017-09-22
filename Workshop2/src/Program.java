


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


import model.Member;
import model.MemberDAO;

public class Program {

	public static void main(String[] args) throws IOException {
		
		MemberDAO members = new MemberDAO();
		members.setMembers(new ArrayList<Member>());
		
		Member member1 = new Member("Anders", 29);
		Member member2 = new Member("Therezia", 32);
		
		members.getMembers().add(member1);
		members.getMembers().add(member2);
		
		
		try {
			String file = "C:\\Users\\andyw\\git\\1dv607\\Workshop2\\src\\members.xml";
			
			
			JAXBContext context = JAXBContext.newInstance(MemberDAO.class);
	        Marshaller marshaller = context.createMarshaller();
	                   marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	                   marshaller.marshal(members, new FileWriter(file));
			
			
			
			//Write to console
	                   marshaller.marshal(members, System.out);
		}
		catch (JAXBException e) {
			e.printStackTrace();
		}
		
	}
}
