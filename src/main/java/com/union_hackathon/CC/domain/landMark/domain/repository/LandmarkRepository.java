package com.union_hackathon.CC.domain.landMark.domain.repository;

import com.union_hackathon.CC.domain.landMark.domain.Landmark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LandmarkRepository extends JpaRepository<Landmark, Long> {
}
