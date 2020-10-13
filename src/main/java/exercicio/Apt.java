package exercicio;


import javax.persistence.*;

@Entity
@Table(name = "apartamento")

public class Apt {
    private Long id;
    private String numero;
    private String bloco;
    private String andar;

    private int versao;

    public Apt() {
    }

    public Apt(String numero,
               String bloco,
               String andar) {
        this.numero = numero;
        this.bloco = bloco;
        this.andar = andar;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public String getBloco() {
        return bloco;
    }

    public String getAndar() {
        return andar;
    }

//    @Column(name = "LANCE_MINIMO")
//    public double getLanceMinimo() {
//        return lanceMinimo;
//    }
//
//    @Transient
//    public String getLanceMinimoMasc() {
//        return Util.doubleToStr(lanceMinimo);
//    }
//
//    @Column(name = "DATA_CADASTRO")
//    public Date getDataCadastro() {
//        return dataCadastro;
//    }
//
//    @Transient
//    public String getDataCadastroMasc() {
//        return Util.dateToStr(dataCadastro);
//    }
//
//    @Column(name = "DATA_VENDA")
//    public Date getDataVenda() {
//        return dataVenda;
//    }
//
//    @Transient
//    public String getDataVendaMasc() {
//        return Util.dateToStr(dataVenda);
//    }
//
//
    // ********* Métodos do Tipo Set *********

    @SuppressWarnings("unused")
    private void setId(Long id) {
        this.id = id;
    }

    @Version
    public int getVersao() {
        return versao;
    }

    public void setVersao(int versao) {
        this.versao = versao;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    public void setAndar(String andar) {
        this.andar = andar;
    }
}

