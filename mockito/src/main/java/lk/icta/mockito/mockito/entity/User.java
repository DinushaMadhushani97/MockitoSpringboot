package lk.icta.mockito.mockito.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "`user`")
public class User {
			
		@Id
		@GeneratedValue
		private int id;
		private String name;
		private String role;
		public User(int id, String name, String role) {
			
			this.id = id;
			this.name = name;
			this.role = role;
		}
		public User() {
			
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		
		

	}