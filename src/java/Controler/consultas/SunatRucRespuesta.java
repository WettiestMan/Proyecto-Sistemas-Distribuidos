/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controler.consultas;

/**
 *
 * @author santi
 */
import com.fasterxml.jackson.annotation.JsonProperty;

public class SunatRucRespuesta {

    private boolean success;
    private String ruc;

    @JsonProperty("nombre_o_razon_social")
    private String nombreORazonSocial;

    @JsonProperty("estado_del_contribuyente")
    private String estadoDelContribuyente;

    @JsonProperty("condicion_de_domicilio")
    private String condicionDeDomicilio;

    private String ubigeo;

    @JsonProperty("tipo_de_via")
    private String tipoDeVia;

    @JsonProperty("nombre_de_via")
    private String nombreDeVia;

    @JsonProperty("codigo_de_zona")
    private String codigoDeZona;

    @JsonProperty("tipo_de_zona")
    private String tipoDeZona;

    private String numero;
    private String interior;
    private String lote;
    private String dpto;
    private String manzana;
    private String kilometro;
    private String departamento;
    private String provincia;
    private String distrito;
    private String direccion;

    @JsonProperty("direccion_completa")
    private String direccionCompleta;

    @JsonProperty("ultima_actualizacion")
    private String ultimaActualizacion;

    public SunatRucRespuesta() {
    }

    // Getters y Setters
    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }

    public String getRuc() { return ruc; }
    public void setRuc(String ruc) { this.ruc = ruc; }

    public String getNombreORazonSocial() { return nombreORazonSocial; }
    public void setNombreORazonSocial(String nombreORazonSocial) { this.nombreORazonSocial = nombreORazonSocial; }

    public String getEstadoDelContribuyente() { return estadoDelContribuyente; }
    public void setEstadoDelContribuyente(String estadoDelContribuyente) { this.estadoDelContribuyente = estadoDelContribuyente; }

    public String getCondicionDeDomicilio() { return condicionDeDomicilio; }
    public void setCondicionDeDomicilio(String condicionDeDomicilio) { this.condicionDeDomicilio = condicionDeDomicilio; }

    public String getUbigeo() { return ubigeo; }
    public void setUbigeo(String ubigeo) { this.ubigeo = ubigeo; }

    public String getTipoDeVia() { return tipoDeVia; }
    public void setTipoDeVia(String tipoDeVia) { this.tipoDeVia = tipoDeVia; }

    public String getNombreDeVia() { return nombreDeVia; }
    public void setNombreDeVia(String nombreDeVia) { this.nombreDeVia = nombreDeVia; }

    public String getCodigoDeZona() { return codigoDeZona; }
    public void setCodigoDeZona(String codigoDeZona) { this.codigoDeZona = codigoDeZona; }

    public String getTipoDeZona() { return tipoDeZona; }
    public void setTipoDeZona(String tipoDeZona) { this.tipoDeZona = tipoDeZona; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public String getInterior() { return interior; }
    public void setInterior(String interior) { this.interior = interior; }

    public String getLote() { return lote; }
    public void setLote(String lote) { this.lote = lote; }

    public String getDpto() { return dpto; }
    public void setDpto(String dpto) { this.dpto = dpto; }

    public String getManzana() { return manzana; }
    public void setManzana(String manzana) { this.manzana = manzana; }

    public String getKilometro() { return kilometro; }
    public void setKilometro(String kilometro) { this.kilometro = kilometro; }

    public String getDepartamento() { return departamento; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }

    public String getProvincia() { return provincia; }
    public void setProvincia(String provincia) { this.provincia = provincia; }

    public String getDistrito() { return distrito; }
    public void setDistrito(String distrito) { this.distrito = distrito; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getDireccionCompleta() { return direccionCompleta; }
    public void setDireccionCompleta(String direccionCompleta) { this.direccionCompleta = direccionCompleta; }

    public String getUltimaActualizacion() { return ultimaActualizacion; }
    public void setUltimaActualizacion(String ultimaActualizacion) { this.ultimaActualizacion = ultimaActualizacion; }
}