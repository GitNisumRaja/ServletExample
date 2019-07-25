package service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import model.XmlModel;

public class XmlService {
	//Convert XML message to Java objects using JAXB
	public XmlModel getObjectFromXmlFile(String filepath)  {
		try {
		File file = new File(filepath);
		JAXBContext jaxbContext = JAXBContext.newInstance(XmlModel.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		XmlModel xmlModel = (XmlModel) unmarshaller.unmarshal(file);
		
		return xmlModel;
		}catch(JAXBException jax) {
			jax.printStackTrace();
			return null;
		}
	}
	//Convert Java objects to XML message using JAXB
	public void parseObjectToXml(String filePath, XmlModel xmlModel) {
		try {
			JAXBContext contextObj = JAXBContext.newInstance(XmlModel.class);

			Marshaller marshallerObj = contextObj.createMarshaller();
			marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			marshallerObj.marshal(xmlModel, new FileOutputStream(filePath));
		} catch (JAXBException je) {
			System.out.println("JAXBException");
		} catch (IOException ie) {
			System.out.println("IOException");
		}
	}

}
