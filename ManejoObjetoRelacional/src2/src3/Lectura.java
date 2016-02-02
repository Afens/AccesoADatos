import java.util.InputMismatchException;
import java.util.Scanner;
public class Lectura{
	public enum Limite{
		MAYOR, MENOR, MAYORIGUAL, MENORIGUAL;
	}
	public enum Rango{
		AMBOSINCLUIDOS, AMBOSEXCLUIDOS, MINIMOEXCLUIDO, MAXIMOEXCLUIDO;
	}
	static Scanner lectura=new Scanner(System.in);
	
	//Lectura de un carácter cualquiera.
	public static char caracter(){
		char salida=' ';
		salida=lectura.nextLine().charAt(0);
		return salida;
	}
	
	//Lectura de un carácter que cumple un patrón pasado como parámetro.
	public static char caracterPatron(char caracter){
		char salida=' ';
		boolean error=false;
		do{
			salida=lectura.nextLine().charAt(0);
			if(salida==caracter){
				error=false;
			}
			else{
				System.out.println("¡ERROR en el dato!");
				error=true;
			}
		}while(error);
		return salida;
	}
	
	//Lectura de un cadena cualquiera.
	public static String cadena(){
		String salida;
		salida=lectura.nextLine();
		return salida;
	}
	
	//Lectura de un cadena que cumpla un patrón pasado como parámetro.
	public static String cadenaPatron(String patron){
		String salida;
		boolean error=false;
		do{
			salida=lectura.nextLine();
			if(salida.matches(patron)){
				error=false;
			}
			else{
				System.out.println("¡ERROR en el dato!");
				error=true;
			}
		}while(error);
		return salida;
	}
	
	//Lectura de un booleano. Se le pasará como parámetro el mensaje de petición al usuario, una cadena para el true y una cadena para el false.
	public static boolean booleano(String mensaje, String a, String b){
		boolean salida;
		int aux;
		System.out.print(mensaje+"\n"+a+"\n"+b+"\nRespuesta: ");
		aux=lectura.nextInt();
		if(aux==1){
			salida=true;
		}
		else{
			salida=false;
		}
		lectura.nextLine();
		return salida;
	}
	
	//Lectura de un número byte cualquiera.
	public static byte numeroByte(){
		boolean error=false;
		byte salida=0;
		do{
			try{
				salida=lectura.nextByte();
				error=false;	
			}
			catch (InputMismatchException e){
				System.out.println("¡ERROR en el dato!");
				error=true;
			}finally{
				lectura.nextLine();
			}
		}while(error);
		return salida;
	}
	
	//Lectura de un número short cualquiera.
	public static short numeroShort(){
		boolean error=false;
		short salida=0;
		do{
			try{
				salida=lectura.nextShort();
				error=false;	
			}
			catch (InputMismatchException e){
				System.out.println("¡ERROR en el dato!");
				error=true;
			}finally{
				lectura.nextLine();
			}
		}while(error);
		return salida;
	}
	
	//Lectura de un número int cualquiera.
		public static int numeroInt(){
			boolean error=false;
			int salida=0;
			do{
				try{
					salida=lectura.nextInt();
					error=false;	
				}
				catch (InputMismatchException e){
					System.out.println("¡ERROR en el dato!");
					error=true;
				}finally{
					lectura.nextLine();
				}
			}while(error);
			return salida;
		}
		
	//Lectura de un número long cualquiera.
		public static long numeroLong(){
			boolean error=false;
			long salida=0;
			do{
				try{
					salida=lectura.nextLong();
					error=false;	
				}
				catch (InputMismatchException e){
					System.out.println("¡ERROR en el dato!");
					error=true;
				}finally{
					lectura.nextLine();
				}
			}while(error);
			return salida;
		}	
	
	//Lectura de un número float cualquiera.
		public static float numeroFloat(){
			boolean error=false;
			float salida=0;
			do{
				try{
					salida=lectura.nextFloat();
					error=false;	
				}
				catch (InputMismatchException e){
					System.out.println("¡ERROR en el dato!");
					error=true;
				}finally{
					lectura.nextLine();
				}
			}while(error);
			return salida;
		}
		
