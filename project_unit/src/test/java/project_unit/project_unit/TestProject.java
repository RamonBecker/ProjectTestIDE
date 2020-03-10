package project_unit.project_unit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import br.com.projetoUnit.entities.ControllerProject;
import br.com.projetoUnit.exception.CompileCode;

class TestProject {
	private static ControllerProject controllerProject = new ControllerProject();

	@BeforeAll
	
	static void contrutor() {
		// controllerProject.addProjeto();
		controllerProject.addProjetoPredefined();
		
	}

	@Test
	@Disabled
	void checkVersionJDKProject() {

		assertEquals(controllerProject.checkJDKVersion(), true);

	}

	@Test
	@Disabled
	void checkMainClass() {
		assertNotEquals(controllerProject.checkMainClass(), false);
	}

	@Test
	@Disabled
	void editJDKProject() {
		assertNull(controllerProject.editJDKProject());
	}

	@Test
	void compileCode() {
		assertThrows(CompileCode.class, () -> {
			controllerProject.compileCode();
		});
	}
	
	@BeforeEach
	void initCheckLibraryProject() {
		assertEquals(controllerProject.checkLibraryProject(), true);
	}
	
}
