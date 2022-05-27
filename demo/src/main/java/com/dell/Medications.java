package com.dell;

public class Medications {
    
    private String substancia;
    private String cnpj;
    private String laboratorio;
    private String codigoGgrem;
    private String registro;
    private String ean1;
    private String ean2;
    private String ean3;
    private String produto;
    private String apresentacao;
    private String classeTerapeutica;
    private String tipoProduto;
    private String regimePreco;
    private String pfSemImposto;
    private String pmcZero;
    private String restricaoHospitalar;
    private String cap;
    private String confaz87;
    private String icms0;
    private String analiseRecursal;
    private String listaConcessaoCreditoTributario;
    private String comercializacao2020;
    private String tarja;
    
    public String getSubstancia() {
        return substancia;
    }
    public void setSubstancia(String substancia) {
        this.substancia = substancia;
    }
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public String getLaboratorio() {
        return laboratorio;
    }
    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }
    public String getCodigoGgrem() {
        return codigoGgrem;
    }
    public void setCodigoGgrem(String codigoGgrem) {
        this.codigoGgrem = codigoGgrem;
    }
    public String getRegistro() {
        return registro;
    }
    public void setRegistro(String registro) {
        this.registro = registro;
    }
    public String getEan1() {
        return ean1;
    }
    public void setEan1(String ean1) {
        this.ean1 = ean1;
    }
    public String getEan2() {
        return ean2;
    }
    public void setEan2(String ean2) {
        this.ean2 = ean2;
    }
    public String getEan3() {
        return ean3;
    }
    public void setEan3(String ean3) {
        this.ean3 = ean3;
    }
    public String getProduto() {
        return produto;
    }
    public void setProduto(String produto) {
        this.produto = produto;
    }
    public String getApresentacao() {
        return apresentacao;
    }
    public void setApresentacao(String apresentacao) {
        this.apresentacao = apresentacao;
    }
    public String getClasseTerapeutica() {
        return classeTerapeutica;
    }
    public void setClasseTerapeutica(String classeTerapeutica) {
        this.classeTerapeutica = classeTerapeutica;
    }
    public String getTipoProduto() {
        return tipoProduto;
    }
    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }
    public String getRegimePreco() {
        return regimePreco;
    }
    public void setRegimePreco(String regimePreco) {
        this.regimePreco = regimePreco;
    }
    public String getPfSemImposto() {
        return pfSemImposto;
    }
    public void setPfSemImposto(String pfSemImposto) {
        this.pfSemImposto = pfSemImposto;
    }
    public String getPmcZero() {
        return pmcZero;
    }
    public void setPmcZero(String pmcZero) {
        this.pmcZero = pmcZero;
    }
    public String getRestricaoHospitalar() {
        return restricaoHospitalar;
    }
    public void setRestricaoHospitalar(String restricaoHospitalar) {
        this.restricaoHospitalar = restricaoHospitalar;
    }
    public String getCap() {
        return cap;
    }
    public void setCap(String cap) {
        this.cap = cap;
    }
    public String getConfaz87() {
        return confaz87;
    }
    public void setConfaz87(String confaz87) {
        this.confaz87 = confaz87;
    }
    public String getIcms0() {
        return icms0;
    }
    public void setIcms0(String icms0) {
        this.icms0 = icms0;
    }
    public String getAnaliseRecursal() {
        return analiseRecursal;
    }
    public void setAnaliseRecursal(String analiseRecursal) {
        this.analiseRecursal = analiseRecursal;
    }
    public String getListaConcessaoCreditoTributario() {
        return listaConcessaoCreditoTributario;
    }
    public void setListaConcessaoCreditoTributario(String listaConcessaoCreditoTributario) {
        this.listaConcessaoCreditoTributario = listaConcessaoCreditoTributario;
    }
    public String getComercializacao2020() {
        return comercializacao2020;
    }
    public void setComercializacao2020(String comercializacao2020) {
        this.comercializacao2020 = comercializacao2020;
    }
    public String getTarja() {
        return tarja;
    }
    public void setTarja(String tarja) {
        this.tarja = tarja;
    }

    public Medications(String substancia, String cnpj, String laboratorio, String codigoGgrem, String registro,
            String ean1, String ean2, String ean3, String produto, String apresentacao, String classeTerapeutica,
            String tipoProduto, String regimePreco, String pfSemImposto, String pmcZero, String restricaoHospitalar,
            String cap, String confaz87, String icms0, String analiseRecursal, String listaConcessaoCreditoTributario,
            String comercializacao2020, String tarja) {
                
        this.substancia = substancia;
        this.cnpj = cnpj;
        this.laboratorio = laboratorio;
        this.codigoGgrem = codigoGgrem;
        this.registro = registro;
        this.ean1 = ean1;
        this.ean2 = ean2;
        this.ean3 = ean3;
        this.produto = produto;
        this.apresentacao = apresentacao;
        this.classeTerapeutica = classeTerapeutica;
        this.tipoProduto = tipoProduto;
        this.regimePreco = regimePreco;
        this.pfSemImposto = pfSemImposto;
        this.pmcZero = pmcZero;
        this.restricaoHospitalar = restricaoHospitalar;
        this.cap = cap;
        this.confaz87 = confaz87;
        this.icms0 = icms0;
        this.analiseRecursal = analiseRecursal;
        this.listaConcessaoCreditoTributario = listaConcessaoCreditoTributario;
        this.comercializacao2020 = comercializacao2020;
        this.tarja = tarja;
    }


    @Override
    public String toString() {
        return "Medications [analiseRecursal=" + analiseRecursal + ", apresentacao=" + apresentacao + ", cap=" + cap
                + ", classeTerapeutica=" + classeTerapeutica + ", cnpj=" + cnpj + ", codigoGgrem=" + codigoGgrem
                + ", comercializacao2020=" + comercializacao2020 + ", confaz87=" + confaz87 + ", ean1=" + ean1
                + ", ean2=" + ean2 + ", ean3=" + ean3 + ", icms0=" + icms0 + ", laboratorio=" + laboratorio
                + ", listaConcessaoCreditoTributario=" + listaConcessaoCreditoTributario + ", pfSemImposto="
                + pfSemImposto + ", pmcZero=" + pmcZero + ", produto=" + produto + ", regimePreco=" + regimePreco
                + ", registro=" + registro + ", restricaoHospitalar=" + restricaoHospitalar + ", substancia="
                + substancia + ", tarja=" + tarja + ", tipoProduto=" + tipoProduto + "]";
    }
    
    public String returnMedicineBasicInfo(){
        String basicInformation = getSubstancia() + "" + getProduto() + "" + getApresentacao() + getPfSemImposto() + " ";
        return basicInformation;
    }


    
}
