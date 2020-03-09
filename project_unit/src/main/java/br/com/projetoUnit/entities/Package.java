package br.com.projetoUnit.entities;

import java.util.ArrayList;
import java.util.List;

public class Package {
	private String name;
	private List<Class> listClass;

	public Package(String name) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("O nome do pacote não pode ser vazio");
		}
		this.name = name;
	}

	public Package(String name, List<Class> listClass) {

		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("O nome do pacote não pdoe ser vazio");
		}

		if (listClass == null) {
			throw new IllegalArgumentException("A lista de classe não pode ser vazia");
		}

		this.name = name;
		this.listClass = listClass;;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("O nome do pacote não pdoe ser vazio");
		}
		this.name = name;
	}

	public List<Class> getListClass() {
		if (this.listClass == null) {
			this.listClass = new ArrayList<>();
		}
		return listClass;
	}

	public void setListClass(List<Class> listClass) {
		if (listClass == null) {
			throw new IllegalArgumentException("A lista de classe não pode ser vazia");
		}
		this.listClass = listClass;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listClass == null) ? 0 : listClass.hashCode());
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
		Package other = (Package) obj;
		if (listClass == null) {
			if (other.listClass != null)
				return false;
		} else if (!listClass.equals(other.listClass))
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
		return "Package [name=" + name + ", listClass=" + listClass + "]";
	}

}
