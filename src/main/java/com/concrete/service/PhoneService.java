package com.concrete.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concrete.data.PhoneRepository;
import com.concrete.model.Phone;

@Service
public class PhoneService {

	@Autowired
	PhoneRepository phoneRepository;

	@Transactional
	public ArrayList<Phone> saveList(java.util.List<Phone> list) {
		ArrayList<Phone> phonesSaved = new ArrayList<Phone>();

		if (list != null) {
			for (Phone p : list) {
				Phone phoneSaved = phoneRepository.save(p);
				phonesSaved.add(phoneSaved);
			}
		}
		
		return phonesSaved;
	}

}

