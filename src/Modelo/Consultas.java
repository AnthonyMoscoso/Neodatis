package Modelo;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

public class Consultas {
	public Objects LeerDepartamentos() {
		ODB odb = ODBFactory.open("bd.test");// Abrir BD
		Objects<Departamentos> objects = odb.getObjects(Departamentos.class);
		return objects;
	}
}
