package IU;

import javax.swing.JOptionPane;
import Datos.Persona;

import Negocios.Validador;

public class Main {

	public static void main(String[] args) {

		Validador interfaz = new Validador();

		int repetirLogin = 0;
		boolean validador =true;
		int rolusuario=0;
		do {

			String nombre = JOptionPane.showInputDialog("Ingrese nombre");
			String dni = JOptionPane.showInputDialog("Ingrese dni");
			while (validador) {
				if (interfaz.ValidarCaracteres(nombre) && interfaz.ValidarCaracteres(dni)) {
					repetirLogin = interfaz.IniciarSesion(nombre, dni);

					if (repetirLogin != 0) {
						JOptionPane.showMessageDialog(null, "Inicio sesion correctamente");
						validador = false;
						rolusuario= repetirLogin;
						repetirLogin=0;
					} else {
						JOptionPane.showMessageDialog(null, "Este usuario no existe");
						nombre = JOptionPane.showInputDialog("Ingrese nombre");
						dni = JOptionPane.showInputDialog("Ingrese dni");
					}
				}else {
					JOptionPane.showMessageDialog(null, "Hubo un error en el ingreso de caracteres");
					nombre = JOptionPane.showInputDialog("Ingrese nombre");
					dni = JOptionPane.showInputDialog("Ingrese dni");
				}
			}

		} while (repetirLogin != 0);
		// EN ESTA VARIABLE "repetirLogin" ESTA GUARDADO EL ROL DEL USUARIO,
		// UTILIZAR ESTE ROL PARA ABRIR UN MENU DE CLIENTE NORMAL
		// ej ROL 1, Y UNO DE ADMIN CON ROL 2.

		// EXTRA: AGREGAR UN PRODUCTO A EL PROGRAMA, INGRESAR LOS PRODUCTOS COMO ADMIN
		// AL SISTMEA
		// CREAR CRUD PARA PRODUCTO
		String[] opciones = {

				"Ingresar nuevo registro", "Mostrar existente", "Editar", "Eliminar", "Salir" };

		String opcion = "";
		do {

			opcion = (String) JOptionPane.showInputDialog(null, "Elija la accion a realizar", null, 0, null, opciones,
					opciones[0]);
			switch (opcion) {
			case "Ingresar nuevo registro":
				String nombre = JOptionPane.showInputDialog("Ingrese nombre");
				String apellido = JOptionPane.showInputDialog("Ingrese apellido");
				String dni = JOptionPane.showInputDialog("Ingrese dni");
				int rol = Integer.parseInt(JOptionPane.showInputDialog("Ingrese rol"));
				if (interfaz.ValidarIngreso(nombre, apellido, dni, rol)) {
					JOptionPane.showMessageDialog(null, "Se pudo guardar");
				} else {
					JOptionPane.showMessageDialog(null, "No pudo guardar");
				}
				break;
			case "Mostrar existente":
				String registros = "Lista de personas";
				if (interfaz.Mostrar() == null) {
					JOptionPane.showMessageDialog(null, "No hay personas");
				} else {

					for (Persona persona : interfaz.Mostrar()) {
						registros = registros + "\n" + persona;
					}
					JOptionPane.showMessageDialog(null, registros);
				}

				break;
			case "Editar":
				dni = JOptionPane.showInputDialog(null, "Ingrese dni de persona a editar");
				nombre = JOptionPane.showInputDialog("Ingrese nombre");
				apellido = JOptionPane.showInputDialog("Ingrese apellido");
				rol = Integer.parseInt(JOptionPane.showInputDialog("Ingrese rol"));
				if (interfaz.ValidarEditar(nombre, apellido, dni, rol)) {
					JOptionPane.showMessageDialog(null, "Se pudo editar");
				} else {
					JOptionPane.showMessageDialog(null, "No pudo editar");
				}

				break;
			case "Eliminar":
				dni = JOptionPane.showInputDialog(null, "Ingrese dni de persona a editar");

				if (interfaz.ValidarEliminar(dni)) {
					JOptionPane.showMessageDialog(null, "Se pudo Eliminar");
				} else {
					JOptionPane.showMessageDialog(null, "No pudo Eliminar");
				}

				break;
			default:
				break;
			}

		} while (!opcion.equals("Salir"));

	}

}
