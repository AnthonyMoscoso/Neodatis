package Modelo;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class Consultas {
	public Objects<Departamentos> LeerDepartamentos() {
		ODB odb = ODBFactory.open("bd.test");// Abrir BD
		Objects<Departamentos> objects = odb.getObjects(Departamentos.class);
		odb.close();
		return objects;
	}

	//Recogemos todos los empleados de nuestra base de datos
	public Objects<Empleados> LeerEmpleados() {
		ODB odb = ODBFactory.open("bd.test");// Abrir BD
		Objects<Empleados> objects = odb.getObjects(Empleados.class);
		odb.close();
		return objects;
	}



	public boolean existEmpleadoId(int id) {
		ODB odb = ODBFactory.open("bd.test");
		IQuery query = new CriteriaQuery(Empleados.class, Where.equal("emp_no", id));
		Objects<Empleados> o = odb.getObjects(query);
		if (o.isEmpty()) {
			odb.close();
			return true;

		}
		odb.close();
		return false;
	}

	//nos devuelve un departamento dependiendo del Id introducido
	public Departamentos GetDepartamentoById(int id) {
		ODB odb = ODBFactory.open("bd.test");
		IQuery query = new CriteriaQuery(Departamentos.class, Where.equal("dept_no", id));
		Objects<Departamentos> o = odb.getObjects(query);
		while (o.hasNext()) {
			Departamentos d = o.getFirst();
			odb.close();
			return d;
		}
		odb.close();
		return null;
	}

	//si existe el departamento con la Id indicada nos devuelve true 
	public boolean existDeparmento(int id) {
		ODB odb = ODBFactory.open("bd.test");
		IQuery query = new CriteriaQuery(Departamentos.class, Where.equal("dept_no", id));
		Objects<Departamentos> o = odb.getObjects(query);
		if (!o.isEmpty()) {
			odb.close();
			return true;
		}
		odb.close();
		return false;
	}

}
