package org.ict.myday.Login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginDTO {

    @SerializedName("mno")
    @Expose
    public Integer mno;

    @SerializedName("mid")
    @Expose
    public String mid;

    @SerializedName("mpw")
    @Expose
    public String mpw;

    public Integer getMno() { return mno; }

    public void setMno(Integer mno) { this.mno = mno; }

    public String getMid() { return mid; }

    public void setMid(String mid) { this.mid = mid; }

    public String getMpw() { return mpw; }

    public void setMpw(String mpw) { this.mpw = mpw; }
}
