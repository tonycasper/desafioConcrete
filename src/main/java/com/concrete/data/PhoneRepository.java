package com.concrete.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.concrete.model.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Long> {

}
