package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinkedList<Veiculo> lista = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        String nomeArquivo = "rodizio_de_veiculos.txt";

        // Solicitar critério ao usuário
        System.out.println("Escolha o critério de filtro:");
        System.out.println("1 - Placa final");
        System.out.println("2 - Dia da semana");
        int criterio = scanner.nextInt();
        scanner.nextLine();

        String valorFiltro;
        if (criterio == 1) {
            System.out.print("Digite o final da placa (0-9): ");
            valorFiltro = scanner.nextLine();
        } else {
            System.out.print("Digite o dia da semana (ex: Segunda, Terça): ");
            valorFiltro = scanner.nextLine();
        }

        // Carregar dados do arquivo e aplicar o filtro
        LinkedList<Veiculo> listaFiltrada = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes.length == 2) {
                    String placa = partes[0].trim();
                    String diaSemana = partes[1].trim();
                    Veiculo veiculo = new Veiculo(placa, diaSemana);
                    // Adicionar à lista completa
                    lista.add(veiculo);
                    // Adicionar à lista filtrada se atender ao critério
                    if (criterio == 1 && placa.endsWith(valorFiltro)) {
                        listaFiltrada.add(veiculo);
                    } else if (criterio == 2 && diaSemana.equalsIgnoreCase(valorFiltro)) {
                        listaFiltrada.add(veiculo);
                    }
                }
            }
            System.out.println("Veículos carregados com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            scanner.close();
            return;
        }

        // Exibir a lista filtrada completa
        if (!listaFiltrada.isEmpty()) {
            System.out.println("\nVeículos filtrados (" + listaFiltrada.size() + " encontrados):");
            for (Veiculo veiculo : listaFiltrada) {
                System.out.println(veiculo);
            }
        } else {
            System.out.println("Nenhum veículo encontrado para o critério especificado.");
            scanner.close();
            return;
        }

        // Navegação circular pela lista filtrada
        int indiceAtual = 0;
        boolean continuar = true;

        while (continuar) {
            // Exibir o veículo atual
            System.out.println("\nVeículo atual (" + (indiceAtual + 1) + "/" + listaFiltrada.size() + "):");
            System.out.println(listaFiltrada.get(indiceAtual));

            // Menu de navegação
            System.out.println("\nOpções:");
            System.out.println("1 - Próximo veículo");
            System.out.println("2 - Veículo anterior");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1: // Próximo
                    indiceAtual = (indiceAtual + 1) % listaFiltrada.size(); // Volta ao início se chegar ao fim
                    break;
                case 2: // Anterior
                    indiceAtual = (indiceAtual - 1 + listaFiltrada.size()) % listaFiltrada.size(); // Volta ao fim se estiver no início
                    break;
                case 3: // Sair
                    continuar = false;
                    System.out.println("Encerrando a navegação.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Erro na exibição: " + e.getMessage());
            }
        }

        scanner.close();
    }
}