package com.haveitfast.cafe.bbuserservice.User;

public class User {
		private long id;
		private String fullName;
		private String mobile;
		private String username;
		private String password;
		private String role;
		
		protected User() {}
		
		public User(long id, String fullName, String mobile, String username, String password, String role) {
			super();
			this.id = id;
			this.fullName = fullName;
			this.mobile = mobile;
			this.username = username;
			this.password = password;
			this.role = role;
		}
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getFullName() {
			return fullName;
		}
		public void setFullName(String fullName) {
			this.fullName = fullName;
		}
		public String getMobile() {
			return mobile;
		}
		public void setMobile(String mobile) {
			this.mobile = mobile;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + (int) (id ^ (id >>> 32));
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
			if (id != other.id)
				return false;
			return true;
		}
		
		
}
