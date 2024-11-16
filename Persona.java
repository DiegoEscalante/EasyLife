public abstract class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private String sexo;
    private Direccion direccion;

    public Persona(int id, String nombre, String apellido, int edad, String sexo, Direccion direccion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sexo = sexo;
        this.direccion = direccion;
    }
    
    public Persona(int id, String nombre, String apellido, String sexo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Direccion getDireccion() {
        return direccion;

    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getFullName(){
        return this.nombre + " " + this.apellido;
    }

}
