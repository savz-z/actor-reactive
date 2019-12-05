package com.lightbend.model;

public class BaseTC {
	
	private int dep;
	private int subdep;
	private String depDesc;
	private String subdepDesc;
	public int getDep() {
		return dep;
	}
	public void setDep(int dep) {
		this.dep = dep;
	}
	public int getSubdep() {
		return subdep;
	}
	public void setSubdep(int subdep) {
		this.subdep = subdep;
	}
	public String getDepDesc() {
		return depDesc;
	}
	public void setDepDesc(String depDesc) {
		this.depDesc = depDesc;
	}
	public String getSubdepDesc() {
		return subdepDesc;
	}
	public void setSubdepDesc(String subdepDesc) {
		this.subdepDesc = subdepDesc;
	}

}
