package com.edp.hbm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STATUS")
public class Status {
	
	private int id;
	private StatusName statusName;
	
	public Status(){
		
	}
	
	public Status(StatusName statusName){
		this.id = statusName.getValue();
		this.statusName = statusName;
	}
	
	@Id
	@Column(name = "ID", unique = true, nullable = false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "STATUS")
	public StatusName getStatusName() {
		return statusName;
	}
	public void setStatusName(StatusName statusName) {
		this.statusName = statusName;
	}
	
	@Override
	public String toString() {
		StringBuffer strBuff = new StringBuffer();
		strBuff.append("id : ").append(id);
		strBuff.append(", status name: ").append(statusName);
		return strBuff.toString();
	}
	
	@Override
	public int hashCode() {
	    return id;
	}

	@Override
	public boolean equals(final Object obj) {
	    if (obj instanceof Status) {
	        Status item = (Status) obj;
	        return item.getId()==getId();
	    }
	    return false;
	}

}
