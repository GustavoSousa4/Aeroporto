import java.lang.reflect.*;

public class Lista<X> {
    private class No {
        private X info;
        private No prox;

        public No(X i, No p) {
            this.info = i;
            this.prox = p;
        }

        public No(X i) {
            this.info = i;
            this.prox = null;
        }

        public X getInfo() {
            return this.info;
        }

        public No getProx() {
            return this.prox;
        }

        public void setInfo(X i) {
            this.info = i;
        }

        public void setProx(No p) {
            this.prox = p;
        }
    }

    private No primeiro, ultimo;

    public Lista() {
        this.primeiro = this.ultimo = null;
    }

    private X meuCloneDeX(X x) {
        X ret = null;

        try {
            Class<?> classe = x.getClass();
            Method metodo = classe.getMethod("clone");
            ret = (X) metodo.invoke(x);
        } catch (NoSuchMethodException erro) {
        } catch (IllegalAccessException erro) {
        } catch (InvocationTargetException erro) {
        }

        return ret;
    }

    public void guardeUmItemNoInicio(X i) throws Exception {
        if (i == null)
            throw new Exception("Informacao ausente");

        X inserir = null;
        if (i instanceof Cloneable)
            inserir = (X) meuCloneDeX(i);
        else
            inserir = i;

        this.primeiro = new No(inserir, this.primeiro);

        if (this.ultimo == null)
            this.ultimo = this.primeiro;
    }

    public void guardeUmItemNoFinal(X i) throws Exception {
        if (i == null)
            throw new Exception("Informacao ausente");

        X inserir = null;
        if (i instanceof Cloneable)
            inserir = (X) meuCloneDeX(i);
        else
            inserir = i;

        if (this.ultimo == null) {
            this.ultimo = new No(inserir);
            this.primeiro = this.ultimo;
        } else {
            this.ultimo.setProx(new No(inserir));
            this.ultimo = this.ultimo.getProx();
        }
    }

    // Invertendo a lista
    public void inverterLista() throws Exception {
        Lista<X> lista = this.getReverse();
        this.primeiro = lista.primeiro;
        this.ultimo = lista.ultimo;
    }

    // Retornando a lista invertida
    public Lista<X> getReverse() throws Exception {
        Lista<X> listaSimplesDesordenada = new Lista<>();
        for (No atual = this.primeiro; atual != null; atual = atual.getProx())
            try {
                listaSimplesDesordenada.guardeUmItemNoInicio(atual.getInfo());
            } catch (Exception e) {
            }
        return listaSimplesDesordenada;
    }

    public X recupereItemDoInicio() throws Exception {
        if (this.primeiro == null)
            throw new Exception("Nada a obter");

        X ret = this.primeiro.getInfo();
        if (ret instanceof Cloneable)
            ret = meuCloneDeX(ret);

        return ret;
    }

    public X recupereItemDoFinal() throws Exception {
        if (this.primeiro == null)
            throw new Exception("Nada a obter");

        X ret = this.ultimo.getInfo();
        if (ret instanceof Cloneable)
            ret = meuCloneDeX(ret);

        return ret;
    }

    public void removaItemDoInicio() throws Exception {
        if (this.primeiro == null)
            throw new Exception("Nada a remover");

        if (this.primeiro == this.ultimo) {
            this.primeiro = this.ultimo = null;
            return;
        }

        this.primeiro = this.primeiro.getProx();
    }

    public void removaItemDoFinal() throws Exception {
        if (this.primeiro == null)
            throw new Exception("Nada a remover");
        if (this.primeiro == this.ultimo) {
            this.primeiro = this.ultimo = null;
            return;
        }

        No atual;
        for (atual = this.primeiro; atual.getProx() != this.ultimo; atual = atual.getProx())
            atual.setProx(null);
        this.ultimo = atual;
    }

    public void removaItemNoIndex(int index)throws Exception{
        if(index < 0) throw new Exception("Index inválido");
        No anterior = null, atual = this.primeiro, proximo = atual.getProx();

        for(int i = 0; i < index; i++) {
            anterior = atual;
            atual = proximo;
            proximo = atual.getProx();
        }
        anterior.setProx(proximo);
        atual = null;

    }
    public void removaInfo(X info)throws Exception{
        if(info == null) throw new Exception("Infomação vazia");
        No anterior = null, atual = this.primeiro, proximo = atual.getProx();
        while(!atual.getInfo().equals(info)){
            anterior = atual;
            atual = proximo;
            proximo = atual.getProx();
        }
        anterior.setProx(proximo);
        atual = null;
    }
    public int getQuantidade() {
        No atual = this.primeiro;
        int ret = 0;

        while (atual != null) {
            ret++;
            atual = atual.getProx();
        }

        return ret;
    }

    // Concatenando a Lista passada como parametro à this
    public Lista<X> concatenando(Lista<X> lis) throws Exception {
        if (lis == null)
            throw new Exception("Lista vazia");
        for (No prox = lis.primeiro; prox != null; prox = prox.getProx())
            this.guardeUmItemNoFinal(prox.getInfo());
        return this;
    }

