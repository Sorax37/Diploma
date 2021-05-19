package com.FQW.CSDocumentFlow.repo;

import com.FQW.CSDocumentFlow.models.App_User;
import com.FQW.CSDocumentFlow.models.Record_card_first;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Record_card_firstRepository extends CrudRepository<Record_card_first, Long> {
    List<Record_card_first> findByFIO(String FIO);

}
