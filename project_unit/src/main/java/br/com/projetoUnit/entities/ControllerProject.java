package br.com.projetoUnit.entities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ControllerProject {

	private List<Project> listProject;

	public ControllerProject() {
		listProject = new ArrayList<Project>();
	}

	public Object addProjeto(String name, int jdkVersion) {
		Project project = new Project(name, jdkVersion);
		listProject.add(project);
		return true;
	}

	public Object addPackage(String name) {
		Package pacote = new Package(name);
		listProject.get(0).getListPackage().add(pacote);
		return true;
	}

	public Object addClass(String name, String type) {
		Class class1 = new Class(name, type);

		listProject.get(0).getListPackage().get(0).getListClass().add(class1);

		return true;
	}

	public Project searchProjects() {

		for (int i = 0; i < listProject.size(); i++) {
			System.out.println("Index:" + i + " project:" + listProject.get(i).getName());
		}

		Scanner scanner = new Scanner(System.in);
		System.out.println("Select the project:");
		int index = scanner.nextInt();

		Project project = listProject.get(index);
		// scanner.close();

		return project;
	}

	public Package searchPackage() {
		Project project = searchProjects();

		for (int i = 0; i < project.getListPackage().size(); i++) {
			System.out.println("Index:" + i + " package:" + project.getListPackage().get(i).getName());
		}

		Scanner scanner = new Scanner(System.in);
		System.out.println("Select the package: ");
		int index = scanner.nextInt();
		Package package1 = project.getListPackage().get(index);
		// scanner.close();

		return package1;
	}

	public Class searchClass() {

		Package package1 = searchPackage();

		for (int i = 0; i < package1.getListClass().size(); i++) {
			System.out.println("Index:" + i + " class:" + package1.getListClass().get(i));

		}
		Scanner scanner = new Scanner(System.in);

		System.out.println("Select the class:");
		int index = scanner.nextInt();
		Class class1 = package1.getListClass().get(index);
		// scanner.close();

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

	public static void main(String[] args) {
		Project project = new Project("Projeto", 13);

		Package package1 = new Package("Pacote");

		Class class1 = new Class("Classe", "Public");

		package1.getListClass().add(class1);

		project.getListPackage().add(package1);

		ControllerProject controllerProject = new ControllerProject();
		controllerProject.getListProject().add(project);

		// System.out.println("------------ projeto");
		// System.out.println(controllerProject.searchProjects());

		// System.out.println("------------ pacote");
		// System.out.println(controllerProject.searchPackage());

		System.out.println(controllerProject.searchClass());

	}

	public boolean checkJDKVersion() {

		System.out.println("Verificação de JDK de projetos");

		System.out.println("--------------------------");
		for (Project project : listProject) {
			if (project.getJdkVersion() < 8) {
				System.out.println("Este projeto precisa atualizar a JDK");
				return false;
			}
		}
		return true;
	}
}
