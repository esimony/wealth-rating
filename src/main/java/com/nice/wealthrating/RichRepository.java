package com.nice.wealthrating;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface RichRepository extends CrudRepository<Rich, String> {

//    List<Rich> findRichByIdEquals(String id);

}