	//Lectura de un número double cualquiera.
		public static double numeroDouble(){
			boolean error=false;
			double salida=0;
			do{
				try{
					salida=lectura.nextDouble();
					error=false;	
				}
				catch (InputMismatchException e){
					System.out.println("¡ERROR en el dato!");
					error=true;
				}finally{
					lectura.nextLine();
				}
			}while(error);
			return salida;
		}
		
	//Lectura de un número byte comparado con otro.
		public static byte numeroByte(byte a, Limite limite){
			boolean error=true;
			byte salida=0;
			do{
				salida=Lectura.numeroByte();		
				switch(limite){
					case MAYOR: if(salida>a){error=false;} break;
					case MENOR: if(salida<a){error=false;} break;
					case MAYORIGUAL: if(salida>=a){error=false;} break;
					case MENORIGUAL: if(salida<=a){error=false;} break;
				}
				if(error){System.out.println("¡ERROR en el límite!");}
			}while(error);
			return salida;
		}

	//Lectura de un número short comparado con otro.
		public static short numeroShort(short a, Limite compara){
			boolean error=true;
			short salida=0;
			do{
				salida=Lectura.numeroShort();		
				switch(compara){
					case MAYOR: if(salida>a){error=false;} break;
					case MENOR: if(salida<a){error=false;} break;
					case MAYORIGUAL: if(salida>=a){error=false;} break;
					case MENORIGUAL: if(salida<=a){error=false;} break;
				}
				if(error){System.out.println("¡ERROR en el límite!");}
			}while(error);
			return salida;
		}

	//Lectura de un número int comparado con otro.
		public static int numeroInt(int a, Limite compara){
			boolean error=true;
			int salida=0;
			do{
				salida=Lectura.numeroInt();	
				switch(compara){
					case MAYOR: if(salida>a){error=false;} break;
					case MENOR: if(salida<a){error=false;} break;
					case MAYORIGUAL: if(salida>=a){error=false;} break;
					case MENORIGUAL: if(salida<=a){error=false;} break;
				}
				if(error){System.out.println("¡ERROR en el límite!");}
			}while(error);
			return salida;
		}	

	//Lectura de un número long comparado con otro.
		public static long numeroLong(long a, Limite compara){
			boolean error=true;
			long salida=0;
			do{
				salida=Lectura.numeroLong();		
				switch(compara){
					case MAYOR: if(salida>a){error=false;} break;
					case MENOR: if(salida<a){error=false;} break;
					case MAYORIGUAL: if(salida>=a){error=false;} break;
					case MENORIGUAL: if(salida<=a){error=false;} break;
				}
				if(error){System.out.println("¡ERROR en el límite!");}
			}while(error);
			return salida;
		}

	//Lectura de un número float comparado con otro.
		public static float numeroFloat(float a, Limite compara){
			boolean error=true;
			float salida=0;
			do{
				salida=Lectura.numeroFloat();		
				switch(compara){
					case MAYOR: if(salida>a){error=false;} break;
					case MENOR: if(salida<a){error=false;} break;
					case MAYORIGUAL: if(salida>=a){error=false;} break;
					case MENORIGUAL: if(salida<=a){error=false;} break;
				}
				if(error){System.out.println("¡ERROR en el límite!");}
			}while(error);
			return salida;
		}

	//Lectura de un número double comparado con otro.
		public static double numeroDouble(double a, Limite compara){
			boolean error=true;
			double salida=0;
			do{
				salida=Lectura.numeroDouble();
				switch(compara){
					case MAYOR: if(salida>a){error=false;} break;
					case MENOR: if(salida<a){error=false;} break;
					case MAYORIGUAL: if(salida>=a){error=false;} break;
					case MENORIGUAL: if(salida<=a){error=false;} break;
				}
				if(error){System.out.println("¡ERROR en el límite!");}
			}while(error);
			return salida;
		}
		
	//Lectura de un número byte dentro de un rango.
		public static byte numeroByte(byte minimo, byte maximo, Rango rango){
			boolean error=true;
			byte salida=0;
				do{
				salida=Lectura.numeroByte();		
				switch(rango){
					case AMBOSINCLUIDOS: if(salida>=minimo && salida <=maximo){error=false;} break;
					case AMBOSEXCLUIDOS: if(salida>minimo && salida <maximo){error=false;} break;
					case MINIMOEXCLUIDO: if(salida>minimo && salida <=maximo){error=false;} break;
					case MAXIMOEXCLUIDO: if(salida>=minimo && salida <maximo){error=false;} break;
				}
				if(error){System.out.println("¡ERROR en el rango!");}
			}while(error);
			return salida;
		}
		
