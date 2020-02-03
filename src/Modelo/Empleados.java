package Modelo;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

public class Empleados {

	private int emp_no;
	private String apellido;
	private String oficio;

	@Override
	public String toString() {
		return "emp_no=" + emp_no + ", apellido=" + apellido + ", oficio=" + oficio + ", fecha_atl="
				+ fecha_atl + ", salario=" + salario + ", comision=" + comision + ", dept_no=" + dept_no;
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



	public String SaveInDepartamento(Departamentos e) {
		ODB odb = ODBFactory.open("bd.test");
		odb.store(this);
		e.getListEmpleados().add(this);
		odb.store(e);
		odb.close();
		return "Empleado Creado";
		
	

	}
}
