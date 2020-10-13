package exercicio;

public class AptNaoEncontradoException extends Exception {
    private final static long serialVersionUID = 1;

    private int codigo;

    public AptNaoEncontradoException(String msg) {
        super(msg);
    }

    public AptNaoEncontradoException(int codigo, String msg) {
        super(msg);
        this.codigo = codigo;
    }

    public int getCodigoDeErro() {
        return codigo;
    }
}	