	//Lectura de un número short dentro de un rango.
		public static short numeroShort(short minimo, short maximo, Rango rango){
			boolean error=true;
			short salida=0;
				do{
				salida=Lectura.numeroShort();		
				switch(rango){
					case AMBOSINCLUIDOS: if(salida>=minimo && salida <=maximo){error=false;} break;
					case AMBOSEXCLUIDOS: if(salida>minimo && salida <maximo){error=false;} break;
					case MINIMOEXCLUIDO: if(salida>minimo && salida <=maximo){error=false;} break;
					case MAXIMOEXCLUIDO: if(salida>=minimo && salida <maximo){error=false;} break;
				}
				if(error){System.out.println("¡ERROR en el rango!");}
			}while(error);
			return salida;
		}

	//Lectura de un número int dentro de un rango.
		public static int numeroInt(int minimo, int maximo, Rango rango){
			boolean error=true;
			int salida=0;
				do{
				salida=Lectura.numeroInt();		
				switch(rango){
					case AMBOSINCLUIDOS: if(salida>=minimo && salida <=maximo){error=false;} break;
					case AMBOSEXCLUIDOS: if(salida>minimo && salida <maximo){error=false;} break;
					case MINIMOEXCLUIDO: if(salida>minimo && salida <=maximo){error=false;} break;
					case MAXIMOEXCLUIDO: if(salida>=minimo && salida <maximo){error=false;} break;
				}
				if(error){System.out.println("¡ERROR en el rango!");}
			}while(error);
			return salida;
		}

	//Lectura de un número long dentro de un rango.
		public static long numeroLong(long minimo, long maximo, Rango rango){
			boolean error=true;
			long salida=0;
				do{
				salida=Lectura.numeroLong();		
				switch(rango){
					case AMBOSINCLUIDOS: if(salida>=minimo && salida <=maximo){error=false;} break;
					case AMBOSEXCLUIDOS: if(salida>minimo && salida <maximo){error=false;} break;
					case MINIMOEXCLUIDO: if(salida>minimo && salida <=maximo){error=false;} break;
					case MAXIMOEXCLUIDO: if(salida>=minimo && salida <maximo){error=false;} break;
				}
				if(error){System.out.println("¡ERROR en el rango!");}
			}while(error);
			return salida;
		}

	//Lectura de un número int dentro de un rango.
		public static float numeroFloat(float minimo, float maximo, Rango rango){
			boolean error=true;
			float salida=0;
				do{
				salida=Lectura.numeroFloat();		
				switch(rango){
					case AMBOSINCLUIDOS: if(salida>=minimo && salida <=maximo){error=false;} break;
					case AMBOSEXCLUIDOS: if(salida>minimo && salida <maximo){error=false;} break;
					case MINIMOEXCLUIDO: if(salida>minimo && salida <=maximo){error=false;} break;
					case MAXIMOEXCLUIDO: if(salida>=minimo && salida <maximo){error=false;} break;
				}
				if(error){System.out.println("¡ERROR en el rango!");}
			}while(error);
			return salida;
		}

	//Lectura de un número double dentro de un rango.
		public static double numeroDouble(double minimo, double maximo, Rango rango){
			boolean error=true;
			double salida=0;
				do{
				salida=Lectura.numeroDouble();		
				switch(rango){
					case AMBOSINCLUIDOS: if(salida>=minimo && salida <=maximo){error=false;} break;
					case AMBOSEXCLUIDOS: if(salida>minimo && salida <maximo){error=false;} break;
					case MINIMOEXCLUIDO: if(salida>minimo && salida <=maximo){error=false;} break;
					case MAXIMOEXCLUIDO: if(salida>=minimo && salida <maximo){error=false;} break;
				}
				if(error){System.out.println("¡ERROR en el rango!");}
			}while(error);
			return salida;
		}

	//cerrar la lectura de datos
		public static void cerrar(){
			lectura.close();
		}
}