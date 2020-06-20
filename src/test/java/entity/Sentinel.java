package entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

/**
 * @author dunhanson
 * 2020-04-22
 * 哨兵信息
 */
@Data
public class Sentinel implements Serializable {
    /**master名称**/
    private String masterName;
    /**密码**/
    private String password;
    /**地址以及端口**/
    private Set<String> hostAndPort;
}
