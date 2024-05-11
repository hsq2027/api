package com.ldrobot.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建时间：2020/4/13  16:21
 * 作者：5#
 * 描述：TODO
 * 注意：
 */
public class ProductGuideBean implements Parcelable {

    /**
     * productKey : a1AqHQUFWB1
     * data : [{"country":"cn","content":[{"title":"隐私协议","url":"https://ldsfile.scvrobot.com/html/a124PnYvAjlIVjCb/cn/1.html"},{"title":"免责协议","url":"https://ldsfile.scvrobot.com/html/a124PnYvAjlIVjCb/cn/1.html"},{"title":"用户协议","url":"https://ldsfile.scvrobot.com/html/a124PnYvAjlIVjCb/cn/1.html"}]},{"country":"en","content":[{"title":"隐私协议","url":"https://ldsfile.scvrobot.com/html/a124PnYvAjlIVjCb/cn/1.html"},{"title":"免责协议","url":"https://ldsfile.scvrobot.com/html/a124PnYvAjlIVjCb/cn/1.html"},{"title":"用户协议","url":"https://ldsfile.scvrobot.com/html/a124PnYvAjlIVjCb/cn/1.html"}]}]
     */

    private String productKey;
    private String productName;
    private String productImage;
    private List<DataBean> data;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductKey() {
        return productKey;
    }

    public void setProductKey(String productKey) {
        this.productKey = productKey;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Parcelable {
        /**
         * country : cn
         * content : [{"title":"隐私协议","url":"https://ldsfile.scvrobot.com/html/a124PnYvAjlIVjCb/cn/1.html"},{"title":"免责协议","url":"https://ldsfile.scvrobot.com/html/a124PnYvAjlIVjCb/cn/1.html"},{"title":"用户协议","url":"https://ldsfile.scvrobot.com/html/a124PnYvAjlIVjCb/cn/1.html"}]
         */

        private String country;
        private List<ContentBean> content;

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public List<ContentBean> getContent() {
            return content;
        }

        public void setContent(List<ContentBean> content) {
            this.content = content;
        }

        public static class ContentBean implements Parcelable {
            /**
             * title : 隐私协议
             * url : https://ldsfile.scvrobot.com/html/a124PnYvAjlIVjCb/cn/1.html
             */

            private String title;
            private String url;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }


            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.title);
                dest.writeString(this.url);
            }

            public ContentBean() {
            }

            protected ContentBean(Parcel in) {
                this.title = in.readString();
                this.url = in.readString();
            }

            public static final Creator<ContentBean> CREATOR = new Creator<ContentBean>() {
                @Override
                public ContentBean createFromParcel(Parcel source) {
                    return new ContentBean(source);
                }

                @Override
                public ContentBean[] newArray(int size) {
                    return new ContentBean[size];
                }
            };
        }


        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.country);
            dest.writeList(this.content);
        }

        public DataBean() {
        }

        protected DataBean(Parcel in) {
            this.country = in.readString();
            this.content = new ArrayList<ContentBean>();
            in.readList(this.content, ContentBean.class.getClassLoader());
        }

        public static final Creator<DataBean> CREATOR = new Creator<DataBean>() {
            @Override
            public DataBean createFromParcel(Parcel source) {
                return new DataBean(source);
            }

            @Override
            public DataBean[] newArray(int size) {
                return new DataBean[size];
            }
        };
    }


    public ProductGuideBean() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.productKey);
        dest.writeString(this.productName);
        dest.writeString(this.productImage);
        dest.writeTypedList(this.data);
    }

    protected ProductGuideBean(Parcel in) {
        this.productKey = in.readString();
        this.productName = in.readString();
        this.productImage = in.readString();
        this.data = in.createTypedArrayList(DataBean.CREATOR);
    }

    public static final Creator<ProductGuideBean> CREATOR = new Creator<ProductGuideBean>() {
        @Override
        public ProductGuideBean createFromParcel(Parcel source) {
            return new ProductGuideBean(source);
        }

        @Override
        public ProductGuideBean[] newArray(int size) {
            return new ProductGuideBean[size];
        }
    };
}