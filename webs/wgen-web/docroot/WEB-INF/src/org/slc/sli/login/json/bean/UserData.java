package org.slc.sli.login.json.bean;

import java.io.Serializable;
import java.util.List;

/**
 * UserData.java
 * 
 * Purpose: the user json object retreived from the session chek api is
 * converted to userdata bean
 * 
 * @author
 * @version 1.0
 */

public class UserData implements Serializable {

	public List<Role> getAll_roles() {
		return all_roles;
	}

	public void setAll_roles(List<Role> all_roles) {
		this.all_roles = all_roles;
	}

	private List<Role> all_roles;

	private boolean authenticated;

	public boolean isAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	private String full_name;

	private String user_id;

	private String[] granted_authorities;

	public String[] getGranted_authorities() {
		return granted_authorities;
	}

	public void setGranted_authorities(String[] granted_authorities) {
		this.granted_authorities = granted_authorities;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public static class Role {
		private String name;
		private String id;
		private String[] rights;
		private String springRoleName;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String[] getRights() {
			return rights;
		}

		public void setRights(String[] rights) {
			this.rights = rights;
		}

		public String getSpringRoleName() {
			return springRoleName;
		}

		public void setSpringRoleName(String springRoleName) {
			this.springRoleName = springRoleName;
		}
	}
}
