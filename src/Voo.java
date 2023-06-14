public class Voo {
    private String codVoo, codAeroporto;;

    public Voo(String codAeroporto, String codVoo) throws Exception {
        if (codVoo == null || codVoo.length() != 3)
            throw new Exception("Valores não podem ser menores ou iguais a zero ou diferentes de três");
        if (codAeroporto == null || codVoo.length() != 3)
            throw new Exception("Valores não podem ser menores ou iguais a zero ou diferentes de três");
        this.codAeroporto = codAeroporto;
        this.codVoo = codVoo;
    }

    public String getCodAeroporto() {
        return codAeroporto;
    }

    public void setCodAeroporto(String codAeroporto) throws Exception {
        if (codAeroporto == null || codAeroporto.length() != 3)
            throw new Exception("Valor não pode ser menor ou igual a zero");
        this.codAeroporto = codAeroporto;
    }

    public String getCodVoo() {
        return codVoo;
    }

    public void setCodVoo(String codVoo) throws Exception {
        if (codVoo == null)
            throw new Exception("Valor não pode ser menor ou igual a zero");
        this.codVoo = codVoo;
    }

    @Override
    public String toString() {
        return this.codAeroporto + " " + this.codVoo;
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
        if (!this.codVoo.equals(voo.codVoo))
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