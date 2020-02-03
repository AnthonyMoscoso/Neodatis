package Vista;

import java.util.Scanner;

import org.neodatis.odb.Objects;

import Modelo.Departamentos;
import Modelo.Empleados;

public class Consola {
	private Scanner sc;
	public void ImprimirDepartamentos(Objects<Departamentos> objects) {
		while(objects.hasNext()){
		  	 Departamentos e = objects.next();
		  	 System.out.println(e.toString());
			}
	}
	public void ImprimirDepartamentoConEmpleados(Objects<Departamentos> objects) {
		while(objects.hasNext()){ 
		  	 Departamentos e = objects.next();
		  	 System.out.println(e.toString());
		  	 if(e.getListEmpleados()!=null && e.getListEmpleados().size()>0) {
		  		 for(Empleados em : e.getListEmpleados()) {
		  			 System.out.println(em.toString());
		  		 }
		  	 }
		  	 System.out.println();
			}
		
	}
	public void ImprimirEmpleadosDeUnDepartamento(Departamentos d) {
		for(Empleados emp : d.getListEmpleados()) {
			System.out.println(emp.toString());
		}
	}
	public void ImprimirEmpleados(Objects<Empleados>objects) {
		while(objects.hasNext()){
		  	 Empleados e = objects.next();
		  	 System.out.println(e.toString());
			}
	}

	public void ImprimirMensage(String mensaje) {
		System.out.println(mensaje);
	}

	public String ObtenerValorScanner(String mensaje) {
		System.out.println(mensaje);
		sc = new Scanner(System.in);
		String value=sc.nextLine();
		return value;
	}
}
