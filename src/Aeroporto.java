public class Aeroporto {
    private String cidade, sigla;
    private Lista<Voo> listaVoo;
    private int cod;
    
    public Aeroporto(String cidade, String sigla, int cod) throws Exception {
        if (cidade == null)
        throw new Exception("Cidade não pode ser vazio");
        if (sigla == null)
        throw new Exception("Sigla não pode ser vazio");
        if(cod < 0)
        throw new Exception("Código não pode ser negativo");    
        this.cidade = cidade;
        this.sigla = sigla;
        this.cod=cod;
    }
    public Aeroporto(String cidade, String sigla, Lista<Voo> listaVoo) throws Exception {
        if (cidade == null)
        throw new Exception("Cidade não pode ser vazio");
        if (sigla == null)
        throw new Exception("Sigla não pode ser vazio");
        if(listaVoo.equals(null))
        throw new Exception("Lista não pode ser nula");
        this.cidade = cidade;
        this.sigla = sigla;
        this.listaVoo = new Lista<>();
    }
    
    public int getCod() {
        return cod;
    }
    public void setCod(int cod) {
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

    public void guardeUmVoo(Voo voo)throws Exception{
        if(voo.equals(null)) throw new Exception("Voo não pode ser nulo");
        listaVoo.guardeUmItemNoFinal(voo);
    }
    public int getVooIndex(Voo voo)throws Exception{
        if(voo.equals(null)) throw new Exception("Voo não pode ser nulo");
        return this.listaVoo.indexOf(voo);
    }
    
    public Voo getVooInIndex(int i)throws Exception{
        if(i < 0) throw new Exception("Index inválido");
        return listaVoo.getIezima(i);
    }

    public void removeVoo(Voo voo)throws Exception{
        if(voo == null) throw new Exception("Voo não pode ser nulo");
        this.listaVoo.removaItemIndicado(voo);
    }

    @Override
    public String toString() {
        String ret;
        ret = "Cidade: " + this.cidade +
                "\n Sigla Aeroporto: " + this.sigla;

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