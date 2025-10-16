package com.springBoot.Practice.Repository;

import com.springBoot.Practice.Entity.BasicBankSystem;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasicBankSystemRepository extends MongoRepository<BasicBankSystem, ObjectId>
{

}
