package com.middleware.middleware.repository;

import com.middleware.middleware.model.EDIMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface EDIMessageRepository extends JpaRepository<EDIMessage, String> {
}