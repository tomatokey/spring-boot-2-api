package com.tomatokey.prototype.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDateTime;

public abstract class Entity {

    public static final String COLUMN_NAME_REGISTER_TIME = "register_time";
    public static final String COLUMN_NAME_UPDATE_TIME = "update_time";

    @CreatedDate
    @Column(COLUMN_NAME_REGISTER_TIME)
    @JsonSerialize
    private LocalDateTime registerTime;

    @LastModifiedDate
    @Column(COLUMN_NAME_UPDATE_TIME)
    @JsonSerialize
    private LocalDateTime updateTime;

}
