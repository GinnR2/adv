package ua.lviv.lgs.domain;

public class User {
	private Integer id;
	private String email;
	private String name;
	private String surname;
	private String group;
	private String password;

	public User(String email, String name, String surname, String group, String password) {

		this.email = email;
		this.name = name;
		this.surname = surname;
		this.group = group;
		this.password = password;
	}

	public User(Integer id, String email, String name, String surname, String group, String password) {

		this.id = id;
		this.email = email;
		this.name = name;
		this.surname = surname;
		this.group = group;
		this.password = password;
	}
	
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", name=" + name + ", surname=" + surname + ", group=" + group
				+ "]";
	}

}
