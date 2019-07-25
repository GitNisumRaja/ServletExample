package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="root")
public class XmlModel {

	private Department  department;

	@XmlElement(name="department")
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("XmlModle [department=");
		builder.append(department);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