    // Verifica quais itens são iguais e retorna dentro de uma nova lista
    public Lista<X> elemIguais(Lista<X> lis) throws Exception {
        if (lis == null)
            throw new Exception("Lista vazia");
        Lista<X> ret = new Lista<>();
        No atual, prox;
        for (prox = lis.primeiro; prox != null; prox = prox.getProx()) {
            for (atual = this.primeiro; atual != null; atual = atual.getProx()) {
                if (atual.getInfo().equals(prox.getInfo()))
                    ret.guardeUmItemNoFinal(atual.getInfo());
            }
        }
        return ret;
    }

    // Retorna a informação pedida pela iezima posição da Lista
    public X getIezima(int i) throws Exception {
        if (i < 0)
            throw new Exception("Posição invalida");
        No atual = this.primeiro;
        int posi = 0;
        for (;;) {
            if (atual == null)
                throw new Exception("Posição inválida");
            if (posi == i) {
                if (atual.getInfo() instanceof Cloneable)
                    return meuCloneDeX(atual.getInfo());
                else
                    return atual.getInfo();
            }
            posi++;
            atual = atual.getProx();
        }
    }

    /*
     * Retorna em String se há mais de uma informação igual ao passado pelo
     * parametro
     * dentro da mesma lista
     */
    public String getQuantidadeElement(X info) throws Exception {
        if (info == null)
            throw new Exception("Informacao ausente");
        No atual = this.primeiro;
        int ret = 0;
        while (atual != null) {
            if (atual.getInfo().equals(info))
                ret++;
            atual = atual.getProx();
        }
        if (ret == 1)
            return "A lista não possui '" + info + "' se repetindo";
        return "A lista possui: " + ret + " elementos iguais";

    }

    // retorna o tamanho da Lista
    public int getTamanhoLista() throws Exception {

        int contador = 0;
        No atual = this.primeiro;
        while (atual != null) {
            contador++;
            atual = atual.getProx();
        }
        return contador;
    }

    public boolean tem(X i) throws Exception {
        if (i == null)
            throw new Exception("Informacao ausente");

        No atual = this.primeiro;

        while (atual != null) {
            if (i.equals(atual.getInfo()))
                return true;

            atual = atual.getProx();
        }

        return false;
    }

    public void removaItemIndicado(X i) throws Exception {
        if (i == null)
            throw new Exception("Informacao ausente");

        boolean removeu = false;

        for (;;) {
            if (this.primeiro == null)
                break;

            if (!i.equals(this.primeiro.getInfo()))
                break;

            if (this.ultimo == this.primeiro)
                this.ultimo = null;

            this.primeiro = this.primeiro.getProx();

            removeu = true;
        }

        if (this.primeiro != null) {
            No atual = this.primeiro;

            forever: for (;;) {
                if (atual.getProx() == null)
                    break;

                while (i.equals(atual.getProx().getInfo())) {
                    if (this.ultimo == atual.getProx())
                        this.ultimo = atual;

                    atual.setProx(atual.getProx().getProx());

                    removeu = true;

                    if (atual == this.ultimo)
                        break forever;
                }

                atual = atual.getProx();
            }
        }

        if (!removeu)
            throw new Exception("Informacao inexistente");
    }

    public int indexOf(X value) throws Exception {
        if(value == null) throw new Exception();

        int count = 0;
        for(No current = this.primeiro; current != null; current = current.getProx()) {
            if(current.getInfo().equals(value))
                return count;
            count++;
        }
        return -1;
    }

    public boolean isVazia() {
        return this.primeiro == null;
    }

    public String toString() {
        String ret = "[";

        No atual = this.primeiro;

        while (atual != null) {
            ret = ret + atual.getInfo();

            if (atual != this.ultimo)
                ret = ret + ",";

            atual = atual.getProx();
        }

        return ret + "]";
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (this.getClass() != obj.getClass())
            return false;

        Lista<X> lista = (Lista<X>) obj;

        No atualThis = this.primeiro;
        No atualLista = lista.primeiro;

        while (atualThis != null && atualLista != null) {
            if (!atualThis.getInfo().equals(atualLista.getInfo()))
                return false;
            atualThis = atualThis.getProx();
            atualLista = atualLista.getProx();
        }

        if (atualThis != null)
            return false;

        if (atualLista != null)
            return false;
        return true;
    }

    public int hashCode() {
        final int PRIMO = 13; // qualquer número primo serve

        int ret = 666; // qualquer inteiro positivo serve

        for (No atual = this.primeiro; atual != null; atual = atual.getProx())
            ret = PRIMO * ret + atual.getInfo().hashCode();

        if (ret < 0)
            ret = -ret;
        return ret;
    }

    // construtor de copia
    public Lista(Lista<X> modelo) throws Exception {
        if (modelo == null)
            throw new Exception("Modelo ausente");

        if (modelo.primeiro == null)
            return; // sai do construtor, pq this.primeiro ja é null

        this.primeiro = new No(modelo.primeiro.getInfo());

        No atualDoThis = this.primeiro;
        No atualDoModelo = modelo.primeiro.getProx();

        while (atualDoModelo != null) {
            atualDoThis.setProx(new No(atualDoModelo.getInfo()));
            atualDoThis = atualDoThis.getProx();
            atualDoModelo = atualDoModelo.getProx();
        }

        this.ultimo = atualDoThis;
    }

    public Object clone() {
        Lista<X> ret = null;

        try {
            ret = new Lista(this);
        } catch (Exception erro) {
        }

        return ret;
    }
}