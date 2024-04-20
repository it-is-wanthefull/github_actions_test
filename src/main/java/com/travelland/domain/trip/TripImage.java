package com.travelland.domain.trip;

import com.travelland.dto.trip.TripImageDto.CreateRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TripImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageUrl;

    private String storeImageName;

    private boolean isThumbnail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trip_id")
    private Trip trip;

    private boolean isDeleted;

    public TripImage(CreateRequest requestDto, boolean isThumbnail, Trip trip) {
        this.imageUrl = requestDto.getImageUrl();
        this.storeImageName = requestDto.getStoreImageName();
        this.isThumbnail = isThumbnail;
        this.trip = trip;
        this.isDeleted = false;
    }
}
