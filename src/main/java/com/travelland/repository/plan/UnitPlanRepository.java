package com.travelland.repository.plan;

import com.travelland.domain.plan.UnitPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UnitPlanRepository extends JpaRepository<UnitPlan, Long> {
    List<UnitPlan> findAllByDayPlanIdAndIsDeleted(Long id, boolean isDeleted);

    Optional<UnitPlan> findByIdAndIsDeleted(Long unitPlanId, boolean isDeleted);
}
