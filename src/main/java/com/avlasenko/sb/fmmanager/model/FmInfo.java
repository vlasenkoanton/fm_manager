package com.avlasenko.sb.fmmanager.model;

import javax.persistence.*;

/**
 * Created by A. Vlasenko on 19.07.2016.
 */
@Entity
@Table(name = "fm_info")
@NamedQueries({
        @NamedQuery(name = FmInfo.GET_BY_CLIENT, query = "SELECT c.fmInfo FROM Client c " +
                "WHERE c.fmInfo.id=:id AND c.id=:clientId"),
        @NamedQuery(name = FmInfo.DELETE_BY_CLIENT, query = "DELETE FROM FmInfo f WHERE f.id=:id")
})
public class FmInfo extends BaseEntity {
    public static final String GET_BY_CLIENT = "FmInfo.getByClient";
    public static final String DELETE_BY_CLIENT = "FmInfo.deleteByClient";

    @Column(name = "service_history")
    private String serviceHistory;

    @Embedded
    private IncomeSources incomeSources;

    public FmInfo() {
    }

    public String getServiceHistory() {
        return serviceHistory;
    }

    public void setServiceHistory(String serviceHistory) {
        this.serviceHistory = serviceHistory;
    }

    public IncomeSources getIncomeSources() {
        return incomeSources;
    }

    public void setIncomeSources(IncomeSources incomeSources) {
        this.incomeSources = incomeSources;
    }
}
