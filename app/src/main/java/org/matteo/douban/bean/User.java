package org.matteo.douban.bean;

import java.io.Serializable;

/**
 * Created by matteo on 2015/6/19.
 */
public class User  implements Serializable {
    private String id;
    private String name;
    private String uid;
    private String signature;
    private String alt;
    private String avatar;
    private Rating rating;
    private String summary;
}
