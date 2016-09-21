package pruebasArguments;

public class PruebasArguments {
	/*
	 * assoc .xargp=xargpfile
	 * ftype xargpfile=%JAVA_HOME%\bin\java -jar C:\Users\USUARIO\arg.jar -file %1 %*
	 */
	
	
	public static void main(String[] args) {
		for (String string : args){
			System.out.println("arg: "+string);
		}
	}

}
