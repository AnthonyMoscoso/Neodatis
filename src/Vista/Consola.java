package Vista;

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
}
