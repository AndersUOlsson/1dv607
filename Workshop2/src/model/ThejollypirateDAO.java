package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class ThejollypirateDAO {
	
	MemberList members;
	String fileLocation = "C:\\Users\\andyw\\git\\1dv607\\Workshop2\\members.xml";
	

	/**
	 * Write members list to XML 
	 * @throws IOException printStackTrace
	 */
	public void writeMembersToXml(MemberList members) throws IOException {
		
		try {

			JAXBContext context = JAXBContext.newInstance(MemberList.class);
	        Marshaller marshaller = context.createMarshaller();
	                   marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	                   
//	                   Write members to XML file.
	                   marshaller.marshal(members, new FileWriter(fileLocation));
		}
		catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Loads members list from XML.
	 * @return a list of all the members in the XML.
	 */
	public MemberList loadMembersFromXml() {
		MemberList members = null;
		
		try { 
			
			File file = new File(fileLocation);
	 
			JAXBContext jaxbContext = JAXBContext.newInstance(MemberList.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//			Read from file.
			members = (MemberList)jaxbUnmarshaller.unmarshal(file);
		}
		catch(JAXBException e) {
			e.printStackTrace();
		}
		return members;
	}
}
