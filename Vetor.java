public class Vetor {
    private Pais[] paises;
    private int totalPaises;

    public Vetor(int capacidade) {
        this.paises = new Pais[capacidade];
        this.totalPaises = 0;
    }

    public void adicionar(Pais pais) {
        if (totalPaises < paises.length) {
            paises[totalPaises] = pais;
            totalPaises++;
        } else {
            System.err.println("Vetor cheio! Não é possível adicionar mais países.");
        }
    }

    public Pais buscarPorSigla(String sigla) {
        for (int i = 0; i < totalPaises; i++) {
            if (paises[i].getSigla().equalsIgnoreCase(sigla)) {
                return paises[i];
            }
        }
        return null;
    }

    public void ordenarPorNome() {
        for (int i = 0; i < totalPaises - 1; i++) {
            for (int j = 0; j < totalPaises - i - 1; j++) {
                if (paises[j].getNome().compareToIgnoreCase(paises[j+1].getNome()) > 0) {
                    Pais temp = paises[j];
                    paises[j] = paises[j+1];
                    paises[j+1] = temp;
                }
            }
        }
    }

    public void ordenarPorQtdeTitulos() {
        for (int i = 0; i < totalPaises - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < totalPaises; j++) {
                if (paises[j].getQtdeTitulos() > paises[maxIdx].getQtdeTitulos()) {
                    maxIdx = j;
                }
            }
            Pais temp = paises[maxIdx];
            paises[maxIdx] = paises[i];
            paises[i] = temp;
        }
    }

    public void exibirTodos() {
        for (int i = 0; i < totalPaises; i++) {
            System.out.println(paises[i]);
        }
    }

    public void gerarEstatisticas() {
        if (totalPaises == 0) {
            System.out.println("Nenhum dado carregado para gerar estatísticas.");
            return;
        }

        double somaBasica = 0;
        double maiorPremium = Double.MIN_VALUE;
        String paisMaiorPremium = "";

        for (int i = 0; i < totalPaises; i++) {
            somaBasica += paises[i].getTarifaBasica();

            if (paises[i].getTarifaPremium() > maiorPremium) {
                maiorPremium = paises[i].getTarifaPremium();
                paisMaiorPremium = paises[i].getNome();
            }
        }

        System.out.printf("Média das tarifas básicas: %.2f\n", somaBasica / totalPaises);
        System.out.printf("País com tarifa premium mais cara: %s (%.2f)\n", paisMaiorPremium, maiorPremium);
    }
}