package com.FQW.CSDocumentFlow.repo;

import com.FQW.CSDocumentFlow.models.Record_card_first;
import com.FQW.CSDocumentFlow.models.Record_card_second;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Record_card_secondRepository extends CrudRepository<Record_card_second, Long> {
    List<Record_card_second> findByFIO(String FIO);
}
