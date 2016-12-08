package com.zgf.modelapplication.model;

import java.util.List;


public class Tea {
    private String errorMessage;
    private List<DataBean> data;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String id;
        private String title;
        private String name;
        private String link;
        private String content;
        private String image;
        private String image_s;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getImage_s() {
            return image_s;
        }

        public void setImage_s(String image_s) {
            this.image_s = image_s;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "id='" + id + '\'' +
                    ", title='" + title + '\'' +
                    ", name='" + name + '\'' +
                    ", link='" + link + '\'' +
                    ", content='" + content + '\'' +
                    ", image='" + image + '\'' +
                    ", image_s='" + image_s + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Tea{" +
                "errorMessage='" + errorMessage + '\'' +
                ", data=" + data +
                '}';
    }
}
