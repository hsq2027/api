package com.ldrobot.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by MOSL
 * on 2021/11/11
 */
public class AiArea implements Parcelable{

    private double time;
    private ArrayList<AreaMsg> area;

    protected AiArea(Parcel in) {
        time = in.readDouble();
        area = in.createTypedArrayList(AreaMsg.CREATOR);
    }

    public static final Creator<AiArea> CREATOR = new Creator<AiArea>() {
        @Override
        public AiArea createFromParcel(Parcel in) {
            return new AiArea(in);
        }

        @Override
        public AiArea[] newArray(int size) {
            return new AiArea[size];
        }
    };

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public ArrayList<AreaMsg> getArea() {
        return area;
    }

    public void setArea(ArrayList<AreaMsg> area) {
        this.area = area;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(time);
        dest.writeTypedList(area);
    }

    public static class AreaMsg implements Parcelable{
        private int id;
        private double time;
        private int label = -1;
        private AreaPos pose;
        private String img_url;
        private float confidence;

        //本地字段，用于保存计算出的像素坐标
        private float pixelX;
        private float pixelY;

        protected AreaMsg(Parcel in) {
            id = in.readInt();
            time = in.readDouble();
            label = in.readInt();
            pose = in.readParcelable(AreaPos.class.getClassLoader());
            img_url = in.readString();
            confidence = in.readFloat();
            pixelX = in.readFloat();
            pixelY = in.readFloat();
        }

        public static final Creator<AreaMsg> CREATOR = new Creator<AreaMsg>() {
            @Override
            public AreaMsg createFromParcel(Parcel in) {
                return new AreaMsg(in);
            }

            @Override
            public AreaMsg[] newArray(int size) {
                return new AreaMsg[size];
            }
        };

        public float getPixelX() {
            return pixelX;
        }

        public void setPixelX(float pixelX) {
            this.pixelX = pixelX;
        }

        public float getPixelY() {
            return pixelY;
        }

        public void setPixelY(float pixelY) {
            this.pixelY = pixelY;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }


        public int getLabel() {
            return label;
        }

        public void setLabel(int label) {
            this.label = label;
        }

        public AreaPos getPos() {
            return pose;
        }

        public void setPos(AreaPos pos) {
            this.pose = pos;
        }

        public String getImg_url() {
            return img_url;
        }

        public void setImg_url(String img_url) {
            this.img_url = img_url;
        }

        public double getTime() {
            return time;
        }

        public void setTime(double time) {
            this.time = time;
        }

        public float getConfidence() {
            return confidence;
        }

        public void setConfidence(float confidence) {
            this.confidence = confidence;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(id);
            dest.writeDouble(time);
            dest.writeInt(label);
            dest.writeParcelable(pose, flags);
            dest.writeString(img_url);
            dest.writeFloat(confidence);
            dest.writeFloat(pixelX);
            dest.writeFloat(pixelY);
        }

        public static class AreaPos implements Parcelable {
            float x;
            float y;
            float phi;

            protected AreaPos(Parcel in) {
                x = in.readFloat();
                y = in.readFloat();
                phi = in.readFloat();
            }

            public static final Creator<AreaPos> CREATOR = new Creator<AreaPos>() {
                @Override
                public AreaPos createFromParcel(Parcel in) {
                    return new AreaPos(in);
                }

                @Override
                public AreaPos[] newArray(int size) {
                    return new AreaPos[size];
                }
            };

            public float getX() {
                return x;
            }

            public void setX(float x) {
                this.x = x;
            }

            public float getY() {
                return y;
            }

            public void setY(float y) {
                this.y = y;
            }

            public float getPhi() {
                return phi;
            }

            public void setPhi(float phi) {
                this.phi = phi;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeFloat(x);
                dest.writeFloat(y);
                dest.writeFloat(phi);
            }
        }
    }


}

