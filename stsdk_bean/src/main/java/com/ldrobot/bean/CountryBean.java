package com.ldrobot.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by msl
 * on 2022/4/6
 */
public class CountryBean implements Parcelable {

    public String areaName;
    public String code;
    public String domainAbbreviation;
    public String isoCode;
    public String pinyin;
    public String sortLetters;

    public CountryBean(){}

    protected CountryBean(Parcel in) {
        areaName = in.readString();
        code = in.readString();
        domainAbbreviation = in.readString();
        isoCode = in.readString();
        pinyin = in.readString();
        sortLetters = in.readString();
    }

    public static final Creator<CountryBean> CREATOR = new Creator<CountryBean>() {
        @Override
        public CountryBean createFromParcel(Parcel in) {
            return new CountryBean(in);
        }

        @Override
        public CountryBean[] newArray(int size) {
            return new CountryBean[size];
        }
    };

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDomainAbbreviation() {
        return domainAbbreviation;
    }

    public void setDomainAbbreviation(String domainAbbreviation) {
        this.domainAbbreviation = domainAbbreviation;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getSortLetters() {
        return sortLetters;
    }

    public void setSortLetters(String sortLetters) {
        this.sortLetters = sortLetters;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(areaName);
        dest.writeString(code);
        dest.writeString(domainAbbreviation);
        dest.writeString(isoCode);
        dest.writeString(pinyin);
        dest.writeString(sortLetters);
    }
}