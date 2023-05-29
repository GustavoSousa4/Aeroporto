public class Aeroporto {
    private String cidade, sigla;
    private int cod;

    public Aeroporto(String cidade, String sigla, int cod) throws Exception {
        if (cidade == null)
            throw new Exception("Cidade não pode ser vazio");
        if (sigla == null)
            throw new Exception("Sigla não pode ser vazio");
        if (cod <= 0)
            throw new Exception("Código não pode ser menor ou igual a zero");

        this.cidade = cidade;
        this.sigla = sigla;
        this.cod = cod;
    }

    public String getCidade() {
        return this.cidade;
    }

    public void setCidade(String cidade) throws Exception {
        if (cidade == null)
            throw new Exception("Para alterar, o valor não pode ser nulo");
        this.cidade = cidade;
    }

    public String getSigla() {
        return this.sigla;
    }

    public void setSigla(String sigla) throws Exception {
        if (sigla == null)
            throw new Exception("Para alterar, o valor não pode ser nulo");
        this.sigla = sigla;
    }

    public int getCod() {
        return this.cod;
    }

    public void setCod(int cod) throws Exception {
        if (cod <= 0)
            throw new Exception("Para alterar, o valor não pode ser menor ou igual a zero");
        this.cod = cod;
    }

    @Override
    public String toString() {
        String ret;
        ret = "Cidade: " + this.cidade +
                "\n Sigla Aeroporto: " + this.sigla +
                "\n COD Aeroporto: " + this.cod;

        return ret;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash += 11 * hash + Integer.valueOf(this.cidade);
        hashCode();
        hash += 11 * hash + Integer.valueOf(this.sigla).hashCode();
        hash += 11 * hash + Integer.valueOf(this.cod).hashCode();
        if (hash < 0)
            hash = -hash;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        Aeroporto aero = (Aeroporto) obj;
        if (!this.cidade.equals(aero.cidade))
            return false;
        if (!this.sigla.equals(aero.sigla))
            return false;
        if (!Integer.valueOf(this.cod).equals(aero.cod))
            return false;
        return true;
    }

    public Aeroporto(Aeroporto modelo) throws Exception {
        if (modelo == null)
            throw new Exception("Modelo ausente");
        this.cidade = modelo.cidade;
        this.sigla = modelo.sigla;
        this.cod = modelo.cod;
    }

    public Object clone() {
        Aeroporto ret = null;
        try {
            ret = new Aeroporto(this);
        } catch (Exception erro) {
        }
        return ret;
    }
}
