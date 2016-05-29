package com.aem999.audit;

import java.util.Date;

/**
 * Interface for Audited Entities.
 */
public interface Auditable {

    /**
     * Returns the user who created this entity.
     */
    String getCreatedBy();

    /**
     * Returns the date the entity was created.
     */
    Date getCreatedDate();

    /**
     * Returns the user who last modified the entity.
     */
    String getLastModifiedBy();

    /**
     * Returns the date of the last modification.
     */
    Date getLastModifiedDate();
}
