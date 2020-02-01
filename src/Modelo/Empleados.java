package Modelo;

import java.util.ArrayList;
import java.util.Date;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class Empleados {

	private int emp_no;
	private String apellido;
	private String oficio;

	@Override
	public String toString() {
		return "Empleados [emp_no=" + emp_no + ", apellido=" + apellido + ", oficio=" + oficio + ", fecha_atl="
				+ fecha_atl + ", salario=" + salario + ", comision=" + comision + ", dept_no=" + dept_no + "]";
	}

	public Empleados(int emp_no, String apellido, String oficio, String date, double salario, double comision,
			int dept_no) {
		super();
		this.emp_no = emp_no;
		this.apellido = apellido;
		this.oficio = oficio;
		this.fecha_atl = date;
		this.salario = salario;
		this.comision = comision;
		this.dept_no = dept_no;
	}

	public int getEmp_no() {
		return emp_no;
	}

	public void setEmp_no(int emp_no) {
		this.emp_no = emp_no;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getOficio() {
		return oficio;
	}

	public void setOficio(String oficio) {
		this.oficio = oficio;
	}

	public String getFecha_atl() {
		return fecha_atl;
	}

	public void setFecha_atl(String fecha_atl) {
		this.fecha_atl = fecha_atl;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public double getComision() {
		return comision;
	}

	public void setComision(double comision) {
		this.comision = comision;
	}

	public int getDept_no() {
		return dept_no;
	}

	public void setDept_no(int dept_no) {
		this.dept_no = dept_no;
	}

	private String fecha_atl;
	private double salario;
	private double comision;
	private int dept_no;

	public boolean IsEmpleadoValid(ODB odb) {
		IQuery query = new CriteriaQuery(Empleados.class, Where.equal("emp_no", this.emp_no));
		Objects<Empleados> o = odb.getObjects(query);
		if (o.isEmpty()) {
			
			return true;
		}
		System.out.println("Ya existe un Empleado con este Id");
		return false;
	}

	public String SaveOdb() {
		ODB odb = ODBFactory.open("bd.test");

		IQuery query = new CriteriaQuery(Departamentos.class, Where.equal("dept_no", this.dept_no));
		Objects<Departamentos> o = odb.getObjects(query);
		if (!o.isEmpty() && IsEmpleadoValid(odb)) {
			odb.store(this);
			Departamentos e = o.getFirst();
			e.getListEmpleados().add(this);
			odb.store(e);
			odb.close();
			return "Empleado Creado";
		}
		else {
			odb.close();
			return ("No existe un departamento con este codigo");
	
		}

	}
}
