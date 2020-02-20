package com.bawei.hujintao.model.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Time:2020/2/18 0018上午 9:29202002
 * 邮箱:2094158527@qq.com
 * 作者:李庆瑶
 * 类功能:
 */
@Entity
public class JsonSqlite {
    @Id(autoincrement = true)
    Long id;
    String json;
    @Generated(hash = 489908297)
    public JsonSqlite(Long id, String json) {
        this.id = id;
        this.json = json;
    }
    @Generated(hash = 1890786739)
    public JsonSqlite() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getJson() {
        return this.json;
    }
    public void setJson(String json) {
        this.json = json;
    }
}
