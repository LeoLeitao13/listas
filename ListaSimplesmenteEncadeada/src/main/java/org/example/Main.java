package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinkedList<PontoDescarte> lista = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        String nomeArquivo = "pontos_de_descarte.txt";

        // Carregar os pontos do arquivo
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes.length == 2) {
                    String local = partes[0].trim();
                    String tipoMaterial = partes[1].trim();
                    lista.add(new PontoDescarte(local, tipoMaterial));
                }
            }
            System.out.println("Pontos de descarte carregados com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            return;
        }

        // Menu interativo
        int opcao;
        do {
            System.out.println("\n=== Sistema de Pontos de Descarte ===");
            System.out.println("1 - Buscar pontos por tipo de material");
            System.out.println("2 - Mostrar todos os pontos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o tipo de material (ex: Plástico, Vidro, Eletrônicos): ");
                    String tipoMaterial = scanner.nextLine();
                    buscarPorMaterial(lista, tipoMaterial);
                    break;
                case 2:
                    imprimirLista(lista);
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }

    // Metodo para buscar pontos por tipo de material
    private static void buscarPorMaterial(LinkedList<PontoDescarte> lista, String tipoMaterial) {
        boolean encontrado = false;
        System.out.println("\nPontos de descarte que aceitam " + tipoMaterial + ":");

        //foreach entao para cada elemento da lista vai fazer o comando dentro do for
        for (PontoDescarte ponto : lista) {
            if (ponto.getTipoMaterial().equalsIgnoreCase(tipoMaterial)) {
                System.out.println("- " + ponto.getLocal());
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Nenhum ponto descarte encontrado para " + tipoMaterial);
        }
    }

    // Metodo para imprimir toda a lista
    private static void imprimirLista(LinkedList<PontoDescarte> lista) {
        System.out.println("\nLista completa de pontos de descarte:");
        for (PontoDescarte ponto : lista) {
            System.out.println(ponto);
        }
    }
}
