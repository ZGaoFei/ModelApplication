package com.zgf.modelapplication.model;

import java.util.List;


public class CurrentCosmeticTrialModel {

    private int code;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private int cosmeticId;
        private String title;
        private String headImg;
        private int limits;
        private int applyNum;
        private String leftTime;
        private String shareImg;
        private String shareContent;

        public int getCosmeticId() {
            return cosmeticId;
        }

        public void setCosmeticId(int cosmeticId) {
            this.cosmeticId = cosmeticId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getHeadImg() {
            return headImg;
        }

        public void setHeadImg(String headImg) {
            this.headImg = headImg;
        }

        public int getLimits() {
            return limits;
        }

        public void setLimits(int limits) {
            this.limits = limits;
        }

        public int getApplyNum() {
            return applyNum;
        }

        public void setApplyNum(int applyNum) {
            this.applyNum = applyNum;
        }

        public String getLeftTime() {
            return leftTime;
        }

        public void setLeftTime(String leftTime) {
            this.leftTime = leftTime;
        }

        public String getShareImg() {
            return shareImg;
        }

        public void setShareImg(String shareImg) {
            this.shareImg = shareImg;
        }

        public String getShareContent() {
            return shareContent;
        }

        public void setShareContent(String shareContent) {
            this.shareContent = shareContent;
        }
    }
}
