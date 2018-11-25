package com.middleware.middleware.repository;

import com.middleware.middleware.model.EDIMessage;
import com.middleware.middleware.model.EDIMessageResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface EDIMessageResponseRepository extends JpaRepository<EDIMessageResponse, String> {
}