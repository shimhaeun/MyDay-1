package org.ict.myday.Diary;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

    public class Diary {

        @SerializedName("dno")
        @Expose
        private Integer dno;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("content")
        @Expose
        private String content;
        @SerializedName("regdate")
        @Expose
        private String regdate;
        @SerializedName("image")
        @Expose
        private String image;
        @SerializedName("mno")
        @Expose
        private Integer mno;

        public Integer getDno() {
            return dno;
        }

        public void setDno(Integer dno) {
            this.dno = dno;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getRegdate() {
            return regdate;
        }

        public void setRegdate(String regdate) {
            this.regdate = regdate;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public Integer getMno() {
            return mno;
        }

        public void setMno(Integer mno) {
            this.mno = mno;
        }

    }
