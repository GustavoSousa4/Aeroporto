public class Aeroporto {
    private String cidade, sigla;
    private Lista<Voo> listaVoo;

    public Aeroporto(String cidade, String sigla) throws Exception {
        if (cidade == null)
            throw new Exception("Cidade não pode ser vazio");
        if (sigla == null)
            throw new Exception("Sigla não pode ser vazio");
        if (sigla.length() > 3)
            throw new Exception("Sigla não pode ser maior do que três letras");
        this.cidade = cidade;
        this.sigla = sigla;
        this.listaVoo = new Lista<Voo>();
    }

    public Aeroporto(String cidade, String sigla, Lista<Voo> listaVoo) throws Exception {
        if (cidade == null)
            throw new Exception("Cidade não pode ser vazio");
        if (sigla == null)
            throw new Exception("Sigla não pode ser vazio");
        if (sigla.length() != 3)
            throw new Exception("Sigla não pode ser maior do que três letras");
        if (listaVoo.equals(null))
            throw new Exception("Lista não pode ser nula");
        this.cidade = cidade;
        this.sigla = sigla.toUpperCase();
        this.listaVoo = new Lista<>();
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) throws Exception {
        if (cidade == null)
            throw new Exception("Para alterar, o valor não pode ser nulo");
        this.cidade = cidade;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) throws Exception {
        if (sigla == null)
            throw new Exception("Para alterar, o valor não pode ser nulo");
        this.sigla = sigla;
    }

    public Lista<Voo> getListaDeVoos() {
        return this.listaVoo;
    }

    public void guardeUmVoo(Voo voo) throws Exception {
        if (voo.equals(null))
            throw new Exception("Voo não pode ser nulo");
        this.listaVoo.guardeUmItemNoFinal(voo);
    }

    public void removaVoo(Voo voo) throws Exception {
        if (sigla.equals(null))
            throw new Exception("Sigla não pode ser nulo");
        listaVoo.removaItemIndicado(voo);
        throw new Exception("Voo não encontrado");
    }

    public int getVooIndex(Voo voo) throws Exception {
        if (voo.equals(null))
            throw new Exception("Voo não pode ser nulo");
        return listaVoo.indexOf(voo);
    }

    public Voo getVooInIndex(int i) throws Exception {
        if (i < 0)
            throw new Exception("Index inválido");
        return listaVoo.getIezima(i);
    }

    public void removeVoo(Voo voo) throws Exception {
        if (voo == null)
            throw new Exception("Voo não pode ser nulo");
        listaVoo.removaInfo(voo);
    }

    @Override
    public String toString() {
        String ret;
        ret = "Cidade: " + this.cidade + "\nSigla Aeroporto: " + this.sigla + "\n";

        return ret;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash += 11 * hash + Integer.valueOf(this.cidade).hashCode();
        hash += 11 * hash + Integer.valueOf(this.sigla).hashCode();
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
        return true;
    }

    public Aeroporto(Aeroporto modelo) throws Exception {
        if (modelo == null)
            throw new Exception("Modelo ausente");
        this.cidade = modelo.cidade;
        this.sigla = modelo.sigla;
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