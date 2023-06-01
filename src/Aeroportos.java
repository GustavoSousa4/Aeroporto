public class Aeroportos {
    private Lista<Aeroporto> listaAeroporto = new Lista<>();
    
    public Aeroportos(Aeroporto aero)throws Exception {
        if(aero==null) throw new Exception("Objeto não pode ser nulo");
        this.listaAeroporto.guardeUmItemNoFinal(aero);;
    }
    public Aeroportos(){}
    public Lista<Aeroporto> getListaAeroporto() {
        return this.listaAeroporto;
    }

    public void setListaAeroporto(Lista<Aeroporto> listaAeroporto)throws Exception {
        if(listaAeroporto==null) throw new Exception("Objeto não pode ser nulo");
        this.listaAeroporto = listaAeroporto;
    }
    public void guardeAeroporto(Aeroporto aero)throws Exception{
        if(aero == null) throw new Exception("Aeroporto não pode ser vazio");
        listaAeroporto.guardeUmItemNoInicio(aero);

    }

    @Override
    public String toString(){
        String ret = "";
        try {
            for(int i = 0; i< this.listaAeroporto.getTamanhoLista();i++){
                ret += this.listaAeroporto.getIezima(i) + ",";
                if(i == this.listaAeroporto.getQuantidade())
                    ret += ".";
            }
        } catch (Exception e) {e.getMessage();}
        return ret;
    }
    @Override
    public int hashCode(){
        int hash = 7;
        try{
            for(int i = 0; i < this.listaAeroporto.getTamanhoLista(); i++){
                hash = hash * 11 + Integer.valueOf(this.listaAeroporto.getIezima(i).hashCode()).hashCode();
            }
        }catch(Exception e){e.getMessage();}
        if(hash<0) hash = -hash;
        return hash;
    }
    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null) return false;
        if(this.getClass() != obj.getClass()) return false;
        Aeroportos aero = (Aeroportos)obj;
        try{
            for(int i = 0; i < this.listaAeroporto.getTamanhoLista(); i++){
                if(!this.listaAeroporto.getIezima(i).equals(aero)) return false;
            }
        }catch(Exception e){e.getMessage();}
        return true;
    }

    public Aeroportos(Aeroportos modelo)throws Exception{
        if(modelo == null) throw new Exception("Modelo ausente");
        this.listaAeroporto = modelo.listaAeroporto;
    }

    public Object clone(){
        Aeroportos ret = null;
        try {ret = new Aeroportos(this);}
        catch (Exception e) {}
        return ret;
    }
}