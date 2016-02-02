import java.util.InputMismatchException;
import java.util.Scanner;
public class ES {
	
//------------------------- METODOS DE ENTRADA -------------------------//	
	
	//Abrir Teclado
	public static Scanner teclado = new Scanner(System.in);
	
	//Lectura de un caracter cualquiera
	public static char introChar (String mensaje) {
		
		//Variables
		String cad;
		boolean error;
		
		//Peticion por teclado de un caracter
		do {
			System.out.printf("%s", mensaje);
			cad=teclado.nextLine();
			
			//Si no se introduce un solo caracter vuelve a pedirlo
			if (cad.length() != 1) {
				System.out.printf("ERROR: Has introducido mas de uno o ningun caracter\n\n");
				error=true;
			} else error=false;
		} while (error);
		
		//Devolvemos el caracter
		return cad.charAt(0);
	}
	
	//Lectura de un caracter por patron
	public static char introChar (String mensaje, String patron) {
		
		//Variables
		String cad;
		boolean error;
		
		//Peticion por teclado de un caracter
		do {
			System.out.printf("%s", mensaje);
			cad=teclado.nextLine();
			
			//Si no se introduce un solo caracter o no cumple el patron vuelve a pedirlo
			if (cad.length() != 1 || cad.matches(patron) == false) {
				System.out.printf("ERROR: Has introducido mas de uno o ningun caracter o el caracter introducido no esta dentro del patron\n\n");
				error=true;
			} else error=false;
		} while (error);
		
		//Devolvemos el caracter
		return cad.charAt(0);
	}
	
	//Lectura de una cadena cualquiera
	public static String introString (String mensaje) {
		
		//Variables
		String cad;
		
		//Peticion por teclado de una cadena
		System.out.printf("%s", mensaje);
		cad=teclado.nextLine();
		
		//Devolvemos la cadena
		return cad;
	}
	
	//Lectura de una cadena por patron
	public static String introString (String mensaje, String patron) {
		
		//Variables
		String cad;
		boolean error;
		
		//Peticion por teclado de una cadena
		do {
			System.out.printf("%s", mensaje);
			cad=teclado.nextLine();
			
			//Si la cadena no cumple el patron
			if (cad.matches(patron) == false) {
				System.out.printf("ERROR: La cadena introducida no corresponde con el patron indicado\n\n");
				error=true;
			}
			else error=false;
		} while (error);
		
		//Devolvemos la cadena
		return cad;
	}
	
	//Lectura de un booleano
	public static boolean introBoolean(String mensaje, String v, String f) {
		
		//Variables
		String cad;
		boolean error;
		
		//Pedimos por teclado la respuesta 
		do {
			cad=introString(mensaje);
			
			//Comprobamos si lo introducido es un valor valido para v y f
			if (cad.equalsIgnoreCase(v) || cad.equalsIgnoreCase(f)) error=false;
			else {
				System.out.printf("ERROR: EL valor introducido no coincide con el indicado\n\n");
				error=true;
			}
		} while (error);
		
		//Comprobamos si el valor corresponde a v o y
		if (cad.equalsIgnoreCase(v)) error=true;
		else error=false;
		
		//Devolver el booleano
		return error;
	}
	
	//Lectura un numero cualquiera (byte)
	public static byte introByte (String mensaje) {
		
		//Variables
		byte num=0;
		boolean error;
		
		//Peticion por teclado de un numero
		do {
			//Si no se introduce un tipo byte capturamos la excepcion
			try {
				System.out.printf("%s", mensaje);
				num=teclado.nextByte();
				error=false;
			} catch (InputMismatchException e) {
				System.out.printf("ERROR: No has introducido un valor valido\n\n");
				teclado.nextLine(); //Limpiar buffer
				error=true;
			}
		} while (error);
		
		//Limpiar buffer por si despues pedimos una cadena
		teclado.nextLine(); 
		
		//Devolvemos el numero
		return num;
	}

