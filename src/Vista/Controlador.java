package Vista;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
	//Departamentos d=new Departamentos(4,"Compras","Chicago");
	ArrayList<Empleados>empleados=new ArrayList<Empleados>();
	Departamentos d=new Departamentos(54,"Ventas","Manhattan",empleados);
	d.saveNeodatis();
}
public static void crearEmpleado() {
	Date date= new Date();
	SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd");
	String fecha=simple.format(date);
	Empleados empleado=new Empleados(25,"Ramirez","Programador",fecha,2345.56,100.45,54);
	empleado.SaveOdb();
}
public static void LeerDepartamentosConEmpleados() {
	Objects<Departamentos> objects =consulta.LeerDepartamentos();
	consola.ImprimirDepartamentos(objects);
}
}
