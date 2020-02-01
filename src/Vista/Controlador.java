package Vista;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.neodatis.odb.Objects;

import Modelo.Consultas;
import Modelo.Departamentos;
import Modelo.Empleados;

public class Controlador {
	public static Menu menu;
	public static Consola consola;
	public static Consultas consulta=new Consultas();
	public Controlador(Menu menu,Consola consola) {
		this.menu=menu;
		this.consola=consola;
		Iniciar();
	}
public void Iniciar() {
	Menu m =new Menu() ;
	int valor=m.Inicio();
	switch(valor) {
	case 1:
		LeerTodosLosEmpleados();
		isExit();
		break;
	case 2:
		LeerTodosLosDepartamentos();
		isExit();
		break;
	case 3:
		VerEmpleadosDeUnDepartamento();
		isExit();
		break;
		
	case 4:
		LeerDepartamentosConEmpleados();
		isExit();
		break;
	case 5:
		System.exit(0);
		break;
	}
}
public static void LeerTodosLosEmpleados() {
	isExit();
}
public static void isExit() {
	int value=menu.Salida();
	if(value==0) {
		menu.Inicio();
	}
	else {
		System.exit(0);
	}
}
public static void LeerTodosLosDepartamentos() {
	
}
public static void VerEmpleadosDeUnDepartamento() {
	
}
public static void crearDepartamento() {
	try {
		int codigo=Integer.parseInt(consola.ObtenerValorScanner("Inserte el Sueldo de empleado"));
		String nombre=consola.ObtenerValorScanner("Inserte el nombre del departamento");
		String localidad=consola.ObtenerValorScanner("Inserte la localidad");
		ArrayList<Empleados>empleados=new ArrayList<Empleados>();
		Departamentos d=new Departamentos(codigo,nombre,localidad,empleados);
		consola.ImprimirMensage(d.saveNeodatis());
		
	}
	catch(InputMismatchException e) {
		System.out.println("Error al introducir el codigo solo acepta datos numericos");
		
	}
	catch(NumberFormatException ex) {
		System.out.println("Error al introducir el codigo solo acepta datos numericos");
	
	}
	
	

		
	
	
}
public static void crearEmpleado() {
	Date date= new Date();
	SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd");
	String fecha=simple.format(date);
	consola.ImprimirMensage("Inserte el codigo de empleado");
	Scanner sc =new Scanner (System.in);
	try
	{
		int codigo=sc.nextInt();	
			String apellido=consola.ObtenerValorScanner("Inserte el apellido del empleado");
			String oficio=consola.ObtenerValorScanner("Inserte el oficio del empleado");
			double sueldo=Double.parseDouble(consola.ObtenerValorScanner("Inserte el Sueldo de empleado"));
			double comision=Double.parseDouble(consola.ObtenerValorScanner("Inserte la comision de empleado"));
			int departamento=Integer.parseInt(consola.ObtenerValorScanner("Inserte el Sueldo de empleado"));
			Empleados empleado=new Empleados(codigo,apellido,oficio,fecha,sueldo,comision,departamento);
			consola.ImprimirMensage(empleado.SaveOdb());
	}
	catch(NumberFormatException ex) {
		consola.ImprimirMensage("Error al introducir el dato solo acepta datos numericos");
		
	}
}
public static void LeerDepartamentosConEmpleados() {
	Objects<Departamentos> objects =consulta.LeerDepartamentos();
	consola.ImprimirDepartamentos(objects);
}
}