	//Lectura de un numero >, >=, < o <= que un numero pasado por parametros (byte)
	public static byte introByte (String mensaje, int valor, int opcion) {
		
		//Variables
		byte num=0;
		boolean error=true;
		
		//Peticion por teclado de un numero
		do {
			//Si no se introduce un tipo byte capturamos la excepcion
			try {
				System.out.printf("%s", mensaje);
				num=teclado.nextByte();
				
				//Evaluamos si cumple la condicion de opcion
				switch (opcion) {
				
				//Mayor o igual que valor minimo
				case 0: 
					if (num < valor) {
						System.out.printf("ERROR: El numero introducido no es mayor o igual que %d\n\n",valor);
					} else error=false;
				break;

				//Menor o igual que valor maximo
				case 1:  
					if (num > valor) {
						System.out.printf("ERROR: El numero introducido no es menor o igual que %d\n\n",valor);
					} else error=false;
				break;

				//Mayor que valor minimo
				case 2:
					if (num <= valor) {
						System.out.printf("ERROR: El numero introducido no es mayor que %d\n\n",valor);
					} else error=false;
				break;

				//Menor que valor maximo
				case 3:
					if (num >= valor) {
						System.out.printf("ERROR: El numero introducido no es menor que %d\n\n",valor);
					} else error=false;
				break;
				}
			} catch (InputMismatchException e) {
				System.out.printf("ERROR: No has introducido un valor valido\n\n");
				teclado.nextLine(); //Limpiar buffer
			}
		} while (error);
		
		//Limpiar buffer por si despues pedimos una cadena
		teclado.nextLine(); 
		
		//Devolvemos el numero
		return num;
	}
	
	//Lectura de un numero de un rango (byte)
	public static byte introByte (String mensaje, int min, int max, int opcion) {
		
		//Variables
		byte num=0;
		boolean error=true;
		
		//Peticion por teclado de un numero
		do {
			//Si no se introduce un tipo byte capturamos la excepcion
			try {
				System.out.printf("%s", mensaje);
				num=teclado.nextByte();
				
				//Evaluamos si cumple la condicion de opcion
				switch (opcion) {
				
				//Rango con ambos incluidos
				case 0: 
					if (num >= min && num <= max) error=false;
					else System.out.printf("ERROR: El numero introducido no se encuentra dentro del rango %d - %d, ambos incluidos\n\n", min, max);
				break;

				//Rango con ambos excluidos
				case 1:  
					if (num > min && num < max) error=false;
					else System.out.printf("ERROR: El numero introducido no se encuentra dentro del rango %d - %d, ambos excluidos\n\n", min, max);
				break;

				//Rango con min incluido y max excluido
				case 2:
					if (num >= min && num < max) error=false;
					else System.out.printf("ERROR: El numero introducido no se encuentra dentro del rango %d(incl) - %d(excl)\n\n", min, max);
				break;

				//Rango con min excluido y max incluido
				case 3:
					if (num > min && num <= max) error=false;
					else System.out.printf("ERROR: El numero introducido no se encuentra dentro del rango %d(excl) - %d(incl)\n\n", min, max);
				break;
				}
			} catch (InputMismatchException e) {
				System.out.printf("ERROR: No has introducido un valor valido\n\n");
				teclado.nextLine(); //Limpiar buffer
			}
		} while (error);
		
		//Limpiar buffer por si despues pedimos una cadena
		teclado.nextLine(); 
		
		//Devolvemos el numero
		return num;
	}
	
	//Lectura un numero cualquiera (short)
	public static short introShort (String mensaje) {
		
		//Variables
		short num=0;
		boolean error;
		
		//Peticion por teclado de un numero
		do {
			//Si no se introduce un tipo short capturamos la excepcion
			try {
				System.out.printf("%s", mensaje);
				num=teclado.nextShort();
				error=false;
			} catch (InputMismatchException e) {
				System.out.printf("ERROR: No has introducido un valor valido\n\n");
				teclado.nextLine(); //Limpiar buffer
				error=true;
			}
		} while (error);
		
		//Limpiar buffer por si despues pedimos una cadena
		teclado.nextLine(); 
		
		//Devolvemos el numero
		return num;
	}

