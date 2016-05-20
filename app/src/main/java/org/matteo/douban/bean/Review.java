package org.matteo.douban.bean;

import java.io.Serializable;

/**
 * Created by matteo on 2015/6/19.
 */
public class Review  implements Serializable {
    private String id;
    private String title;
    private String alt;
    private String subject_id;
    private User author;

}
