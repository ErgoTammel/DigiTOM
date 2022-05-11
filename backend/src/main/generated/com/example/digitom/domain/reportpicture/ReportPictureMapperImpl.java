package com.example.digitom.domain.reportpicture;

import com.example.digitom.domain.report.Report;
import com.example.digitom.domain.task.Task;
import com.example.digitom.service.image.ReportPictureRequest;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-11T14:59:23+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14.1 (Amazon.com Inc.)"
)
@Component
public class ReportPictureMapperImpl implements ReportPictureMapper {

    @Override
    public ReportPicture requestToReportPicture(ReportPictureRequest reportPictureRequest) {
        if ( reportPictureRequest == null ) {
            return null;
        }

        ReportPicture reportPicture = new ReportPicture();

        reportPicture.setReport( reportPictureRequestToReport( reportPictureRequest ) );
        reportPicture.setTask( reportPictureRequestToTask( reportPictureRequest ) );
        reportPicture.setBase64( ReportPictureMapper.stringToByteArray( reportPictureRequest.getBase64() ) );

        return reportPicture;
    }

    protected Report reportPictureRequestToReport(ReportPictureRequest reportPictureRequest) {
        if ( reportPictureRequest == null ) {
            return null;
        }

        Report report = new Report();

        report.setId( reportPictureRequest.getReportId() );

        return report;
    }

    protected Task reportPictureRequestToTask(ReportPictureRequest reportPictureRequest) {
        if ( reportPictureRequest == null ) {
            return null;
        }

        Task task = new Task();

        task.setId( reportPictureRequest.getTaskId() );

        return task;
    }
}
