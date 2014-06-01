package com.ijunes.timer.core;

import javax.persistence.*;

/**
 * Created by kang on 6/1/2014.
 */
@Entity
@Table(name = "machine")
@NamedQueries({
        @NamedQuery(
                name = "com.ijunes.timer.core.Machine.findAll",
                query = "SELECT m FROM Machine m"
        ),
        @NamedQuery(
                name = "com.ijunes.timer.core.Machine.findById",
                query = "SELECT m FROM Machine m WHERE m.id = :id"
        )
})
public class Machine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "machineId", nullable = false)
    private String fullName;

    @Column(name = "jobTitle", nullable = false)
    private String jobTitle;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}
