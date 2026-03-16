package com.creatip.lms.domain.learning;

import com.creatip.lms.domain.base.LmsAuditableEntity;
import com.creatip.lms.domain.learning.enums.*;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(
    name = "session_enrollment",
    uniqueConstraints = {
        @UniqueConstraint(name = "uq_session_student", columnNames = {"session_id", "student_id"})
    }
)
public class SessionEnrollment extends LmsAuditableEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "session_enrollment_id")
    private Long sessionEnrollmentId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "session_id", nullable = false)
    private CourseSession session;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @Column(name = "enrolled_at", nullable = false)
    private LocalDateTime enrolledAt;

    @Convert(converter = SessionEnrollmentStatusConverter.class)
    @Column(name = "status", nullable = false)
    private SessionEnrollmentStatus status;

    public Long getSessionEnrollmentId() {
        return sessionEnrollmentId;
    }

    public void setSessionEnrollmentId(Long sessionEnrollmentId) {
        this.sessionEnrollmentId = sessionEnrollmentId;
    }

    public CourseSession getSession() {
        return session;
    }

    public void setSession(CourseSession session) {
        this.session = session;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public LocalDateTime getEnrolledAt() {
        return enrolledAt;
    }

    public void setEnrolledAt(LocalDateTime enrolledAt) {
        this.enrolledAt = enrolledAt;
    }

    public SessionEnrollmentStatus getStatus() {
        return status;
    }

    public void setStatus(SessionEnrollmentStatus status) {
        this.status = status;
    }
}