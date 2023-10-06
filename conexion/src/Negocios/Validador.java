package Negocios;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import Datos.Persona;

public class Validador {

	Persona Verificador = new Persona();
	
	public boolean ValidarIngreso(String nombre,String apellido,String dni,int rol) {
		
		
		if (nombre.length()==0) {
			JOptionPane.showMessageDialog(null, "Nombre vacio");
			return false;
		}else {
			Verificador.setNombre(nombre);
			Verificador.setApellido(apellido);
			Verificador.setDni(dni);
			Verificador.setRol(rol);
			if( Verificador.guardar()) {
				return true;
			}else {
				return false;
			}
		}

	}
	
public boolean ValidarEditar(String nombre,String apellido,String dni,int rol) {
		
		
		if (nombre.length()==0) {
			JOptionPane.showMessageDialog(null, "Nombre vacio");
			return false;
		}else {
			Verificador.setNombre(nombre);
			Verificador.setApellido(apellido);
			Verificador.setDni(dni);
			Verificador.setRol(rol);
			if( Verificador.editar()) {
				return true;
			}else {
				return false;
			}
		}

	}
public boolean ValidarEliminar(String dni) {
	
	
	if (dni.length()==0) {
		JOptionPane.showMessageDialog(null, "dni vacio");
		return false;
	}else {
		Verificador.setDni(dni);
		if( Verificador.Eliminar()) {
			return true;
		}else {
			return false;
		}
	}

}
	public LinkedList<Persona> Mostrar() {
		
		return Verificador.Mostrar();
	}
	public int IniciarSesion(String nombre, String dni) {
		
		if (Verificador.Mostrar() == null) {
			JOptionPane.showMessageDialog(null, "No hay personas");
			return 0;

		} else {

			for (Persona persona : Verificador.Mostrar()) {
				
				if (nombre.equals(persona.getNombre()) && dni.equals(persona.getDni()))
				
					return persona.getRol();
				}
			}
		return 0;
		}
		 
	
	public boolean ValidarCaracteres(String palabra) {
		if (palabra.isEmpty()) {
			return false;
		}else {
			
			return true;
		}
	}
	}
	//Creo una funcion nueva, le pido nombre y dni, valido que sean iguales 
	//devuelvo true en el caso de que sean iguales