	//Lectura de un numero >, >=, < o <= que un numero pasado por parametros (short)
	public static short introShort (String mensaje, int valor, int opcion) {
		
		//Variables
		short num=0;
		boolean error=true;
		
		//Peticion por teclado de un numero
		do {
			//Si no se introduce un tipo short capturamos la excepcion
			try {
				System.out.printf("%s", mensaje);
				num=teclado.nextShort();
				
				//Evaluamos si cumple la condicion de opcion
				switch (opcion) {
				
				//Mayor o igual que valor minimo
				case 0: 
					if (num < valor) {
						System.out.printf("ERROR: El numero introducido no es mayor o igual que %d\n\n",valor);
					} else error=false;
				break;

				//Menor o igual que valor maximo
				case 1:  
					if (num > valor) {
						System.out.printf("ERROR: El numero introducido no es menor o igual que %d\n\n",valor);
					} else error=false;
				break;

				//Mayor que valor minimo
				case 2:
					if (num <= valor) {
						System.out.printf("ERROR: El numero introducido no es mayor que %d\n\n",valor);
					} else error=false;
				break;

				//Menor que valor maximo
				case 3:
					if (num >= valor) {
						System.out.printf("ERROR: El numero introducido no es menor que %d\n\n",valor);
					} else error=false;
				break;
				}
			} catch (InputMismatchException e) {
				System.out.printf("ERROR: No has introducido un valor valido\n\n");
				teclado.nextLine(); //Limpiar buffer
			}
		} while (error);
		
		//Limpiar buffer por si despues pedimos una cadena
		teclado.nextLine(); 
		
		//Devolvemos el numero
		return num;
	}
	
	//Lectura de un numero de un rango (short)
	public static short introShort (String mensaje, int min, int max, int opcion) {
		
		//Variables
		short num=0;
		boolean error=true;
		
		//Peticion por teclado de un numero
		do {
			//Si no se introduce un tipo short capturamos la excepcion
			try {
				System.out.printf("%s", mensaje);
				num=teclado.nextShort();
				
				//Evaluamos si cumple la condicion de opcion
				switch (opcion) {
				
				//Rango con ambos incluidos
				case 0: 
					if (num >= min && num <= max) error=false;
					else System.out.printf("ERROR: El numero introducido no se encuentra dentro del rango %d - %d, ambos incluidos\n\n", min, max);
				break;

				//Rango con ambos excluidos
				case 1:  
					if (num > min && num < max) error=false;
					else System.out.printf("ERROR: El numero introducido no se encuentra dentro del rango %d - %d, ambos excluidos\n\n", min, max);
				break;

				//Rango con min incluido y max excluido
				case 2:
					if (num >= min && num < max) error=false;
					else System.out.printf("ERROR: El numero introducido no se encuentra dentro del rango %d(incl) - %d(excl)\n\n", min, max);
				break;

				//Rango con min excluido y max incluido
				case 3:
					if (num > min && num <= max) error=false;
					else System.out.printf("ERROR: El numero introducido no se encuentra dentro del rango %d(excl) - %d(incl)\n\n", min, max);
				break;
				}
			} catch (InputMismatchException e) {
				System.out.printf("ERROR: No has introducido un valor valido\n\n");
				teclado.nextLine(); //Limpiar buffer
			}
		} while (error);
		
		//Limpiar buffer por si despues pedimos una cadena
		teclado.nextLine(); 
		
		//Devolvemos el numero
		return num;
	}
	
	//Lectura un numero cualquiera (int)
	public static int introInt (String mensaje) {
		
		//Variables
		int num=0;
		boolean error;
		
		//Peticion por teclado de un numero
		do {
			//Si no se introduce un tipo int capturamos la excepcion
			try {
				System.out.printf("%s", mensaje);
				num=teclado.nextInt();
				error=false;
			} catch (InputMismatchException e) {
				System.out.printf("ERROR: No has introducido un valor valido\n\n");
				teclado.nextLine(); //Limpiar buffer
				error=true;
			}
		} while (error);
		
		//Limpiar buffer por si despues pedimos una cadena
		teclado.nextLine(); 
		
		//Devolvemos el numero
		return num;
	}

