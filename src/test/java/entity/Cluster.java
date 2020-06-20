package entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author dunhanson
 * 2020-04-22
 * 集群信息
 */
@Data
public class Cluster implements Serializable {
    /**集群类型**/
    private String type;
    /**哨兵信息**/
    private Sentinel sentinel;
}
