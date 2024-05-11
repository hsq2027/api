package com.ldrobot.bean;

/**
 * 创建时间：2020/2/21  13:53
 * 作者：5#
 * 描述：TODO
 */
public class STSBean {

    /**
     * accessKeySecret : BraBrekn9zFjWnz7TRrG9hSxHLqkqN8s8UhzJ6CXTd7T
     * accessKeyId : STS.NTS6XRHqbWQePUd2rQ7KexFJe
     * expiration : 1583241416
     * securityToken : CAIS+wJ1q6Ft5B2yfSjIr5fmfeLmpa5D4JOOUnPV1nIEO8RJl4Phhzz2IHxPdXFtAO8WtPozlWhU6voflqMqFs8eHxebPZIutmCdMu9DJdivgde8yJBZoiPMewHKeRKZsebWZ+LmNqS/Ht6md1HDkAJq3LL+bk/Mdle5MJqP+/EFA9MMRVv6F2gkYu1bPQx/ssQXGGLMPPK2SH7Qj3HXEVBjt3gK6xd24r/txdaHuFiMzg/+xqoOu5+2P4OpdY42bNA9IdTXscVycq3eqmQyjzFB6KZxioFd5D7DpavzKlJN4hKAQYi2ktp0N11Wa7R4YfgmysLxjvploOfeup3qwhJWR4FvXj/YWZqrzbmOequgPc1rcq3gaTafkIKLOtzurxhjanUeMQRMPMc6J2U3Sz5UE2yLdfD8oQCQPlf4GvnbgJtbi8Qlkw/amvORPEWKTrmj1iIVB4QxdUtANWRNgTewKvJfLFwWLQ82X+rJEdhpARRSsr/zrcVgyKuGAvI9GoABobB9oOBbtz1FgQr08Wh7+5MXsU8aK5cOO3Sn5XclFSWFf8LJrun4zIVRq3eZ3pT6LsaJgASlcpfCkzCopV68NIr+p4BZjBURc/mG7Un6SULRbXLf8AQd5VrVRX0sPf8lraRYbjuZRhZN7PW8D9j34Qu0tGk6yxIZIIM3QJ28hEU=
     * endpoint : oss-cn-beijing.aliyuncs.com
     * bucketName : ld-sts
     */

    private String accessKeySecret;
    private String accessKeyId;
    private int expiration;
    private String securityToken;
    private String endpoint;
    private String bucketName;

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public int getExpiration() {
        return expiration;
    }

    public void setExpiration(int expiration) {
        this.expiration = expiration;
    }

    public String getSecurityToken() {
        return securityToken;
    }

    public void setSecurityToken(String securityToken) {
        this.securityToken = securityToken;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    @Override
    public String toString() {
        return "STSBean{" +
                "accessKeySecret='" + accessKeySecret + '\'' +
                ", accessKeyId='" + accessKeyId + '\'' +
                ", expiration=" + expiration +
                ", securityToken='" + securityToken + '\'' +
                ", endpoint='" + endpoint + '\'' +
                ", bucketName='" + bucketName + '\'' +
                '}';
    }
}