	//Lectura de un numero >, >=, < o <= que un numero pasado por parametros (int)
	public static int introInt (String mensaje, int valor, int opcion) {
		
		//Variables
		int num=0;
		boolean error=true;
		
		//Peticion por teclado de un numero
		do {
			//Si no se introduce un tipo int capturamos la excepcion
			try {
				System.out.printf("%s", mensaje);
				num=teclado.nextInt();
				
				//Evaluamos si cumple la condicion de opcion
				switch (opcion) {
				
				//Mayor o igual que valor minimo
				case 0: 
					if (num < valor) {
						System.out.printf("ERROR: El numero introducido no es mayor o igual que %d\n\n",valor);
					} else error=false;
				break;

				//Menor o igual que valor maximo
				case 1:  
					if (num > valor) {
						System.out.printf("ERROR: El numero introducido no es menor o igual que %d\n\n",valor);
					} else error=false;
				break;

				//Mayor que valor minimo
				case 2:
					if (num <= valor) {
						System.out.printf("ERROR: El numero introducido no es mayor que %d\n\n",valor);
					} else error=false;
				break;

				//Menor que valor maximo
				case 3:
					if (num >= valor) {
						System.out.printf("ERROR: El numero introducido no es menor que %d\n\n",valor);
					} else error=false;
				break;
				}
			} catch (InputMismatchException e) {
				System.out.printf("ERROR: No has introducido un valor valido\n\n");
				teclado.nextLine(); //Limpiar buffer
			}
		} while (error);
		
		//Limpiar buffer por si despues pedimos una cadena
		teclado.nextLine(); 
		
		//Devolvemos el numero
		return num;
	}
	
	//Lectura de un numero de un rango (int)
	public static int introInt (String mensaje, int min, int max, int opcion) {
		
		//Variables
		int num=0;
		boolean error=true;
		
		//Peticion por teclado de un numero
		do {
			//Si no se introduce un tipo int capturamos la excepcion
			try {
				System.out.printf("%s", mensaje);
				num=teclado.nextInt();
				
				//Evaluamos si cumple la condicion de opcion
				switch (opcion) {
				
				//Rango con ambos incluidos
				case 0: 
					if (num >= min && num <= max) error=false;
					else System.out.printf("ERROR: El numero introducido no se encuentra dentro del rango %d - %d, ambos incluidos\n\n", min, max);
				break;

				//Rango con ambos excluidos
				case 1:  
					if (num > min && num < max) error=false;
					else System.out.printf("ERROR: El numero introducido no se encuentra dentro del rango %d - %d, ambos excluidos\n\n", min, max);
				break;

				//Rango con min incluido y max excluido
				case 2:
					if (num >= min && num < max) error=false;
					else System.out.printf("ERROR: El numero introducido no se encuentra dentro del rango %d(incl) - %d(excl)\n\n", min, max);
				break;

				//Rango con min excluido y max incluido
				case 3:
					if (num > min && num <= max) error=false;
					else System.out.printf("ERROR: El numero introducido no se encuentra dentro del rango %d(excl) - %d(incl)\n\n", min, max);
				break;
				}
			} catch (InputMismatchException e) {
				System.out.printf("ERROR: No has introducido un valor valido\n\n");
				teclado.nextLine(); //Limpiar buffer
			}
		} while (error);
		
		//Limpiar buffer por si despues pedimos una cadena
		teclado.nextLine(); 
		
		//Devolvemos el numero
		return num;
	}
	
	//Lectura un numero cualquiera (long)
	public static long introLong (String mensaje) {
		
		//Variables
		long num=0;
		boolean error;
		
		//Peticion por teclado de un numero
		do {
			//Si no se introduce un tipo long capturamos la excepcion
			try {
				System.out.printf("%s", mensaje);
				num=teclado.nextLong();
				error=false;
			} catch (InputMismatchException e) {
				System.out.printf("ERROR: No has introducido un valor valido\n\n");
				teclado.nextLine(); //Limpiar buffer
				error=true;
			}
		} while (error);
		
		//Limpiar buffer por si despues pedimos una cadena
		teclado.nextLine(); 
		
		//Devolvemos el numero
		return num;
	}

