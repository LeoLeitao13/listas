import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
//Lgc
public class ListaRotas {
    private LinkedList<Rota> lista;

    public ListaRotas() {
        lista = new LinkedList<>(); //usamos o linkedlist para armazenar as rotas
    }

    public void adicionar(int id, String nomeLinha, String tipo, String regiao) {
        Rota novaRota = new Rota(id, nomeLinha, tipo, regiao);
        lista.addLast(novaRota);
    }

    //esse metodo lê e filtra o arquivo com base no tipo igual
    public void carregar(String nomeArquivo, String filtro) {
        try {
            BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo));
            String linha;
            while ((linha = leitor.readLine()) != null) {
                String[] partes = linha.split(" ");
                if (partes.length == 4) {
                    int id = Integer.parseInt(partes[0]);
                    String nomeLinha = partes[1];
                    String tipo = partes[2];
                    String regiao = partes[3];

                    if (tipo.equalsIgnoreCase(filtro) || regiao.equalsIgnoreCase(filtro)) {
                        adicionar(id, nomeLinha, tipo, regiao);
                    }
                }
            }
            leitor.close();
        } catch (IOException e) {
            System.out.println("Erro ao abrir o arquivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Erro ao converter ID: " + e.getMessage());
        }
    }

    public void imprimirInicioFim() {
        System.out.println("\nRotas do início ao fim:");
        if (lista.isEmpty()) {
            System.out.println("Nenhuma rota encontrada.");
            return;
        }
        for (Rota rota : lista) {
            System.out.println(rota);
        }
    }

    public void imprimirFimInicio() {
        System.out.println("\nRotas do fim ao início:");
        if (lista.isEmpty()) {
            System.out.println("Nenhuma rota encontrada.");
            return;
        }
        for (int i = lista.size() - 1; i >= 0; i--) {
            System.out.println(lista.get(i));
        }
    }
}