package org.ict.myday.weather2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("tm")
    @Expose
    private String tm;
    @SerializedName("rnum")
    @Expose
    private String rnum;
    @SerializedName("stnId")
    @Expose
    private String stnId;
    @SerializedName("stnNm")
    @Expose
    private String stnNm;
    @SerializedName("ta")
    @Expose
    private String ta;
    @SerializedName("taQcflg")
    @Expose
    private String taQcflg;
    @SerializedName("rn")
    @Expose
    private String rn;
    @SerializedName("rnQcflg")
    @Expose
    private String rnQcflg;
    @SerializedName("ws")
    @Expose
    private String ws;
    @SerializedName("wsQcflg")
    @Expose
    private String wsQcflg;
    @SerializedName("wd")
    @Expose
    private String wd;
    @SerializedName("wdQcflg")
    @Expose
    private String wdQcflg;
    @SerializedName("hm")
    @Expose
    private String hm;
    @SerializedName("hmQcflg")
    @Expose
    private String hmQcflg;
    @SerializedName("pv")
    @Expose
    private String pv;
    @SerializedName("td")
    @Expose
    private String td;
    @SerializedName("pa")
    @Expose
    private String pa;
    @SerializedName("paQcflg")
    @Expose
    private String paQcflg;
    @SerializedName("ps")
    @Expose
    private String ps;
    @SerializedName("psQcflg")
    @Expose
    private String psQcflg;
    @SerializedName("ss")
    @Expose
    private String ss;
    @SerializedName("ssQcflg")
    @Expose
    private String ssQcflg;
    @SerializedName("icsr")
    @Expose
    private String icsr;
    @SerializedName("dsnw")
    @Expose
    private String dsnw;
    @SerializedName("hr3Fhsc")
    @Expose
    private String hr3Fhsc;
    @SerializedName("dc10Tca")
    @Expose
    private String dc10Tca;
    @SerializedName("dc10LmcsCa")
    @Expose
    private String dc10LmcsCa;
    @SerializedName("clfmAbbrCd")
    @Expose
    private String clfmAbbrCd;
    @SerializedName("lcsCh")
    @Expose
    private String lcsCh;
    @SerializedName("vs")
    @Expose
    private String vs;
    @SerializedName("gndSttCd")
    @Expose
    private String gndSttCd;
    @SerializedName("dmstMtphNo")
    @Expose
    private String dmstMtphNo;
    @SerializedName("ts")
    @Expose
    private String ts;
    @SerializedName("tsQcflg")
    @Expose
    private String tsQcflg;
    @SerializedName("m005Te")
    @Expose
    private String m005Te;
    @SerializedName("m01Te")
    @Expose
    private String m01Te;
    @SerializedName("m02Te")
    @Expose
    private String m02Te;
    @SerializedName("m03Te")
    @Expose
    private String m03Te;

    public String getTm() {
        return tm;
    }

    public void setTm(String tm) {
        this.tm = tm;
    }

    public String getRnum() {
        return rnum;
    }

    public void setRnum(String rnum) {
        this.rnum = rnum;
    }

    public String getStnId() {
        return stnId;
    }

    public void setStnId(String stnId) {
        this.stnId = stnId;
    }

    public String getStnNm() {
        return stnNm;
    }

    public void setStnNm(String stnNm) {
        this.stnNm = stnNm;
    }

    public String getTa() {
        return ta;
    }

    public void setTa(String ta) {
        this.ta = ta;
    }

    public String getTaQcflg() {
        return taQcflg;
    }

    public void setTaQcflg(String taQcflg) {
        this.taQcflg = taQcflg;
    }

    public String getRn() {
        return rn;
    }

    public void setRn(String rn) {
        this.rn = rn;
    }

    public String getRnQcflg() {
        return rnQcflg;
    }

    public void setRnQcflg(String rnQcflg) {
        this.rnQcflg = rnQcflg;
    }

    public String getWs() {
        return ws;
    }

    public void setWs(String ws) {
        this.ws = ws;
    }

    public String getWsQcflg() {
        return wsQcflg;
    }

    public void setWsQcflg(String wsQcflg) {
        this.wsQcflg = wsQcflg;
    }

    public String getWd() {
        return wd;
    }

    public void setWd(String wd) {
        this.wd = wd;
    }

    public String getWdQcflg() {
        return wdQcflg;
    }

    public void setWdQcflg(String wdQcflg) {
        this.wdQcflg = wdQcflg;
    }

    public String getHm() {
        return hm;
    }

    public void setHm(String hm) {
        this.hm = hm;
    }

    public String getHmQcflg() {
        return hmQcflg;
    }

    public void setHmQcflg(String hmQcflg) {
        this.hmQcflg = hmQcflg;
    }

    public String getPv() {
        return pv;
    }

    public void setPv(String pv) {
        this.pv = pv;
    }

    public String getTd() {
        return td;
    }

    public void setTd(String td) {
        this.td = td;
    }

    public String getPa() {
        return pa;
    }

    public void setPa(String pa) {
        this.pa = pa;
    }

    public String getPaQcflg() {
        return paQcflg;
    }

    public void setPaQcflg(String paQcflg) {
        this.paQcflg = paQcflg;
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps;
    }

    public String getPsQcflg() {
        return psQcflg;
    }

    public void setPsQcflg(String psQcflg) {
        this.psQcflg = psQcflg;
    }

    public String getSs() {
        return ss;
    }

    public void setSs(String ss) {
        this.ss = ss;
    }

    public String getSsQcflg() {
        return ssQcflg;
    }

    public void setSsQcflg(String ssQcflg) {
        this.ssQcflg = ssQcflg;
    }

    public String getIcsr() {
        return icsr;
    }

    public void setIcsr(String icsr) {
        this.icsr = icsr;
    }

    public String getDsnw() {
        return dsnw;
    }

    public void setDsnw(String dsnw) {
        this.dsnw = dsnw;
    }

    public String getHr3Fhsc() {
        return hr3Fhsc;
    }

    public void setHr3Fhsc(String hr3Fhsc) {
        this.hr3Fhsc = hr3Fhsc;
    }

    public String getDc10Tca() {
        return dc10Tca;
    }

    public void setDc10Tca(String dc10Tca) {
        this.dc10Tca = dc10Tca;
    }

    public String getDc10LmcsCa() {
        return dc10LmcsCa;
    }

    public void setDc10LmcsCa(String dc10LmcsCa) {
        this.dc10LmcsCa = dc10LmcsCa;
    }

    public String getClfmAbbrCd() {
        return clfmAbbrCd;
    }

    public void setClfmAbbrCd(String clfmAbbrCd) {
        this.clfmAbbrCd = clfmAbbrCd;
    }

    public String getLcsCh() {
        return lcsCh;
    }

    public void setLcsCh(String lcsCh) {
        this.lcsCh = lcsCh;
    }

    public String getVs() {
        return vs;
    }

    public void setVs(String vs) {
        this.vs = vs;
    }

    public String getGndSttCd() {
        return gndSttCd;
    }

    public void setGndSttCd(String gndSttCd) {
        this.gndSttCd = gndSttCd;
    }

    public String getDmstMtphNo() {
        return dmstMtphNo;
    }

    public void setDmstMtphNo(String dmstMtphNo) {
        this.dmstMtphNo = dmstMtphNo;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getTsQcflg() {
        return tsQcflg;
    }

    public void setTsQcflg(String tsQcflg) {
        this.tsQcflg = tsQcflg;
    }

    public String getM005Te() {
        return m005Te;
    }

    public void setM005Te(String m005Te) {
        this.m005Te = m005Te;
    }

    public String getM01Te() {
        return m01Te;
    }

    public void setM01Te(String m01Te) {
        this.m01Te = m01Te;
    }

    public String getM02Te() {
        return m02Te;
    }

    public void setM02Te(String m02Te) {
        this.m02Te = m02Te;
    }

    public String getM03Te() {
        return m03Te;
    }

    public void setM03Te(String m03Te) {
        this.m03Te = m03Te;
    }

}