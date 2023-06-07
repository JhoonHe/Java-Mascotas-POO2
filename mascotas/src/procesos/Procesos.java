package procesos;

import mascota.Mascota;

import java.util.HashMap;

import javax.swing.JOptionPane;

public class Procesos {

	HashMap<String, Mascota> mapaMascotas = new HashMap<String, Mascota>();

	public Procesos() {

	}

	public void iniciar() {

		String menu = obtenerMenu();

		int opcion = 0;

		do {
			opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
			validarOpcion(opcion);
		} while (opcion != 5);
	}

	private String obtenerMenu() {

		String menu = "";

		menu += "***** Bienvenido *****";
		menu += "\n\nIngrese la opcion:\n";
		menu += "\n1- Registrar mascotas.";
		menu += "\n2- Consultar lista de mascotas.";
		menu += "\n3- Consultar mascota.";
		menu += "\n4- Modificar datos de una mascota.";
		menu += "\n5- Salir.\n\n";

		return menu;
	}

	private void validarOpcion(int opcion) {

		switch (opcion) {

		case 1:
				registrarMascotas();
			break;

		case 2:
			if (!mapaMascotas.isEmpty()) {
				listaMascotas();
				break;
			}
			JOptionPane.showMessageDialog(null, "No hay datos registrados");
			break;

		case 3:
			if (!mapaMascotas.isEmpty()) {				
				buscarMascota();
				break;
			}
			JOptionPane.showMessageDialog(null, "No hay datos registrados");
			break;

		case 4:
			if (!mapaMascotas.isEmpty()) {				
				actualizarMascota();
				break;
			}
			JOptionPane.showMessageDialog(null, "No hay datos registrados");
			break;

		case 5:
			JOptionPane.showMessageDialog(null, "Gracias por usar el programa");
			break;

		default:
			JOptionPane.showMessageDialog(null, "Opcion incorrecta");

		}
	}

	private void actualizarMascota() {

		String identificacion = JOptionPane.showInputDialog("Ingrese la identificacion de la mascota a consultar");

		String nombre = "";
		String especie = "";
		int edad = 0;

		int opcion = 0;

		Mascota mascota = mapaMascotas.get(identificacion);

		if (mapaMascotas.containsKey(identificacion)) {

			do {
				opcion = Integer.parseInt(JOptionPane
						.showInputDialog("Seleccione por favor que desea actualizar:\n1- Nombre\n2- Especie\n3- Edad"));
			} while (opcion < 1 || opcion > 3);

			switch (opcion) {

			case 1:
				nombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre de la mascota").toLowerCase();
				mascota.setNombre(nombre);
				break;

			case 2:
				especie = JOptionPane.showInputDialog("Ingrese la nueva especie de la mascota").toLowerCase();
				mascota.setEspecie(especie);
				break;

			case 3:
				edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva edad de la mascota"));
				mascota.setEdad(edad);
				break;
			}

			JOptionPane.showMessageDialog(null, "Actualizacion exitosa");

		} else {
			JOptionPane.showMessageDialog(null,
					"La identificacion de la mascota ingresada no se encuentra en el sistema");
		}

	}

	private void registrarMascotas() {
		
	    int cantidad = 0;
	    cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de mascotas"));

	    for (int i = 0; i < cantidad; i++) {
	        Mascota mascota = new Mascota();
	        mascota.registrarMascota(i);

	        while (mapaMascotas.containsKey(mascota.getIdentificacion())) {
	            JOptionPane.showMessageDialog(null, "La ID de mascota ya existe. Ingrese una ID diferente e intente nuevamente con la mascota " + mascota.getNombre());
	            mascota.registrarMascota(i); 
	        }

	        mapaMascotas.put(mascota.getIdentificacion(), mascota);
	    }
	}


	public void listaMascotas() {

		String mensaje = "**** Lista mascotas ****\n";

		mensaje += "\n********************";

		for (Mascota mascota : mapaMascotas.values()) {
			mensaje += "\nIdentificacion: " + mascota.getIdentificacion();
			mensaje += "\nNombre: " + mascota.getNombre();
			mensaje += "\nEspecie: " + mascota.getEspecie();
			mensaje += "\nEdad: " + mascota.getEdad();
			mensaje += "\nSonido: " + mascota.hacerSonido();
			mensaje += "\nAccion: " + mascota.saltar();
			mensaje += "\nJugar: " + mascota.jugar();
			mensaje += "\n********************";
		}

		JOptionPane.showMessageDialog(null, mensaje);
	}

	public void buscarMascota() {

		String mensaje = "**** Buscar por identificacion ****\n";

		String identificacion = JOptionPane.showInputDialog("Ingrese la identificacion de la mascota a consultar");

		Mascota mascota = mapaMascotas.get(identificacion);

		mensaje += "\n********************";

		if (mapaMascotas.containsKey(identificacion)) {
			mensaje += "\nIdentificacion: " + mascota.getIdentificacion();
			mensaje += "\nNombre: " + mascota.getNombre();
			mensaje += "\nEspecie: " + mascota.getEspecie();
			mensaje += "\nEdad: " + mascota.getEdad();
			mensaje += "\nSonido: " + mascota.hacerSonido();
			mensaje += "\nAccion: " + mascota.saltar();
			mensaje += "\nJugar: " + mascota.jugar();
			mensaje += "\n********************";
		} else {
			JOptionPane.showMessageDialog(null,
					"La identificacion de la mascota ingresada no se encuentra en el sistema");
		}

		JOptionPane.showMessageDialog(null, mensaje);
	}

}