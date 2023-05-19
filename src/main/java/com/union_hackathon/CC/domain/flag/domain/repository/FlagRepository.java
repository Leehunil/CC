package com.union_hackathon.CC.domain.flag.domain.repository;

import com.union_hackathon.CC.domain.flag.domain.Flag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlagRepository extends JpaRepository<Flag, Long> {
}
