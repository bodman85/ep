package com.edp.hbm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ROLE")
public class Role {
	
	private int id;
	
	private RoleName roleName;
	
	public Role(){
	}
	
	public Role(RoleName roleName){
		this.id = roleName.getValue();
		this.roleName = roleName;
	}
	
	@Id
	@Column(name = "ID", unique = true, nullable = false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "ROLE_NAME")
	public RoleName getRoleName() {
		return roleName;
	}
	public void setRoleName(RoleName roleName) {
		this.roleName = roleName;
	}
	
	@Override
	public String toString() {
		StringBuffer strBuff = new StringBuffer();
		strBuff.append("id : ").append(id);
		strBuff.append(", role name : ").append(roleName);
		return strBuff.toString();
	}
	
	@Override
	public int hashCode() {
	    return id;
	}

	@Override
	public boolean equals(final Object obj) {
	    if (obj instanceof Role) {
	        Role item = (Role) obj;
	        return item.getId()==getId();
	    }
	    return false;
	}

}
