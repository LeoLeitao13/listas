public class Rota {
    public int id;
    public String nomeLinha;
    public String tipo;
    public String regiao;

    //Construtor
    public Rota(int id, String nomeLinha, String tipo, String regiao) {
        this.id = id;
        this.nomeLinha = nomeLinha;
        this.tipo = tipo;
        this.regiao = regiao;
    }

    //O metodo to strig vai formatar a saída para a impressão em tela
    @Override
    public String toString() {
        return "ID: " + id + " | Linha: " + nomeLinha + " | Tipo: " + tipo + " | Região: " + regiao;
    }
}