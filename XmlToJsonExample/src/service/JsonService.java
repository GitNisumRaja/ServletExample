package service;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import model.Department;
import model.Person;
import model.Role;

public class JsonService {

	//Convert Java objects to JSON message using Gson
	public void writeDataToJsonfile(String filepath,List<Role> roles, List<Person> persons){
	try {
		JsonWriter writer = new JsonWriter(new FileWriter(filepath));
		writer.setIndent("    ");
		writer.beginObject();
		writer.name("roles");
		writer.beginArray();
		for(Role role:roles) {
			writer.beginObject();
			writer.name("id").value(role.getId());
			writer.name("position").value(role.getPosition());
			writer.name("salary").value(role.getSalary());
			
			
			writer.name("persons");
			writer.beginArray();
			
			for(Person person:persons) {
				if(person.getRole().equalsIgnoreCase(role.getId())) {
				writer.beginObject();
				writer.name("id").value(person.getId());
				writer.name("name").value(person.getName());
				writer.endObject();
				}
			
			}
			writer.endArray();
			writer.endObject();
		
		}
		writer.flush();
		writer.endArray();
		writer.endObject();
		writer.close();
	
	}catch(IOException ioe) {
		ioe.printStackTrace();
		System.out.println(ioe.getMessage());
	}
	
	}
	
	
	//Convert JSON message to Java objects using Gson
	public Department getDataFromJsonFile(String filePath, List<Role> roles, List<Person> persons) {
		try {
			JsonReader reader = new JsonReader(new FileReader(filePath));

			reader.beginObject();

			while (reader.hasNext()) {
				String nameRoot = reader.nextName();

				if (nameRoot.equals("roles")) {
					reader.beginArray();

					while (reader.hasNext()) {
						reader.beginObject();

						Role role = new Role();

						while (reader.hasNext()) {
							String nameRole = reader.nextName();

							if (nameRole.equals("id")) {
								role.setId(reader.nextString());
							} else if (nameRole.equals("position")) {
								role.setPosition(reader.nextString());
							} else if (nameRole.equals("salary")) {
								role.setSalary(reader.nextString());
							} else if (nameRole.equals("persons")) {
								reader.beginArray();

								while (reader.hasNext()) {
									reader.beginObject();

									Person person = new Person();

									person.setRole(role.getId());

							while (reader.hasNext()) {
								String namePerson = reader.nextName();

								if (namePerson.equals("id")) {
									person.setId(reader.nextString());
								} else if (namePerson.equals("name")) {
									person.setName(reader.nextString());
								}
							}

									persons.add(person);

									reader.endObject();
								}

								reader.endArray();
							}
						}

						roles.add(role);

						reader.endObject();
					}

					reader.endArray();
				}
			}

			reader.endObject();

			reader.close();
			
			Department department = new Department();
			department.setRoles(roles);
			department.setPersons(persons);
			return department;
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
