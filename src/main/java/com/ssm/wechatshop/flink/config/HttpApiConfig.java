
package com.ssm.wechatshop.flink.config;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * galileo: HttpApiConfig
 *
 * @author wanghao
 * @version 2019-12-10 09:31
 */
@Data
@Accessors(chain = true)
public class HttpApiConfig implements Serializable {
    private static final long serialVersionUID = 2610933320891024832L;

    public HttpApiConfig() {
    }

    private String host;

    private String apiPath;

    private String username;

    private String password;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getApiPath() {
        return apiPath;
    }

    public void setApiPath(String apiPath) {
        this.apiPath = apiPath;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
