package Controller;

import Entity.ProgrammeAssembleur;

public class ControllerAfficherProgramme {
    ControllerEntrerProgramme controllerEntrerProgramme;
    public ControllerAfficherProgramme(ControllerEntrerProgramme controllerEntrerProgramme) {
        this.controllerEntrerProgramme = controllerEntrerProgramme;
    }

    public void afficherProgramme() {
       ProgrammeAssembleur prog = controllerEntrerProgramme.getProgrammeAssembleur();
       prog.afficherLignes();
    }
}