	//Lectura de un numero >, >=, < o <= que un numero pasado por parametros (long)
	public static long introLong (String mensaje, int valor, int opcion) {
		
		//Variables
		long num=0;
		boolean error=true;
		
		//Peticion por teclado de un numero
		do {
			//Si no se introduce un tipo long capturamos la excepcion
			try {
				System.out.printf("%s", mensaje);
				num=teclado.nextLong();
				
				//Evaluamos si cumple la condicion de opcion
				switch (opcion) {
				
				//Mayor o igual que valor minimo
				case 0: 
					if (num < valor) {
						System.out.printf("ERROR: El numero introducido no es mayor o igual que %d\n\n",valor);
					} else error=false;
				break;

				//Menor o igual que valor maximo
				case 1:  
					if (num > valor) {
						System.out.printf("ERROR: El numero introducido no es menor o igual que %d\n\n",valor);
					} else error=false;
				break;

				//Mayor que valor minimo
				case 2:
					if (num <= valor) {
						System.out.printf("ERROR: El numero introducido no es mayor que %d\n\n",valor);
					} else error=false;
				break;

				//Menor que valor maximo
				case 3:
					if (num >= valor) {
						System.out.printf("ERROR: El numero introducido no es menor que %d\n\n",valor);
					} else error=false;
				break;
				}
			} catch (InputMismatchException e) {
				System.out.printf("ERROR: No has introducido un valor valido\n\n");
				teclado.nextLine(); //Limpiar buffer
			}
		} while (error);
		
		//Limpiar buffer por si despues pedimos una cadena
		teclado.nextLine(); 
		
		//Devolvemos el numero
		return num;
	}
	
	//Lectura de un numero de un rango (long)
	public static long introLong (String mensaje, int min, int max, int opcion) {
		
		//Variables
		long num=0;
		boolean error=true;
		
		//Peticion por teclado de un numero
		do {
			//Si no se introduce un tipo long capturamos la excepcion
			try {
				System.out.printf("%s", mensaje);
				num=teclado.nextLong();
				
				//Evaluamos si cumple la condicion de opcion
				switch (opcion) {
				
				//Rango con ambos incluidos
				case 0: 
					if (num >= min && num <= max) error=false;
					else System.out.printf("ERROR: El numero introducido no se encuentra dentro del rango %d - %d, ambos incluidos\n\n", min, max);
				break;

				//Rango con ambos excluidos
				case 1:  
					if (num > min && num < max) error=false;
					else System.out.printf("ERROR: El numero introducido no se encuentra dentro del rango %d - %d, ambos excluidos\n\n", min, max);
				break;

				//Rango con min incluido y max excluido
				case 2:
					if (num >= min && num < max) error=false;
					else System.out.printf("ERROR: El numero introducido no se encuentra dentro del rango %d(incl) - %d(excl)\n\n", min, max);
				break;

				//Rango con min excluido y max incluido
				case 3:
					if (num > min && num <= max) error=false;
					else System.out.printf("ERROR: El numero introducido no se encuentra dentro del rango %d(excl) - %d(incl)\n\n", min, max);
				break;
				}
			} catch (InputMismatchException e) {
				System.out.printf("ERROR: No has introducido un valor valido\n\n");
				teclado.nextLine(); //Limpiar buffer
			}
		} while (error);
		
		//Limpiar buffer por si despues pedimos una cadena
		teclado.nextLine(); 
		
		//Devolvemos el numero
		return num;
	}
	
	//Lectura un numero cualquiera (float)
	public static float introFloat (String mensaje) {
		
		//Variables
		float num=0;
		boolean error;
		
		//Peticion por teclado de un numero
		do {
			//Si no se introduce un tipo float capturamos la excepcion
			try {
				System.out.printf("%s", mensaje);
				num=teclado.nextFloat();
				error=false;
			} catch (InputMismatchException e) {
				System.out.printf("ERROR: No has introducido un valor valido\n\n");
				teclado.nextLine(); //Limpiar buffer
				error=true;
			}
		} while (error);
		
		//Limpiar buffer por si despues pedimos una cadena
		teclado.nextLine(); 
		
		//Devolvemos el numero
		return num;
	}

