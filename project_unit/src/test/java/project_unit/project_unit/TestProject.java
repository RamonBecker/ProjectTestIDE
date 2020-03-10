package project_unit.project_unit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
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

	@BeforeEach
	void checkVersionJDKProject() {

		assertEquals(controllerProject.checkJDKVersion(), false);

	}

	@Test
	@Disabled
	void checkMainClass() {
		assertNotEquals(controllerProject.checkMainClass(), false);
	}

	@Test
	void editJDKProject() {
		assertNull(controllerProject.editJDKProject());
	}
//
//	@Test
//	void compileCode() {
//		assertThrows(CompileCode.class, () -> {
//			controllerProject.compileCode();
//		});
//	}

	@BeforeEach
	void initCheckLibraryProject() {
		controllerProject.checkLibraryProject();
		
	}

	@AfterEach
	void retesteCompileCode() {
		controllerProject.setLibrary();
		assertThrows(CompileCode.class, () -> {
			controllerProject.compileCode();
		});
	}

}
