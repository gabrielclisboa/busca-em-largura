public class Vertice {
    Vertice(String nome, Boolean visitado) {
        this.nome = nome;
        this.visitado = visitado;
    }
    private String nome;
    private Boolean visitado;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getVisitado() {
        return visitado;
    }

    public void setVisitado(Boolean visitado) {
        this.visitado = visitado;
    }

}
