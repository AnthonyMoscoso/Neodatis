import Controlador.Controlador;
import Vista.Consola;
import Vista.Menu;

public class Lanzador {
public static void main(String args[]) {
	Menu menu =new Menu();
	Consola consola=new Consola();
	Controlador controlador=new Controlador(menu,consola);
}
}
