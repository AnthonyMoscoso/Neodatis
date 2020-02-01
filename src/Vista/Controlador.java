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
		break;
	case 2:
		LeerTodosLosDepartamentos();
		break;
	case 3:
		VerEmpleadosDeUnDepartamento();
		break;
		
	case 4:
		LeerDepartamentosConEmpleados();
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
	Departamentos insert=consola.ImprimirGetDepartamento();
	if(insert!=null) {
		consola.ImprimirMensage(insert.saveNeodatis());
	}
	menu.Inicio();
}
public static void crearEmpleado() {
	Date date= new Date();
	SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd");
	String fecha=simple.format(date);
	System.out.println("Inserte el codigo de empleado");
	Scanner sc =new Scanner (System.in);
	try
	{
		int codigo=sc.nextInt();	
			consola.ImprimirMensage("Inserte el apellido del empleado");
			Scanner scApellido=new Scanner(System.in);
			String apellido=scApellido.nextLine();
			
			consola.ImprimirMensage("Inserte el oficio del empleado");
			Scanner scOficio=new Scanner(System.in);
			String oficio=scOficio.nextLine();
			
			consola.ImprimirMensage("Inserte el Sueldo de empleado");
			Scanner Sueldo=new Scanner(System.in);
			
			double sueldo=Sueldo.nextDouble();;
			consola.ImprimirMensage("Inserte la comision del empleado");
			Scanner C=new Scanner(System.in);
			
			double comision=C.nextDouble();
			consola.ImprimirMensage("Inserte el codigo de departamento");
			
			Scanner scDept=new Scanner(System.in);
			int departamento=scDept.nextInt();
			
			Empleados empleado=new Empleados(codigo,apellido,oficio,fecha,sueldo,comision,departamento);
			consola.ImprimirMensage(empleado.SaveOdb());
	}

	catch(InputMismatchException e) {
		System.out.println("Error al introducir el dato solo acepta datos numericos");
		
	}
	catch(NumberFormatException ex) {
		System.out.println("Error al introducir el dato solo acepta datos numericos");
		
	}
}
public static void LeerDepartamentosConEmpleados() {
	Objects<Departamentos> objects =consulta.LeerDepartamentos();
	consola.ImprimirDepartamentos(objects);
}
}
