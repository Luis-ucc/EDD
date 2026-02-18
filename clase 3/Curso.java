public class Curso {
    private int ID;
    private String Ncurso;
    private String profesor;
    private int Estudiantes;
    
    public Curso(int iD, String ncurso, String profesor, int estudiantes) {
        ID = iD;
        Ncurso = ncurso;
        this.profesor = profesor;
        Estudiantes = estudiantes;
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public String getNcurso() {
        return Ncurso;
    }

    public void setNcurso(String ncurso) {
        Ncurso = ncurso;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public int getEstudiantes() {
        return Estudiantes;
    }

    public void setEstudiantes(int estudiantes) {
        Estudiantes = estudiantes;
    }

    @Override
    public String toString() {
        return "Curso [ID=" + ID + ", Ncurso=" + Ncurso + ", profesor=" + profesor + ", Estudiantes=" + Estudiantes
                + "]";
    }

    
}