	//Lectura de un numero >, >=, < o <= que un numero pasado por parametros (float)
	public static float introFloat (String mensaje, int valor, int opcion) {
		
		//Variables
		float num=0;
		boolean error=true;
		
		//Peticion por teclado de un numero
		do {
			//Si no se introduce un tipo float capturamos la excepcion
			try {
				System.out.printf("%s", mensaje);
				num=teclado.nextFloat();
				
				//Evaluamos si cumple la condicion de opcion
				switch (opcion) {
				
				//Mayor o igual que valor minimo
				case 0: 
					if (num < valor) {
						System.out.printf("ERROR: El numero introducido no es mayor o igual que %d\n\n",valor);
					} else error=false;
				break;

				//Menor o igual que valor maximo
				case 1:  
					if (num > valor) {
						System.out.printf("ERROR: El numero introducido no es menor o igual que %d\n\n",valor);
					} else error=false;
				break;

				//Mayor que valor minimo
				case 2:
					if (num <= valor) {
						System.out.printf("ERROR: El numero introducido no es mayor que %d\n\n",valor);
					} else error=false;
				break;

				//Menor que valor maximo
				case 3:
					if (num >= valor) {
						System.out.printf("ERROR: El numero introducido no es menor que %d\n\n",valor);
					} else error=false;
				break;
				}
			} catch (InputMismatchException e) {
				System.out.printf("ERROR: No has introducido un valor valido\n\n");
				teclado.nextLine(); //Limpiar buffer
			}
		} while (error);
		
		//Limpiar buffer por si despues pedimos una cadena
		teclado.nextLine(); 
		
		//Devolvemos el numero
		return num;
	}
	
	//Lectura de un numero de un rango (float)
	public static float introFloat (String mensaje, int min, int max, int opcion) {
		
		//Variables
		float num=0;
		boolean error=true;
		
		//Peticion por teclado de un numero
		do {
			//Si no se introduce un tipo float capturamos la excepcion
			try {
				System.out.printf("%s", mensaje);
				num=teclado.nextFloat();
				
				//Evaluamos si cumple la condicion de opcion
				switch (opcion) {
				
				//Rango con ambos incluidos
				case 0: 
					if (num >= min && num <= max) error=false;
					else System.out.printf("ERROR: El numero introducido no se encuentra dentro del rango %d - %d, ambos incluidos\n\n", min, max);
				break;

				//Rango con ambos excluidos
				case 1:  
					if (num > min && num < max) error=false;
					else System.out.printf("ERROR: El numero introducido no se encuentra dentro del rango %d - %d, ambos excluidos\n\n", min, max);
				break;

				//Rango con min incluido y max excluido
				case 2:
					if (num >= min && num < max) error=false;
					else System.out.printf("ERROR: El numero introducido no se encuentra dentro del rango %d(incl) - %d(excl)\n\n", min, max);
				break;

				//Rango con min excluido y max incluido
				case 3:
					if (num > min && num <= max) error=false;
					else System.out.printf("ERROR: El numero introducido no se encuentra dentro del rango %d(excl) - %d(incl)\n\n", min, max);
				break;
				}
			} catch (InputMismatchException e) {
				System.out.printf("ERROR: No has introducido un valor valido\n\n");
				teclado.nextLine(); //Limpiar buffer
			}
		} while (error);
		
		//Limpiar buffer por si despues pedimos una cadena
		teclado.nextLine(); 
		
		//Devolvemos el numero
		return num;
	}
	
