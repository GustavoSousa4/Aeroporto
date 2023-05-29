public class Voo {
    private int codAeroporto, codVoo;

    public Voo(int codAeroporto, int codVoo) throws Exception {
        if (codAeroporto <= 0 || codVoo <= 0)
            throw new Exception("Valores não podem ser menores ou iguais a zero");
        this.codAeroporto = codAeroporto;
        this.codVoo = codVoo;
    }

    public int getCodAeroporto() {
        return codAeroporto;
    }

    public void setCodAeroporto(int codAeroporto) throws Exception {
        if (codAeroporto <= 0)
            throw new Exception("Valor não pode ser menor ou igual a zero");
        this.codAeroporto = codAeroporto;
    }

    public int getCodVoo() {
        return codVoo;
    }

    public void setCodVoo(int codVoo) throws Exception {
        if (codVoo <= 0)
            throw new Exception("Valor não pode ser menor ou igual a zero");
        this.codVoo = codVoo;
    }

    @Override
    public String toString() {
        return "Código de Aeroporto: " + this.codAeroporto + "\nCódigo de voo: " + this.codVoo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash += 11 * hash + Integer.valueOf(this.codAeroporto).hashCode();
        hash += 11 * hash + Integer.valueOf(this.codVoo).hashCode();
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
        Voo voo = (Voo) obj;
        if (!Integer.valueOf(this.codAeroporto).equals(voo.codAeroporto))
            return false;
        if (!Integer.valueOf(this.codVoo).equals(voo.codVoo))
            return false;
        return true;
    }

    public Voo(Voo modelo) throws Exception {
        if (modelo == null)
            throw new Exception("Modelo ausente");
        this.codAeroporto = modelo.codAeroporto;
        this.codVoo = modelo.codVoo;
    }

    public Object clone() {
        Voo ret = null;
        try {
            ret = new Voo(this);
        } catch (Exception erro) {
        }
        return ret;
    }
}