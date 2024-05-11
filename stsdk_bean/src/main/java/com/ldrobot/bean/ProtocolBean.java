package com.ldrobot.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建时间：2020/4/9  16:48
 * 作者：5#
 * 描述：TODO
 * 注意：
 */
public class ProtocolBean implements Parcelable {

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

    public static class ContentBean implements Parcelable{
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

    public ProtocolBean() {
    }

    protected ProtocolBean(Parcel in) {
        this.country = in.readString();
        this.content = new ArrayList<ContentBean>();
        in.readList(this.content, ContentBean.class.getClassLoader());
    }

    public static final Creator<ProtocolBean> CREATOR = new Creator<ProtocolBean>() {
        @Override
        public ProtocolBean createFromParcel(Parcel source) {
            return new ProtocolBean(source);
        }

        @Override
        public ProtocolBean[] newArray(int size) {
            return new ProtocolBean[size];
        }
    };
}