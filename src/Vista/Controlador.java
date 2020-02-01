package Vista;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import Modelo.Departamentos;
import Modelo.Empleados;

public class Controlador {
	public static Menu menu;
	public Controlador(Menu menu) {
		this.menu=menu;
	}
public static void main(String args[] ) {

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
	ODB odb = ODBFactory.open("bd.test");// Abrir BD
	Objects<Departamentos> objects = odb.getObjects(Departamentos.class);
	while(objects.hasNext()){
  	  Departamentos e = objects.next();
  	 System.out.println(e.toString());
  	 if(e.getListEmpleados()!=null) {
  		 for(Empleados em : e.getListEmpleados()) {
  			 System.out.println(em.toString());
  		 }
  	 }
	}
}
}
