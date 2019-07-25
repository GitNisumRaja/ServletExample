package service;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import model.Department;
import model.Person;
import model.Role;
import model.XmlModel;

public class XmlToJsonService {

	public static void main(String[] args) {
		
		XmlService xmlService  = new XmlService();
		
			//xml to java
			XmlModel  xmlModel = xmlService.getObjectFromXmlFile("src/data/input/sample.xml");
			Department department = xmlModel.getDepartment();
			List<Role> roles = department.getRoles();
			List<Person> persons = department.getPersons();
			
			System.out.println(xmlModel);
			
			// java to xml
/*			XmlModel xmlModelj = new XmlModel();
			List<Role> roleList = new ArrayList<>();
			Role rolehead = new Role();
			rolehead.setId("1");rolehead.setPosition("head");rolehead.setSalary("20k");
			Role rolemanage = new Role();
			rolemanage.setId("2"); rolemanage.setPosition("manager");rolemanage.setSalary("18k");
			Role roleemp = new Role();
			roleemp.setId("3");roleemp.setPosition("employee");roleemp.setSalary("15k");

			roleList.add(rolehead);roleList.add(rolemanage);roleList.add(roleemp);
			
			List<Person> personList = new ArrayList<>();
			Person green = new Person("1","green",rolehead.getId());
			Person yellow = new Person("2","yellow",rolemanage.getId());
			Person blue  = new Person("3","blue",rolemanage.getId());
			Person white = new Person("4","white",roleemp.getId());
			Person black = new Person("5","black",roleemp.getId());
			
			personList.add(green);personList.add(white);personList.add(blue);personList.add(yellow);personList.add(black);
			
			Department departmentj = new Department();
			departmentj.setRoles(roleList);
			departmentj.setPersons(personList);

			xmlModelj.setDepartment(departmentj);

			xmlService.parseObjectToXml("src/data/input/samplexml.xml", xmlModelj);
			*/
		
			///Json conversion 
			
			JsonService jsonService = new JsonService();
			
			//java to Json file
			//jsonService.writeDataToJsonfile("src/data/input/samplejson.json", roles, persons);
			
			//get data from json file
			List<Role> rolesList = new ArrayList<>();
			List<Person> personsList = new ArrayList<>();
			Department json_department = jsonService.getDataFromJsonFile("src/data/input/sample.json", rolesList, personsList);
			System.out.println(json_department);
			
		
	}
}
