package com.travelland.repository.plan;

import com.travelland.domain.plan.Plan;
import com.travelland.repository.plan.querydsl.CustomPlanRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long>, CustomPlanRepository {
    Optional<Plan> findByIdAndIsDeletedAndIsPublic(Long planId, boolean isDeleted, boolean isPublic);

    Optional<Plan> findByIdAndIsDeletedAndMemberId(Long planId, boolean isDeleted, Long memberId);
    Optional<Plan> findByIdAndIsDeleted(Long planId, boolean isDeleted);

    Page<Plan> findAllByIsDeletedAndIsPublic(Pageable pageable, boolean isDeleted, boolean isPublic);

    Page<Plan> findAllByIsDeletedAndMemberId(Pageable pageable, boolean isDeleted, Long memberId);
    Page<Plan> findAllByIsDeleted(Pageable pageable, boolean isDeleted);
}
