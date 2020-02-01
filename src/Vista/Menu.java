package Vista;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

	public static int Inicio() {
		int opcion=0;
		boolean isValid =false;
		while(!isValid) {
			System.out.println("Indique la accion a realizar");
			System.out.println("1.Visualizar todos los Empleados");
			System.out.println("2.Visualizar todos los Departamentos");
			System.out.println("3.Insertar un Departamento");
			System.out.println("4.Insertar un Empleado");
			System.out.println("5.Visualizar todos los Empleados  de un Departamento");
			System.out.println("6.Visualizar todos los Departamentos con sus empleados");
			System.out.println("7.Salir");
			Scanner sc1 =new Scanner(System.in);
			try {
				opcion=sc1.nextInt();
				isValid=true;
			
			}
			catch(InputMismatchException e) {
				System.out.println("Error al introducir la accion");
			}
			catch(NumberFormatException ex) {
				System.out.println("Error al introducir la accion");
			}
		}
		return opcion;
	}
	public static int Salida() {
		Scanner sc =new Scanner(System.in);
		System.out.println("\nSi desea salir de la aplicacion pulse 1 si no pulse cualquier tecla");
		try {
			int opcion=sc.nextInt();
			return opcion;
		}
		catch(InputMismatchException e) {
			System.out.println("Error al introducir la accion");
			return 0;
		}
		catch(NumberFormatException ex) {
			System.out.println("Error al introducir la accion");
			return 0;
		}
	}
}
