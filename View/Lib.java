package View;
import java.util.Scanner;

public class Lib {
	
	static Scanner scn = new Scanner(System.in);
	
	public static int verifOpc(int min, int max, int num) {
		while(num < min || num > max) {
			System.out.print("Opção inválida. Digite novamente: ");
			num = scn.nextInt();
		}
		return num;
	}
}
