package entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author dunhanson
 * 2020-04-22
 * redis
 */
@Data
public class Redis implements Serializable {
    /**集群类型**/
    private String type;
    /**单节点**/
    private Single single;
    /**集群**/
    private Cluster cluster;
}
