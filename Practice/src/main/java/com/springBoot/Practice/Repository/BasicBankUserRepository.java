package com.springBoot.Practice.Repository;

import com.springBoot.Practice.Entity.BasicBankUsers;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasicBankUserRepository extends MongoRepository<BasicBankUsers, ObjectId>
{

    BasicBankUsers findBasicBankUsersByEmail(String email);

    BasicBankUsers findBasicBankUsersByUserId(String userId);

    void deleteBasicBankUsersByUserId(String userId);

    BasicBankUsers findByName(String name);
}
