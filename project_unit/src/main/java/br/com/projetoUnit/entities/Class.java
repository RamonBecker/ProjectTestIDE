package br.com.projetoUnit.entities;

public class Class {
	private String name;
	private String type;
	private String code;
	private String library;

	public Class(String name, String type) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("O nome da classe não pode ser vazio");
		}
		if (type == null || type.isEmpty()) {
			throw new IllegalArgumentException("O tipo da classe não pode ser vazio");
		}

		this.name = name;
		this.type = type;
		this.library = "";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("O nome da classe não pode ser vazio");
		}
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		if (type == null || type.isEmpty()) {
			throw new IllegalArgumentException("O tipo da classe não pode ser vazio");
		}
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		if (code == null) {
			throw new IllegalArgumentException("O código setado não pode ser nulo");
		}
		this.code = code;
	}

	public String getLibrary() {
		return library;
	}

	public void setLibrary(String library) {
		if (library.isEmpty() || library == null) {
			throw new IllegalArgumentException("A biblioteca não pode ser vazia");
		}
		this.library = library;
	}

	@Override
	public String toString() {
		return "Class [name=" + name + ", type=" + type + ", code=" + code + "]";
	}

}
