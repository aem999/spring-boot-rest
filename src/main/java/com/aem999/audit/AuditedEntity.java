package com.aem999.audit;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

/**
 * Abstract base class for auditable entities.
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AuditedEntity implements Auditable {

    protected static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    @JsonIgnore
    @CreatedBy
    private String createdBy;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT, timezone = "UTC")
    @CreatedDate
    private Date createdDate;

    @JsonIgnore
    @LastModifiedBy
    private String lastModifiedBy;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT, timezone = "UTC")
    @LastModifiedDate
    private Date lastModifiedDate;


    @Override
    public String getCreatedBy() {
        return createdBy;
    }

    @Override
    public Date getCreatedDate() {
        return createdDate;
    }

    @Override
    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    @Override
    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }
}
