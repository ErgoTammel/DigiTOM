package com.example.digitom.domain.reportpicture;

import com.example.digitom.domain.report.Report;
import com.example.digitom.domain.task.Task;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "report_picture", schema = "digi_tom")
public class ReportPicture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "report_id", nullable = false)
    private Report report;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;

    @Column(name = "description")
    private String description;

    @Column(name = "base64", nullable = false)
    private byte[] base64;

}