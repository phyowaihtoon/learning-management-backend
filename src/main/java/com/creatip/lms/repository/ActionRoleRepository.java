package com.creatip.lms.repository;

import com.creatip.lms.domain.base.ActionRole;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionRoleRepository extends JpaRepository<ActionRole,Long> {
    List<ActionRole> findByRoleCodeIn(Collection<String> roleCodes);
}
    