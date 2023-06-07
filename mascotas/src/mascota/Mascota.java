package mascota;

import javax.swing.JOptionPane;

public class Mascota {

    private String identificacion;
    private String nombre;
    private String especie;
    private int edad;

    public Mascota() {

    }

    public Mascota(String identificacion, String nombre, String especie, int edad) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
    }
    
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setIdentifiacion(String identificacion) {
		this.identificacion = identificacion;
	}
	
	public String getIdentificacion() {
		return identificacion;
	}
	
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	
	public String getEspecie() {
		return especie;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public int getEdad() {
		return edad;
	}

    public void registrarMascota(int contador) {
        identificacion = JOptionPane.showInputDialog("Ingrese la identificacion de la mascota " + (contador+1)).toLowerCase();
        nombre = JOptionPane.showInputDialog("Ingrese el nombre de la mascota " + (contador+1)).toLowerCase();
        especie = JOptionPane.showInputDialog("Ingrese la especie de la mascota " + (contador+1)).toLowerCase();
        edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad de la mascota " + (contador+1)));
        contador++;
    }

    public String hacerSonido() {

        String sonido = "";

        if (especie.equalsIgnoreCase("perro")) {
            sonido = "¡Guau guau!";
        } else if (especie.equalsIgnoreCase("gato")) {
            sonido = "¡Miau miau!";
        } else {
            sonido = "La mascota no hace sonidos conocidos.";
        }

        return sonido;
    }

    public String saltar() {
    	
    	String mensaje = "¡" + nombre + " esta saltando!";
    	
    	return mensaje;
    }

    public String jugar () {
    	
    	String mensaje = "¡" + nombre + " esta jugando!";
    	
    	return mensaje;
    }
}