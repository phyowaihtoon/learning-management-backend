package com.creatip.lms.repository;

import com.creatip.lms.domain.ActionItemOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionItemOrderRepository extends JpaRepository<ActionItemOrder,Long> {
}
