package com.springBoot.Practice.Repository;

import com.springBoot.Practice.Entity.JournalEntryV2;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalEntryRepositoryV2 extends MongoRepository<JournalEntryV2,Object> {

}
