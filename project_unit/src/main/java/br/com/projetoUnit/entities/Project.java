package br.com.projetoUnit.entities;

import java.util.ArrayList;
import java.util.List;

public class Project {
	private String name;
	private int jdkVersion;
	private List<Package> listPackage;

	public Project(String name, int jdkVersion) {

		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("O nome do projeto não pode ser vazio");
		}

		this.name = name;
		this.jdkVersion = jdkVersion;
	}

	public Project(String name, int jdkVersion, List<Package> listPackage) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("O nome do projeto não pode ser vazio");
		}

		if (listPackage == null) {
			throw new IllegalArgumentException("A lista de pacote não pode ser vazia");
		}

		this.name = name;
		this.jdkVersion = jdkVersion;
		this.listPackage = listPackage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("O nome do projeto não pode ser vazio");
		}
		this.name = name;
	}

	public int getJdkVersion() {
		return jdkVersion;
	}

	public void setJdkVersion(int jdkVersion) {

		this.jdkVersion = jdkVersion;
	}

	public List<Package> getListPackage() {
		if (this.listPackage == null) {
			this.listPackage = new ArrayList<>();
		}
		return listPackage;
	}

	public void setListPackage(List<Package> listPackage) {
		if (listPackage == null) {
			throw new IllegalArgumentException("A lista de pacote não pode ser vazia");
		}
		this.listPackage = listPackage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + jdkVersion;
		result = prime * result + ((listPackage == null) ? 0 : listPackage.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Project other = (Project) obj;
		if (jdkVersion != other.jdkVersion)
			return false;
		if (listPackage == null) {
			if (other.listPackage != null)
				return false;
		} else if (!listPackage.equals(other.listPackage))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Project [name=" + name + ", jdkVersion=" + jdkVersion + ", listPackage=" + listPackage + "]";
	}

}
