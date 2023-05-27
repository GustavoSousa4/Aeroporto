public class ListaEncadeada<X> {
    private class No{
        private X info;
        private No proximo;
        public No (X info, No proximo)throws Exception{
            if(info == null) throw new Exception("Informação ausente");
            this.info = info;
            this.proximo = proximo;
        }
        public No (X info) throws Exception{
            if(info == null) throw new Exception("Informação ausente");
            this.info = info;
        }
        public X getInfo(){
            return this.info;
        }
        public void setInfo(X info) throws Exception{
            if(info == null) throw new Exception("Infomação ausente");
            this.info = info;
        }
        public No getProximo(){
            return this.proximo;
        }
        public void setProximo(No proximo){
            this.proximo = proximo;
        }
    }

    private No primeiro, ultimo;
    
    public ListaEncadeada(){
        this.primeiro = null;
        this.ultimo = null;
    }

    public void guardeUmItemNoInicio(X i) throws Exception {
        if (i == null)
            throw new Exception("Informacao ausente");
        
        this.primeiro = new No((X) ShallowOrDeepCopy.verificaDeepCopy(i), this.primeiro);
        if(this.ultimo == null)
            this.ultimo = this.primeiro;
    }

    public void removaItemDoInicio() throws Exception {
        if (this.primeiro == null)
            throw new Exception("Nada a remover");

        if (this.primeiro == this.ultimo) 
        {
            this.primeiro = this.ultimo = null;
            return;
        }

        this.primeiro = this.primeiro.getProximo();
    }


    public void guardeUmItemNoFinal(X i) throws Exception {
        if (i == null)
            throw new Exception("Informacao ausente");
        if(this.ultimo == null)
            this.primeiro = this.ultimo = new No((X) ShallowOrDeepCopy.verificaDeepCopy(i));
        else{
            this.ultimo.setProximo(new No((X)ShallowOrDeepCopy.verificaDeepCopy(i)));
        }
    }

    public void removaItemDoFinal() throws Exception {
        if (this.primeiro == null)
            throw new Exception("Nada a remover");
        if (this.primeiro == this.ultimo) {
            this.primeiro = this.ultimo = null;
            return;
        }

        No atual;
        for (atual = this.primeiro; atual.getProximo() != this.ultimo; atual = atual.getProximo())
            atual.setProximo(null);
        this.ultimo = atual;
    }

    public int indexOf(X info) throws Exception{
        int ret = 0;
        if(info == null) throw new Exception("Informação ausente");{
        for(No atual = this.primeiro; atual != null; atual = atual.getProximo())
            if(atual.getInfo().equals(info)) return ret;
            ret++;
        }
        return -1;
    }

    public void setElementoIndexOf(X info, int index) throws Exception{
        int contador = -1;
        if(info == null || index < 0) throw new Exception("Valores não devem ser nulos");
        for(No atual = this.primeiro; atual != null; atual.getProximo())
            if((contador++) == index){
                atual.setInfo(info);
                return;
            }
        throw new Exception("O index é inexitente");
    }

    public int sizeOf(){
        int ret = 0;
        for(No atual = this.primeiro; atual != null; atual.getProximo())
            ret++;
        return ret;
    }

    @Override
    public String toString() {
        String ret = "[";

        No atual = this.primeiro;

        while (atual != null) {
            ret = ret + atual.getInfo();

            if (atual != this.ultimo)
                ret = ret + ",";

            atual = atual.getProximo();
        }

        return ret + "]";
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null) return false;

        if (this.getClass() != obj.getClass()) return false;

        ListaEncadeada<X> lista = (ListaEncadeada<X>) obj;

        No atualThis = this.primeiro;
        No atualLista = lista.primeiro;

        while (atualThis != null && atualLista != null) {
            if (!atualThis.getInfo().equals(atualLista.getInfo())) return false;
            atualThis = atualThis.getProximo();
            atualLista = atualLista.getProximo();
        }

        if (atualThis != null)
            return false;

        if (atualLista != null)
            return false;
        return true;
    }
    @Override
    public int hashCode() {
        final int PRIMO = 13; // qualquer número primo serve

        int ret = 666; // qualquer inteiro positivo serve

        for (No atual = this.primeiro; atual != null; atual = atual.getProximo())
            ret = PRIMO * ret + atual.getInfo().hashCode();

        if (ret < 0) ret = -ret;
        return ret;
    }

    // construtor de copia
    public ListaEncadeada(ListaEncadeada<X> modelo) throws Exception {
        if (modelo == null)
            throw new Exception("Modelo ausente");

        if (modelo.primeiro == null)
            return; // sai do construtor, pq this.primeiro ja é null

        this.primeiro = new No(modelo.primeiro.getInfo());

        No atualDoThis = this.primeiro;
        No atualDoModelo = modelo.primeiro.getProximo();

        while (atualDoModelo != null) {
            atualDoThis.setProximo(new No(atualDoModelo.getInfo()));
            atualDoThis = atualDoThis.getProximo();
            atualDoModelo = atualDoModelo.getProximo();
        }

        this.ultimo = atualDoThis;
    }
    @Override
    public Object clone() {
        ListaEncadeada<X> ret = null;

        try {ret = new ListaEncadeada<X>(this);} 
        catch (Exception erro) {}

        return ret;
    }
}