	//Lectura un numero cualquiera (double)
	public static double introDouble (String mensaje) {
		
		//Variables
		double num=0;
		boolean error;
		
		//Peticion por teclado de un numero
		do {
			//Si no se introduce un tipo double capturamos la excepcion
			try {
				System.out.printf("%s", mensaje);
				num=teclado.nextDouble();
				error=false;
			} catch (InputMismatchException e) {
				System.out.printf("ERROR: No has introducido un valor valido\n\n");
				teclado.nextLine(); //Limpiar buffer
				error=true;
			}
		} while (error);
		
		//Limpiar buffer por si despues pedimos una cadena
		teclado.nextLine(); 
		
		//Devolvemos el numero
		return num;
	}

	//Lectura de un numero >, >=, < o <= que un numero pasado por parametros (double)
	public static double introDouble (String mensaje, int valor, int opcion) {
		
		//Variables
		double num=0;
		boolean error=true;
		
		//Peticion por teclado de un numero
		do {
			//Si no se introduce un tipo double capturamos la excepcion
			try {
				System.out.printf("%s", mensaje);
				num=teclado.nextDouble();
				
				//Evaluamos si cumple la condicion de opcion
				switch (opcion) {
				
				//Mayor o igual que valor minimo
				case 0: 
					if (num < valor) {
						System.out.printf("ERROR: El numero introducido no es mayor o igual que %d\n\n",valor);
					} else error=false;
				break;

				//Menor o igual que valor maximo
				case 1:  
					if (num > valor) {
						System.out.printf("ERROR: El numero introducido no es menor o igual que %d\n\n",valor);
					} else error=false;
				break;

				//Mayor que valor minimo
				case 2:
					if (num <= valor) {
						System.out.printf("ERROR: El numero introducido no es mayor que %d\n\n",valor);
					} else error=false;
				break;

				//Menor que valor maximo
				case 3:
					if (num >= valor) {
						System.out.printf("ERROR: El numero introducido no es menor que %d\n\n",valor);
					} else error=false;
				break;
				}
			} catch (InputMismatchException e) {
				System.out.printf("ERROR: No has introducido un valor valido\n\n");
				teclado.nextLine(); //Limpiar buffer
			}
		} while (error);
		
		//Limpiar buffer por si despues pedimos una cadena
		teclado.nextLine(); 
		
		//Devolvemos el numero
		return num;
	}
	
	//Lectura de un numero de un rango (double)
	public static double introDouble (String mensaje, int min, int max, int opcion) {
		
		//Variables
		double num=0;
		boolean error=true;
		
		//Peticion por teclado de un numero
		do {
			//Si no se introduce un tipo double capturamos la excepcion
			try {
				System.out.printf("%s", mensaje);
				num=teclado.nextDouble();
				
				//Evaluamos si cumple la condicion de opcion
				switch (opcion) {
				
				//Rango con ambos incluidos
				case 0: 
					if (num >= min && num <= max) error=false;
					else System.out.printf("ERROR: El numero introducido no se encuentra dentro del rango %d - %d, ambos incluidos\n\n", min, max);
				break;

				//Rango con ambos excluidos
				case 1:  
					if (num > min && num < max) error=false;
					else System.out.printf("ERROR: El numero introducido no se encuentra dentro del rango %d - %d, ambos excluidos\n\n", min, max);
				break;

				//Rango con min incluido y max excluido
				case 2:
					if (num >= min && num < max) error=false;
					else System.out.printf("ERROR: El numero introducido no se encuentra dentro del rango %d(incl) - %d(excl)\n\n", min, max);
				break;

				//Rango con min excluido y max incluido
				case 3:
					if (num > min && num <= max) error=false;
					else System.out.printf("ERROR: El numero introducido no se encuentra dentro del rango %d(excl) - %d(incl)\n\n", min, max);
				break;
				}
			} catch (InputMismatchException e) {
				System.out.printf("ERROR: No has introducido un valor valido\n\n");
				teclado.nextLine(); //Limpiar buffer
			}
		} while (error);
		
		//Limpiar buffer por si despues pedimos una cadena
		teclado.nextLine(); 
		
		//Devolvemos el numero
		return num;
	}
	
	//Cerrar Teclado
	public static void CerrarTeclado () {
		teclado.close();
	}
	
//------------------------- METODOS DE SALIDA -------------------------//
	
}
