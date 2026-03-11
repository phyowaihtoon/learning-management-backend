-- Complete Final MySQL DDL for Online Learning Platform

-- 1. INSTRUCTOR
CREATE TABLE instructor (
    instructor_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL,
    bio TEXT,
    email VARCHAR(255) NOT NULL UNIQUE,
    profile_image_url VARCHAR(500),
    expertise VARCHAR(255),
    -- previous: status ENUM('ACTIVE', 'INACTIVE') DEFAULT 'ACTIVE',
    status INT NOT NULL,

    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by VARCHAR(255)
);

-- 2. STUDENT
CREATE TABLE student (
    student_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    user_id BIGINT NOT NULL UNIQUE,
    -- previous: status ENUM('ACTIVE', 'INACTIVE') DEFAULT 'ACTIVE',
    status INT NOT NULL,

    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by VARCHAR(255),

    CONSTRAINT fk_student_user
        FOREIGN KEY (user_id)
        REFERENCES creatip_user(id)
);

-- 3. CATEGORY
CREATE TABLE category (
    category_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    category_name VARCHAR(255) NOT NULL,
    description TEXT,
    -- previous: status ENUM('ACTIVE', 'INACTIVE') DEFAULT 'ACTIVE',
    status INT NOT NULL,

    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by VARCHAR(255)
);

-- 4. COURSE
CREATE TABLE course (
    course_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    instructor_id BIGINT NOT NULL,
    category_id BIGINT NOT NULL,
    title VARCHAR(255) NOT NULL,
    overview TEXT,
    description TEXT,
    thumbnail_url VARCHAR(500),
    keyword VARCHAR(500),
    -- previous: course_type ENUM('ONLINE', 'IN_PERSON') NOT NULL,
    course_type INT NOT NULL,
    -- previous: status ENUM('DRAFT', 'PUBLISHED', 'ARCHIVED') DEFAULT 'DRAFT',
    status INT NOT NULL,

    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by VARCHAR(255),

    CONSTRAINT fk_course_instructor
        FOREIGN KEY (instructor_id)
        REFERENCES instructor(instructor_id),
    
    CONSTRAINT fk_course_category
        FOREIGN KEY (category_id)
        REFERENCES category(category_id)
);

-- 5. CHAPTER
CREATE TABLE chapter (
    chapter_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    course_id BIGINT NOT NULL,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    order_no INT NOT NULL,

    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by VARCHAR(255),

    CONSTRAINT fk_chapter_course
        FOREIGN KEY (course_id)
        REFERENCES course(course_id)
        ON DELETE CASCADE
);

-- 6. LESSON
CREATE TABLE lesson (
    lesson_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    chapter_id BIGINT NOT NULL,
    title VARCHAR(255) NOT NULL,
    -- previous: content_type ENUM('VIDEO', 'DOCUMENT') NOT NULL,
    content_type INT NOT NULL,
    content_url VARCHAR(500) NOT NULL,
    duration_seconds INT,
    order_no INT NOT NULL,

    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by VARCHAR(255),

    CONSTRAINT fk_lesson_chapter
        FOREIGN KEY (chapter_id)
        REFERENCES chapter(chapter_id)
        ON DELETE CASCADE
);

-- 7. COURSE_MEDIA
CREATE TABLE course_media (
    media_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    course_id BIGINT NOT NULL,
    -- previous: media_type ENUM('INTRO_VIDEO', 'IMAGE') NOT NULL,
    media_type INT NOT NULL,
    media_url VARCHAR(500) NOT NULL,

    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by VARCHAR(255),

    CONSTRAINT fk_media_course
        FOREIGN KEY (course_id)
        REFERENCES course(course_id)
        ON DELETE CASCADE
);

-- 8. COURSE_SESSION
CREATE TABLE course_session (
    session_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    course_id BIGINT NOT NULL,
    instructor_id BIGINT NOT NULL,

    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    session_date DATE NOT NULL,
    start_time TIME NOT NULL,
    end_time TIME NOT NULL,

    capacity INT NOT NULL,
    location VARCHAR(255),
    -- previous: status ENUM('OPEN', 'FULL', 'CANCELLED', 'COMPLETED') DEFAULT 'OPEN',
    status INT NOT NULL,

    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by VARCHAR(255),

    CONSTRAINT fk_session_course
        FOREIGN KEY (course_id)
        REFERENCES course(course_id)
        ON DELETE CASCADE,

    CONSTRAINT fk_session_instructor
        FOREIGN KEY (instructor_id)
        REFERENCES instructor(instructor_id)
);

-- 9. SESSION_ENROLLMENT
CREATE TABLE session_enrollment (
    session_enrollment_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    session_id BIGINT NOT NULL,
    student_id BIGINT NOT NULL,
    enrolled_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    -- previous: status ENUM('CONFIRMED', 'CANCELLED', 'ATTENDED') DEFAULT 'CONFIRMED',
    status INT NOT NULL,

    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    updated_by VARCHAR(255),

    CONSTRAINT fk_se_session
        FOREIGN KEY (session_id)
        REFERENCES course_session(session_id)
        ON DELETE CASCADE,

    CONSTRAINT fk_se_student
        FOREIGN KEY (student_id)
        REFERENCES student(student_id),

    CONSTRAINT uq_session_student UNIQUE (session_id, student_id)
);
