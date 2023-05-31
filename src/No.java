public class No<X> {
        private X info;
        private No<X> proximo;

        public No(X info, No<X> proximo) throws Exception {
            if (info == null)
                throw new Exception("Informação ausente");
            this.info = info;
            this.proximo = proximo;
        }

        public No(X info) throws Exception {
            if (info == null)
                throw new Exception("Informação ausente");
            this.info = info;
        }

        public X getInfo() {
            return this.info;
        }

        public void setInfo(X info) throws Exception {
            if (info == null)
                throw new Exception("Infomação ausente");
            this.info = info;
        }

        public No<X> getProximo() {
            return this.proximo;
        }

        public void setProximo(No<X> proximo) {
            this.proximo = proximo;
        }
}
