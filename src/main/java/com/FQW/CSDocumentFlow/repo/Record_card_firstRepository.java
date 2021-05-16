package com.FQW.CSDocumentFlow.repo;

import com.FQW.CSDocumentFlow.models.App_User;
import com.FQW.CSDocumentFlow.models.Record_card_first;
import org.springframework.data.repository.CrudRepository;

public interface Record_card_firstRepository extends CrudRepository<Record_card_first, Long> {
    Record_card_first findByFIO(String FIO);
}
