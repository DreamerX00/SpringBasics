package com.springBoot.Practice.Repository;

import com.springBoot.Practice.Entity.BasicBankSystem;
import com.springBoot.Practice.Entity.BasicBankUsers;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasicBankSystemRepository extends MongoRepository<BasicBankSystem, ObjectId>
{
    BasicBankSystem findByUsers(BasicBankUsers users);
}
