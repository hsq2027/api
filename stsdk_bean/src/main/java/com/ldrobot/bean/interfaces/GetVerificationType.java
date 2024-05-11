package com.ldrobot.bean.interfaces;

/**
 * 获取验证码的类型
 */
public interface GetVerificationType {
    int REGISTER = 1;//注册
    int FORGOT_PWD = 2;//忘记密码（邮箱已绑定）
    int BIND_EMAIL = 3;//编辑/绑定（邮箱未被绑定）
}