package Modelo;

import java.util.ArrayList;
import java.util.List;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class Departamentos {
	private int dept_no;
	private String dnombre;
	private String localidad;
	private ArrayList<Empleados> listEmpleados;

	public ArrayList<Empleados> getListEmpleados() {
		return listEmpleados;
	}

	public void setListEmpleados(ArrayList<Empleados> listEmpleados) {
		this.listEmpleados = listEmpleados;
	}

	public int getDept_no() {
		return dept_no;
	}

	public void setDept_no(int dept_no) {
		this.dept_no = dept_no;
	}

	public String getDnombre() {
		return dnombre;
	}

	public void setDnombre(String dnombre) {
		this.dnombre = dnombre;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public Departamentos(int dept_no, String dnombre, String localidad, ArrayList<Empleados> listEmpleados) {
		super();
		this.dept_no = dept_no;
		this.dnombre = dnombre;
		this.localidad = localidad;
		this.listEmpleados = listEmpleados;
	}

	@Override
	public String toString() {
		String size = "";
		if (this.getListEmpleados() != null) {
			size = getListEmpleados().size() + "";
		} else {
			size = 0 + "";
		}

		return "Departamento dept_no=" + dept_no + ", dnombre=" + dnombre + ", localidad=" + localidad + ", empleados="
				+ size + "";
	}

	public boolean IsValidDepartamento(ODB odb) {
		IQuery query = new CriteriaQuery(Departamentos.class, Where.equal("dnombre", this.dnombre));
		Objects<Departamentos> o = odb.getObjects(query);
		if (o.isEmpty()) {
			return true;
		}
		System.out.println(" Ya existe un Departamento con este Nombre");
		return false;

	}

	public void saveNeodatis() {
		ODB odb = ODBFactory.open("bd.test");
		IQuery query = new CriteriaQuery(Departamentos.class, Where.equal("dept_no", this.dept_no));
		Objects<Departamentos> o = odb.getObjects(query);
		if (o.isEmpty() && IsValidDepartamento(odb)) {
			odb.store(this);
			System.out.println("Departamento creado");
		} else {
			System.out.println("Ya existe un departamento con este Id");
		}
		odb.close();

	}

}
