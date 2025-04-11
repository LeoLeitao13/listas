import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaRotas lista = new ListaRotas();

        System.out.print("Digite o tipo ou região (ex: Metro, Onibus, Trem, Centro, Norte, Sul, Leste, Oeste): ");
        String filtro = scanner.nextLine();

        lista.carregar("C:\\Users\\Leonardo\\Downloads\\drive-download-20250410T235804Z-001\\ListaDupla\\ListaDupla.txt", filtro);
        lista.imprimirInicioFim();
        lista.imprimirFimInicio();

        scanner.close();
    }
}