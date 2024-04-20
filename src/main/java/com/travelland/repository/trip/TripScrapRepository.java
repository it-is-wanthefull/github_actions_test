package com.travelland.repository.trip;

import com.travelland.domain.member.Member;
import com.travelland.domain.trip.Trip;
import com.travelland.domain.trip.TripScrap;
import com.travelland.repository.trip.querydsl.CustomTripScrapRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TripScrapRepository extends JpaRepository<TripScrap, Long>, CustomTripScrapRepository {

    Optional<TripScrap> findByMemberAndTrip(Member member, Trip trip);

    boolean existsByMemberAndTripAndIsDeleted(Member member,Trip trip, boolean isDeleted);
}
