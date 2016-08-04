package com.avlasenko.sb.fmmanager.model;

import javax.persistence.*;

/**
 * Created by A. Vlasenko on 19.07.2016.
 */
@Entity
@Table(name = "fm_info")
@NamedQuery(name = FmInfo.GET_BY_OWNER, query = "SELECT i.fmInfo FROM Individual i WHERE i.id=:ownerId")
public class FmInfo extends BaseEntity {
    public static final String GET_BY_OWNER = "FmInfo.getByOwner";

    @Column(name = "service_history")
    private String serviceHistory;

    @Embedded
    private IncomeSources incomeSources;

    public FmInfo() {
    }

    public FmInfo(Integer id, String serviceHistory, IncomeSources incomeSources) {
        super(id);
        this.serviceHistory = serviceHistory;
        this.incomeSources = incomeSources;
    }

    @Override
    public String toString() {
        return "FmInfo{" +
                "serviceHistory='" + serviceHistory + '\'' +
                ", incomeSources=" + incomeSources +
                "} " + super.toString();
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
