package br.com.projetoUnit.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import br.com.projetoUnit.exception.CompileCode;

public class ControllerProject {

	private List<Project> listProject;

	public ControllerProject() {
		listProject = new ArrayList<Project>();
	}

	public void addProjetoPredefined() {

		// Add project 1
		Project project1 = new Project("Projeto de teste 1", 0);

		// Add project 2
		Project project2 = new Project("Projeto de teste 2", 8);

		Package package2 = new Package("Pacote de teste 2");

		Class class2 = new Class("Classe de teste 2", "public");

		class2.setCode("public static void main(String[] args) System.out.println(\"Hello Word\")");

		package2.getListClass().add(class2);

		project2.getListPackage().add(package2);

		this.listProject.add(project1);
		this.listProject.add(project2);
	}

	public void addProjeto() {

		System.out.println("-------------- Cadastro de projeto --------------");

		Scanner scanner = new Scanner(System.in);

		System.out.println("Digite o nome do projeto:");

		String name = scanner.next().trim();

		System.out.println("Digite a versão da JDK:");

		int jdkVersion = scanner.nextInt();

		Project project = new Project(name, jdkVersion);

		System.out.println("-------------- Cadastro de pacote --------------");

		System.out.println("Digite o nome do pacote");

		String namePackage = scanner.next().trim();

		Package package1 = new Package(namePackage);

		System.out.println("-------------- Cadastro de classe --------------");

		System.out.println("Digite nome da classe:");

		String nameClass = scanner.next().trim();

		System.out.println("Digite o tipo da classe: public / private / abstract");

		String type = scanner.next().trim();

		Class class1 = new Class(nameClass, type);

		System.out.println("Deseja iniciar a classe com main ? - sim /nao");

		String option = scanner.next().trim();

		if (option.equalsIgnoreCase("sim")) {
			class1.setCode("public static void main(String[] args)");
		} else {
			class1.setCode("");
		}

		package1.getListClass().add(class1);

		project.getListPackage().add(package1);

		this.listProject.add(project);

	}

	public boolean checkMainClass() {
		System.out.println("-------------- Verificação se a classe possui um main ----------");

		Class class1 = searchClass();

		if (!class1.getCode().contains("public static void main(String[] args)")) {
			return true;
		} else if (class1.getCode() == null) {
			return true;
		}

		return false;
	}

	public Project searchProjects() {

		System.out.println("----------- listando projeto -----------\n");
		for (int i = 0; i < listProject.size(); i++) {
			System.out.println("Index:" + i + " project:" + listProject.get(i).getName());
		}

		Scanner scanner = new Scanner(System.in);
		System.out.println("\nSelect the project:");
		int index = scanner.nextInt();

		Project project = listProject.get(index);

		return project;
	}

	public Package searchPackage() {
		Project project = searchProjects();

		System.out.println("----------- listando pacote -----------\n");
		for (int i = 0; i < project.getListPackage().size(); i++) {
			System.out.println("Index:" + i + " package:" + project.getListPackage().get(i).getName());
		}

		Scanner scanner = new Scanner(System.in);
		System.out.println("Select the package: ");

		int index = scanner.nextInt();

		Package package1 = project.getListPackage().get(index);

		return package1;
	}

	public Class searchClass() {

		System.out.println("----------- listando classe -----------\n");

		Package package1 = searchPackage();

		for (int i = 0; i < package1.getListClass().size(); i++) {
			System.out.println("Index:" + i + " class:" + package1.getListClass().get(i));

		}
		Scanner scanner = new Scanner(System.in);

		System.out.println("Select the class:");
		int index = scanner.nextInt();
		Class class1 = package1.getListClass().get(index);

		return class1;
	}

	public List<Project> getListProject() {

		if (listProject == null) {
			listProject = new ArrayList<Project>();
		}
		return listProject;
	}

	public void setListProject(List<Project> listProject) {

		if (listProject == null) {
			throw new IllegalArgumentException("A lista de projetos não pode ser setada nula");
		}
		this.listProject = listProject;
	}

	public boolean checkJDKVersion() {

		System.out.println("Verificação de JDK de projetos");

		System.out.println("--------------------------");
		for (Project project : listProject) {
			if (project.getJdkVersion() < 8) {
				System.err.println("Este projeto precisa atualizar a JDK");
				return false;
			}
		}

		System.out.println("Projeto possui JDK 8 ou posterior");
		return true;
	}

	public Object editJDKProject() {

		System.out.println("----------- Redefinição de JDK -----------");

		Project project = searchProjects();

		System.out.println("Digite a nova versão da JDK:");

		Scanner scanner = new Scanner(System.in);

		int newJDK = scanner.nextInt();

		if (newJDK < 0) {
			return null;
		}

		project.setJdkVersion(newJDK);

		return true;
	}

	public void compileCode() {

		System.out.println(" ----------- Realizando a compilação da classe ----------- ");

		Class classSearch = searchClass();

		if (!classSearch.getLibrary().contains("java.io.PrintStream ")) {
			throw new CompileCode("Erro: esta faltando adicionar a biblioteca java.io.PrintStream");
		}

		if (!classSearch.getCode().contains(";")) {
			throw new CompileCode("Erro: esta faltando ponto e vírgula");
		}

		System.out.println("Hello Word");

	}

	public boolean checkLibraryProject() {
		System.out.println("-------------- verificando bibliotecas nos projetos");

		for (Project project : listProject) {

			System.out.println("-------- Project -------");
			System.out.println("Name project:" + project.getName());
			System.out.println("JDK:" + project.getJdkVersion());

			if (project.getListPackage() != null) {

				for (Package package1 : project.getListPackage()) {

					System.out.println("\t -------- Package --------");
					System.out.println("\t Name:" + package1.getName());

					if (package1.getListClass() != null) {
						for (Class class1 : package1.getListClass()) {

							System.out.println("\t\t -------- Class --------");
							System.out.println("\t\t Name:" + class1.getName());
							System.out.println("\t\t Type:" + class1.getType());
							System.out.println("\t\t Library:" + class1.getType());

							if (class1.getLibrary().isEmpty()) {
								System.out.println(
										" \t\tEssa classe precisa adicionar a biblioteca java.io.PrintStream para utilizar o System.out.println()");
								return true;
							}
						}
					}

				}

			}
		}
		return false;
	}

}
