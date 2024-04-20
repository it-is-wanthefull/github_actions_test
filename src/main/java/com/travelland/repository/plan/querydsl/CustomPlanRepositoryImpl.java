package com.travelland.repository.plan.querydsl;

import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.travelland.domain.plan.Plan;
import com.travelland.dto.plan.PlanDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.travelland.domain.member.QMember.member;
import static com.travelland.domain.plan.QPlan.plan;

@Repository
@RequiredArgsConstructor
public class CustomPlanRepositoryImpl implements CustomPlanRepository {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<PlanDto.GetList> getPlanList(Long lastId, int size, String sortBy, boolean isAsc) {
        return jpaQueryFactory.select(
                        Projections.constructor(
                                PlanDto.GetList.class,
                                plan.id,
                                plan.title,
                                plan.viewCount,
                                plan.createdAt
                        )
                )
                .from(plan)
                .where(ltPlanId(lastId), plan.isDeleted.eq(false), plan.isPublic.eq(true))
                .orderBy(createOrderSpecifier(sortBy, isAsc))
                .limit(size)
                .fetch();
    }

    private BooleanExpression ltPlanId(Long planId) {
        if (planId == null)
            return null;

        return plan.id.lt(planId);
    }

    private OrderSpecifier createOrderSpecifier(String sortBy, boolean isAsc) {
        Order order = (isAsc) ? Order.ASC : Order.DESC;

        return switch (sortBy) {
            case "viewCount" -> new OrderSpecifier<>(order, plan.viewCount);
            case "title" -> new OrderSpecifier<>(order, plan.title);
            default -> new OrderSpecifier<>(order, plan.createdAt);
        };
    }

    public Plan readPlanAllInOneQuery(Long planId) {
        return jpaQueryFactory.select(
                        Projections.constructor(
                                Plan.class,
                                plan.id,
                                plan.title,
                                plan.budget,
                                plan.area,
                                plan.tripStartDate,
                                plan.tripEndDate,
                                plan.viewCount,
                                plan.likeCount,
                                plan.isVotable,
                                plan.createdAt,
                                member.nickname,
                                member.profileImage
                        )
                )
                .from(plan)
                .where(ltPlanId(planId), plan.isDeleted.eq(false), plan.isPublic.eq(true))
                .fetchOne();
    }
}
