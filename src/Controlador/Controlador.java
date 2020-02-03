package Controlador;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import org.neodatis.odb.Objects;

import Modelo.Consultas;
import Modelo.Departamentos;
import Modelo.Empleados;
import Vista.Consola;
import Vista.Menu;

public class Controlador {
	public static String[] MenuInicio = { "Visualizar todos los Empleados", "Visualizar todos los Departamentos",
			"Insertar un Departamento", "Insertar un Empleado", "Visualizar todos los Empleados  de un Departamento",
			"Visualizar todos los Departamentos con sus empleados", "Salir" };

	public static String titulo = "Indique la accion a realizar";
	public Menu menu;
	public Consola consola;
	public Consultas consulta = new Consultas();

	public Controlador(Menu menu, Consola consola) {
		this.menu = menu;
		this.consola = consola;
		Iniciar();
	}

	public void eleccion(int valor) {
		switch (valor) {
		case 1:
			LeerTodosLosEmpleados();
			isExit();
			break;
		case 2:
			LeerTodosLosDepartamentos();
			isExit();
			break;
		case 3:
			crearDepartamento();
			isExit();
			break;
		case 4:
			crearEmpleado();
			isExit();
			break;
		case 5:
			VerEmpleadosDeUnDepartamento();
			isExit();
			break;

		case 6:
			LeerDepartamentosConEmpleados();
			isExit();
			break;
		case 7:
			System.exit(0);
			break;
		}
	}

	public void Iniciar() {

		int valor = menu.GetChosseInt(titulo, MenuInicio);
		eleccion(valor);
	}

	public void LeerTodosLosEmpleados() {
		Objects<Empleados> objects = consulta.LeerEmpleados();
		consola.ImprimirEmpleados(objects);
	}

	public void isExit() {
		String[] opciones = { "Salir del sistema", "Continuar" };
		int value = menu.GetChosseInt("Desea salir del programa?", opciones);
		if (value == 1) {
			System.exit(0);
		} else {
			eleccion(menu.GetChosseInt(titulo, MenuInicio));
		}
	}

	public void wantContinue() {
		String[] opciones = { "Volver a introducir dato", "Volver al Menu", "Salir de la aplicacioj" };
		int value = menu.GetChosseInt("Que desea realizar", opciones);
		switch (value) {
		case 1:
			break;
		case 2:
			this.Iniciar();
			break;
		case 3:
			System.exit(0);
			break;

		}
	}

	public void LeerTodosLosDepartamentos() {
		Objects<Departamentos> objects = consulta.LeerDepartamentos();
		consola.ImprimirDepartamentos(objects);
	}

	public void VerEmpleadosDeUnDepartamento() {

		try {
			int id = Integer
					.parseInt(consola.ObtenerValorScanner("Introduzca el numero de departamento de los empleados"));
			Departamentos d = consulta.LeerEmpleadosDeUnDepartamentoByDeptNo(id);
			if (d != null) {
				if (!d.getListEmpleados().isEmpty()) {
					consola.ImprimirEmpleadosDeUnDepartamento(d);
				} else {
					consola.ImprimirMensage("este departamento no tiene ningun empleado");
				}
			} else {
				consola.ImprimirMensage("No existe ningun departamento con ese codigo");
			}

		} catch (NumberFormatException ex) {
			consola.ImprimirMensage("Formato equivocado introduzca solo numero");
		}

	}

	public void LeerDepartamentosConEmpleados() {
		Objects<Departamentos> objects = consulta.LeerDepartamentos();
		consola.ImprimirDepartamentoConEmpleados(objects);
	}

	public void crearDepartamento() {

		boolean isCodigValid = false;
		int codigo=0;
		while (!isCodigValid) {
			try {
				codigo = Integer.parseInt(consola.ObtenerValorScanner("Inserte el numero del departamento"));
				if(consulta.existDeparmento(codigo)) {
					consola.ImprimirMensage("Ya existe un departamento con este codigo");
					consola.ImprimirDepartamentos(consulta.LeerDepartamentos());
					wantContinue();
				}
				else {
					isCodigValid = true;
				}
				

			} catch (InputMismatchException e) {
				consola.ImprimirMensage("Error al introducir el codigo solo acepta datos numericos");

			} catch (NumberFormatException ex) {
				consola.ImprimirMensage("Error al introducir el codigo solo acepta datos numericos");

			}

		}
		String nombre = consola.ObtenerValorScanner("Inserte el nombre del departamento");
		String localidad = consola.ObtenerValorScanner("Inserte la localidad del departamento");
		ArrayList<Empleados> empleados = new ArrayList<Empleados>();
		Departamentos d = new Departamentos(codigo, nombre, localidad, empleados);
		consola.ImprimirMensage(d.saveNeodatis());

	}

	public void crearEmpleado() {
		Date date = new Date();
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
		String fecha = simple.format(date);

		boolean isCodigValid = false;
		int codigo = 0, departamento = 0;
		double sueldo = 0, comision = 0;
		while (!isCodigValid) {
			try {
				codigo = Integer.parseInt(consola.ObtenerValorScanner("Inserte el codigo de empleado"));
				isCodigValid = true;
			} catch (NumberFormatException ex) {
				consola.ImprimirMensage("Error al introducir el dato solo acepta datos numericos");
				wantContinue();
			}
		}
		isCodigValid = false;
		String apellido = consola.ObtenerValorScanner("Inserte el apellido del empleado");
		String oficio = consola.ObtenerValorScanner("Inserte el oficio del empleado");
		while (!isCodigValid) {
			try {
				sueldo = Double.parseDouble(consola.ObtenerValorScanner("Inserte el Sueldo de empleado"));
				isCodigValid = true;
			} catch (NumberFormatException ex) {
				consola.ImprimirMensage("Error al introducir el dato solo acepta datos numericos");
				wantContinue();
			}

		}
		isCodigValid = false;
		while (!isCodigValid) {
			try {
				comision = Double.parseDouble(consola.ObtenerValorScanner("Inserte la comision de empleado"));
				isCodigValid = true;
			} catch (NumberFormatException ex) {
				consola.ImprimirMensage("Error al introducir el dato solo acepta datos numericos");
				wantContinue();
			}

		}
		isCodigValid = false;
		while (!isCodigValid) {
			try {
				departamento = Integer.parseInt(consola.ObtenerValorScanner("Inserte el codigo de departamento"));
				if (consulta.existDeparmento(departamento)) {
					isCodigValid = true;
				} else {
					consola.ImprimirMensage(
							"No existe ningun departamento con este codigo\nLosdepartamentos que existen son :");
					consola.ImprimirDepartamentos(consulta.LeerDepartamentos());
				}
			} catch (NumberFormatException ex) {
				consola.ImprimirMensage("Error al introducir el dato solo acepta datos numericos");
				wantContinue();
			}

		}
		Empleados empleado = new Empleados(codigo, apellido, oficio, fecha, sueldo, comision, departamento);
		consola.ImprimirMensage(empleado.SaveOdb());
	}

}
