package project_unit.project_unit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import br.com.projetoUnit.entities.ControllerProject;

class TestProject {

	@Test
	void checkVersionJDKProject() {
		ControllerProject controllerProject = new ControllerProject();

		controllerProject.addProjeto();

		assertEquals(controllerProject.checkJDKVersion(), true);

	}

}
