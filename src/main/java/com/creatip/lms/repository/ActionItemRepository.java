package com.creatip.lms.repository;

import com.creatip.lms.domain.ActionItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionItemRepository extends JpaRepository<ActionItem,Long> {
}
