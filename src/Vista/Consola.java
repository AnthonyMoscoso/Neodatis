package Vista;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.neodatis.odb.Objects;

import Modelo.Departamentos;
import Modelo.Empleados;

public class Consola {
	public void ImprimirDepartamentos(Objects<Departamentos> objects) {
		while(objects.hasNext()){
		  	 Departamentos e = objects.next();
		  	 System.out.println(e.toString());
		  	 if(e.getListEmpleados()!=null && e.getListEmpleados().size()>0) {
		  		 for(Empleados em : e.getListEmpleados()) {
		  			 System.out.println(em.toString());
		  		 }
		  	 }
			}
	}
	public void ImprimirMensage(String mensaje) {
		System.out.println(mensaje);
	}
	public Empleados CreateEmpledo() {
		
		
	}
	public Departamentos ImprimirGetDepartamento() {
		System.out.println("Inserte el codigo de departamento");
		Scanner sc=new Scanner(System.in);
		try {
			int codigo=sc.nextInt();
			System.out.println("Inserte el Nombre del departamento");
			Scanner sc2=new Scanner(System.in);
			String nombre=sc2.nextLine();
			System.out.println("Inserte la localidad del departamento");
			Scanner teclado=new Scanner(System.in);
			String localidad=teclado.nextLine();
			ArrayList<Empleados>empleados=new ArrayList<Empleados>();
			Departamentos d=new Departamentos(codigo,nombre,localidad,empleados);
			d.saveNeodatis();
			return d;
		}
		catch(InputMismatchException e) {
			System.out.println("Error al introducir el codigo solo acepta datos numericos");
			return null;
		}
		catch(NumberFormatException ex) {
			System.out.println("Error al introducir el codigo solo acepta datos numericos");
			return null;
		}
		
		
	}
}
