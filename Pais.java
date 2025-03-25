public class Pais {
    private String sigla;
    private String nome;
    private int qtdeTitulos;
    private int qtdeShows;
    private int qtdeFilmes;
    private double tarifaBasica;
    private double tarifaStandard;
    private double tarifaPremium;

    public Pais(String sigla, String nome, int qtdeTitulos, int qtdeShows,
                int qtdeFilmes, double tarifaBasica, double tarifaStandard,
                double tarifaPremium) {
        this.sigla = sigla;
        this.nome = nome;
        this.qtdeTitulos = qtdeTitulos;
        this.qtdeShows = qtdeShows;
        this.qtdeFilmes = qtdeFilmes;
        this.tarifaBasica = tarifaBasica;
        this.tarifaStandard = tarifaStandard;
        this.tarifaPremium = tarifaPremium;
    }

    public String getSigla() { return sigla; }
    public String getNome() { return nome; }
    public int getQtdeTitulos() { return qtdeTitulos; }
    public int getQtdeShows() { return qtdeShows; }
    public int getQtdeFilmes() { return qtdeFilmes; }
    public double getTarifaBasica() { return tarifaBasica; }
    public double getTarifaStandard() { return tarifaStandard; }
    public double getTarifaPremium() { return tarifaPremium; }

    @Override
    public String toString() {
        return String.format("%s (%s) - Títulos: %d (Shows: %d, Filmes: %d) - Tarifas: Básica: %.2f, Standard: %.2f, Premium: %.2f",
                nome, sigla, qtdeTitulos, qtdeShows, qtdeFilmes,
                tarifaBasica, tarifaStandard, tarifaPremium);
    }
}